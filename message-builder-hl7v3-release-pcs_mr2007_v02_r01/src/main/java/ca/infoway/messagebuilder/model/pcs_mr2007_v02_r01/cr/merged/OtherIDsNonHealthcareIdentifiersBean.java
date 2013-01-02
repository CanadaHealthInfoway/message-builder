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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: OtherIDsNonHealthcareIdentifiers</p>
 * 
 * <p>PRPA_MT101104CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>PRPA_MT101002CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>PRPA_MT101106CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>PRPA_MT101001CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.OtherIDs","PRPA_MT101002CA.OtherIDs","PRPA_MT101104CA.OtherIDs","PRPA_MT101106CA.OtherIDs"})
public class OtherIDsNonHealthcareIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private II assigningIdOrganizationId = new IIImpl();
    private ST assigningIdOrganizationName = new STImpl();


    /**
     * <p>Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIDsRoleCode getCode() {
        return (OtherIDsRoleCode) this.code.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     */
    public void setCode(OtherIDsRoleCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/id"})
    public Identifier getAssigningIdOrganizationId() {
        return this.assigningIdOrganizationId.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     */
    public void setAssigningIdOrganizationId(Identifier assigningIdOrganizationId) {
        this.assigningIdOrganizationId.setValue(assigningIdOrganizationId);
    }


    /**
     * <p>Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/name"})
    public String getAssigningIdOrganizationName() {
        return this.assigningIdOrganizationName.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Un-merged Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     */
    public void setAssigningIdOrganizationName(String assigningIdOrganizationName) {
        this.assigningIdOrganizationName.setValue(assigningIdOrganizationName);
    }

}
