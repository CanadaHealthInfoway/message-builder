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
/* This class was auto-generated by the message builder generator tools. */
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>COCT_MT090310CA.AssignedDevice: EHR Repository</p>
 * 
 * <p>Provides context about the record and its management.</p>
 * 
 * <p>Identification of the EHR infostructure responsible for 
 * the storage and management of the record.</p>
 * 
 * <p>COCT_MT090302CA.AssignedDevice: Application</p>
 * 
 * <p>Allows an application to be uniquely identified.</p>
 * 
 * <p>A reference to a system/application related to healthcare 
 * information.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice","COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean implements Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private ST assignedRepositoryName = new STImpl();
    private ST representedRepositoryJurisdictionName = new STImpl();
    private ST assignedDeviceManufacturerModelName = new STImpl();


    /**
     * <p>Un-merged Business Name: RepositoryIdentifier</p>
     * 
     * <p>Relationship: COCT_MT090310CA.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows repositories to be uniquely identified for linking 
     * or grouping purposes and is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the EHR repository.</p>
     * 
     * <p>Un-merged Business Name: ApplicationId</p>
     * 
     * <p>Relationship: COCT_MT090302CA.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p>
     * 
     * <p>Unique identifier of an application or a system.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: RepositoryIdentifier</p>
     * 
     * <p>Relationship: COCT_MT090310CA.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows repositories to be uniquely identified for linking 
     * or grouping purposes and is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the EHR repository.</p>
     * 
     * <p>Un-merged Business Name: ApplicationId</p>
     * 
     * <p>Relationship: COCT_MT090302CA.AssignedDevice.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p>
     * 
     * <p>Unique identifier of an application or a system.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: RepositoryName</p>
     * 
     * <p>Un-merged Business Name: RepositoryName</p>
     * 
     * <p>Relationship: COCT_MT090310CA.Repository.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable name for the repository and is 
     * therefore mandatory</p>
     * 
     * <p>The name of the repository which is responsible for 
     * maintaining the record. E.g. &quot;Ontario Health 
     * Respository #3&quot;</p>
     */
    @Hl7XmlMapping({"assignedRepository/name"})
    public String getAssignedRepositoryName() {
        return this.assignedRepositoryName.getValue();
    }

    /**
     * <p>Business Name: RepositoryName</p>
     * 
     * <p>Un-merged Business Name: RepositoryName</p>
     * 
     * <p>Relationship: COCT_MT090310CA.Repository.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable name for the repository and is 
     * therefore mandatory</p>
     * 
     * <p>The name of the repository which is responsible for 
     * maintaining the record. E.g. &quot;Ontario Health 
     * Respository #3&quot;</p>
     */
    public void setAssignedRepositoryName(String assignedRepositoryName) {
        this.assignedRepositoryName.setValue(assignedRepositoryName);
    }


    /**
     * <p>Business Name: RepositoryJurisdictionName</p>
     * 
     * <p>Un-merged Business Name: RepositoryJurisdictionName</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryJurisdiction.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Establishes business context for determining 
     * custodianship, and is therefore mandatory.</p>
     * 
     * <p>The name of the jurisdiction that is responsible for the 
     * EHR infostructure that contains and manages the record.</p>
     */
    @Hl7XmlMapping({"representedRepositoryJurisdiction/name"})
    public String getRepresentedRepositoryJurisdictionName() {
        return this.representedRepositoryJurisdictionName.getValue();
    }

    /**
     * <p>Business Name: RepositoryJurisdictionName</p>
     * 
     * <p>Un-merged Business Name: RepositoryJurisdictionName</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryJurisdiction.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Establishes business context for determining 
     * custodianship, and is therefore mandatory.</p>
     * 
     * <p>The name of the jurisdiction that is responsible for the 
     * EHR infostructure that contains and manages the record.</p>
     */
    public void setRepresentedRepositoryJurisdictionName(String representedRepositoryJurisdictionName) {
        this.representedRepositoryJurisdictionName.setValue(representedRepositoryJurisdictionName);
    }


    /**
     * <p>Business Name: ApplicationName</p>
     * 
     * <p>Un-merged Business Name: ApplicationName</p>
     * 
     * <p>Relationship: 
     * COCT_MT090302CA.Device.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication. The name of the application 
     * must be known and is therefore marked as 'mandatory'.</p>
     * 
     * <p>The name assigned to the application/system.</p>
     */
    @Hl7XmlMapping({"assignedDevice/manufacturerModelName"})
    public String getAssignedDeviceManufacturerModelName() {
        return this.assignedDeviceManufacturerModelName.getValue();
    }

    /**
     * <p>Business Name: ApplicationName</p>
     * 
     * <p>Un-merged Business Name: ApplicationName</p>
     * 
     * <p>Relationship: 
     * COCT_MT090302CA.Device.manufacturerModelName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication. The name of the application 
     * must be known and is therefore marked as 'mandatory'.</p>
     * 
     * <p>The name assigned to the application/system.</p>
     */
    public void setAssignedDeviceManufacturerModelName(String assignedDeviceManufacturerModelName) {
        this.assignedDeviceManufacturerModelName.setValue(assignedDeviceManufacturerModelName);
    }

}
