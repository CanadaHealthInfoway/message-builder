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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ActInvoiceDetailTaxCode;



/**
 * <p>Business Name: Tax Account of Provider</p>
 * 
 * <p>Can be used to specify the appropriate GST number and 
 * other tax numbers.</p>
 * 
 * <p>Tax Account No. of Provider eg. GST, PST</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.ProviderBillingTaxAccount"})
public class TaxAccountOfProviderBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Business Name: Tax number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Tax number</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailTaxCode getCode() {
        return (ActInvoiceDetailTaxCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceDetailTaxCode code) {
        this.code.setValue(code);
    }

}