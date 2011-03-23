package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.List;

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
			List<String> partNames = new ArrayList<String>();
			List<Element> childs = MifXPathHelper.getParticipantClassSpecializationChilds(targetConnection);
			for (Element child : childs) {
				String type = new TypeResolver().resolveSpecializationChildType(resolver, child);
				if (StringUtils.isNotBlank(type)) {
					partNames.add(type);
				}
			}
			List<Element> specializations = MifXPathHelper.getParticipantSpecializations(this.targetConnection);
			return createOptions(resolver, toParts(resolver, partNames), specializations);
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
				List<String> partNames = part.getSpecializationChilds();
				List<Element> specializations = MifXPathHelper.getParticipantSpecializations(this.targetConnection);
				return createOptions(resolver, toParts(resolver, partNames), specializations);
			}
		}

	}

	public abstract String getHighLevelType(MessagePartResolver resolver);
	public abstract List<ChoiceOption> getChoiceOptions(MessagePartResolver resolver);

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
				String className = specialization.getAttribute("className");
				String traversalName = specialization.getAttribute("traversalName");
				MessagePart part = parts.get(i);
				String type = part.getName();
				
				if (hasSubspecializations(specialization) && !CollectionUtils.isEmpty(part.getSpecializationChilds())) {
					List<ChoiceOption> subchoices = createOptions(resolver, 
							toParts(resolver, part.getSpecializationChilds()), 
							MifXPathHelper.getSubspecializations(specialization));
					result.add(new ChoiceOption(className, traversalName, type, subchoices));
				} else {
					result.add(new ChoiceOption(className, traversalName, type));
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
