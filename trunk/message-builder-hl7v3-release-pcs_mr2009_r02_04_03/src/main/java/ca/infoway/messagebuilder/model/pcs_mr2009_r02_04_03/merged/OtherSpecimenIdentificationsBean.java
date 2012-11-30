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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.OtherIdentifiersRoleType;
import java.util.Date;
import java.util.List;



/**
 * <p>COCT_MT080100CA.IdentifiedEntity: Other Specimen 
 * Identifications</p>
 * 
 * <p>Associated specimen identifiers.</p>
 * 
 * <p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing.</p>
 * 
 * <p>COCT_MT050007CA.IdentifiedEntity: Other Identifiers</p>
 * 
 * <p>This role object is used to store any other patient 
 * identification identifiers.</p>
 * 
 * <p>Used for patient identification.</p>
 * 
 * <p>PRPA_MT101003CA.IdentifiedEntity: Identified Person</p>
 * 
 * <p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p>
 * 
 * <p>Provides the message entry point required to add a person 
 * to the Client Registry</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifiedEntity","COCT_MT080100CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ResponsibleOrganizationBean assigningOrganization;
    private LIST<PN, PersonName> identifiedPersonName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV identifiedPersonAdministrativeGenderCode = new CVImpl();
    private TS identifiedPersonBirthTime = new TSImpl();


    /**
     * <p>Other Specimen Identifiers</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>K:Other Identifier</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Drivers 
     * License number, Health insurance number).</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Client Healthcare Identification Number</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Other Specimen Identifiers</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>K:Other Identifier</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Drivers 
     * License number, Health insurance number).</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Client Healthcare Identification Number</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>J:Other Identifier Type</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Other Specimen Identifier Type</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIdentifiersRoleType getCode() {
        return (OtherIdentifiersRoleType) this.code.getValue();
    }

    /**
     * <p>J:Other Identifier Type</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Other Specimen Identifier Type</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     */
    public void setCode(OtherIdentifiersRoleType code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"assigningOrganization"})
    public ResponsibleOrganizationBean getAssigningOrganization() {
        return this.assigningOrganization;
    }

    public void setAssigningOrganization(ResponsibleOrganizationBean assigningOrganization) {
        this.assigningOrganization = assigningOrganization;
    }


    /**
     * <p>ClientName</p>
     * 
     * <p>Client Name</p>
     * 
     * <p>Name(s) for the Client</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getIdentifiedPersonName() {
        return this.identifiedPersonName.rawList();
    }


    /**
     * <p>ClientGender</p>
     * 
     * <p>Client Gender</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (UN)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getIdentifiedPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.identifiedPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>ClientGender</p>
     * 
     * <p>Client Gender</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (UN)</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    public void setIdentifiedPersonAdministrativeGenderCode(AdministrativeGender identifiedPersonAdministrativeGenderCode) {
        this.identifiedPersonAdministrativeGenderCode.setValue(identifiedPersonAdministrativeGenderCode);
    }


    /**
     * <p>ClientDateOfBirth</p>
     * 
     * <p>Client Date of Birth</p>
     * 
     * <p>Date of birth of the Client</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getIdentifiedPersonBirthTime() {
        return this.identifiedPersonBirthTime.getValue();
    }

    /**
     * <p>ClientDateOfBirth</p>
     * 
     * <p>Client Date of Birth</p>
     * 
     * <p>Date of birth of the Client</p>
     * 
     * <p>Populated attribute supports the identification of the 
     * client</p>
     */
    public void setIdentifiedPersonBirthTime(Date identifiedPersonBirthTime) {
        this.identifiedPersonBirthTime.setValue(identifiedPersonBirthTime);
    }

}
