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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>BusinessArrangement</p>
 * 
 * <p>QUCR_MT810201CA.AdjudResultsFinancialContract: Business 
 * Arrangement</p>
 * 
 * <p><p>Business arrangement for payment purposes.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.FinancialContract","QUCR_MT810201CA.AdjudResultsFinancialContract"})
public class BusinessArrangementBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Financial Contract ID</p>
     * 
     * <p><p>The unique identifier of the billing contract 
     * information.</p></p>
     * 
     * <p><p>Alberta Health &amp; Wellness requires an ability to 
     * message a business arrangement identifier for invoices in 
     * Alberta.</p></p>
     * 
     * <p><p>Alberta Health &amp; Wellness requires an ability to 
     * message a business arrangement identifier for invoices in 
     * Alberta.</p></p>
     * 
     * <p>Business Arrangement ID</p>
     * 
     * <p><p>Business arrangement identifier</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>BillingArrangementType</p>
     * 
     * <p>Billing Arrangement Type</p>
     * 
     * <p><p>The type of provision made for reimbursing the 
     * healthcare services provided over a specific period. I.e. 
     * Capitation Funding or Fee For Service.</p></p>
     * 
     * <p><p>RxS1: Not permitted, as billing arrangements are not 
     * included in this scenario.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

}