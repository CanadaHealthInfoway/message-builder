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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Dispense Information</p>
 * 
 * <p><p>At least one of the 2 components of SupplyDefinition3 
 * First Fill Period or Refill Period must be specified.</p></p>
 * 
 * <p><p>Indicates how the drug should be supplied and/or who 
 * can dispense it.</p></p>
 * 
 * <p><p>Needed to understand limits on how dispenses can be 
 * performed.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.DispenseGuidelines"})
public class DispenseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private SubsequentDispenseBean component1SubsequentDispense;
    private DrugValidityPeriodBean component2InitialDispense;


    @Hl7XmlMapping({"component1/subsequentDispense"})
    public SubsequentDispenseBean getComponent1SubsequentDispense() {
        return this.component1SubsequentDispense;
    }
    public void setComponent1SubsequentDispense(SubsequentDispenseBean component1SubsequentDispense) {
        this.component1SubsequentDispense = component1SubsequentDispense;
    }


    @Hl7XmlMapping({"component2/initialDispense"})
    public DrugValidityPeriodBean getComponent2InitialDispense() {
        return this.component2InitialDispense;
    }
    public void setComponent2InitialDispense(DrugValidityPeriodBean component2InitialDispense) {
        this.component2InitialDispense = component2InitialDispense;
    }

}
