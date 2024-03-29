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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActInvoiceDetailTaxType;



/**
 * <p>FICR_MT500201CA.ProviderBillingTaxAccount: (no business 
 * name)</p>
 * 
 * <p>Can be used to specify the appropriate GST number and 
 * other tax numbers.</p>
 * 
 * <p>FICR_MT600201CA.ProviderBillingTaxAccount: (no business 
 * name)</p>
 * 
 * <p>Can be used to specify the appropriate GST number and 
 * other tax numbers.</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.ProviderBillingTaxAccount","FICR_MT600201CA.ProviderBillingTaxAccount"})
public class ProviderBillingTaxAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Business Name: TaxNumber</p>
     * 
     * <p>Un-merged Business Name: TaxNumber</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.ProviderBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: TaxNumber</p>
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
     * <p>Business Name: TaxNumber</p>
     * 
     * <p>Un-merged Business Name: TaxNumber</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.ProviderBillingTaxAccount.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: TaxNumber</p>
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
     * <p>Un-merged Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceDetailTaxType getCode() {
        return (ActInvoiceDetailTaxType) this.code.getValue();
    }

    /**
     * <p>Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Un-merged Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ActInvoiceDetailscode</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.ProviderBillingTaxAccount.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActInvoiceDetailTaxType code) {
        this.code.setValue(code);
    }

}
