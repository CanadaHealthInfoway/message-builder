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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceDetailTaxCode;



/**
 * <p>Business Name: Adjudicator Billing Tax Account</p>
 * 
 * <p>Can be used to specify the appropriate GST number and 
 * other tax numbers.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatorBillingTaxAccount"})
public class AdjudicatorBillingTaxAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatorBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tax number, such as GST, PST number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatorBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tax number, such as GST, PST number</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Detail Tax Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatorBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Billable item code which identifies modifications such as 
     * a tax factor 7% Provincial Sales tax.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailTaxCode getCode() {
        return (ActInvoiceDetailTaxCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Detail Tax Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatorBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Billable item code which identifies modifications such as 
     * a tax factor 7% Provincial Sales tax.</p>
     */
    public void setCode(ActInvoiceDetailTaxCode code) {
        this.code.setValue(code);
    }

}
