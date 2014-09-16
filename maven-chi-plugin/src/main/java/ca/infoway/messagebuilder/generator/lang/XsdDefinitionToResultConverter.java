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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.generator.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

/**
 * XSD-specific logic to address Redmine issue 738. We need to de-inline elements that
 * wouldn't be distinguishable from each other in the schema. For example, in COCT_MT011001CA.xsd:
 * 
 *   <xs:group maxOccurs="10" minOccurs="0" ref="chi:COCT_MT011001CA.Assignees"/>
 *   <xs:group maxOccurs="10" minOccurs="0" ref="chi:COCT_MT011001CA.Assignees"/>
 *
 * This should look like this:
 *   
 *   <xs:complexType name="COCT_MT011001CA.Admitter">
 *     <xs:sequence>
 *       <xs:group maxOccurs="1" minOccurs="1" ref="chi:COCT_MT011001CA.Assignees"/>
 *     </xs:sequence>
 *   </xs:complexType>
 *   [...]
 *   <xs:complexType name="COCT_MT011001CA.Attender">
 *     <xs:sequence>
 *       <xs:group maxOccurs="1" minOccurs="1" ref="chi:COCT_MT011001CA.Assignees"/>
 *     </xs:sequence>
 *   </xs:complexType>
 *   [...]
 *   <xs:element maxOccurs="10" minOccurs="0" name="admitter" type="chi:COCT_MT011001CA.Admitter"/>
 *   <xs:element maxOccurs="10" minOccurs="0" name="attender" type="chi:COCT_MT011001CA.Attender"/>
 *   
 *   Because Admitter and Attender were inlined, and they inlined to the same optional component (Assignees),
 *   the XSD is not valid.
 */
class XsdDefinitionToResultConverter extends DefinitionToResultConverter {
	
	XsdDefinitionToResultConverter(SimplifiableDefinitions definitions,
			String basePackageName, ProgrammingLanguage programmingLanguage, OutputUI outputUI,
			NamingPolicy namingPolicy, boolean isR2) {
		super(definitions, basePackageName, programmingLanguage, outputUI, namingPolicy, isR2);
	}

	protected void reassessInlining(TypeAnalysisResult result) {
		super.reassessInlining(result);

		/* 
		 * Get all inlined types. We'll be going this array multiple times.
		 */
		List<SimplifiableType> inlinedTypes = new ArrayList<SimplifiableType>();
		for (SimplifiableType type : getDefinitions().getAllTypes()) {
			if (type.isInlined()) {
				inlinedTypes.add(type);
			}
		}

		/* 
		 * For each inline type, get the names of the relations that the type inlines to. That is,
		 * get a representation of what the type would look like after inlining. The inlineResolutions 
		 * map tracks what are inline type resolves to after inlining.
		 */
		Map<SimplifiableType, List<String>> inlineResolutions = new HashMap<SimplifiableType, List<String>>();
		for (SimplifiableType inlinedType : inlinedTypes) {
			for (SimplifiableRelationship relationship : inlinedType.getRelationships()) {
				// We're only interested in choice relationships for the time being
				if (relationship.isAssociation() && relationship.isChoice() && relationship.getType() != null) {
					if (!inlineResolutions.containsKey(inlinedType)) {
						inlineResolutions.put(inlinedType, new  ArrayList<String>());
					}
					inlineResolutions.get(inlinedType).add(relationship.getType().getName());
				}
			}
		}
		
		/* 
		 * For each type, check immediate children. If a resolution is shared between that child and a peer, 
		 * then we have to un-inline the child.
		 */
		for (SimplifiableType parentType : getDefinitions().getAllTypes()) {
			for (SimplifiableRelationship relationship : parentType.getRelationships()) {
				SimplifiableType childType = relationship.getType();
				
				if (relationship.isAssociation() && childType != null && childType.isInlined()) {
					for (SimplifiableRelationship peerRelationship : parentType.getRelationships()) {
						SimplifiableType peerType = peerRelationship.getType();
						if (relationship.isAssociation() && peerType != null && peerType != childType) {
							if (doesListContainSameString(inlineResolutions.get(childType), inlineResolutions.get(peerType))) {
								childType.setInlined(false);
								getOutputUI().log(LogLevel.INFO, 
										  "Rejected inlining for parent type: " +  parentType.getTypeName()
										+ " child type:" + childType.getTypeName()
										+ " relationship:" + relationship.getRelationship().getName()
										+ " because child type resolves the same as peer type: " + peerType.getTypeName());
							}
						}
					}
				}
			}
		}
	}
	
	private boolean doesListContainSameString(List<String> list1, List<String> list2) {
		if (list1 == null | list2 == null) {
			return false;
		}
		for (String string1: list1) {
			if (list2.contains(string1)) {
				return true;
			}
		}
		return false;
	}
}
