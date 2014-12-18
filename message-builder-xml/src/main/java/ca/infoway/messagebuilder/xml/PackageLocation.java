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
import java.util.Map;
import java.util.TreeMap;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.Named;

/**
 * <p>The package location.  Each package location corresponds with one MIF file.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class PackageLocation implements Categorizable, HasDifferences, Named, Documentable {
	
	@Attribute
	private String name;
	@Attribute(name="desc",required=false)
	private String descriptiveName;
	@Attribute(required=false)
	private String rootType;
	@Element(required=false)
	private ImportedPackage derivedFromStaticModel;
	@Element(required=false)
	private ImportedPackage datatypeModel;
	@Element(required=false)
	private ImportedPackage vocabularyModel;
	@Element(required=false)
	private ImportedPackage commonModelElement;
	@ElementList(inline=true,entry="cmetBinding",required=false)
	private List<CmetBinding> cmetBindings = new ArrayList<CmetBinding>();
	@Element(required=false)
	private Documentation documentation;
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	@ElementMap(name="messagePart",key="name",required=false,inline=true,attribute=true)
	private Map<String,MessagePart> messageParts = new TreeMap<String,MessagePart>();
	@Attribute(required=false)
	private String category;
	@Attribute(required=false)
	private String templateOid;
	@Attribute(required=false)
	private String impliedTemplateOid;
	@ElementList(inline=true,required=false,entry="containedTemplate")
	private List<ContainedTemplate> containedTemplateConstraints = new ArrayList<ContainedTemplate>();
	
	/**
	 * <p>The default constructor.
	 */
	public PackageLocation() {
	}
	/**
	 * <p>Standard constructor.
	 * @param name the name of the package location
	 */
	public PackageLocation(String name) {
		this.name = name;
	}
	/**
	 * <p>Get the name.  e.g. "PRPA_MT101103CA"
	 * @return the name
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
	 * <p>The name of the top-level class defined by the MIF file.
	 * @return the root type name.
	 */
	public String getRootType() {
		return this.rootType;
	}
	/**
	 * <p>Set the name of the top-level class defined by the MIF file.
	 * @param rootType - the root type name.
	 */
	public void setRootType(String rootType) {
		this.rootType = rootType;
	}
	/**
	 * <p>Get a map of all message parts, keyed by fully-qualified type name.
	 * @return - the map
	 */
	public Map<String, MessagePart> getMessageParts() {
		return this.messageParts;
	}
	/**
	 * <p>Set the map of all message parts.
	 * @param messageParts - the new value
	 */
	public void setMessageParts(Map<String, MessagePart> messageParts) {
		this.messageParts = messageParts;
	}
	/**
	 * <p>Get the descriptive name.
	 * @return the descriptive name.
	 */
	public String getDescriptiveName() {
		return this.descriptiveName;
	}
	/**
	 * <p>Set the descriptive name.
	 * @param descriptiveName - the new value
	 */
	public void setDescriptiveName(String descriptiveName) {
		this.descriptiveName = descriptiveName;
	}
	/**
	 * <p>Set the category, such as "cr" (Client Registry).
	 * @param category - the new value
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * <p>Get the category.
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}
	
	public String getTemplateOid() {
		return templateOid;
	}
	public void setTemplateOid(String templateOid) {
		this.templateOid = templateOid;
	}
	public String getImpliedTemplateOid() {
		return impliedTemplateOid;
	}
	public void setImpliedTemplateOid(String impliedTemplateOid) {
		this.impliedTemplateOid = impliedTemplateOid;
	}
	public List<ContainedTemplate> getContainedTemplateConstraints() {
		return containedTemplateConstraints;
	}
	/**
	 * Tracks package location differences for regen 
	 * 
	 * @return the differences
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
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public ImportedPackage getDerivedFromStaticModel() {
		return derivedFromStaticModel;
	}
	public void setDerivedFromStaticModel(ImportedPackage derivedFromStaticModel) {
		this.derivedFromStaticModel = derivedFromStaticModel;
	}
	public ImportedPackage getDatatypeModel() {
		return datatypeModel;
	}
	public void setDatatypeModel(ImportedPackage datatypeModel) {
		this.datatypeModel = datatypeModel;
	}
	public ImportedPackage getVocabularyModel() {
		return vocabularyModel;
	}
	public void setVocabularyModel(ImportedPackage vocabularyModel) {
		this.vocabularyModel = vocabularyModel;
	}
	public ImportedPackage getCommonModelElement() {
		return commonModelElement;
	}
	public void setCommonModelElement(ImportedPackage commonModelElement) {
		this.commonModelElement = commonModelElement;
	}
	public List<CmetBinding> getCmetBindings() {
		return this.cmetBindings;
	}
	public CmetBinding getCmetBinding(String name) {
		CmetBinding result = null;
		for (CmetBinding cmetBinding : this.cmetBindings) {
			if (cmetBinding.getCmetName().equals(name)) {
				result = cmetBinding;
			}
		}
		return result;
	}
	public void addCmetBinding(CmetBinding cmetbinding) {
		this.cmetBindings.add(cmetbinding);
	}
	public boolean isCmet() {
		return !this.cmetBindings.isEmpty();
	}
	
}
