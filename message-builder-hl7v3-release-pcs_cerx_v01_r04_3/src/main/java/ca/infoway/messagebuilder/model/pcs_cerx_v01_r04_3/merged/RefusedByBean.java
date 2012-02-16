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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>COMT_MT300003CA.Author: *b:annotated by</p>
 * 
 * <p><p>Identifier of the provider who created the patient 
 * note.</p></p>
 * 
 * <p><p>Allows other providers to communicator with the author 
 * of the note for follow-up enquiries. The author of an 
 * annotation must always be known and is therefore 
 * mandatory.</p></p>
 * 
 * <p>POIZ_MT060150CA.Author: *administered by</p>
 * 
 * <p><p>Identity of the provider who performed the 
 * immunization event.</p></p>
 * 
 * <p><p>Allows for the tracking of the provider who did the 
 * immunization and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.Author5: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p>PORX_MT060190CA.Author: *recorded by</p>
 * 
 * <p><p>Indicates the provider who recorded the &quot;other 
 * active medication&quot;.</p></p>
 * 
 * <p><p>Useful for follow-up and audit purposes, and therefore 
 * mandatory.</p></p>
 * 
 * <p>REPC_MT000010CA.Author3: *changed by</p>
 * 
 * <p><p>Identity of the health service provider responsible 
 * for the change in the medical condition.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing. The provider responsible for a change should 
 * always be known and is therefore mandatory.</p></p>
 * 
 * <p>MCAI_MT700221CA.Author: a:*created by</p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>REPC_MT100002CA.Author3: *b:recorded by</p>
 * 
 * <p><p>Identifies the provider responsible for the recording 
 * the patient measurement.</p></p>
 * 
 * <p><p>Annotation.requestingProvider</p><p>ZPB3.18 
 * (id.root)</p><p>ZPB3.19 (id.extension)</p><p>ZPB3.15</p></p>
 * 
 * <p><p>Annotation.requestingProvider</p><p>ZPB3.18 
 * (id.root)</p><p>ZPB3.19 (id.extension)</p><p>ZPB3.15</p></p>
 * 
 * <p><p>Annotation.requestingProvider</p><p>ZPB3.18 
 * (id.root)</p><p>ZPB3.19 (id.extension)</p><p>ZPB3.15</p></p>
 * 
 * <p><p>Annotation.requestingProvider</p><p>ZPB3.18 
 * (id.root)</p><p>ZPB3.19 (id.extension)</p><p>ZPB3.15</p></p>
 * 
 * <p><p>Allows tracking of who made the patient observation. 
 * This attribute is mandatory because the provider responsible 
 * for the observation must be known.</p></p>
 * 
 * <p><p>Only needs to be specified if the author of the 
 * annotation differs from the prescriber.</p></p>
 * 
 * <p>REPC_MT000010CA.Author: *d:authored by</p>
 * 
 * <p><p>Identifies the provider who caused the condition to be 
 * recorded.</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>Identifies responsibility for accuracy and relevance 
 * of the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p></p>
 * 
 * <p>QUQI_MT020000CA.Author: *b:created by</p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060040CA.Author: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p>REPC_MT000006CA.Author: *f:authored by</p>
 * 
 * <p><p>Identifies the provider who reported the reaction.</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>Identifies responsibility for accuracy and relevance 
 * of the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060210CA.Author: *b:recorded by</p>
 * 
 * <p><p>Indicates the identity of the provider who recorded 
 * the other medication information.</p></p>
 * 
 * <p><p>Allows other providers to enquire about the 
 * authenticity of the content of the other medication record 
 * and is therefore mandatory.</p></p>
 * 
 * <p>MCAI_MT700210CA.Author: a:*created by</p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT020070CA.Author: bc:prescribed by</p>
 * 
 * <p><p>The person who prescribed the medication.</p></p>
 * 
 * <p><p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p></p>
 * 
 * <p>MCAI_MT700223CA.Author: a:*created by</p>
 * 
 * <p><p>Indicates the person responsible for the event that 
 * caused this message.</p></p>
 * 
 * <p><p>Critical for auditing and for validating permissions 
 * and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060190CA.Author3: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the refusal and 
 * is therefore mandatory</p></p>
 * 
 * <p>PORX_MT030040CA.Author: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the refusal and 
 * is therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060090CA.Author5: *prescribed by</p>
 * 
 * <p><p>Indicates the prescriber of the prescription.</p></p>
 * 
 * <p><p>The prescriber is a key piece of legal information 
 * which must be conveyed and is therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.Author: *created by</p>
 * 
 * <p><p>Identifies the provider responsible for capturing the 
 * Other Medication record</p></p>
 * 
 * <p><p>Provides traceability as well as contact information 
 * for follow-up and is therefore mandatory.</p></p>
 * 
 * <p>REPC_MT000009CA.Author: *f:authored by</p>
 * 
 * <p><p>Identifies the provider who reported the allergy or 
 * intolerance.</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>Identifies responsibility for accuracy and relevance 
 * of the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p></p>
 * 
 * <p>COCT_MT130001CA.Author3: *changed by</p>
 * 
 * <p><p>Identity of the health service provider responsible 
 * for the change.</p></p>
 * 
 * <p><p>In an EHR integrated health services environment, it 
 * is important that other providers are able to query who is 
 * responsible for a given change. Also used by applications 
 * for auditing and sorting. The attribute is mandatory because 
 * the responsible provider should always be known.</p></p>
 * 
 * <p>PORX_MT060340CA.Author: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the provider 
 * refusing the fill must be known.</p></p>
 * 
 * <p>REPC_MT000017CA.Author: Provider</p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p>PORX_MT060060CA.Author: *refused by</p>
 * 
 * <p><p>Indicates who refused to fulfill the prescription</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the refusal and 
 * is therefore mandatory</p></p>
 * 
 * <p>REPC_MT000007CA.Author: *b:authored by</p>
 * 
 * <p><p>Identifies the provider who caused the condition to be 
 * recorded.</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>AllergyIntolerance.authorizingProvider</p><p>ZPB1.3</p><p>AllergyIntolerance.authorizingPhysician</p></p>
 * 
 * <p><p>Identifies responsibility for accuracy and relevance 
 * of the information. This association reflects primary 
 * responsibility, and is therefore mandatory.</p></p>
 * 
 * <p>REPC_MT000009CA.Author3: *changed by</p>
 * 
 * 
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"COCT_MT120600CA.Author","COCT_MT130001CA.Author3","COMT_MT300003CA.Author","MCAI_MT700210CA.Author","MCAI_MT700221CA.Author","MCAI_MT700223CA.Author","POIZ_MT060150CA.Author","PORX_MT020060CA.Author","PORX_MT020070CA.Author","PORX_MT030040CA.Author","PORX_MT060010CA.Author5","PORX_MT060040CA.Author","PORX_MT060060CA.Author","PORX_MT060090CA.Author5","PORX_MT060160CA.Author","PORX_MT060160CA.Author5","PORX_MT060190CA.Author","PORX_MT060190CA.Author3","PORX_MT060210CA.Author","PORX_MT060340CA.Author","QUQI_MT020000CA.Author","REPC_MT000005CA.Author","REPC_MT000006CA.Author","REPC_MT000007CA.Author","REPC_MT000009CA.Author","REPC_MT000009CA.Author3","REPC_MT000010CA.Author","REPC_MT000010CA.Author3","REPC_MT000017CA.Author","REPC_MT100001CA.Author","REPC_MT100002CA.Author3"})
public class RefusedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private TS time = new TSImpl();
    private ProviderBean assignedPerson;
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();


    /**
     * <p>Prescription Order Date</p>
     * 
     * <p><p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     * 
     * <p>Recording Datetime</p>
     * 
     * <p><p>The date and time on which the observation was 
     * recorded.</p></p>
     * 
     * <p><p>ZPB3.20</p><p>Annotation.annotationDate</p></p>
     * 
     * <p><p>ZPB3.20</p><p>Annotation.annotationDate</p></p>
     * 
     * <p><p>The date and time on which the observation was 
     * recorded. Identifies timing of observation for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p></p>
     * 
     * <p><p>If not specified, the author time of the overall order 
     * will be assumed.</p></p>
     * 
     * <p>Create Timestamp</p>
     * 
     * <p><p>The date and time on which the allergy/intolerance 
     * record was created.</p></p>
     * 
     * <p><p>Identifies timing of allergy/intolerance for sorting 
     * and for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p></p>
     * 
     * <p>Create Timestamp</p>
     * 
     * <p><p>The date and time on which the allergy/intolerance 
     * record was created.</p></p>
     * 
     * <p><p>Identifies timing of allergy/intolerance for sorting 
     * and for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record 
     * allergy/intolerance' interaction.</p></p>
     * 
     * <p>*Create Timestamp</p>
     * 
     * <p><p>The date and time on which the medication condition 
     * record was created.</p></p>
     * 
     * <p><p>Identifies timing of medical condition for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record medical 
     * condition' interaction.</p></p>
     * 
     * <p>B:Patient Note Date</p>
     * 
     * <p><p>The date on which the patient note was created.</p></p>
     * 
     * <p><p>Allows other provider to evaluate the currency of the 
     * information contained in the note.</p><p>The date of the 
     * note creation is always known and is therefore 
     * mandatory.</p></p>
     * 
     * <p><p>Allows other provider to evaluate the currency of the 
     * information contained in the note.</p><p>The date of the 
     * note creation is always known and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Change Time</p>
     * 
     * <p><p>The date and time on which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the medical 
     * condition. Also used for sorting and audit purposes. Time of 
     * change is always known and thus the attribute is 
     * mandatory.</p></p>
     * 
     * <p>Create Timestamp</p>
     * 
     * <p><p>The date and time on which the medical condition 
     * record was created.</p></p>
     * 
     * <p><p>Identifies timing of the medical condition for sorting 
     * and for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p></p>
     * 
     * <p>D:Time of Creation</p>
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time the person responsible for the event made the 
     * decision for it to occur. This may be different than the 
     * time the change became effective. (E.g. If a provider 
     * decides today to put a prescription on hold starting next 
     * Tuesday, the time of creation would be today and the change 
     * effective period would be next Tuesday.)</p><p>This date can 
     * be back-dated.</p></p>
     * 
     * <p><p>The time a change is made is a critical piece of audit 
     * information and is therefore mandatory.</p></p>
     * 
     * <p>D:Time of Creation</p>
     * 
     * <p><p>The time the person responsible for the query made the 
     * decision for it to occur. This may be different than the 
     * time the time the query was actually performed.</p></p>
     * 
     * <p><p>The time a decision is made is a critical piece of 
     * audit information and is therefore mandatory.</p></p>
     * 
     * <p>Prescription Order Date</p>
     * 
     * <p><p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     * 
     * <p>Note Timestamp</p>
     * 
     * <p><p>The date and time at which the note was posted.</p></p>
     * 
     * <p><p>Identifies timing of the annotation for sorting and 
     * for audit purposes.</p><p>This attribute is mandatory 
     * because the time of creation of the annotation will always 
     * be known.</p></p>
     * 
     * <p><p>Identifies timing of the annotation for sorting and 
     * for audit purposes.</p><p>This attribute is mandatory 
     * because the time of creation of the annotation will always 
     * be known.</p></p>
     * 
     * <p>Create Timestamp</p>
     * 
     * <p><p>The date and time on which the adverse reaction record 
     * was created.</p></p>
     * 
     * <p><p>Identifies timing of adverse reaction for sorting and 
     * for audit purposes. Attribute is populated because the 
     * source of the data may not be through the 'record common 
     * observation' interaction.</p></p>
     * 
     * <p>Change Time</p>
     * 
     * <p><p>The date on which the change was made.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the allergy. Also 
     * used for sorting and audit purposes. Time of change is 
     * always known and thus the attribute is mandatory.</p></p>
     * 
     * <p>Change Datetime</p>
     * 
     * <p><p>The date on which the change was made. Note that this 
     * may be earlier or occassionally later than when the change 
     * is actually effective.</p></p>
     * 
     * <p><p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the event. Also used 
     * for sorting and audit purposes. Time of change is always 
     * known and thus the attribute is mandatory.</p></p>
     * 
     * <p>Prescription Order Date</p>
     * 
     * <p><p>The calendar date on which the device was prescribed. 
     * This may differ from the date on which the prescription 
     * becomes effective. E.g. A prescription created today may not 
     * be valid to be dispensed or used for two weeks.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     * 
     * <p><p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription 
     * shall always be known or absent for a reason.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>InformationReceivedMethod</p>
     * 
     * <p>F:Information Received Method</p>
     * 
     * <p><p>Indicates how the person who recorded the event became 
     * aware of it. E.g. Verbal, written, fax, etc.</p></p>
     * 
     * <p><p>May have ramifications for the audit trail and 
     * reliability of the information.</p></p>
     * 
     * <p>F:Information Received Method</p>
     * 
     * <p><p>Indicates how the person who recorded the event became 
     * aware of it.. E.g. Verbal, written, fax, etc.</p></p>
     * 
     * <p><p>May have ramifications for the audit trail and 
     * reliability of the information.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>DigitalSignature</p>
     * 
     * <p>G:Digital Signature</p>
     * 
     * <p><p>Indicates the formal digital signature of the message 
     * content.</p></p>
     * 
     * <p><p>Digital signatures may be needed for authentication of 
     * message content. The attribute is marked as optional because 
     * it is not yet clear whether there is a use-case for this, or 
     * where it will be used.</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }

}
