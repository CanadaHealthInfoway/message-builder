/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.acceptance.runner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marshalling.MessageBeanRegistry;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageSetCoverageAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private static final String MESSAGE_SET_COVERAGE = "Message set coverage";

	private static final SpecificationVersion VERSION = SpecificationVersion.R02_04_02;
	
	private final Log log = LogFactory.getLog(getClass());
	
	private final MessageDefinitionService messageDefinitionService;

	public MessageSetCoverageAcceptanceTestRunner() {
		this.messageDefinitionService = new MessageDefinitionServiceFactory().create();
	}

	public void run(AcceptanceTestResultCallback resultCallback) {
		try {
			// collect together all part type mappings used in our model objects under a certain package structure
			Set<String> messagePartsInModel = new HashSet<String>();
			
//			// FIXME - TM/SPD - check if reflections is loading classes; replace with something else?
//			Reflections reflections = new Reflections("ca.infoway.messagebuilder.model", new TypeAnnotationsScanner(), new SubTypesScanner());
//			Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Hl7PartTypeMapping.class);
			
//			List<Class<?>> classes = new ClassFinder().findClasses(MessageBean.class, Predicates.hasAnnotationPredicate(Hl7PartTypeMapping.class));
			Collection<Class<?>> classes = MessageBeanRegistry.getInstance().getAllMessageParts();
			
			for (Class<?> clazz : classes) {
				Hl7PartTypeMapping partTypeMapping = clazz.getAnnotation(Hl7PartTypeMapping.class);
				String[] values = partTypeMapping.value();
				messagePartsInModel.addAll(Arrays.asList(values));
			}

			// collect all part types for a message set
			Set<String> messagePartsInMessageSet = new HashSet<String>();
			List<Interaction> allInteractions = this.messageDefinitionService.getAllInteractions(VERSION.getVersionLiteral());
			for (Interaction interaction : allInteractions) {
				// store interaction part
				messagePartsInMessageSet.add(interaction.getName());
				Map<String, MessagePart> allMessageParts = this.messageDefinitionService.getAllMessageParts(interaction, VERSION.getVersionLiteral());
				// store all parts
				messagePartsInMessageSet.addAll(allMessageParts.keySet());
			}

			// possible issue if model object part not in message set??? - log message?
			if (!messagePartsInMessageSet.containsAll(messagePartsInModel)) {
				log.warn("Model object parts not in message set. Hmmmm.");
			}

			int totalParts = messagePartsInMessageSet.size();
			// no coverage if message set part not found in model object parts
			messagePartsInMessageSet.removeAll(messagePartsInModel);
			
			// callback with number missing
			resultCallback.done(
					MESSAGE_SET_COVERAGE,
					totalParts - messagePartsInMessageSet.size(),
					totalParts, 
					messagePartsInMessageSet.size() > 0 ? 
							Arrays.<String>asList(String.format("Missing %s message parts out of %s.", messagePartsInMessageSet.size(), totalParts)) : 
							Collections.<String>emptyList());
		} catch (Exception e) {
			this.log.error("Acceptance test failed with exception", e);
			resultCallback.done(MESSAGE_SET_COVERAGE, 0, 0, Collections.<String>emptyList());
		}
	}
	
}
