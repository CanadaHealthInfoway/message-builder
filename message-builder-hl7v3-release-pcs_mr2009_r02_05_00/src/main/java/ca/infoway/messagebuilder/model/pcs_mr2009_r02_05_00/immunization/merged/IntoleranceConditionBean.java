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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT030060CA.IntoleranceCondition: (no business name)</p>
 * 
 * <p>Necessary component of a person's overall medication and 
 * clinical profile. Helps with drug contraindication 
 * checking.</p>
 * 
 * <p>A record of a patient's allergy or intolerance.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.IntoleranceCondition","POIZ_MT030060CA.IntoleranceCondition","POIZ_MT060150CA.IntoleranceCondition"})
public class IntoleranceConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private CV uncertaintyCode = new CVImpl();


    /**
     * <p>Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to reference allergy and intolerance records 
     * stored in a patient's logitudinal electronic health record. 
     * As a result, this attribute is mandatory.</p>
     * 
     * <p>Unique identifier for the intolerance condition.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to reference allergy and intolerance records 
     * stored in a patient's logitudinal electronic health record. 
     * As a result, this attribute is mandatory.</p>
     * 
     * <p>Unique identifier for the intolerance condition.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRecordID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.IntoleranceCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p>
     * 
     * <p>A coded value denoting whether the record pertains to an 
     * intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.IntoleranceCondition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. The attribute is mandatory because it is 
     * essential to know whether a record is refuted or not.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to refute a previously confirmed or 
     * suspected allergy. The attribute is mandatory because it is 
     * essential to know whether a record is refuted or not.</p>
     * 
     * <p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceRefuted</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'ACTIVE' and is therefore mandatory.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'ACTIVE' or 'COMPLETE' (indicating no 
     * longer active).</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the relevance of a recorded 
     * allergy/intolerance. The status has a default value of 
     * 'ACTIVE' and is therefore mandatory.</p>
     * 
     * <p>A coded value that indicates whether an 
     * allergy/intolerance is 'ACTIVE' or 'COMPLETE' (indicating no 
     * longer active).</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AllergyIntoleranceStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: ConfirmedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications. Attribute is mandatory because an allergy 
     * or intolerance record must be tagged as either 'confirmed' 
     * or 'suspected'.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information. The two valid confirmation 
     * statuses are&quot; 'CONFIRMED' and 'SUSPECTED'. An allergy 
     * or intolerance record is always used in drug 
     * contraindication checking whether the record is tagged as 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: ConfirmedIndicator</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications. Attribute is mandatory because an allergy 
     * or intolerance record must be tagged as either 'confirmed' 
     * or 'suspected'.</p>
     * 
     * <p>An indication of the level of confidence/surety placed in 
     * the recorded information. The two valid confirmation 
     * statuses are&quot; 'CONFIRMED' and 'SUSPECTED'. An allergy 
     * or intolerance record is always used in drug 
     * contraindication checking whether the record is tagged as 
     * 'confirmed' or 'suspected'.</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ConfirmedIndicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.IntoleranceCondition.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }

}