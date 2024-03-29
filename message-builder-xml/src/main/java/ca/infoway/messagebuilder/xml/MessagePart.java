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

package ca.infoway.messagebuilder.xml;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>A message part.  An example message part might be represent the type
 * "MCCI_MT700751CA.ControlActEvent".
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
@Root
public class MessagePart implements Documentable, HasDifferences, Named {

	@Attribute(required=false)
	private String name;

	@Attribute(required=false,name="abstract")
	private boolean isAbstract;
	
	@Attribute(required=false)
	private boolean templateParameter;
	
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	
	@Element(required=false)
	private Documentation documentation;
	
	@Attribute(required=false)
	private String rimClass;
	
	@Attribute(required=false)
	private String derivedFromClass;
	
	@ElementList(required=false,inline=true)
	private List<Relationship> relationships = new ArrayList<Relationship>();

	@ElementList(required=false,inline=true,entry="specializationChild") 
	private List<SpecializationChild> specializationChilds = new ArrayList<SpecializationChild>();
	
	/**
	 * <p>Default constructor.
	 */
	public MessagePart() {
	}
	/**
	 * <p>Default constructor.
	 * @param name - the part type name
	 */
	public MessagePart(String name) {
		this.name = name;
	}
	/**
	 * Get the name.
	 * @return the name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * <p>Set the name.
	 * @param name - the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>Get the documentation.
	 * @return the documentation.
	 */
	public Documentation getDocumentation() {
		return this.documentation;
	}
	/**
	 * <p>Set the documentation.
	 * @param documentation - the new documentation value
	 */
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public String getDerivedFromClass() {
		return derivedFromClass;
	}
	public void setDerivedFromClass(String derivedFromClass) {
		this.derivedFromClass = derivedFromClass;
	}
	/**
	 * <p>Get the list of relationships.
	 * @return - the relationships
	 */
	public List<Relationship> getRelationships() {
		for (Relationship relationship : this.relationships) {
			relationship.setParentType(this.name);
		}
		return this.relationships;
	}
	/**
	 * <p>Set the list of relationships.
	 * @param relationships - the new value
	 */
	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}
	/**
	 * <p>Get the abstractness.
	 * @return true if the message part is abstract; false otherwise.
	 */
	public boolean isAbstract() {
		return this.isAbstract;
	}
	/**
	 * <p>Set the abstractness.
	 * @param isAbstract - the new abstractness value
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	/**
	 * <p>Factory method for creating an abstract message part.
	 * @param name - the type name of the message part
	 * @return - the newly-constructed message part
	 */
	public static MessagePart createAbstractPart(String name) {
		MessagePart part = new MessagePart(name);
		part.setAbstract(true);
		return part;
	}
	public boolean isTemplateParameter() {
		return templateParameter;
	}
	public void setTemplateParameter(boolean templateParameter) {
		this.templateParameter = templateParameter;
	}
	/**
	 * <p>Factory method for creating a template parameter.
	 * @param name - the type name of the message part
	 * @return - the newly-constructed message part
	 */
	public static MessagePart createTemplateParameter(String name) {
		MessagePart part = new MessagePart(name);
		part.setTemplateParameter(true);
		return part;
	}
	/**
	 * <p>Get the list of names of the child types.
	 * @return the child types.
	 */
	public List<SpecializationChild> getSpecializationChilds() {
		return this.specializationChilds;
	}
	/**
	 * <p>Determines whether the message part has a specialization child
	 * matching the given name
	 * @param childName the name to test
	 * @return true if the name matches
	 */
	public SpecializationChild getSpecializationChild(String childName) {
		SpecializationChild result = null;
		for (SpecializationChild child : this.specializationChilds) {
			if (child.getName().equals(childName)) {
				result = child;
				break;
			}
		}
		return result;
	}
	/**
	 * <p>Add a child to the list of child types.
	 * @param specializationChild - the new child
	 */
	public void addSpecializationChild(SpecializationChild specializationChild) {
		this.specializationChilds.add(specializationChild);
	}
	/**
	 * <p>Remove a specialization child from the list by name
	 * @param childName the name of the child to remove
	 */
	public void removeSpecializationChild(String childName) {
		// TM - modified to remove usage of iterator.remove() to facilitate translation
		int index = -1;
		for (int i = 0; i < this.specializationChilds.size(); i++) {
			if (this.specializationChilds.get(i).getName().equals(childName)) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			this.specializationChilds.remove(index);
		}
	}
	/**
	 * <p>Determines whether the message part has a specialization child
	 * matching the given name
	 * @param childName the name to test
	 * @return true if the name matches
	 */
	public boolean hasSpecializationChild(String childName) {
		return getSpecializationChild(childName) != null;
	}

	/**
	 * <p>Get a specific relationship by name.
	 * @param name - the name of the relationship
	 * @return - the relationship
	 */
	public Relationship getRelationship(String name) {
		return getRelationship(name, null, null);
	}

	/**
	 * <p>Get a specific relationship by name.
	 * @param name - the name of the relationship
	 * @return - the relationship
	 */
	public Relationship getRelationship(String name, String namespaze) {
		return getRelationship(name, namespaze, null);
	}
	
	/**
	 * <p>Get a specific relationship by name.
	 * @param name - the name of the relationship
	 * @param interaction - the interaction (used to resolve names of template parameters) or null
	 * @return - the relationship
	 */
	public Relationship getRelationship(String name, String namespaze, Interaction interaction) {
		
		Relationship result = null;
		//First look for children matching 'name'
		for (Relationship relationship : this.relationships) {
			if (matchesRelationshipByName(name, namespaze, relationship) 
					|| matchesRelationshipByTraversalName(name, relationship, interaction)) {
				result = relationship;
				break;
			}
		}
		
		//If that doesn't work, check inside any child relationships that are choices
		if (result == null) {
			for (Relationship relationship : this.relationships) {
				if (matchesRelationshipByChoiceOptionName(name, relationship)) {
					result = relationship;
					break;
				}
			}
		}
		
		if (result != null) {
			result.setParentType(this.name);
		}
		
		return result;
	}
	private boolean matchesRelationshipByChoiceOptionName(String name, Relationship relationship) {
		return relationship.isChoice() && relationship.findChoiceOption(Relationship.choiceOptionNamePredicate(name)) != null;
	}
	private boolean matchesRelationshipByName(String name, String namespaze, Relationship relationship) {
		// TM - removing check against namespace; this may eventually be reinstated
		return isNotBlank(name) && name.equals(relationship.getName()); 
				// && (StringUtils.equals(namespace, relationship.getNamespace()));
	}
	private boolean matchesRelationshipByTraversalName(String name,	Relationship relationship, Interaction interaction) {
		if (interaction != null && relationship.isTemplateRelationship()){
			return matchesRelationshipByTraversalName(name, relationship, interaction.getArguments());
		} else {
			return false;
		}
	}

	private boolean matchesRelationshipByTraversalName(String name,	Relationship relationship, List<Argument> arguments) {
		boolean result = false;
		for (Argument argument : arguments) {
			if (isNotBlank(name) && isNotBlank(relationship.getTemplateParameterName())){
				if (relationship.getTemplateParameterName().equals(argument.getTemplateParameterName())
						&& name.equals(argument.getTraversalName())) {
					result = true;
				} else {
					result = matchesRelationshipByTraversalName(name, relationship, argument.getArguments());
				}
				if (!result) {
					Relationship choice = argument.findChoiceOption(Argument.choiceOptionNamePredicate(name));
					if (choice != null) {
						result = true;
					}
				}
			}
			if (result) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Records the differences between message parts of different release versions during regen.
	 * 
	 * @return list of differences
	 */
	public List<Difference> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<Difference> differences) {
		this.differences = differences;
	}
	public void addDifference(Difference difference) {
		this.differences.add(difference);
	}
	public RimClass getRimClass() {
		if (this.rimClass != null) {
			return EnumPattern.valueOf(RimClass.class, this.rimClass);
		} 
		return null;
	}
	public void setRimClass(RimClass rimClass) {
		this.rimClass = rimClass == null ? null : rimClass.name();
	}
}