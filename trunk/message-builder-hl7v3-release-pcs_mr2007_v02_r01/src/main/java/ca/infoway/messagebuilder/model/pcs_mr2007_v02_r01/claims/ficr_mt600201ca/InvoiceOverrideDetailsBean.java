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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.domainvalue.ActInvoiceOverrideCode;



/**
 * <p>Invoice Override details</p>
 * 
 * <p>The reason or rationale for an Invoice Element 
 * override.</p>
 * 
 * <p>Some overrides will require a text note component to 
 * fully explain the override.</p><p>If an adjudicator does not 
 * support the override (e.g. repeated service), the override 
 * code should not be ignored. In other words, the Invoice 
 * Grouping will likely be refused with a message &quot;we 
 * don't support this type of override&quot;.</p>
 * 
 * <p>Some overrides will require a text note component to 
 * fully explain the override.</p><p>If an adjudicator does not 
 * support the override (e.g. repeated service), the override 
 * code should not be ignored. In other words, the Invoice 
 * Grouping will likely be refused with a message &quot;we 
 * don't support this type of override&quot;.</p>
 * 
 * <p>RxS1: Not permitted for this scenario.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementOverride"})
public class InvoiceOverrideDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();


    /**
     * <p>Invoice override code</p>
     * 
     * <p>Coded responses that may occur as a result of the 
     * adjudication of an electronic invoice at a summary level and 
     * provides guidance on interpretation of the referenced 
     * adjudication results. i.e.. Subscriber Coverage Problem, 
     * Good Faith Indicator, Late Invoice</p>
     * 
     * <p>This can be used for Xray to follow, paper to follow, 
     * etc.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceOverrideCode getCode() {
        return (ActInvoiceOverrideCode) this.code.getValue();
    }

    /**
     * <p>Invoice override code</p>
     * 
     * <p>Coded responses that may occur as a result of the 
     * adjudication of an electronic invoice at a summary level and 
     * provides guidance on interpretation of the referenced 
     * adjudication results. i.e.. Subscriber Coverage Problem, 
     * Good Faith Indicator, Late Invoice</p>
     * 
     * <p>This can be used for Xray to follow, paper to follow, 
     * etc.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     */
    public void setCode(ActInvoiceOverrideCode code) {
        this.code.setValue(code);
    }

}
