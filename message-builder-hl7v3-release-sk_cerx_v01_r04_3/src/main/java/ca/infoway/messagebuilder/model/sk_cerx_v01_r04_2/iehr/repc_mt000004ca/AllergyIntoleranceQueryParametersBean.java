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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt000004ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Allergy/Intolerance Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"REPC_MT000004CA.ParameterList"})
@Hl7RootType
public class AllergyIntoleranceQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV allergyIntoleranceStatusValue = new CVImpl();
    private CD allergyIntoleranceTypeValue = new CDImpl();
    private IVL<TS, Interval<Date>> alllergyIntoleranceChangePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private BL includeNotesIndicatorValue = new BLImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private CV reactionTypeValue = new CVImpl();


    /**
     * <p>Business Name: G:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the result set should be filtered to 
     * include only those allergy/intolerance records for the 
     * specified status. Valid statuses include: ACTIVE or 
     * COMPLETE.</p>
     * 
     * <p>Allows for the selective retrieval of allergy/intolerance 
     * records based on the status of the record.</p>
     */
    @Hl7XmlMapping({"allergyIntoleranceStatus/value"})
    public ActStatus getAllergyIntoleranceStatusValue() {
        return (ActStatus) this.allergyIntoleranceStatusValue.getValue();
    }

    /**
     * <p>Business Name: G:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the result set should be filtered to 
     * include only those allergy/intolerance records for the 
     * specified status. Valid statuses include: ACTIVE or 
     * COMPLETE.</p>
     * 
     * <p>Allows for the selective retrieval of allergy/intolerance 
     * records based on the status of the record.</p>
     */
    public void setAllergyIntoleranceStatusValue(ActStatus allergyIntoleranceStatusValue) {
        this.allergyIntoleranceStatusValue.setValue(allergyIntoleranceStatusValue);
    }


    /**
     * <p>Business Name: H:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value indicating whether to return an allergy 
     * record or an intolerance record. The result set will be 
     * filtered to include only allergy records or intolerance 
     * records accordingly.</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p><strong>If a non-leaf code is specified, then all records 
     * whose type is in the specified code\'s hierarchy will be 
     * returned. Example: if ALG is specified, any DALG,</strong> 
     * <strong>EALG, or FALG will be returned.</strong></p>
     */
    @Hl7XmlMapping({"allergyIntoleranceType/value"})
    public ObservationIntoleranceType getAllergyIntoleranceTypeValue() {
        return (ObservationIntoleranceType) this.allergyIntoleranceTypeValue.getValue();
    }

    /**
     * <p>Business Name: H:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value indicating whether to return an allergy 
     * record or an intolerance record. The result set will be 
     * filtered to include only allergy records or intolerance 
     * records accordingly.</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p><strong>If a non-leaf code is specified, then all records 
     * whose type is in the specified code\'s hierarchy will be 
     * returned. Example: if ALG is specified, any DALG,</strong> 
     * <strong>EALG, or FALG will be returned.</strong></p>
     */
    public void setAllergyIntoleranceTypeValue(ObservationIntoleranceType allergyIntoleranceTypeValue) {
        this.allergyIntoleranceTypeValue.setValue(allergyIntoleranceTypeValue);
    }


    /**
     * <p>Business Name: F:Allergy/Intolerance Change Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AlllergyIntoleranceChangePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Filters the query response to only include 
     * allergy/intolerance records which have been created or 
     * modified within the date-range specified.</p>
     * 
     * <p>Useful in retrieving incremental changes to the patient's 
     * record.</p>
     */
    @Hl7XmlMapping({"alllergyIntoleranceChangePeriod/value"})
    public Interval<Date> getAlllergyIntoleranceChangePeriodValue() {
        return this.alllergyIntoleranceChangePeriodValue.getValue();
    }

    /**
     * <p>Business Name: F:Allergy/Intolerance Change Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AlllergyIntoleranceChangePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Filters the query response to only include 
     * allergy/intolerance records which have been created or 
     * modified within the date-range specified.</p>
     * 
     * <p>Useful in retrieving incremental changes to the patient's 
     * record.</p>
     */
    public void setAlllergyIntoleranceChangePeriodValue(Interval<Date> alllergyIntoleranceChangePeriodValue) {
        this.alllergyIntoleranceChangePeriodValue.setValue(alllergyIntoleranceChangePeriodValue);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000004CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * allergy/intolerance records are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000004CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * allergy/intolerance records are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p><strong>This will be compared to the birthdate of the 
     * patient given by the ID. (See the External Registry ID 
     * section for details on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p><strong>This will be compared to the birthdate of the 
     * patient given by the ID. (See the External Registry ID 
     * section for details on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p><strong>This will be compared to the gender of the 
     * patient given by the ID. (See the External Registry ID 
     * section for details on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p><strong>This will be compared to the gender of the 
     * patient given by the ID. (See the External Registry ID 
     * section for details on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid.</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this ID. 
     * <strong>A KEY204 error issue will be returned if this ID 
     * does not exist in the jurisdictional client 
     * registry.</strong></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid.</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this ID. 
     * <strong>A KEY204 error issue will be returned if this ID 
     * does not exist in the jurisdictional client 
     * registry.</strong></p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * allergy/intolerance query. <strong>This will be compared to 
     * the name of the patient given by the ID. (See the External 
     * Registry ID section on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT000004CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * allergy/intolerance query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * allergy/intolerance query. <strong>This will be compared to 
     * the name of the patient given by the ID. (See the External 
     * Registry ID section on the comparison and the error that may 
     * be raised.)</strong></p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: I:Reaction</p>
     * 
     * <p>Relationship: REPC_MT000004CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific reaction. E.g. Code for 
     * 'rash'. The result set will be filtered to include only 
     * those allergy records or intolerance records pertaining to 
     * the specified reaction.</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     */
    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReactionTypeValue() {
        return (SubjectReaction) this.reactionTypeValue.getValue();
    }

    /**
     * <p>Business Name: I:Reaction</p>
     * 
     * <p>Relationship: REPC_MT000004CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific reaction. E.g. Code for 
     * 'rash'. The result set will be filtered to include only 
     * those allergy records or intolerance records pertaining to 
     * the specified reaction.</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     */
    public void setReactionTypeValue(SubjectReaction reactionTypeValue) {
        this.reactionTypeValue.setValue(reactionTypeValue);
    }

}