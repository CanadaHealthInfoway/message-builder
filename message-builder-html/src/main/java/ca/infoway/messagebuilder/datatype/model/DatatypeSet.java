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

import ca.infoway.messagebuilder.datatype.mif.MifDatatype;
import ca.infoway.messagebuilder.datatype.mif.MifDatatypeModelLibrary;

public class DatatypeSet {
	private String version;
	private String realmCode;
	private Map<String, Datatype> datatypes = new HashMap<String, Datatype>();
	
	public DatatypeSet() {}
	
	public DatatypeSet(MifDatatypeModelLibrary mifDatatypeModelLibrary) {
		this.version = mifDatatypeModelLibrary.getPackageLocation().getVersion();
		this.realmCode = mifDatatypeModelLibrary.getPackageLocation().getRealmNamespace();
		
		for (MifDatatype mifDatatype : mifDatatypeModelLibrary.getDatatypes()) {
			this.datatypes.put(mifDatatype.getName(), new Datatype(mifDatatype));
		}
	}
	
	public DatatypeSet(DatatypeSet parentSet, MifDatatypeModelLibrary mifDatatypeModelLibrary) {
		this(mifDatatypeModelLibrary);

		for (Datatype datatype : parentSet.getAllDatatypes()) {
			if (!this.datatypes.keySet().contains(datatype.getName())) {				
				this.datatypes.put(datatype.getName(), datatype);
			}
		}
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
}
