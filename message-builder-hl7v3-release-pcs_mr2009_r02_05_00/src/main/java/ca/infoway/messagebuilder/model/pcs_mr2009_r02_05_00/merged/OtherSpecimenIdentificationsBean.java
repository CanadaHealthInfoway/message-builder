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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.OtherIdentifiersRoleType;
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
 * <p>COCT_MT050007CA.IdentifiedEntity: Other Identifiers</p>
 * 
 * <p>Used for patient identification.</p>
 * 
 * <p>This role object is used to store any other patient 
 * identification identifiers.</p>
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
@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifiedEntity","COCT_MT080100CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20140507L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ResponsibleOrganizationBean assigningOrganization;
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
     * <p>Un-merged Business Name: OtherIdentifier</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Driver'''s 
     * License number, Health insurance number).</p>
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
     * <p>Un-merged Business Name: OtherIdentifier</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Driver'''s 
     * License number, Health insurance number).</p>
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
     * 
     * <p>Un-merged Business Name: OtherIdentifierType</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIdentifiersRoleType getCode() {
        return (OtherIdentifiersRoleType) this.code.getValue();
    }

    /**
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
     * 
     * <p>Un-merged Business Name: OtherIdentifierType</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     */
    public void setCode(OtherIdentifiersRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.IdentifiedEntity.assigningOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"assigningOrganization"})
    public ResponsibleOrganizationBean getAssigningOrganization() {
        return this.assigningOrganization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.IdentifiedEntity.assigningOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAssigningOrganization(ResponsibleOrganizationBean assigningOrganization) {
        this.assigningOrganization = assigningOrganization;
    }


    /**
     * <p>Business Name: ClientName</p>
     * 
     * <p>Un-merged Business Name: ClientName</p>
     * 
     * <p>Relationship: PRPA_MT101003CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-20)</p>
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
     * (UN)</p>
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
     * (UN)</p>
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
