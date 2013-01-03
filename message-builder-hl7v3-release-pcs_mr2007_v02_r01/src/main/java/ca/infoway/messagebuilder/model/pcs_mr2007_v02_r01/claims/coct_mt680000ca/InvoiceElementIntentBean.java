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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.domainvalue.ActInvoiceGroupCode;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementIntent"})
public class InvoiceElementIntentBean extends MessagePartBean implements InvoiceElementChoice {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<InvoiceElementComponentBean> component = new ArrayList<InvoiceElementComponentBean>();


    /**
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceGroupCode getCode() {
        return (ActInvoiceGroupCode) this.code.getValue();
    }

    /**
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Invoice Type e.g. Healthcare Services, Rx Dispense, Rx 
     * Compound, Healthcare Goods, Preferred Accomodation</p>
     */
    public void setCode(ActInvoiceGroupCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element.</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }

    /**
     * <p>Relationship: COCT_MT680000CA.InvoiceElementIntent.netAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the total monetary amount billed for the 
     * invoice element.</p>
     */
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    /**
     * <p>Relationship: 
     * COCT_MT680000CA.InvoiceElementIntent.component</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     */
    @Hl7XmlMapping({"component"})
    public List<InvoiceElementComponentBean> getComponent() {
        return this.component;
    }

}
