/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090310ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: EHR Repository</p>
 * 
 * <p>Provides context about the record and its management.</p>
 * 
 * <p>Identification of the EHR infostructure responsible for 
 * the storage and management of the record</p>
 */
@Hl7PartTypeMapping({"COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private ST assignedRepositoryLocationName = new STImpl();
    private TEL assignedRepositoryLocationTelecom = new TELImpl();
    private ST representedRepositoryJurisdictionName = new STImpl();


    /**
     * <p>Business Name: Repository Name</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryLocation.name</p>
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
    @Hl7XmlMapping({"assignedRepositoryLocation/name"})
    public String getAssignedRepositoryLocationName() {
        return this.assignedRepositoryLocationName.getValue();
    }

    /**
     * <p>Business Name: Repository Name</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryLocation.name</p>
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
    public void setAssignedRepositoryLocationName(String assignedRepositoryLocationName) {
        this.assignedRepositoryLocationName.setValue(assignedRepositoryLocationName);
    }


    /**
     * <p>Business Name: Repository URL</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows direct access to the repository and is therefore 
     * mandatory.</p>
     * 
     * <p>Identification of the electronic address for reaching the 
     * repository where the event is stored.</p>
     */
    @Hl7XmlMapping({"assignedRepositoryLocation/telecom"})
    public TelecommunicationAddress getAssignedRepositoryLocationTelecom() {
        return this.assignedRepositoryLocationTelecom.getValue();
    }

    /**
     * <p>Business Name: Repository URL</p>
     * 
     * <p>Relationship: COCT_MT090310CA.RepositoryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows direct access to the repository and is therefore 
     * mandatory.</p>
     * 
     * <p>Identification of the electronic address for reaching the 
     * repository where the event is stored.</p>
     */
    public void setAssignedRepositoryLocationTelecom(TelecommunicationAddress assignedRepositoryLocationTelecom) {
        this.assignedRepositoryLocationTelecom.setValue(assignedRepositoryLocationTelecom);
    }


    /**
     * <p>Business Name: Repository Jurisdiction Name</p>
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
     * <p>Business Name: Repository Jurisdiction Name</p>
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

}
