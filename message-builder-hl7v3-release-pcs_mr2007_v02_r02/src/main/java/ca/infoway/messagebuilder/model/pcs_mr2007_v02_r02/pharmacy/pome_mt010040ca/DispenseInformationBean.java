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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Dispense Information</p>
 * 
 * <p>At least one of the 2 components of SupplyDefinition3 
 * First Fill Period or Refill Period must be specified.</p>
 * 
 * <p>Needed to understand limits on how dispenses can be 
 * performed.</p>
 * 
 * <p>Indicates how the drug should be supplied and/or who can 
 * dispense it.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.DispenseGuidelines"})
public class DispenseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private IVL<TS, Interval<Date>> component1SubsequentDispenseEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> component2InitialDispenseEffectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Refill period</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.SubsequentDispense.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Certain prescribers have time limitations or certain 
     * drugs must be filled in a finite period of time.</p>
     * 
     * <p>The interval within which subsequent dispensing can be 
     * made against a prescription, after the first/initial 
     * fill.</p>
     */
    @Hl7XmlMapping({"component1/subsequentDispense/effectiveTime"})
    public Interval<Date> getComponent1SubsequentDispenseEffectiveTime() {
        return this.component1SubsequentDispenseEffectiveTime.getValue();
    }

    /**
     * <p>Business Name: Refill period</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.SubsequentDispense.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Certain prescribers have time limitations or certain 
     * drugs must be filled in a finite period of time.</p>
     * 
     * <p>The interval within which subsequent dispensing can be 
     * made against a prescription, after the first/initial 
     * fill.</p>
     */
    public void setComponent1SubsequentDispenseEffectiveTime(Interval<Date> component1SubsequentDispenseEffectiveTime) {
        this.component1SubsequentDispenseEffectiveTime.setValue(component1SubsequentDispenseEffectiveTime);
    }


    /**
     * <p>Business Name: First Fill Period</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.InitialDispense.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Certain prescribers have time limitations or certain 
     * drugs must be filled in a finite period of time.</p>
     * 
     * <p>The period within which the prescribed drug has to be 
     * dispensed for the first time.</p><p>This is usually 
     * jurisdiction-specific, and for the most part, it is set at 
     * the drug class level.</p><p>For instance, the first fill 
     * period of validity for narcotic drugs is 3 days in most 
     * jurisdiction, where as it is between 18 and 24 months for 
     * other non-controlled drugs.</p>
     */
    @Hl7XmlMapping({"component2/initialDispense/effectiveTime"})
    public Interval<Date> getComponent2InitialDispenseEffectiveTime() {
        return this.component2InitialDispenseEffectiveTime.getValue();
    }

    /**
     * <p>Business Name: First Fill Period</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.InitialDispense.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Certain prescribers have time limitations or certain 
     * drugs must be filled in a finite period of time.</p>
     * 
     * <p>The period within which the prescribed drug has to be 
     * dispensed for the first time.</p><p>This is usually 
     * jurisdiction-specific, and for the most part, it is set at 
     * the drug class level.</p><p>For instance, the first fill 
     * period of validity for narcotic drugs is 3 days in most 
     * jurisdiction, where as it is between 18 and 24 months for 
     * other non-controlled drugs.</p>
     */
    public void setComponent2InitialDispenseEffectiveTime(Interval<Date> component2InitialDispenseEffectiveTime) {
        this.component2InitialDispenseEffectiveTime.setValue(component2InitialDispenseEffectiveTime);
    }

}
