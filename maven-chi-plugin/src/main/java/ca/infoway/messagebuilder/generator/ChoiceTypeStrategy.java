/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;

public abstract class ChoiceTypeStrategy {
	
	static class ParticipantClassStrategy extends ChoiceTypeStrategy {

		private final Element targetConnection;

		public ParticipantClassStrategy(Element targetConnection) {
			this.targetConnection = targetConnection;
		}

		public String getHighLevelType(MessagePartResolver resolver) {
			return NameHelper.qualifiyName(this.targetConnection, 
					MifXPathHelper.getParticipantClassName(this.targetConnection));
		}

		public List<ChoiceOption> getChoiceOptions(MessagePartResolver resolver) {
			Map<Element, MessagePart> map = new LinkedHashMap<Element, MessagePart>(); 

			List<Element> allParticipantClassSpecializations = MifXPathHelper.getParticipantSpecializations(this.targetConnection);
			for (Element participantClassSpecialization : allParticipantClassSpecializations) {
				map.put(participantClassSpecialization, null);
			}
			
			List<Element> specializationChilds = MifXPathHelper.getParticipantClassSpecializationChilds(this.targetConnection);
			int i = 0;
			int numChildren = specializationChilds.size();
			for (Element specialization : allParticipantClassSpecializations) {
				Element specializationChild = specializationChilds.get(i % numChildren);
				String childType = new TypeResolver().resolveSpecializationChildType(resolver, specializationChild);
				
				MessagePart childMessagePart = resolver.getMessagePart(childType);
				map.put(specialization, childMessagePart);
				i++;
			}
			
			return createOptions(resolver, map);
		}

	}

	static class ReferenceStrategy extends ChoiceTypeStrategy {

		private final Element targetConnection;

		public ReferenceStrategy(Element targetConnection) {
			this.targetConnection = targetConnection;
		}

		public String getHighLevelType(MessagePartResolver resolver) {
			String packageLocation = MifXPathHelper.getGeneralizationTarget(this.targetConnection);
			String highLevelType = resolver.getPackageLocationRootType(packageLocation);

			// need to check if this highleveltype is actually defined within the same package as the targetConnection
			String ownedEntryPoint = MifXPathHelper.getOwnedEntryPoint(this.targetConnection);
			if (StringUtils.equals(packageLocation, ownedEntryPoint)) {
				String className = MifXPathHelper.getParticipantClassName(this.targetConnection);
				if (StringUtils.isBlank(className)) {
					className  = MifXPathHelper.getMifReferenceType(this.targetConnection);
				}
				if (StringUtils.isNotBlank(className)) {
					highLevelType = NameHelper.qualifiyName(this.targetConnection, className);
				}
			}
			
			if (StringUtils.isNotBlank(highLevelType)) {
				return highLevelType;
			} else {
				throw new MifProcessingException(this.targetConnection, "Cannot find high level type for " + packageLocation);
			}
		}

		public List<ChoiceOption> getChoiceOptions(MessagePartResolver resolver) {
			
			MessagePart part = resolver.getMessagePart(getHighLevelType(resolver));
			if (part == null) {
				throw new MifProcessingException(this.targetConnection, "Cannot find message part: " + getHighLevelType(resolver));
			} else {
				List<Element> specializations = MifXPathHelper.getParticipantSpecializations(this.targetConnection);
				List<String> specializationChilds = part.getSpecializationChilds();
				int numChildren = specializationChilds.size();
				
				Map<Element, MessagePart> map = new LinkedHashMap<Element, MessagePart>();
				int i = 0;
				for (Element specialization : specializations) {
					String childType = specializationChilds.get(i % numChildren);
					MessagePart childMessagePart = resolver.getMessagePart(childType);
					map.put(specialization, childMessagePart);
					i++;
				}
				return createOptions(resolver, map);
			}
		}
	}

	public abstract String getHighLevelType(MessagePartResolver resolver);
	public abstract List<ChoiceOption> getChoiceOptions(MessagePartResolver resolver);

	protected ArrayList<ChoiceOption> createOptions(MessagePartResolver resolver, Map<Element, MessagePart> map) {
		
		ArrayList<ChoiceOption> result = new ArrayList<ChoiceOption>();
		for (Element specialization : map.keySet()) {
			String traversalName = specialization.getAttribute("traversalName");
			MessagePart part = map.get(specialization);
			if (part == null) {
				System.out.println("break here");
			}
			String type = part.getName();
			
			if (hasSubspecializations(specialization) && !CollectionUtils.isEmpty(part.getSpecializationChilds())) {
				
				List<MessagePart> parts = toParts(resolver, part.getSpecializationChilds());
				List<Element> subspecializations = MifXPathHelper.getSubspecializations(specialization);
				List<ChoiceOption> subchoices = createOptions(resolver, parts, subspecializations);
				
				result.add(new ChoiceOption(traversalName, type, subchoices));
			} else {
				result.add(new ChoiceOption(traversalName, type));
			}
		}
		return result;
	}
	
	protected ArrayList<ChoiceOption> createOptions(MessagePartResolver resolver, 
			List<MessagePart> parts,
			List<Element> specializations) {
		if (specializations.size() != parts.size()) {
			throw new MifProcessingException(
					"Expected part " + getHighLevelType(resolver) 
					+ " to have " + specializations.size() + " specializations but was " 
					+ parts.size());
		} else {
			ArrayList<ChoiceOption> result = new ArrayList<ChoiceOption>();
			for (int i = 0, length = specializations.size(); i < length; i++) {
				Element specialization = specializations.get(i);
				String traversalName = specialization.getAttribute("traversalName");
				MessagePart part = parts.get(i);
				String type = part.getName();
				
				if (hasSubspecializations(specialization) && !CollectionUtils.isEmpty(part.getSpecializationChilds())) {
					List<ChoiceOption> subchoices = createOptions(resolver, 
							toParts(resolver, part.getSpecializationChilds()), 
							MifXPathHelper.getSubspecializations(specialization));
					result.add(new ChoiceOption(traversalName, type, subchoices));
				} else {
					result.add(new ChoiceOption(traversalName, type));
				}
			}
			return result;
		}
	}

	private boolean hasSubspecializations(Element specialization) {
		return !CollectionUtils.isEmpty(MifXPathHelper.getSubspecializations(specialization));
	}
	public static ChoiceTypeStrategy getChoiceTypeStrategy(Element targetConnection) {
		if (MifXPathHelper.isReferenceToOtherModelType(targetConnection)) {
			return new ReferenceStrategy(targetConnection);
		} else {
			return new ParticipantClassStrategy(targetConnection);
		}
	}

	protected List<MessagePart> toParts(MessagePartResolver resolver, List<String> partNames) {
		List<MessagePart> result = new ArrayList<MessagePart>();
		for (String name : partNames) {
			MessagePart messagePart = resolver.getMessagePart(name);
			if (messagePart != null) {
				result.add(messagePart);
			}
		}
		return result;
	}
}
