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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Drug Validity Period</p>
 * 
 * <p><p>Defines upper limits for period in which a prescribed 
 * drug may be dispensed. Although an attempt will be made to 
 * obtain and define panCanadian validity periods for drug, it 
 * is possible that drug validity periods wii be 
 * jurisdiction-specific</p></p>
 * 
 * <p><p>Allows for business rules regarding dispenses against 
 * a prescription. Controlled and monitored drugs have shorter 
 * prescription lifespans that other drugs.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.InitialDispense"})
public class DrugValidityPeriodBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private IVL<TS, Interval<Date>> firstFillPeriod = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>First Fill Period</p>
     * 
     * <p><p>The period within which the prescribed drug has to be 
     * dispensed for the first time.</p><p>This is usually 
     * jurisdiction-specific, and for the most part, it is set at 
     * the drug class level.</p><p>For instance, the first fill 
     * period of validity for narcotic drugs is 3 days in most 
     * jurisdiction, where as it is between 18 and 24 months for 
     * other non-controlled drugs.</p></p>
     * 
     * <p><p>The period within which the prescribed drug has to be 
     * dispensed for the first time.</p><p>This is usually 
     * jurisdiction-specific, and for the most part, it is set at 
     * the drug class level.</p><p>For instance, the first fill 
     * period of validity for narcotic drugs is 3 days in most 
     * jurisdiction, where as it is between 18 and 24 months for 
     * other non-controlled drugs.</p></p>
     * 
     * <p><p>The period within which the prescribed drug has to be 
     * dispensed for the first time.</p><p>This is usually 
     * jurisdiction-specific, and for the most part, it is set at 
     * the drug class level.</p><p>For instance, the first fill 
     * period of validity for narcotic drugs is 3 days in most 
     * jurisdiction, where as it is between 18 and 24 months for 
     * other non-controlled drugs.</p></p>
     * 
     * <p><p>Certain prescribers have time limitations or certain 
     * drugs must be filled in a finite period of time.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFirstFillPeriod() {
        return this.firstFillPeriod.getValue();
    }
    public void setFirstFillPeriod(Interval<Date> firstFillPeriod) {
        this.firstFillPeriod.setValue(firstFillPeriod);
    }

}
