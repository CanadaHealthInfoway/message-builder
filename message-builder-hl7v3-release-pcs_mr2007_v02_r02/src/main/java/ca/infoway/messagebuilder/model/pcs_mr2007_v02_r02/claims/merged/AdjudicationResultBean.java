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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca.RequiredActionTypeBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActAdjudicationCode;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: AdjudicationResult</p>
 * 
 * <p>COCT_MT680000CA.AdjudicationResult: Adjudication Result</p>
 * 
 * <p>Result of adjudication</p>
 * 
 * <p>FICR_MT610201CA.AdjudicationResult: Adjudication Result</p>
 * 
 * <p>Result of Adjudication</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResult","FICR_MT610201CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<AdjudicationResultReferenceBean> reference = new ArrayList<AdjudicationResultReferenceBean>();
    private List<RequiredActionTypeBean> triggerAdjudicationResultRequiredAct = new ArrayList<RequiredActionTypeBean>();
    private List<IssuesBean> reasonOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Un-merged Business Name: CodeDenotingAdjudicationResults</p>
     * 
     * <p>Relationship: COCT_MT680000CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     * 
     * <p>Un-merged Business Name: AdjudicationResultsAdjudicationCode</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>For Invoice (COB): AS (Adjudicated As Submitted) and ANF 
     * (Adjudicated with No Financial Impact) is not usually 
     * allowed, as this would imply that the previous Adjudicator 
     * has provided an intention to pay ALL of the Invoice and 
     * therefore, an Invoice to a downstream Adjudicator is not 
     * necessary. However, if there is still an outstanding balance 
     * the EOB from an upstream Adjudicator may be sent to a 
     * downstream Adjudicator. For Adjudication Results: Can be any 
     * code from the ActAdjudicationCode domain.</p>
     * 
     * <p>For Adjudication Results: Can be any code from the 
     * ActAdjudicationCode domain.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationCode getCode() {
        return (ActAdjudicationCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: CodeDenotingAdjudicationResults</p>
     * 
     * <p>Relationship: COCT_MT680000CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     * 
     * <p>Un-merged Business Name: AdjudicationResultsAdjudicationCode</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>For Invoice (COB): AS (Adjudicated As Submitted) and ANF 
     * (Adjudicated with No Financial Impact) is not usually 
     * allowed, as this would imply that the previous Adjudicator 
     * has provided an intention to pay ALL of the Invoice and 
     * therefore, an Invoice to a downstream Adjudicator is not 
     * necessary. However, if there is still an outstanding balance 
     * the EOB from an upstream Adjudicator may be sent to a 
     * downstream Adjudicator. For Adjudication Results: Can be any 
     * code from the ActAdjudicationCode domain.</p>
     * 
     * <p>For Adjudication Results: Can be any code from the 
     * ActAdjudicationCode domain.</p>
     */
    public void setCode(ActAdjudicationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdditionalPertinentInformation.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdditionalPertinentInformation.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/adjudicationCodeChoice"})
    public List<AdjudicationCodeChoice> getPertinentInformationAdjudicationCodeChoice() {
        return this.pertinentInformationAdjudicationCodeChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicationResult.reference</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResult.reference</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-10)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<AdjudicationResultReferenceBean> getReference() {
        return this.reference;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultTrigger.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct"})
    public List<RequiredActionTypeBean> getTriggerAdjudicationResultRequiredAct() {
        return this.triggerAdjudicationResultRequiredAct;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationObservationReason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/detectedIssueEvent"})
    public List<IssuesBean> getReasonOfDetectedIssueEvent() {
        return this.reasonOfDetectedIssueEvent;
    }

}
