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

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.Named;

/**
 * <p>The specific type argument for a template parameter.</p>
 * 
 * <p>When an interaction is defined, it is composed of various specific 
 * parts (e.g. the base message part) with template parameters specified by
 * a particular template argument.  This class models the information that
 * is specified in the template argument.
 * 
 * <p>For example, the parameters for Find Candidates look like this:
 * 
 * <code>
 * &lt;mif:argumentMessage root="DEFN" section="IM" subSection="MC" domain="CI" artifact="MT"
 *                      realmNamespace="CA"
 *                      id="002100"&gt;
 *    &lt;mif:parameterModel parameterName="ControlActEvent" root="DEFN" section="IM" 
 *                        subSection="MF"
 *                        domain="MI"
 *                        artifact="MT"
 *                        realmNamespace="CA"
 *                        id="700751"
 *                        traversalName="controlActEvent"&gt;
 *       &lt;mif:parameterModel parameterName="ParameterList" root="DEFN" section="AM" subSection="PR"
 *                           domain="PA"
 *                           artifact="MT"
 *                           realmNamespace="CA"
 *                           id="101103"
 *                           traversalName="parameterList"/&gt;
 * </code>
 * 
 * <p>Each <tt>parameterModel</tt> represents one argument.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Argument extends ChoiceSupport implements HasDifferences, Named {
	
	@Attribute
	private String name;
	
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	
	@ElementList(inline=true,required=false,name="argument")
	private List<Argument> arguments = new ArrayList<Argument>();
	
	@Attribute(required=false)
	private String templateParameterName;
	@Attribute(required=false)
	private String traversalName;
	
	@ElementList(entry="choice",inline=true,required=false)
	private List<Relationship> choices = new ArrayList<Relationship>();
	
	/**
	 * <p>The name of the type that the argument defines.  For example, a name
	 * might return "MCCI_MT700751CA.ControlActEvent".
	 * 
	 * @return the type name of the argument.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * <p>Set the name.
	 * @param name - the new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>Sub-arguments.  
	 * 
	 * <p>Arguments can, themselves, have arguments.  Usually used in the case of a 
	 * control act type, the argument of which is the payload.
	 * @return the sub-arguments
	 */
	public List<Argument> getArguments() {
		return this.arguments;
	}
	/**
	 * <p>Set the sub-arguments.
	 * 
	 * @param arguments - sets the sub-arguments.
	 */
	public void setArguments(List<Argument> arguments) {
		this.arguments = arguments;
	}
	/**
	 * <p>The template parameter name.  Each message part with template parameters
	 * will name the parameter (e.g. "RegisteredRole" or "Act").  This maps to the 
	 * <tt>templateParameterName</tt> attribute of the <tt>parameterModel</tt> element
	 * @return the template parameter name.
	 */
	public String getTemplateParameterName() {
		return this.templateParameterName;
	}
	/**
	 * <p>Sets the template parameter name.
	 * @param templateParameterName - the new templateParameterName
	 */
	public void setTemplateParameterName(String templateParameterName) {
		this.templateParameterName = templateParameterName;
	}
	/**
	 * <p>Gets the traversal name.  The traversal name is used to describe the
	 * element name when the message is rendered to XML.
	 * @return - the traversal name.
	 */
	public String getTraversalName() {
		return this.traversalName;
	}
	/**
	 * <p>Sets the traversal name.
	 * @param traversalName - the new traversal name.
	 */
	public void setTraversalName(String traversalName) {
		this.traversalName = traversalName;
	}
	/**
	 * <p>The possible choices when an argument is defined as an abstract type.
	 * @return the list of choices.
	 */
	public List<Relationship> getChoices() {
		return this.choices;
	}
	/**
	 * <p>Indicates that an argument is defined as an abstract type and has specific 
	 * choices.
	 * 
	 * @return true if the argument is abstract and has choices; false otherwise.
	 */
	public boolean isChoice() {
		return !this.choices.isEmpty();
	}

	/**
	 * Records the differences between arguments of different release versions during regen.
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
}
