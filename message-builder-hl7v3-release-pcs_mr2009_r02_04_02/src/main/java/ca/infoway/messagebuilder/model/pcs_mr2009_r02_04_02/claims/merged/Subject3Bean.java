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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt400004ca.DevicePassThruBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActiveMedicationBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.Subject3","FICR_MT400003CA.Subject","FICR_MT400003CA.Subject3","FICR_MT400004CA.Subject","FICR_MT400004CA.Subject3","FICR_MT490101CA.Subject3","FICR_MT490102CA.Subject3","FICR_MT490102CA.Subject4"})
public class Subject3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private BL includesExcludesProduct = new BLImpl();
    private SpecialAuthorizationChoice specialAuthorizationChoice;


    /**
     * <p>IncludesExcludesProduct</p>
     * 
     * <p>Includes / Excludes Product</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getIncludesExcludesProduct() {
        return this.includesExcludesProduct.getValue();
    }
    public void setIncludesExcludesProduct(Boolean includesExcludesProduct) {
        this.includesExcludesProduct.setValue(includesExcludesProduct);
    }


    @Hl7XmlMapping({"specialAuthorizationChoice"})
    public SpecialAuthorizationChoice getSpecialAuthorizationChoice() {
        return this.specialAuthorizationChoice;
    }
    public void setSpecialAuthorizationChoice(SpecialAuthorizationChoice specialAuthorizationChoice) {
        this.specialAuthorizationChoice = specialAuthorizationChoice;
    }

}
