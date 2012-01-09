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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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
 * <p><p>Identification of the EHR infostructure responsible 
 * for the storage and management of the record.</p></p>
 * 
 * <p><p>Provides context about the record and its 
 * management.</p></p>
 * 
 * <p>COCT_MT090302CA.AssignedDevice: Application</p>
 * 
 * <p><p>A reference to a system/application related to 
 * healthcare information.</p></p>
 * 
 * <p><p>Allows an application to be uniquely identified.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice","COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private ST assignedRepositoryName = new STImpl();
    private ST representedRepositoryJurisdictionName = new STImpl();
    private ST assignedDeviceManufacturerModelName = new STImpl();


    /**
     * <p>Repository Identifier</p>
     * 
     * <p><p>A unique identifier for the EHR repository.</p></p>
     * 
     * <p><p>Allows repositories to be uniquely identified for 
     * linking or grouping purposes and is therefore mandatory.</p></p>
     * 
     * <p>C:Application Id</p>
     * 
     * <p><p>Unique identifier of an application or a system.</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p></p>
     * 
     * <p><p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>RepositoryName</p>
     * 
     * <p>Repository Name</p>
     * 
     * <p><p>The name of the repository which is responsible for 
     * maintaining the record. E.g. &quot;Ontario Health 
     * Respository #3&quot;</p></p>
     * 
     * <p><p>Provides a human-readable name for the repository and 
     * is therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"assignedRepository/name"})
    public String getAssignedRepositoryName() {
        return this.assignedRepositoryName.getValue();
    }
    public void setAssignedRepositoryName(String assignedRepositoryName) {
        this.assignedRepositoryName.setValue(assignedRepositoryName);
    }


    /**
     * <p>RepositoryJurisdictionName</p>
     * 
     * <p>Repository Jurisdiction Name</p>
     * 
     * <p><p>The name of the jurisdiction that is responsible for 
     * the EHR infostructure that contains and manages the 
     * record.</p></p>
     * 
     * <p><p>Establishes business context for determining 
     * custodianship, and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"representedRepositoryJurisdiction/name"})
    public String getRepresentedRepositoryJurisdictionName() {
        return this.representedRepositoryJurisdictionName.getValue();
    }
    public void setRepresentedRepositoryJurisdictionName(String representedRepositoryJurisdictionName) {
        this.representedRepositoryJurisdictionName.setValue(representedRepositoryJurisdictionName);
    }


    /**
     * <p>ApplicationName</p>
     * 
     * <p>B: Application Name</p>
     * 
     * <p><p>The name assigned to the application/system.</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>Used for human communication. The name of the 
     * application must be known and is therefore marked as 
     * 'mandatory'.</p></p>
     */
    @Hl7XmlMapping({"assignedDevice/manufacturerModelName"})
    public String getAssignedDeviceManufacturerModelName() {
        return this.assignedDeviceManufacturerModelName.getValue();
    }
    public void setAssignedDeviceManufacturerModelName(String assignedDeviceManufacturerModelName) {
        this.assignedDeviceManufacturerModelName.setValue(assignedDeviceManufacturerModelName);
    }

}
