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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>QUQI_MT020000CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MFMI_MT700726CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700220CA.Subject: d:raises</p>
 * 
 * <p><p>Identifies errors or warnings that were caused by the 
 * previous message.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700210CA.Subject: d:caused</p>
 * 
 * <p><p>Identifies errors or warnings that were caused by the 
 * previous message or that are being managed as part of the 
 * current message.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700222CA.Subject: d:raises</p>
 * 
 * <p><p>Identifies errors or warnings that were caused by the 
 * previous message.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700227CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700216CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700230CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>PORX_MT060210CA.Subject: k:managed</p>
 * 
 * <p><p>Detailed information indicating identified issues 
 * (permission problems, drug-drug interactions, dosage issues, 
 * duplicate therapy, drug-allergy, drug-lab, age 
 * appropriateness, etc.) with the proposed medication, along 
 * with how the issues have been managed by the recorder.</p></p>
 * 
 * <p><p>Allows a recorder to override alerts and business 
 * rules, as well as providing a permanent record of management 
 * steps.</p></p>
 * 
 * <p>PORX_MT060160CA.Subject6: k:managed</p>
 * 
 * <p><p>Detailed information indicating identified issues 
 * (permission problems, drug-drug interactions, dosage issues, 
 * duplicate therapy, drug-allergy, drug-lab, age 
 * appropriateness, etc.) with the proposed prescription 
 * dispense, along with how the issues have been managed by the 
 * dispenser.</p></p>
 * 
 * <p><p>Allows a dispenser to override alerts and business 
 * rules, as well as providing a permanent record of management 
 * steps.</p></p>
 * 
 * <p>MCAI_MT700237CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MFMI_MT700751CA.Subject2: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>QUQI_MT020002CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700221CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700232CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MFMI_MT700746CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>PORX_MT060040CA.Subject6: k:managed</p>
 * 
 * <p><p>Detailed information indicating identified issues 
 * (permission problems, drug-drug interactions, dosage issues, 
 * duplicate therapy, drug-allergy, drug-lab, age 
 * appropriateness, etc.) with the proposed prescription 
 * dispense, along with how the issues have been managed by the 
 * dispenser.</p></p>
 * 
 * <p><p>Allows a dispenser to override alerts and business 
 * rules, as well as providing a permanent record of management 
 * steps.</p></p>
 * 
 * <p>MCAI_MT700218CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700231CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>PORX_MT060090CA.Subject6: k:managed</p>
 * 
 * <p><p>Detailed information indicating identified issues 
 * (permission problems, drug-drug interactions, dosage issues, 
 * duplicate therapy, drug-allergy, drug-lab, age 
 * appropriateness, etc.) with the proposed prescription 
 * dispense, along with how the issues have been managed by the 
 * dispenser.</p></p>
 * 
 * <p><p>Allows a dispenser to override alerts and business 
 * rules, as well as providing a permanent record of management 
 * steps.</p></p>
 * 
 * <p>PORX_MT060340CA.Subject6: k:managed</p>
 * 
 * <p><p>Detailed information indicating identified issues 
 * (permission problems, drug-drug interactions, dosage issues, 
 * duplicate therapy, drug-allergy, drug-lab, age 
 * appropriateness, etc.) with the proposed prescription 
 * dispense, along with how the issues have been managed by the 
 * dispenser.</p></p>
 * 
 * <p><p>Allows a dispenser to override alerts and business 
 * rules, as well as providing a permanent record of management 
 * steps.</p></p>
 * 
 * <p>MCAI_MT700212CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700211CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700236CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700226CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MCAI_MT700217CA.Subject: d:caused</p>
 * 
 * <p><p>Specific wrappers will implement one of the IssueEvent 
 * CMETs. In other words, the Choice Box will not be present in 
 * individual wrappers derived from this model.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>MFMI_MT700716CA.Subject: d:caused</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and/or managed involving the current 
 * action.</p></p>
 * 
 * <p><p>Any trigger event can result in errors or may allow 
 * for errors to be overridden or managed.</p></p>
 * 
 * <p>PORX_MT060010CA.Subject6: k:managed</p>
 * 
 * <p><p>
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject","MCAI_MT700211CA.Subject","MCAI_MT700212CA.Subject","MCAI_MT700216CA.Subject","MCAI_MT700217CA.Subject","MCAI_MT700218CA.Subject","MCAI_MT700220CA.Subject","MCAI_MT700221CA.Subject","MCAI_MT700222CA.Subject","MCAI_MT700226CA.Subject","MCAI_MT700227CA.Subject","MCAI_MT700230CA.Subject","MCAI_MT700231CA.Subject","MCAI_MT700232CA.Subject","MCAI_MT700236CA.Subject","MCAI_MT700237CA.Subject","MFMI_MT700711CA.Subject","MFMI_MT700716CA.Subject","MFMI_MT700726CA.Subject","MFMI_MT700746CA.Subject","MFMI_MT700751CA.Subject2","PORX_MT060010CA.Subject6","PORX_MT060040CA.Subject6","PORX_MT060090CA.Subject6","PORX_MT060160CA.Subject6","PORX_MT060210CA.Subject","PORX_MT060340CA.Subject6","QUQI_MT020000CA.Subject","QUQI_MT020002CA.Subject","QUQI_MT120006CA.Subject","QUQI_MT120008CA.Subject"})
public class CausedBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private IssuesBean detectedIssueEvent;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private BL contextConductionInd = new BLImpl();


    @Hl7XmlMapping({"detectedIssueEvent"})
    public IssuesBean getDetectedIssueEvent() {
        return this.detectedIssueEvent;
    }
    public void setDetectedIssueEvent(IssuesBean detectedIssueEvent) {
        this.detectedIssueEvent = detectedIssueEvent;
    }


    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

}
