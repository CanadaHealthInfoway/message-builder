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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Drug form</p>
 * 
 * <p>Kind of manufactured material</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.ManufacturedMaterialKind"})
public class DrugFormBean extends MessagePartBean {

    private static final long serialVersionUID = 20150318L;
    private CV formCode = new CVImpl();


    /**
     * <p>Business Name: Drug Form</p>
     * 
     * <p>Relationship: 
     * COCT_MT300000CA.ManufacturedMaterialKind.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>required for compounds</p>
     * 
     * <p>code for drug form</p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getFormCode() {
        return (OrderableDrugForm) this.formCode.getValue();
    }

    /**
     * <p>Business Name: Drug Form</p>
     * 
     * <p>Relationship: 
     * COCT_MT300000CA.ManufacturedMaterialKind.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>required for compounds</p>
     * 
     * <p>code for drug form</p>
     */
    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }

}
