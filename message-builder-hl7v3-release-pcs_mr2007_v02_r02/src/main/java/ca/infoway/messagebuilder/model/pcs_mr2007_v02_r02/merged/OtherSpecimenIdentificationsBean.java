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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.SpecimenIdentifierRoleType;
import java.util.Date;
import java.util.List;



/**
 * <p>COCT_MT080100CA.IdentifiedEntity: Other Specimen 
 * Identifications</p>
 * 
 * <p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing.</p>
 * 
 * <p>Associated specimen identifiers.</p>
 * 
 * <p>PRPA_MT101003CA.IdentifiedEntity: Identified Person</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private II assigningOrganizationId = new IIImpl();
    private ST assigningOrganizationName = new STImpl();
    private LIST<PN, PersonName> identifiedPersonName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV identifiedPersonAdministrativeGenderCode = new CVImpl();
    private TS identifiedPersonBirthTime = new TSImpl();


    /**
     * <p>Un-merged Business Name: OtherSpecimenIdentifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>Un-merged Business Name: 
     * ClientHealthcareIdentificationNumber</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: OtherSpecimenIdentifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>Un-merged Business Name: 
     * ClientHealthcareIdentificationNumber</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: OtherSpecimenIdentifierType</p>
     * 
     * <p>Un-merged Business Name: OtherSpecimenIdentifierType</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     */
    @Hl7XmlMapping({"code"})
    public SpecimenIdentifierRoleType getCode() {
        return (SpecimenIdentifierRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: OtherSpecimenIdentifierType</p>
     * 
     * <p>Un-merged Business Name: OtherSpecimenIdentifierType</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     */
    public void setCode(SpecimenIdentifierRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    @Hl7XmlMapping({"assigningOrganization/id"})
    public Identifier getAssigningOrganizationId() {
        return this.assigningOrganizationId.getValue();
    }

    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    public void setAssigningOrganizationId(Identifier assigningOrganizationId) {
        this.assigningOrganizationId.setValue(assigningOrganizationId);
    }


    /**
     * <p>Business Name: OrganizationName</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    @Hl7XmlMapping({"assigningOrganization/name"})
    public String getAssigningOrganizationName() {
        return this.assigningOrganizationName.getValue();
    }

    /**
     * <p>Business Name: OrganizationName</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    public void setAssigningOrganizationName(String assigningOrganizationName) {
        this.assigningOrganizationName.setValue(assigningOrganizationName);
    }


    /**
     * <p>Business Name: ClientName</p>
     * 
     * <p>Un-merged Business Name: ClientName</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Name(s) for the Client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getIdentifiedPersonName() {
        return this.identifiedPersonName.rawList();
    }


    /**
     * <p>Business Name: ClientGender</p>
     * 
     * <p>Un-merged Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101003CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (U)</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getIdentifiedPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.identifiedPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: ClientGender</p>
     * 
     * <p>Un-merged Business Name: ClientGender</p>
     * 
     * <p>Relationship: 
     * PRPA_MT101003CA.Person.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (U)</p>
     */
    public void setIdentifiedPersonAdministrativeGenderCode(AdministrativeGender identifiedPersonAdministrativeGenderCode) {
        this.identifiedPersonAdministrativeGenderCode.setValue(identifiedPersonAdministrativeGenderCode);
    }


    /**
     * <p>Business Name: ClientDateOfBirth</p>
     * 
     * <p>Un-merged Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getIdentifiedPersonBirthTime() {
        return this.identifiedPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: ClientDateOfBirth</p>
     * 
     * <p>Un-merged Business Name: ClientDateOfBirth</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.Person.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    public void setIdentifiedPersonBirthTime(Date identifiedPersonBirthTime) {
        this.identifiedPersonBirthTime.setValue(identifiedPersonBirthTime);
    }

}
