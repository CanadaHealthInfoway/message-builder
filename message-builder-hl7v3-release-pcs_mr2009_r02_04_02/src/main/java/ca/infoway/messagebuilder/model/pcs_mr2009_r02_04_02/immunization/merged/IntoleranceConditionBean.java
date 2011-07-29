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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

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
 * <p><p>A record of a patient's allergy or intolerance.</p></p>
 * 
 * <p><p>Necessary component of a person's overall medication 
 * and clinical profile. Helps with drug contraindication 
 * checking.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.IntoleranceCondition","POIZ_MT030060CA.IntoleranceCondition","POIZ_MT060150CA.IntoleranceCondition"})
public class IntoleranceConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II allergyIntoleranceRecordID = new IIImpl();
    private CD allergyIntoleranceType = new CDImpl();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS allergyIntoleranceStatus = new CSImpl();
    private CV confirmedIndicator = new CVImpl();


    /**
     * <p>AllergyIntoleranceRecordID</p>
     * 
     * <p>Allergy/Intolerance Record ID</p>
     * 
     * <p>Allergy/Intolerance Record ID</p>
     * 
     * <p><p>Unique identifier for the intolerance condition.</p></p>
     * 
     * <p><p>Needed to reference allergy and intolerance records 
     * stored in a patient's logitudinal electronic health record. 
     * As a result, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAllergyIntoleranceRecordID() {
        return this.allergyIntoleranceRecordID.getValue();
    }
    public void setAllergyIntoleranceRecordID(Identifier allergyIntoleranceRecordID) {
        this.allergyIntoleranceRecordID.setValue(allergyIntoleranceRecordID);
    }


    /**
     * <p>AllergyIntoleranceType</p>
     * 
     * <p>Allergy Intolerance Type</p>
     * 
     * <p><p>A coded value denoting whether the record pertains to 
     * an intolerance or a true allergy. (Allergies result from 
     * immunologic reactions. Intolerances do not.)</p></p>
     * 
     * <p><p>Allows for the separation of allergy and intolerance 
     * records. The type of condition is critical to understanding 
     * the record and is therefore mandatory. It is expressed as a 
     * CD to allow for SNOMED post-coordination.</p></p>
     * 
     * <p>Allergy Intolerance Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }


    /**
     * <p>AllergyIntoleranceRefuted</p>
     * 
     * <p>Allergy/Intolerance Refuted</p>
     * 
     * <p>Allergy/Intolerance Refuted</p>
     * 
     * <p><p>An indication that the allergy/intolerance has been 
     * refuted. I.e. A clinician has positively determined that the 
     * patient does not suffer from a particular allergy or 
     * intolerance.</p></p>
     * 
     * <p><p>Allows providers to refute a previously confirmed or 
     * suspected allergy. The attribute is mandatory because it is 
     * essential to know whether a record is refuted or not.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
    }


    /**
     * <p>AllergyIntoleranceStatus</p>
     * 
     * <p>Allergy/Intolerance Status</p>
     * 
     * <p><p>A coded value that indicates whether an 
     * allergy/intolerance is 'ACTIVE' or 'COMPLETE' (indicating no 
     * longer active).</p></p>
     * 
     * <p><p>Allows providers to evaluate the relevance of a 
     * recorded allergy/intolerance. The status has a default value 
     * of 'ACTIVE' and is therefore mandatory.</p></p>
     * 
     * <p>Allergy/Intolerance Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }


    /**
     * <p>ConfirmedIndicator</p>
     * 
     * <p>Confirmed Indicator</p>
     * 
     * <p>Confirmed Indicator</p>
     * 
     * <p><p>An indication of the level of confidence/surety placed 
     * in the recorded information. The two valid confirmation 
     * statuses are&quot; 'CONFIRMED' and 'SUSPECTED'. An allergy 
     * or intolerance record is always used in drug 
     * contraindication checking whether the record is tagged as 
     * 'confirmed' or 'suspected'.</p></p>
     * 
     * <p><p>Helps other providers to make appropriate decisions in 
     * their management of allergy or intolerance 
     * contraindications. Attribute is mandatory because an allergy 
     * or intolerance record must be tagged as either 'confirmed' 
     * or 'suspected'.</p></p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return (ActUncertainty) this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }

}
