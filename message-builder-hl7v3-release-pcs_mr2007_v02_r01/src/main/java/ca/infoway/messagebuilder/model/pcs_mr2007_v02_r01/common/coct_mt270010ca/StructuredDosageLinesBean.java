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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT270010CA.DosageLine"})
public class StructuredDosageLinesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS dosageUsageContext = new CSImpl();
    private ST adHocDosageInstruction = new STImpl();
    private GTS dosageTimingFrequency = new GTSImpl();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> dosageRate = new URGImpl<PQ, PhysicalQuantity>();
    private AdministrationPreconditionBean triggerActEventCriterion;
    private AdditionalSIGInstructionBean componentSupplementalInstruction;


    /**
     * <p>Dosage Usage Context</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return (x_ActMoodDefEvnRqo) this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }


    /**
     * <p>C:Ad-hoc Dosage Instruction</p>
     */
    @Hl7XmlMapping({"text"})
    public String getAdHocDosageInstruction() {
        return this.adHocDosageInstruction.getValue();
    }
    public void setAdHocDosageInstruction(String adHocDosageInstruction) {
        this.adHocDosageInstruction.setValue(adHocDosageInstruction);
    }


    /**
     * <p>C:Dosage Timing/Frequency</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public GeneralTimingSpecification getDosageTimingFrequency() {
        return this.dosageTimingFrequency.getValue();
    }
    public void setDosageTimingFrequency(GeneralTimingSpecification dosageTimingFrequency) {
        this.dosageTimingFrequency.setValue(dosageTimingFrequency);
    }


    /**
     * <p>D:Dosage Range</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }


    /**
     * <p>E:Dosage Rate</p>
     */
    @Hl7XmlMapping({"rateQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRate() {
        return this.dosageRate.getValue();
    }
    public void setDosageRate(UncertainRange<PhysicalQuantity> dosageRate) {
        this.dosageRate.setValue(dosageRate);
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
