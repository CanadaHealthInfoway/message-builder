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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980040CA.DosageLine"})
public class StructuredDosageLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20120130L;
    private CS moodCode = new CSImpl();
    private ST text = new STImpl();
    private GTS effectiveTime = new GTSImpl();
    private URG<PQ, PhysicalQuantity> doseQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> rateQuantity = new URGImpl<PQ, PhysicalQuantity>();
    private AdministrationPreconditionBean triggerActEventCriterion;
    private AdditionalSIGInstructionBean componentSupplementalInstruction;


    /**
     * <p>Dosage Usage Context</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>C:Ad-hoc Dosage Instruction</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>C:Dosage Timing/Frequency</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public GeneralTimingSpecification getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(GeneralTimingSpecification effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>D:Dosage Range</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDoseQuantity() {
        return this.doseQuantity.getValue();
    }
    public void setDoseQuantity(UncertainRange<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>E:Dosage Rate</p>
     */
    @Hl7XmlMapping({"rateQuantity"})
    public UncertainRange<PhysicalQuantity> getRateQuantity() {
        return this.rateQuantity.getValue();
    }
    public void setRateQuantity(UncertainRange<PhysicalQuantity> rateQuantity) {
        this.rateQuantity.setValue(rateQuantity);
    }


    @Hl7XmlMapping({"trigger/actEventCriterion"})
    public AdministrationPreconditionBean getTriggerActEventCriterion() {
        return this.triggerActEventCriterion;
    }
    public void setTriggerActEventCriterion(AdministrationPreconditionBean triggerActEventCriterion) {
        this.triggerActEventCriterion = triggerActEventCriterion;
    }


    @Hl7XmlMapping({"component/supplementalInstruction"})
    public AdditionalSIGInstructionBean getComponentSupplementalInstruction() {
        return this.componentSupplementalInstruction;
    }
    public void setComponentSupplementalInstruction(AdditionalSIGInstructionBean componentSupplementalInstruction) {
        this.componentSupplementalInstruction = componentSupplementalInstruction;
    }

}
