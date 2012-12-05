/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.EntityClass;
import ca.infoway.messagebuilder.domainvalue.EntityDeterminer;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: OtherIDsNonHealthcareIdentifiers</p>
 * 
 * <p>PRPA_MT101104CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>PRPA_MT101002CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>PRPA_MT101106CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 * 
 * <p>PRPA_MT101001CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p>
 * 
 * <p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.OtherIDs","PRPA_MT101002CA.OtherIDs","PRPA_MT101104CA.OtherIDs","PRPA_MT101106CA.OtherIDs"})
public class OtherIDsNonHealthcareIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS assigningIdOrganizationClassCode = new CSImpl();
    private CS assigningIdOrganizationDeterminerCode = new CSImpl();
    private II assigningIdOrganizationId = new IIImpl();
    private ST assigningIdOrganizationName = new STImpl();


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code specifying the major category of a Role as defined 
     * by HL7 vocabulary.</p>
     * 
     * <p>Provides a means to identify Roles played by entities</p>
     */
    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A code specifying the major category of a Role as defined 
     * by HL7 vocabulary.</p>
     * 
     * <p>Provides a means to identify Roles played by entities</p>
     */
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentification</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIDsRoleCode getCode() {
        return (OtherIDsRoleCode) this.code.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Other Business Name: NonHealthcareIdentificationCode</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.OtherIDs.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A pan Canadian code further specifying the kind of Role 
     * such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    public void setCode(OtherIDsRoleCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>Due to the extremely large number of potential values for 
     * a code set representing all physical things in the universe, 
     * the class code indicates both the subtype branch of the 
     * Entity hierarchy used as well as a high level classifier to 
     * represent the instance of Entity. This can be used to 
     * constrain the eligible value domains for the Entity.code 
     * attribute.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityClass.htm</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/classCode"})
    public EntityClass getAssigningIdOrganizationClassCode() {
        return (EntityClass) this.assigningIdOrganizationClassCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>An HL7 defined value representing the class or category 
     * that the Entity instance represents.</p><p>Examples: Person, 
     * Animal, Chemical Substance, Group, Organization</p>
     * 
     * <p>Due to the extremely large number of potential values for 
     * a code set representing all physical things in the universe, 
     * the class code indicates both the subtype branch of the 
     * Entity hierarchy used as well as a high level classifier to 
     * represent the instance of Entity. This can be used to 
     * constrain the eligible value domains for the Entity.code 
     * attribute.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityClass.htm</p>
     */
    public void setAssigningIdOrganizationClassCode(EntityClass assigningIdOrganizationClassCode) {
        this.assigningIdOrganizationClassCode.setValue(assigningIdOrganizationClassCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdOrganization.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An Entity may at times represent information concerning a 
     * specific instance (the most common), a quantifiable group 
     * with common characteristics or a general type of Entity. 
     * This code distinguishes these different representations.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityDeterminer.htm</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/determinerCode"})
    public EntityDeterminer getAssigningIdOrganizationDeterminerCode() {
        return (EntityDeterminer) this.assigningIdOrganizationDeterminerCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101104CA.IdOrganization.determinerCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An HL7 defined value representing whether the Entity 
     * represents a kind-of or a specific instance.</p><p>Examples: 
     * 1 human being (an instance), 3 syringes (quantified kind) or 
     * the population of Indianapolis (kind of group)</p>
     * 
     * <p>An Entity may at times represent information concerning a 
     * specific instance (the most common), a quantifiable group 
     * with common characteristics or a general type of Entity. 
     * This code distinguishes these different representations.</p>
     * 
     * <p>http://www.hl7.org/v3ballot/html/infrastructure/vocabulary/EntityDeterminer.htm</p>
     */
    public void setAssigningIdOrganizationDeterminerCode(EntityDeterminer assigningIdOrganizationDeterminerCode) {
        this.assigningIdOrganizationDeterminerCode.setValue(assigningIdOrganizationDeterminerCode);
    }


    /**
     * <p>Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/id"})
    public Identifier getAssigningIdOrganizationId() {
        return this.assigningIdOrganizationId.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for the organization that assigned the 
     * non-healthcare identifier for the client.</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     */
    public void setAssigningIdOrganizationId(Identifier assigningIdOrganizationId) {
        this.assigningIdOrganizationId.setValue(assigningIdOrganizationId);
    }


    /**
     * <p>Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/name"})
    public String getAssigningIdOrganizationName() {
        return this.assigningIdOrganizationName.getValue();
    }

    /**
     * <p>Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101002CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101106CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     * 
     * <p>Other Business Name: NonHealthcareOrganizationName</p>
     * 
     * <p>Relationship: PRPA_MT101001CA.IdOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A name for the non-healthcare organization</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p>
     */
    public void setAssigningIdOrganizationName(String assigningIdOrganizationName) {
        this.assigningIdOrganizationName.setValue(assigningIdOrganizationName);
    }

}
