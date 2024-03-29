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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.Named;

/**
 * <p>A class that models the interaction.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Interaction implements Categorizable, HasDifferences, Named, Documentable {

	@Attribute
	private String name;
	@Attribute(required=false)
	private String triggerEvent;
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	// businessName field no longer used; setter/getter delegates to documentation property
	// however, older message sets, when read in, will have this field populated 
	@Element(required=false)
	@Deprecated
	private String businessName;   
	@Attribute
	private String superTypeName;
	@ElementList(inline=true,required=false)
	private List<Argument> arguments = new ArrayList<Argument>();
	@Element(required=false)
	private Documentation documentation;
	@Attribute(required=false)
	private String category;
	@Attribute(required=false)
	private String templateId;
	@Attribute(required=false)
	private String parentTemplateId;
	@ElementList(inline=true, required=false)
	private List<ReceiverResponsibility> receiverResponsibilities = new ArrayList<ReceiverResponsibility>(); 
	
	/**
	 * <p>Get the type name of the interaction.  For example, a name might be 
	 * PRPA_IN101103CA.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * <p>Set the name.
	 * @param name - the new value
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getTriggerEvent() {
		return triggerEvent;
	}
	public void setTriggerEvent(String triggerEvent) {
		this.triggerEvent = triggerEvent;
	}
	/**
	 * <p>Get the type name of the parent type (or super type).
	 * @return the type name of the parent type
	 */
	public String getSuperTypeName() {
		return this.superTypeName;
	}
	/**
	 * <p>Set the type name of the parent type.
	 * @param superTypeName - the new parent type name.
	 */
	public void setSuperTypeName(String superTypeName) {
		this.superTypeName = superTypeName;
	}
	/**
	 * <p>Get the list of template arguments.
	 * @return the template arguments
	 */
	public List<Argument> getArguments() {
		return this.arguments;
	}
	/**
	 * <p>Set the list of template arguments.
	 * @param arguments - the template arguments
	 */
	public void setArguments(List<Argument> arguments) {
		this.arguments = arguments;
	}
	/**
	 * <p>Get the business name.  A business name might be "Find Candidates Query".
	 * @return the business name
	 */
	public String getBusinessName() {
		// first pull out proper value
		String docBusinessName = this.documentation == null ? null : this.documentation.getBusinessName();
		// if no proper value, but we have a deprecated field value, return the deprecated field value and set it in the correct field
		if (docBusinessName == null && this.businessName != null) {
			docBusinessName = this.businessName;
			setBusinessName(this.businessName);
		}
		// side effect: clear out the deprecated field regardless, in case it was populated from an older message set
		this.businessName = null;
		return docBusinessName;
	}
	/**
	 * <p>Set the business name.
	 * @param businessName - the new business name.
	 */
	public void setBusinessName(String businessName) {
		// side effect: clear out the deprecated field regardless, in case it was populated from an older message set
		this.businessName = null;
		if (this.documentation == null && businessName != null) {
			this.documentation = new Documentation();
		}
		if (this.documentation != null) {
			this.documentation.setBusinessName(businessName);
		}
	}
	/**
	 * <p>Get the documentation.
	 * @return - the documentation
	 */
	public Documentation getDocumentation() {
		// trigger side effect to force Documentation creation if using an old message set that only contains a business name element
		// assigned to unused variable for translation purposes
		String unusedVariable = getBusinessName();
		return this.documentation;
	}
	/**
	 * <p>Set the documentation.
	 * @param documentation - the new documentation
	 */
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	/**
	 * <p>Locate a particular template parameter argument by template parameter name.
	 * @param templateParameterName - the template parameter name
	 * @return - the argument that corresponds to the name.
	 */
	public Argument getArgumentByTemplateParameterName(String templateParameterName) {
		return getArgumentByTemplateParameterName(templateParameterName, getArguments());
	}
	private Argument getArgumentByTemplateParameterName(String templateParameterName, List<Argument> arguments) {
		Argument result = null;
		for (Argument argument : arguments) {
			if (StringUtils.equals(templateParameterName, argument.getTemplateParameterName())){
				result = argument;
			} else {
				result = getArgumentByTemplateParameterName(templateParameterName, argument.getArguments());
			}
			if (result != null) {
				break;
			}
		}
		return result;
	}
	/**
	 * <p>Get the category.
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}
	/**
	 * <p>Set the category.
	 * @param category - the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getParentTemplateId() {
		return parentTemplateId;
	}
	public void setParentTemplateId(String parentTemplateId) {
		this.parentTemplateId = parentTemplateId;
	}
	/**
	 * Tracks an interaction difference for regen 
	 * 
	 * @return the difference
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
	public List<ReceiverResponsibility> getReceiverResponsibilities() {
		return receiverResponsibilities;
	}
	public void setReceiverResponsibilities(
			List<ReceiverResponsibility> receiverResponsibilities) {
		this.receiverResponsibilities = receiverResponsibilities;
	}
	public void addResponsibility(ReceiverResponsibility responsibility) {
		this.receiverResponsibilities.add(responsibility);
	}
	
}
