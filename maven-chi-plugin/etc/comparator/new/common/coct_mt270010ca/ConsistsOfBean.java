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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>b:consists of 
 * 
 * <p>Dosage instructions may be given as textual information 
 * (as in Ad-hoc Dosage Instructions specified above) or as a 
 * structured set of dosage lines. This association allows for 
 * the specification of structured dosage lines. 
 * 
 * <p>Structured dosage lines facilitate the checking of dosage 
 * appropriateness. It also allows for the formal calculation 
 * of days supply based on administration instructions and 
 * supplied quantity. 
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.Component17"})
public class ConsistsOfBean extends MessagePartBean {

    private INT dosageLineOrder = new INTImpl();
    private CS<x_ActMoodDefEvnRqo> dosageUsageContext = new CSImpl<x_ActMoodDefEvnRqo>();
    private ST adHocDosageInstruction = new STImpl();
    private GTS dosageTimingFrequency = new GTSImpl();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();
    private URG<PQ, PhysicalQuantity> dosageRate = new URGImpl<PQ, PhysicalQuantity>();
    private AdditionalSIGInstructionBean dosageLineComponentSupplementalInstruction;
    private ST dosageCondition = new STImpl();

    @Hl7XmlMapping({"sequenceNumber"})
    public java.lang.Integer getDosageLineOrder() {
        return this.dosageLineOrder.getValue();
    }
    public void setDosageLineOrder(java.lang.Integer dosageLineOrder) {
        this.dosageLineOrder.setValue(dosageLineOrder);
    }

    @Hl7XmlMapping({"dosageLine/moodCode"})
    public x_ActMoodDefEvnRqo getDosageUsageContext() {
        return this.dosageUsageContext.getValue();
    }
    public void setDosageUsageContext(x_ActMoodDefEvnRqo dosageUsageContext) {
        this.dosageUsageContext.setValue(dosageUsageContext);
    }

    @Hl7XmlMapping({"dosageLine/text"})
    public java.lang.String getAdHocDosageInstruction() {
        return this.adHocDosageInstruction.getValue();
    }
    public void setAdHocDosageInstruction(java.lang.String adHocDosageInstruction) {
        this.adHocDosageInstruction.setValue(adHocDosageInstruction);
    }

    @Hl7XmlMapping({"dosageLine/effectiveTime"})
    public GeneralTimingSpecification getDosageTimingFrequency() {
        return this.dosageTimingFrequency.getValue();
    }
    public void setDosageTimingFrequency(GeneralTimingSpecification dosageTimingFrequency) {
        this.dosageTimingFrequency.setValue(dosageTimingFrequency);
    }

    @Hl7XmlMapping({"dosageLine/doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }

    @Hl7XmlMapping({"dosageLine/rateQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRate() {
        return this.dosageRate.getValue();
    }
    public void setDosageRate(UncertainRange<PhysicalQuantity> dosageRate) {
        this.dosageRate.setValue(dosageRate);
    }

    @Hl7XmlMapping({"dosageLine/component/supplementalInstruction"})
    public AdditionalSIGInstructionBean getDosageLineComponentSupplementalInstruction() {
        return this.dosageLineComponentSupplementalInstruction;
    }
    public void setDosageLineComponentSupplementalInstruction(AdditionalSIGInstructionBean dosageLineComponentSupplementalInstruction) {
        this.dosageLineComponentSupplementalInstruction = dosageLineComponentSupplementalInstruction;
    }

    @Hl7XmlMapping({"dosageLine/trigger/actEventCriterion/text"})
    public java.lang.String getDosageCondition() {
        return this.dosageCondition.getValue();
    }
    public void setDosageCondition(java.lang.String dosageCondition) {
        this.dosageCondition.setValue(dosageCondition);
    }

}
