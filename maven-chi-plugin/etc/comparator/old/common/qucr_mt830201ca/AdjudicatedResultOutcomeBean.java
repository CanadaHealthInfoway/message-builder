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
package ca.infoway.messagebuilder.model.common.qucr_mt830201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.InvoiceTypeBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicatedResultOutcome"})
public class AdjudicatedResultOutcomeBean extends MessagePartBean {

    private II adjudicationID = new IIImpl();
    private List<InvoiceTypeBean> adjudicationResultReferenceInvoiceElementGroup = new ArrayList<InvoiceTypeBean>();

    @Hl7XmlMapping({"adjudicationResult/id"})
    public Identifier getAdjudicationID() {
        return this.adjudicationID.getValue();
    }
    public void setAdjudicationID(Identifier adjudicationID) {
        this.adjudicationID.setValue(adjudicationID);
    }

    @Hl7XmlMapping({"adjudicationResult/reference/invoiceElementGroup"})
    public List<InvoiceTypeBean> getAdjudicationResultReferenceInvoiceElementGroup() {
        return this.adjudicationResultReferenceInvoiceElementGroup;
    }

}
