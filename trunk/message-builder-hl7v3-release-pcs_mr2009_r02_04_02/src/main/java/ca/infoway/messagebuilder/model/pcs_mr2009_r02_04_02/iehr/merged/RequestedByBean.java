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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import java.util.Date;



/**
 * <p>REPC_MT230002CA.Author: *a: authored by</p>
 * 
 * <p> <i>This identifies the provider who is responsible for 
 * the decision to capture the Clinical Observation Document in 
 * the patient's EHR. Note that while the author is frequently 
 * the data-enterer, this will not always be the case, for 
 * example where transcribers are involved.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p>REPC_MT220001CA.Author3: *a: requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the 
 * Discharge-Care Summary to be performed. The request may have 
 * been verbal, electronic, as part of a referral or by other 
 * means. This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT230002CA.Author2: *a: requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the 
 * Clinical Observation Document to be performed. The request 
 * may have been verbal, electronic, as part of a referral or 
 * by other means. This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT500001CA.Author2: *requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the Care 
 * Composition to be performed. The request may have been 
 * verbal, electronic, as part of a referral or by other means. 
 * This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT220002CA.Author3: *a: requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the 
 * Discharge-Care Summary to be performed. The request may have 
 * been verbal, electronic, as part of a referral or by other 
 * means. This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT500002CA.Author2: *requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the Care 
 * Composition to be performed. The request may have been 
 * verbal, electronic, as part of a referral or by other means. 
 * This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT230003CA.Author2: *a: requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the 
 * Clinical Observation Document to be performed. The request 
 * may have been verbal, electronic, as part of a referral or 
 * by other means. This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT500003CA.Author2: *requested by</p>
 * 
 * <p> <i>This identifies the provider who requested the Care 
 * Composition to be performed. The request may have been 
 * verbal, electronic, as part of a referral or by other means. 
 * This element does not need to be captured in 
 * &quot;record&quot; and &quot;amend&quot; messages where a 
 * request id is captured, as the requesting provider can be 
 * looked up by retrieving the request.</i> </p>
 * 
 * <p> <i>By requesting the action, the provider takes a level 
 * of responsibility for it. The attribute may also be used to 
 * search or filter records. Requesting providers generally 
 * have authorization to view masked information as well.</i> 
 * </p>
 * 
 * <p>REPC_MT220002CA.Author: *a: authored by</p>
 * 
 * <p> <i>This identifies the provider who is responsible for 
 * the decision to capture the Discharge-Care Summary in the 
 * patient's EHR. Note that while the author is frequently the 
 * data-enterer, this will not always be the case, for example 
 * where transcribers are involved.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p>REPC_MT210003CA.Author: *a: authored by</p>
 * 
 * <p> <i>This identifies the provider who is responsible for 
 * the decision to capture the Referral in the patient's EHR. 
 * Note that while the author is frequently the data-enterer, 
 * this will not always be the case, for example where 
 * transcribers are involved.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p>REPC_MT230003CA.Author: *a: authored by</p>
 * 
 * <p> <i>This identifies the provider who is responsible for 
 * the decision to capture the Clinical Observation Document in 
 * the patient's EHR. Note that while the author is frequently 
 * the data-enterer, this will not always be the case, for 
 * example where transcribers are involved.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p> <i>Used to identify responsibility for accuracy and 
 * relevance of the information. This association reflects 
 * primary responsibility, and is therefore mandatory.</i> 
 * </p><p> <i>The author is generally the person to contact 
 * with requests for additional information. In some cases, 
 * this information may also be used for filtering or 
 * sorting.</i> </p>
 * 
 * <p>REPC_MT210002CA.Author: *a: authored by</p>
 * 
 * <p> <i>This identifies the provider who is responsible for 
 * the decision to capture the Referral in the patient's EHR. 
 * Note that while the author is frequently the data-enterer, 
 * this will not always be the case, for example where 
 * transcribers are involved.</i> </p>
 * 
 * <p> <i>Used
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.Author","REPC_MT210002CA.Author","REPC_MT210003CA.Author","REPC_MT220001CA.Author","REPC_MT220001CA.Author3","REPC_MT220002CA.Author","REPC_MT220002CA.Author3","REPC_MT220003CA.Author","REPC_MT220003CA.Author3","REPC_MT230001CA.Author2","REPC_MT230002CA.Author","REPC_MT230002CA.Author2","REPC_MT230003CA.Author","REPC_MT230003CA.Author2","REPC_MT410001CA.Author","REPC_MT410003CA.Author2","REPC_MT410003CA.Author3","REPC_MT420001CA.Author2","REPC_MT420003CA.Author2","REPC_MT500001CA.Author2","REPC_MT500002CA.Author2","REPC_MT500003CA.Author","REPC_MT500003CA.Author2","REPC_MT500004CA.Author","REPC_MT500004CA.Author2","REPC_MT610001CA.Author","REPC_MT610002CA.Author"})
public class RequestedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private TS time = new TSImpl();
    private CV signatureCode = new CVImpl();
    private ActingPerson actingPerson;


    /**
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Clinical Observation Document was made. This will usually be 
     * simultaneous with the time the record is submitted to the 
     * EHR, but in some circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Referral was made. This will usually be simultaneous with 
     * the time the record is submitted to the EHR, but in some 
     * circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     * 
     * <p>Authored Datetime</p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p>G:Amend Datetime</p>
     * 
     * <p> <i>This indicates the last time a change was made to the 
     * Care Composition.</i> </p>
     * 
     * <p> <i>It can be used by PoS applications to sort or filter 
     * records. Also provides information on how recently the 
     * record has changed.</i> </p><p> <i>Because the element 
     * should always be known by the EHR, it is mandatory.</i> </p>
     * 
     * <p> <i>It can be used by PoS applications to sort or filter 
     * records. Also provides information on how recently the 
     * record has changed.</i> </p><p> <i>Because the element 
     * should always be known by the EHR, it is mandatory.</i> </p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Discharge-Care Summary was made. This will usually be 
     * simultaneous with the time the record is submitted to the 
     * EHR, but in some circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Clinical Observation Document was made. This will usually be 
     * simultaneous with the time the record is submitted to the 
     * EHR, but in some circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Referral was made. This will usually be simultaneous with 
     * the time the record is submitted to the EHR, but in some 
     * circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     * 
     * <p>Authored Datetime</p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p>G:Amend Datetime</p>
     * 
     * <p> <i>This indicates the last time a change was made to the 
     * Care Composition.</i> </p>
     * 
     * <p> <i>It can be used by PoS applications to sort or filter 
     * records. Also provides information on how recently the 
     * record has changed.</i> </p><p> <i>Because the element 
     * should always be known by the EHR, it is mandatory.</i> </p>
     * 
     * <p> <i>It can be used by PoS applications to sort or filter 
     * records. Also provides information on how recently the 
     * record has changed.</i> </p><p> <i>Because the element 
     * should always be known by the EHR, it is mandatory.</i> </p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p> <i>Indicates the time the decision to record when the 
     * Discharge-Care Summary was made. This will usually be 
     * simultaneous with the time the record is submitted to the 
     * EHR, but in some circumstances may be before.</i> </p>
     * 
     * <p> <i>Used to allow for historical sequencing of records in 
     * the EHR, which facilitates auditing, sorting etc. This 
     * attribute is populated because it won't always be known in 
     * the circumstance where the data is being entered by a person 
     * other than the original &quot;creator&quot; of the 
     * record.</i> </p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>AttestedIndicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p>An indication that the provider attests to the 
     * authenticity of the document that he/she has authored.</p>
     * 
     * <p>Important for assessing the level of 'officialness' of a 
     * document. Because it must always be known whether a document 
     * has been attested or not, the attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"signatureCode"})
    public ParticipationSignature getSignatureCode() {
        return (ParticipationSignature) this.signatureCode.getValue();
    }

    /**
     * <p>AttestedIndicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p>An indication that the provider attests to the 
     * authenticity of the document that he/she has authored.</p>
     * 
     * <p>Important for assessing the level of 'officialness' of a 
     * document. Because it must always be known whether a document 
     * has been attested or not, the attribute is mandatory.</p>
     */
    public void setSignatureCode(ParticipationSignature signatureCode) {
        this.signatureCode.setValue(signatureCode);
    }


    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }

    public void setActingPerson(ActingPerson actingPerson) {
        this.actingPerson = actingPerson;
    }

}
