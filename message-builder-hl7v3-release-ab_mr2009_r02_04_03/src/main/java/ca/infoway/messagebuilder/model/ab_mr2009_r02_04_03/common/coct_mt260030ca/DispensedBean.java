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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt260030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt220210ca.DrugProductBean;



/**
 * <p>Business Name: *a:dispensed</p>
 * 
 * <p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p>
 * 
 * <p>Indicates the drug that was dispensed</p>
 */
@Hl7PartTypeMapping({"COCT_MT260030CA.Product"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20151019L;
    private DrugProductBean medication;


    /**
     * <p>Relationship: COCT_MT260030CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }

    /**
     * <p>Relationship: COCT_MT260030CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
