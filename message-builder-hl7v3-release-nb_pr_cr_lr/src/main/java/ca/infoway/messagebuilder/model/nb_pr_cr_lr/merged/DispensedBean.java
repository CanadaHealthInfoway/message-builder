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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt220200ca.DrugProductBean;



/**
 * <p>Business Name: Dispensed</p>
 * 
 * <p>PORX_MT020070CA.Product2: *e:dispensed</p>
 * 
 * <p>Identifies the drug as part of the patient's medication 
 * profile. The drug is one of the most important parts of the 
 * dispense record, and it is therefore mandatory.</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>PORX_MT020050CA.Product2: *c:dispensed</p>
 * 
 * <p>The drug being supplied must be identified and and is 
 * therefore mandatory.</p>
 * 
 * <p>Identifies the product being dispensed.</p><p>Also 
 * provides information on compound ingredients and 
 * instructions and packaging requirements</p>
 * 
 * <p>COCT_MT260010CA.Product: *a:dispensed</p>
 * 
 * <p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p>
 * 
 * <p>Indicates the drug that was dispensed</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Product","COCT_MT260020CA.Product","PORX_MT020050CA.Product2","PORX_MT020070CA.Product2"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private DrugProductBean medication;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
