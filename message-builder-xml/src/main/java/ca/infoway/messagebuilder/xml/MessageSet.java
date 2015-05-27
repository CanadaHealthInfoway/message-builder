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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

/**
 * <p>A representation of an entire message set.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class MessageSet implements MessagePartResolver {

	@Attribute(required=false)
	private String version;
	
	@Attribute(required=false)
	private boolean cda;
	
	@Attribute(required=false)
	private boolean generatedAsR2;

	@Attribute(required=false)
	private String descriptiveName;
	
	@Attribute(required=false)
	private String realmCode;
	
	@Attribute(required=false)
	private String component;
	
	@Attribute(required=false)
	private String schemaVersion = "2.0";
	
	@Attribute(required=false)
	private String generatedBy;
	
	@Element(required=false)
	private Vocabulary vocabulary;
	
	@Element(required=false)
	private SchemaMetadata schemaMetadata;

	@ElementList(name="remixHistory",required=false,inline=true,entry="remixHistoryEntry") 
	private List<MessageSetHistory> remixHistory = new ArrayList<MessageSetHistory>();
	
	@ElementMap(name="packageLocation",key="name",required=false,inline=true,attribute=true,entry="packageEntry")
	private Map<String,PackageLocation> packageLocations = new TreeMap<String,PackageLocation>();

	@ElementMap(name="interaction",key="name",required=false,inline=true,attribute=true)
	private Map<String,Interaction> interactions = new TreeMap<String,Interaction>();
	
	@ElementMap(name="constrainedDatatype",key="name",required=false,inline=true,attribute=true,entry="constrainedDatatypeEntry")
	private Map<String, ConstrainedDatatype> constrainedDatatypes = new TreeMap<String, ConstrainedDatatype>();
	
	@ElementList(required=false,inline=true,entry="schematronContext")
	private List<SchematronContext> schematronContexts = new ArrayList<SchematronContext>();
	
	/**
	 * <p>Get the version code that this message set represents.
	 * @return - the version code.
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * <p>Set the version code.
	 * @param version - the new version code.
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	public boolean isCda() {
		return cda;
	}

	public void setCda(boolean cda) {
		this.cda = cda;
	}

	/**
	 * <p> Denotes if this message set was generated for R2 data types
	 * @return whether this message set was generated for R2 data types
	 */
	public boolean isGeneratedAsR2() {
		return generatedAsR2;
	}

	/**
	 * <p>Sets whether this message set was generated for R2 data types
	 * @param generatedAsR2 - whether this message set was generated for R2 data types
	 */
	public void setGeneratedAsR2(boolean generatedAsR2) {
		this.generatedAsR2 = generatedAsR2;
	}

	/**
	 * <p>Get a map of all the interactions defined in the message set, keyed by 
	 * interaction id.
	 * @return - the map of all interactions.
	 */
	public Map<String, Interaction> getInteractions() {
		return this.interactions;
	}

	/**
	 * <p>Set the interactions.
	 * @param interactions - the new value
	 */
	public void setInteractions(Map<String, Interaction> interactions) {
		this.interactions = interactions;
	}
	
	public void addInteraction(Interaction interaction) {
		if (interaction != null && interaction.getName() != null) {
			this.interactions.put(interaction.getName(), interaction);
		}
	}

	/**
	 * <p>Get a map of all package locations, keyed by package location id.
	 * @return - the map
	 */
	public Map<String, PackageLocation> getPackageLocations() {
		return this.packageLocations;
	}

	/**
	 * <p>Set the package locations.
	 * @param packageLocations - the new value.
	 */
	public void setPackageLocations(Map<String, PackageLocation> packageLocations) {
		this.packageLocations = packageLocations;
	}
	
	/**
	 * Get a single PackageLocation by name
	 * 
	 * @param name the name of the package location
	 * @returns the package location, or null if no such location is known
	 */
	public PackageLocation getPackageLocation(String name) {
		return this.packageLocations.get(name);
	}
	
	/**
	 * Add a new package location to the MessageSet
	 * 
	 * @param packageLocation the package location
	 */
	public void addPackageLocation(PackageLocation packageLocation) {
		this.packageLocations.put(packageLocation.getName(), packageLocation);
	}
	
	/**
	 * <p>Get a part by part type name.
	 * @param type - the message part type name
	 * @return - the message part
	 */
	public MessagePart getMessagePart(String type) {
		MessagePart messagePart = null;
		if (type != null) {
			String packageLocationName = type.contains(".") ? StringUtils.substringBefore(type, ".") : type;
			PackageLocation location = getPackageLocations().get(packageLocationName);
			if (location == null) {
				messagePart = null;
			} else if (type.contains(".")) {
				messagePart = location.getMessageParts().get(type);
			} else if (StringUtils.isNotBlank(location.getRootType())) {
				messagePart = location.getMessageParts().get(location.getRootType());
			} 
		}
		return messagePart;
	}
	
	/**
	 * <p>Get a template parameter part by name, relative to a referring part. It is assumed that the parameter part will be in the same package location
	 * @param basePart the message part referring to the template parameter
	 * @param templateParameterName the unqualified name of the template parameter
	 * @return the message part defining the template parameter 
	 */
	public MessagePart resolveTemplateParameter(MessagePart basePart, String templateParameterName) {
		MessagePart messagePart = null;
		if (basePart != null) {
			String packageLocationName = StringUtils.substringBefore(basePart.getName(), ".");
			PackageLocation location = getPackageLocations().get(packageLocationName);
			if (location != null && StringUtils.isNotBlank(templateParameterName)) {
				messagePart = location.getMessageParts().get(packageLocationName + "." + templateParameterName);
			} 
		}
		return messagePart;
	}

	/**
	 * <p>Add a message part.
	 * @param part - the message part to add
	 */
	public void addMessagePart(MessagePart part) {
		TypeName name = new TypeName(part.getName());
		
		String packageName = name.getRootName().getName();
		PackageLocation location = this.packageLocations.get(packageName);
		if (location == null) {
			throw new IllegalArgumentException("No package location exists: " + packageName);
		} else {
			location.getMessageParts().put(part.getName(), part);
		}
	}

	/**
	 * <p>Get a collection of all message parts defined by the message set.
	 * @return the message parts
	 */
	public Collection<MessagePart> getAllMessageParts() {
		List<MessagePart> result = new ArrayList<MessagePart>();
		for (PackageLocation packageLocation : this.packageLocations.values()) {
			result.addAll(packageLocation.getMessageParts().values());
		}
		return result;
	}

	/**
	 * <p>Get a package location root type.
	 * @param packageLocation - the package location key
	 * @return the package location
	 */
	public String getPackageLocationRootType(String packageLocation) {
		if (this.packageLocations.containsKey(packageLocation)) {
			return this.packageLocations.get(packageLocation).getRootType();
		} else {
			return null;
		}
	}
	
	/**
	 * <p>Add a constrained datatype.
	 * @param type - the constrained type to add
	 */
	public void addConstrainedDatatype(ConstrainedDatatype type) {
		this.constrainedDatatypes.put(type.getName(), type);
	}

	/**
	 * <p>Check whether the message set contains a constrained datatype with the specified name
	 * 
	 * @param typeName the name to check
	 * @return true is a constrained datatype with that name is defined; false otherwise
	 */
	public boolean hasConstrainedDatatype(String typeName) {
		return this.constrainedDatatypes.containsKey(typeName);
	}

	/**
	 * <p>Get the list of all constrained datatypes
	 * 
	 * @return the list of all constrained datatypes
	 */
	public List<ConstrainedDatatype> getAllConstrainedDatatypes() {
		List<ConstrainedDatatype> result = new ArrayList<ConstrainedDatatype>();
		result.addAll(this.constrainedDatatypes.values());
		return result;
	}
	
	/**
	 * <p>Get a constrained datatype by name
	 * 
	 * @param typeName the name
	 * @return the constrained datatype
	 */
	public ConstrainedDatatype getConstrainedDatatype(String typeName) {
		return this.constrainedDatatypes.get(typeName);
	}
	
	//For XML Serialization in .NET
	public Map<String, ConstrainedDatatype> getConstrainedDatatypes() {
		return constrainedDatatypes;
	}
	public void setConstrainedDatatypes(Map<String, ConstrainedDatatype> constrainedDatatypes) {
		this.constrainedDatatypes = constrainedDatatypes;
	}
	
	/**
	 * <p>Get the component.
	 * @return the component
	 */
	public String getComponent() {
		return this.component;
	}

	/**
	 * <p>Set the component.
	 * @param component - the new value
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * <p>Get the remixHistory.
	 * @return the remixHistory
	 */
	public List<MessageSetHistory> getRemixHistory() {
		return remixHistory;
	}

	/**
	 * <p>Set the remixHistory.
	 * @param remixHistory - the new value
	 */
	public void setRemixHistory(List<MessageSetHistory> remixHistory) {
		this.remixHistory = remixHistory;
	}

	public Vocabulary getVocabulary() {
		if (this.vocabulary == null) {
			this.vocabulary = new Vocabulary();
		}
		return this.vocabulary;
	}

	/**
	 * <p>Get the schema metadata
	 * 
	 * <p>Only used in the context of CDA documents
	 * 
	 * @return the schema metadata
	 */
	public String getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}
	public boolean isVocabularyDataPresent() {
		return this.vocabulary != null && 
				!(this.vocabulary.getConceptDomains().isEmpty() && 
						this.vocabulary.getValueSets().isEmpty());
	}

	public SchemaMetadata getSchemaMetadata() {
		return schemaMetadata;
	}

	public void setSchemaMetadata(SchemaMetadata schemaMetadata) {
		this.schemaMetadata = schemaMetadata;
	}

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	public String getDescriptiveName() {
		return descriptiveName;
	}

	public void setDescriptiveName(String descriptiveName) {
		this.descriptiveName = descriptiveName;
	}

	public String getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}

	public List<SchematronContext> getSchematronContexts() {
		return schematronContexts;
	}
	
	public void addSchematronContext(SchematronContext context) {
		this.schematronContexts.add(context);
	}
}
