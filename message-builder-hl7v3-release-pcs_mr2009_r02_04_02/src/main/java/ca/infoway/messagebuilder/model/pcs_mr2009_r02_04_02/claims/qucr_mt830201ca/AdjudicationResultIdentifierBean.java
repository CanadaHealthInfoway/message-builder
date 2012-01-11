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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicatorIdBean;
import java.util.Date;



/**
 * <p>Adjudication Result Identifier</p>
 * 
 * <p><p>Adjudication Result Identifier</p></p>
 * 
 * <p><p>May include data centre and sequence numbers</p></p>
 */
@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicationResultIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private CS authorContextControlCode = new CSImpl();
    private TS authorTime = new TSImpl();
    private CV authorModeCode = new CVImpl();
    private AdjudicatorIdBean authorAdjudicatorRole;
    private AdjudicatedResultOutcomeBean outcomeOf;


    /**
     * <p>Adjudication Result Identifier</p>
     * 
     * <p><p>May include data centre and sequence numbers</p></p>
     * 
     * <p><p>Technique to identify that the EOB was not electronic 
     * (manual) is through the participation mode code for the 
     * adjudicator.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>(Invoice Type</p>
     * 
     * <p><p>Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     * 
     * <p><p>For Invoice (COB) : Invoice type (for root) cannot be 
     * different from submitted invoice. This would be a cause for 
     * rejecting the invoice.</p><p>For Adjudication Results: code 
     * must match to the corresponding invoice element that was 
     * submitted.</p><p>For Invoice Nullify Results: this is the 
     * identifier of the EOB that was previously messaged to the 
     * Provider.</p><p>Modifiers for the codes are taken from the 
     * same domain (i.e ActInvoiceGroupCode).</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Paid Amount</p>
     * 
     * <p><p>Grand total of all SOFA observations contained in this 
     * summary</p></p>
     * 
     * <p><p>For Coverage Extension Results, this is typically not 
     * specified, as dollar limits are noted as information 
     * codes.</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Context Control code</p>
     */
    @Hl7XmlMapping({"author/contextControlCode"})
    public ContextControl getAuthorContextControlCode() {
        return (ContextControl) this.authorContextControlCode.getValue();
    }
    public void setAuthorContextControlCode(ContextControl authorContextControlCode) {
        this.authorContextControlCode.setValue(authorContextControlCode);
    }


    /**
     * <p>(Adjudication date/time</p>
     * 
     * <p><p>Date and time of Adjudication</p></p>
     * 
     * <p><p>Used in Pharmacy for daily totals. For Invoice COB: 
     * Will only be value for electronic EOBs</p></p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>EOB Communication Method</p>
     * 
     * <p><p>EOB Communication Method</p></p>
     * 
     * <p><p>For Invoice (COB): If Invoice submitted WRITTEN, then 
     * EOB must be adjudicated WRITTEN.</p><p>If Invoice submitted 
     * ELECTRONIC, then EOB can be ELECTRONIC (preferred) or 
     * WRITTEN.</p><p>For Adjudication Results: Must be ELECTRONIC 
     * only</p></p>
     * 
     * <p><p>For Invoice (COB): If Invoice submitted WRITTEN, then 
     * EOB must be adjudicated WRITTEN.</p><p>If Invoice submitted 
     * ELECTRONIC, then EOB can be ELECTRONIC (preferred) or 
     * WRITTEN.</p><p>For Adjudication Results: Must be ELECTRONIC 
     * only</p></p>
     * 
     * <p><p>For Invoice (COB): If Invoice submitted WRITTEN, then 
     * EOB must be adjudicated WRITTEN.</p><p>If Invoice submitted 
     * ELECTRONIC, then EOB can be ELECTRONIC (preferred) or 
     * WRITTEN.</p><p>For Adjudication Results: Must be ELECTRONIC 
     * only</p></p>
     */
    @Hl7XmlMapping({"author/modeCode"})
    public ParticipationMode getAuthorModeCode() {
        return (ParticipationMode) this.authorModeCode.getValue();
    }
    public void setAuthorModeCode(ParticipationMode authorModeCode) {
        this.authorModeCode.setValue(authorModeCode);
    }


    @Hl7XmlMapping({"author/adjudicatorRole"})
    public AdjudicatorIdBean getAuthorAdjudicatorRole() {
        return this.authorAdjudicatorRole;
    }
    public void setAuthorAdjudicatorRole(AdjudicatorIdBean authorAdjudicatorRole) {
        this.authorAdjudicatorRole = authorAdjudicatorRole;
    }


    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}
