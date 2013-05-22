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
package ca.infoway.messagebuilder.datatype.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.datatype.mif.MifDatatype;
import ca.infoway.messagebuilder.datatype.mif.MifDatatypeModelLibrary;
import ca.infoway.messagebuilder.datatype.mif.MifIdentifier;

@Root
public class DatatypeSet {
	@Attribute(required=false)
	private String version;
	
	@Attribute(required=false)
	private String realmCode;
	
	@Attribute(required=false)
	private String combinedId;
	
	@ElementMap(name="datatype",key="name",required=false,inline=true,attribute=true,entry="datatypeEntry")
	private Map<String, Datatype> datatypes = new HashMap<String, Datatype>();
	
	@Element(required=false)
	private DatatypeSet parentDatatypeSet;
	
	public DatatypeSet() {}
	
	public DatatypeSet(MifDatatypeModelLibrary mifDatatypeModelLibrary) {
		this.version = mifDatatypeModelLibrary.getPackageLocation().getVersion();
		this.realmCode = mifDatatypeModelLibrary.getPackageLocation().getRealmNamespace();
		this.combinedId = getCombinedId(mifDatatypeModelLibrary.getPackageLocation());
		
		String parentCombinedId = getImportedPackageCombinedId(mifDatatypeModelLibrary);
		if (parentCombinedId != null && getParentDatatypeSet() == null) {
			if (StringUtils.isNotBlank(mifDatatypeModelLibrary.getImportedVocabularyModelPackage().getVersion())) {
				throw new RuntimeException("unable to complete processing of datatype coremif: " + getVersion() + ", missing parent coremif: " + parentCombinedId);
			}
		} else if (parentCombinedId != null && getParentDatatypeSet() != null && !parentCombinedId.equals(getParentDatatypeSet().getCombinedId())) {
			throw new RuntimeException("unable to complete processing of datatype coremif: " + getVersion() + ", incorrect parent coremif expecting: " + parentCombinedId);
		}
		
		for (MifDatatype mifDatatype : mifDatatypeModelLibrary.getDatatypes()) {
			if (mifDatatype.getProperties().size() > 0 && mifDatatype.getDerivedFrom().size() > 0) {
				this.datatypes.put(mifDatatype.getName(), new Datatype(mifDatatype, getParentDatatypeSet()));
			}
		}
	}
	
	public DatatypeSet(DatatypeSet parentSet, MifDatatypeModelLibrary mifDatatypeModelLibrary) {
		this.parentDatatypeSet = parentSet;
		this.version = mifDatatypeModelLibrary.getPackageLocation().getVersion();
		this.realmCode = mifDatatypeModelLibrary.getPackageLocation().getRealmNamespace();
		this.combinedId = getCombinedId(mifDatatypeModelLibrary.getPackageLocation());
		
		String parentCombinedId = getImportedPackageCombinedId(mifDatatypeModelLibrary);
		if (parentCombinedId != null && getParentDatatypeSet() == null) {
			if (StringUtils.isNotBlank(mifDatatypeModelLibrary.getImportedVocabularyModelPackage().getVersion())) {
				throw new RuntimeException("unable to complete processing of datatype coremif: " + getVersion() + ", missing parent coremif: " + parentCombinedId);
			}
		} else if (parentCombinedId != null && getParentDatatypeSet() != null && !parentCombinedId.equals(getParentDatatypeSet().getCombinedId())) {
			throw new RuntimeException("unable to complete processing of datatype coremif: " + getVersion() + ", incorrect parent coremif expecting: " + parentCombinedId);
		}
		
		List<Datatype> allDatatypes = parentSet.getAllDatatypes();
		for (Datatype datatype : allDatatypes) {
			this.datatypes.put(datatype.getName(), datatype);
		}
		
		for (MifDatatype mifDatatype : mifDatatypeModelLibrary.getDatatypes()) {
			this.datatypes.put(mifDatatype.getName(), new Datatype(mifDatatype, getParentDatatypeSet()));
		}
	}
	
	private String getCombinedId(MifIdentifier packageLocation) {
		if (packageLocation != null) {
			return packageLocation.getRoot() + "="
				+ packageLocation.getRealmNamespace() + "="
				+ packageLocation.getArtifact() + "="
				+ packageLocation.getVersion();
		}	
		return "";
	}

	private String getImportedPackageCombinedId(MifDatatypeModelLibrary mifDatatypeModelLibrary) {
		if (mifDatatypeModelLibrary != null && mifDatatypeModelLibrary.getImportDatatypeModelLibrary() != null) {
			String result = "";
			MifIdentifier importedDatatypeModelPackage = mifDatatypeModelLibrary.getImportDatatypeModelLibrary();
			if (importedDatatypeModelPackage.getRoot() != null) {
				result += importedDatatypeModelPackage.getRoot() + "=";
			}
			if (importedDatatypeModelPackage.getRealmNamespace() != null) {
				result += importedDatatypeModelPackage.getRealmNamespace() + "=";
			}
			if (importedDatatypeModelPackage.getArtifact() != null) {
				result += importedDatatypeModelPackage.getArtifact() + "=";
			}
			if (importedDatatypeModelPackage.getVersion() != null) {
				result += importedDatatypeModelPackage.getVersion();
			}
			return result;
		}
		return null;
	}
	
	public Datatype getDatatype(String datatypeName) {
		return this.datatypes.get(datatypeName);
	}
	
	public List<Datatype> getAllDatatypes() {
		return new ArrayList<Datatype>(this.datatypes.values());
	}

	public Map<String, Datatype> getDatatypes() {
		return this.datatypes;
	}
	
	public void setDatatypes(Map<String, Datatype> datatypes) {
		this.datatypes = datatypes;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}

	public DatatypeSet getParentDatatypeSet() {
		return parentDatatypeSet;
	}

	public void setParentDatatypeSet(DatatypeSet parentDatatypeSet) {
		this.parentDatatypeSet = parentDatatypeSet;
	}

	public String getCombinedId() {
		return combinedId;
	}

	public void setCombinedId(String combinedId) {
		this.combinedId = combinedId;
	}
}
