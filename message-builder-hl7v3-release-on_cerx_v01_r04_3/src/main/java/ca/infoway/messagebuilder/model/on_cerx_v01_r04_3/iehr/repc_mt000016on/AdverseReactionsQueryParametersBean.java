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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.repc_mt000016on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Adverse Reactions Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000016ON.ParameterList"})
@Hl7RootType
public class AdverseReactionsQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private BL includeNotesIndicatorValue = new BLImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private IVL<TS, Interval<Date>> reactionPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private CV reactionTypeValue = new CVImpl();


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000016ON.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the adverse 
     * reactions records are to be returned along with the detailed 
     * information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000016ON.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the adverse 
     * reactions records are to be returned along with the detailed 
     * information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: E:Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: D:Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * adverse reaction query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * adverse reaction query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the adverse 
     * reaction query.</p><p>Filter the result set to include only 
     * those records pertaining to the patient with this name.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT000016ON.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the adverse 
     * reaction query.</p><p>Filter the result set to include only 
     * those records pertaining to the patient with this name.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: F:Reaction Period</p>
     * 
     * <p>Relationship: REPC_MT000016ON.ReactionPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the adverse reaction 
     * period of interest for retrieval of adverse reaction 
     * records. Useful to avoid run-away queries.</p>
     * 
     * <p>The period in which the recorded adverse reaction 
     * occurred or was updated. I.e. Filters the result-set to 
     * those reactions whose onset occurred within the time-range 
     * specified by this parameter.</p>
     */
    @Hl7XmlMapping({"reactionPeriod/value"})
    public Interval<Date> getReactionPeriodValue() {
        return this.reactionPeriodValue.getValue();
    }

    /**
     * <p>Business Name: F:Reaction Period</p>
     * 
     * <p>Relationship: REPC_MT000016ON.ReactionPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the adverse reaction 
     * period of interest for retrieval of adverse reaction 
     * records. Useful to avoid run-away queries.</p>
     * 
     * <p>The period in which the recorded adverse reaction 
     * occurred or was updated. I.e. Filters the result-set to 
     * those reactions whose onset occurred within the time-range 
     * specified by this parameter.</p>
     */
    public void setReactionPeriodValue(Interval<Date> reactionPeriodValue) {
        this.reactionPeriodValue.setValue(reactionPeriodValue);
    }


    /**
     * <p>Business Name: G:Reaction Type</p>
     * 
     * <p>Relationship: REPC_MT000016ON.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve only those 
     * allergy/intolerance records for which there was a specific 
     * type of reaction.</p>
     * 
     * <p>Indicates that the result set be filtered to include only 
     * those allergy/intolerance records for which specific type of 
     * reaction was recorded.</p><p>Reaction types include: STEVEN 
     * JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p>
     */
    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReactionTypeValue() {
        return (SubjectReaction) this.reactionTypeValue.getValue();
    }

    /**
     * <p>Business Name: G:Reaction Type</p>
     * 
     * <p>Relationship: REPC_MT000016ON.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve only those 
     * allergy/intolerance records for which there was a specific 
     * type of reaction.</p>
     * 
     * <p>Indicates that the result set be filtered to include only 
     * those allergy/intolerance records for which specific type of 
     * reaction was recorded.</p><p>Reaction types include: STEVEN 
     * JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p>
     */
    public void setReactionTypeValue(SubjectReaction reactionTypeValue) {
        this.reactionTypeValue.setValue(reactionTypeValue);
    }

}
