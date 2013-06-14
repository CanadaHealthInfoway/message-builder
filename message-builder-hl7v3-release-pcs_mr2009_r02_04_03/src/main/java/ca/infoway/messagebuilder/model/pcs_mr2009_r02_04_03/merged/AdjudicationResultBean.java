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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActAdjudicationResultActionType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActAdjudicationType;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: AdjudicationResult</p>
 * 
 * <p>COCT_MT680000CA.AdjudicationResult: Adjudication Result</p>
 * 
 * <p>Result of adjudication</p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResult","FICR_MT610201CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private List<InvoiceElementChoice> referenceInvoiceElementChoice = new ArrayList<InvoiceElementChoice>();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<CV> triggerAdjudicationResultRequiredActCode = new ArrayList<CV>();
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
     * <p>Un-merged Business Name: ResultExplanation</p>
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
     * <p>Un-merged Business Name: CodeDenotingAdjudicationResults</p>
     * 
     * <p>Relationship: COCT_MT680000CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     * 
     * <p>Un-merged Business Name: ResultExplanation</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicationResult.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCode(ActAdjudicationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicationResultReference.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultReference.invoiceElementChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/invoiceElementChoice"})
    public List<InvoiceElementChoice> getReferenceInvoiceElementChoice() {
        return this.referenceInvoiceElementChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdditionalPertinentInformation.adjudicationCodeChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Business Name: RequiredActionType</p>
     * 
     * <p>Un-merged Business Name: RequiredActionType</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultRequiredAct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct/code"})
    public List<ActAdjudicationResultActionType> getTriggerAdjudicationResultRequiredActCode() {
        return new RawListWrapper<CV, ActAdjudicationResultActionType>(triggerAdjudicationResultRequiredActCode, CVImpl.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationObservationReason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reasonOf/detectedIssueEvent"})
    public List<IssuesBean> getReasonOfDetectedIssueEvent() {
        return this.reasonOfDetectedIssueEvent;
    }

}
