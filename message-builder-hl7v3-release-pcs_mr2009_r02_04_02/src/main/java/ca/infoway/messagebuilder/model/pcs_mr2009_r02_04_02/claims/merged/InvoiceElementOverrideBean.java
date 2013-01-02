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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActInvoiceOverrideType;



@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementOverride","FICR_MT600201CA.InvoiceElementOverride"})
public class InvoiceElementOverrideBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private ST text = new STImpl();


    /**
     * <p>Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceOverrideType getCode() {
        return (ActInvoiceOverrideType) this.code.getValue();
    }

    /**
     * <p>Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideCode</p>
     * 
     * <p>Relationship: FICR_MT600201CA.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceOverrideType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: InvoiceOverrideNote</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideNote</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementOverride.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: InvoiceOverrideNote</p>
     * 
     * <p>Un-merged Business Name: InvoiceOverrideNote</p>
     * 
     * <p>Relationship: FICR_MT500201CA.InvoiceElementOverride.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
