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
 * Last modified: $LastChangedDate: 2012-01-10 18:22:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3229 $
 */
package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class CodeSystem {

	@Attribute
	private String name;
	@Attribute
	private String businessName;
	@Attribute
	private String oid;
	@Attribute(required=false)
	private String versionId;
	@Attribute(required=false)
	private Date releaseDate;
	@Attribute
	private boolean complete;
	@Element(required=false)
	private CodeSystemMaintenanceOrganization maintenanceOrganization = new CodeSystemMaintenanceOrganization();
	@Element(required=false)
	private Documentation documentation = new Documentation();
	@ElementList(required=false,inline=false,name="concepts",entry="concept")
	private List<Concept> concepts = new ArrayList<Concept>();
	
	public CodeSystem() {
	}
	public CodeSystem(String name) {
		this.setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public CodeSystemMaintenanceOrganization getMaintenanceOrganization() {
		return maintenanceOrganization;
	}
	public void setMaintenanceOrganization(
			CodeSystemMaintenanceOrganization maintenanceOrganization) {
		this.maintenanceOrganization = maintenanceOrganization;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	public List<Concept> getConcepts() {
		return concepts;
	}
	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}
}
