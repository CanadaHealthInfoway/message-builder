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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT980040CA.DosageLine" })
public class DosageLineBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4192539141439016136L;

    private final CD moodCode = new CDImpl();

    private final ST adHocDosageInstruction = new STImpl();

    private final GTS effectiveTime = new GTSImpl();

    private final URG<PQ, PhysicalQuantity> doseQuantity = new URGImpl<PQ, PhysicalQuantity>();

    private final URG<PQ, PhysicalQuantity> rateQuantity = new URGImpl<PQ, PhysicalQuantity>();

    private final ST dosageCondition = new STImpl();

    private SupplementalInstructionBean supplementalInstruction;

    @Hl7XmlMapping("moodCode")
    public x_ActMoodDefEvnRqo getMoodCode() {
        return (x_ActMoodDefEvnRqo) this.moodCode.getValue();
    }

    public void setMoodCode(x_ActMoodDefEvnRqo moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping("text")
    public String getAdHocDosageInstruction() {
        return this.adHocDosageInstruction.getValue();
    }

    public void setAdHocDosageInstruction(String adHocDosageInstruction) {
        this.adHocDosageInstruction.setValue(adHocDosageInstruction);
    }

    @Hl7XmlMapping("effectiveTime")
    public GeneralTimingSpecification getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(GeneralTimingSpecification effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("doseQuantity")
    public UncertainRange<PhysicalQuantity> getDoseQuantity() {
        return doseQuantity.getValue();
    }

    public void setDoseQuantity(UncertainRange<PhysicalQuantity> doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }

    @Hl7XmlMapping("rateQuantity")
    public UncertainRange<PhysicalQuantity> getRateQuantity() {
        return rateQuantity.getValue();
    }

    public void setRateQuantity(UncertainRange<PhysicalQuantity> rateQuantity) {
        this.rateQuantity.setValue(rateQuantity);
    }

    @Hl7XmlMapping("trigger/actEventCriterion/text")
    public String getDosageCondition() {
        return this.dosageCondition.getValue();
    }

    public void setDosageCondition(String dosageCondition) {
        this.dosageCondition.setValue(dosageCondition);
    }

    @Hl7XmlMapping("component/supplementalInstruction")
    public SupplementalInstructionBean getSupplementalInstruction() {
        return supplementalInstruction;
    }

    public void setSupplementalInstruction(SupplementalInstructionBean supplementalInstruction) {
        this.supplementalInstruction = supplementalInstruction;
    }
}
