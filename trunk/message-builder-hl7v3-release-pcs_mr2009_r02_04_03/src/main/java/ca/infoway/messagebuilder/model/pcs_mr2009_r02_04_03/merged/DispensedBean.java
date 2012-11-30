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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt220200ca.DrugProductBean;



/**
 * <p>Dispensed</p>
 * 
 * <p>PORX_MT020070CA.Product2: *e:dispensed</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>Identifies the drug as part of the patient's medication 
 * profile. The drug is one of the most important parts of the 
 * dispense record, and it is therefore mandatory.</p>
 * 
 * <p>PORX_MT020050CA.Product2: *c:dispensed</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>The drug being supplied must be identified and and is 
 * therefore mandatory.</p>
 * 
 * <p>COCT_MT260010CA.Product: *a:dispensed</p>
 * 
 * <p>Indicates the drug that was dispensed</p>
 * 
 * <p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p>
 * 
 * <p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Product","COCT_MT260020CA.Product","PORX_MT020050CA.Product2","PORX_MT020070CA.Product2"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private DrugProductBean medication;


    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }

    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
