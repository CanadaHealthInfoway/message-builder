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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt620000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActInvoiceGroupCode;



/**
 * <p>Business Name: Invoice Type</p>
 * 
 * <p>Cancel reasons are noted in the control wrapper</p>
 */
@Hl7PartTypeMapping({"FICR_MT620000CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();


    /**
     * <p>Business Name: Invoice Grouping Identifiers</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>There are some situations where more than 1 identifier 
     * for this object can be included in a message.</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Invoice Grouping Identifiers</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>There are some situations where more than 1 identifier 
     * for this object can be included in a message.</p>
     * 
     * <p>For example:</p><p>1. unique invoice group identifier, 
     * independent of adjudicator recipient.</p><p>2. sequential 
     * invoice grouping identifier by adjudicator.</p><p>Obligation 
     * on adjudicator is to return and communicate about this item 
     * with all identifiers (i.e. identifier 1. and 2.).</p>
     * 
     * <p></p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupCode getCode() {
        return (ActInvoiceGroupCode) this.code.getValue();
    }

    /**
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Each Invoice Type is used to specify 1. vocabulary, 2. 
     * structure of the Invoice Element Choice and 3. which 
     * Billable Act(s) can be included for the specified Invoice 
     * Type.</p><p>Information on constraints for the Invoice Type 
     * will be found in the NeCST Message Specifications. Each 
     * Benefit Group will indicate which Invoice Types will be 
     * supported by that Benefit Group.</p><p>Invoice Types will 
     * not generate unique and distinct XML schemas that can tested 
     * independent of each other. They must be tested together 
     * within an Message Type.</p>
     * 
     * <p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    public void setCode(ActInvoiceGroupCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Invoice sub-total</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>Invoice sub-total - This is the sum of the Submitted 
     * Invoice Line amounts; Identifies the total monetary amount 
     * billed for the invoice element.</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Business Name: Invoice sub-total</p>
     * 
     * <p>Relationship: FICR_MT620000CA.InvoiceElementGroup.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For Cancel Request: This would serve as a cross-check for 
     * the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p>
     * 
     * <p>Invoice sub-total - This is the sum of the Submitted 
     * Invoice Line amounts; Identifies the total monetary amount 
     * billed for the invoice element.</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }

}
