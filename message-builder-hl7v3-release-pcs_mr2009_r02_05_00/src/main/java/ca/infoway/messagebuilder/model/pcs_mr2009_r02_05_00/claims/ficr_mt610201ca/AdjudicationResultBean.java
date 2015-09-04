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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt260020ca.DetectedIssueEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActAdjudicationType;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private CV code = new CVImpl();
    private List<AdjudicationResultRequiredActBean> triggerAdjudicationResultRequiredAct = new ArrayList<AdjudicationResultRequiredActBean>();
    private List<AdjudicationResultReferenceBean> reference = new ArrayList<AdjudicationResultReferenceBean>();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<DetectedIssueEventBean> reasonOfDetectedIssueEvent = new ArrayList<DetectedIssueEventBean>();


    /**
     * <p>Business Name: Result Explanation</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationType getCode() {
        return (ActAdjudicationType) this.code.getValue();
    }

    /**
     * <p>Business Name: Result Explanation</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCode(ActAdjudicationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultTrigger.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct"})
    public List<AdjudicationResultRequiredActBean> getTriggerAdjudicationResultRequiredAct() {
        return this.triggerAdjudicationResultRequiredAct;
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResult.reference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-10)</p>
     */
    @Hl7XmlMapping({"reference"})
    public List<AdjudicationResultReferenceBean> getReference() {
        return this.reference;
    }


    /**
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
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationObservationReason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/detectedIssueEvent"})
    public List<DetectedIssueEventBean> getReasonOfDetectedIssueEvent() {
        return this.reasonOfDetectedIssueEvent;
    }

}
