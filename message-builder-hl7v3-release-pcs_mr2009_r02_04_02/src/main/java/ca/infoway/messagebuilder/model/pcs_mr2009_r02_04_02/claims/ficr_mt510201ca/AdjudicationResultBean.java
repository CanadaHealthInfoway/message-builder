/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InvoiceElementDetailBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InvoiceElementGroupBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.InvoiceElementChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IssuesBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV adjudicationResultsAdjudicationCode = new CVImpl();
    private List<Trigger1Bean> trigger = new ArrayList<Trigger1Bean>();
    private List<InvoiceElementChoice> referenceInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<IssuesBean> reasonOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Adjudication Results Adjudication Code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getAdjudicationResultsAdjudicationCode() {
        return (Code) this.adjudicationResultsAdjudicationCode.getValue();
    }
    public void setAdjudicationResultsAdjudicationCode(Code adjudicationResultsAdjudicationCode) {
        this.adjudicationResultsAdjudicationCode.setValue(adjudicationResultsAdjudicationCode);
    }


    @Hl7XmlMapping({"trigger"})
    public List<Trigger1Bean> getTrigger() {
        return this.trigger;
    }


    @Hl7XmlMapping({"reference/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReferenceInvoiceElementChoice() {
        return this.referenceInvoiceElementChoice;
    }


    @Hl7XmlMapping({"pertinentInformation/adjudicationCodeChoice"})
    public List<AdjudicationCodeChoice> getPertinentInformationAdjudicationCodeChoice() {
        return this.pertinentInformationAdjudicationCodeChoice;
    }


    @Hl7XmlMapping({"reasonOf/detectedIssueEvent"})
    public List<IssuesBean> getReasonOfDetectedIssueEvent() {
        return this.reasonOfDetectedIssueEvent;
    }

}
