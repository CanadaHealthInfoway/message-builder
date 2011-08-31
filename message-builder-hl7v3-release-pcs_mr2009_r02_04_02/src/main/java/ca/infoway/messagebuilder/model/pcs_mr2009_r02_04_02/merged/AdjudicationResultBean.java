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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt610201ca.AdjudicationResultInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt610201ca.AdjudicationResultReasonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicationResultRequiredActBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>AdjudicationResult</p>
 * 
 * <p>COCT_MT680000CA.AdjudicationResult: Adjudication Result</p>
 * 
 * <p><p>Result of adjudication</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResult","FICR_MT610201CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV code = new CVImpl();
    private List<AdjudicationResultReferenceBean> reference = new ArrayList<AdjudicationResultReferenceBean>();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<AdjudicationResultRequiredActBean> triggerAdjudicationResultRequiredAct = new ArrayList<AdjudicationResultRequiredActBean>();
    private List<IssuesBean> reasonOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Code denoting adjudication results</p>
     * 
     * <p><p>(Summary of the adjudication processing - as 
     * submitted, w/ adjust, refuse adjust, refuse</p></p>
     * 
     * <p>Result Explanation</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"reference"})
    public List<AdjudicationResultReferenceBean> getReference() {
        return this.reference;
    }


    @Hl7XmlMapping({"pertinentInformation/adjudicationCodeChoice"})
    public List<AdjudicationCodeChoice> getPertinentInformationAdjudicationCodeChoice() {
        return this.pertinentInformationAdjudicationCodeChoice;
    }


    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct"})
    public List<AdjudicationResultRequiredActBean> getTriggerAdjudicationResultRequiredAct() {
        return this.triggerAdjudicationResultRequiredAct;
    }


    @Hl7XmlMapping({"reasonOf/detectedIssueEvent"})
    public List<IssuesBean> getReasonOfDetectedIssueEvent() {
        return this.reasonOfDetectedIssueEvent;
    }

}
