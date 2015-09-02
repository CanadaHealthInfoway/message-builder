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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.claims.ficr_mt600201nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ActInvoiceOverrideCode;



/**
 * <p>Business Name: Invoice Override details</p>
 * 
 * <p>Some overrides will require a text note component to 
 * fully explain the override.</p><p>If an adjudicator does not 
 * support the override (e.g. repeated service), the override 
 * code should not be ignored. In other words, the Invoice 
 * Grouping will likely be refused with a message &quot;we 
 * don't support this type of override&quot;.</p>
 * 
 * <p>RxS1: Not permitted for this scenario.</p>
 * 
 * <p>The reason or rationale for an Invoice Element 
 * override.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201NB.InvoiceElementOverride"})
public class InvoiceOverrideDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();


    /**
     * <p>Business Name: Invoice override code</p>
     * 
     * <p>Relationship: FICR_MT600201NB.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This can be used for Xray to follow, paper to follow, 
     * etc.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Coded responses that may occur as a result of the 
     * adjudication of an electronic invoice at a summary level and 
     * provides guidance on interpretation of the referenced 
     * adjudication results. i.e.. Subscriber Coverage Problem, 
     * Good Faith Indicator, Late Invoice</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInvoiceOverrideCode getCode() {
        return (ActInvoiceOverrideCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Invoice override code</p>
     * 
     * <p>Relationship: FICR_MT600201NB.InvoiceElementOverride.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This can be used for Xray to follow, paper to follow, 
     * etc.</p>
     * 
     * <p>RxS1: Not permitted for this scenario.</p>
     * 
     * <p>Coded responses that may occur as a result of the 
     * adjudication of an electronic invoice at a summary level and 
     * provides guidance on interpretation of the referenced 
     * adjudication results. i.e.. Subscriber Coverage Problem, 
     * Good Faith Indicator, Late Invoice</p>
     */
    public void setCode(ActInvoiceOverrideCode code) {
        this.code.setValue(code);
    }

}
