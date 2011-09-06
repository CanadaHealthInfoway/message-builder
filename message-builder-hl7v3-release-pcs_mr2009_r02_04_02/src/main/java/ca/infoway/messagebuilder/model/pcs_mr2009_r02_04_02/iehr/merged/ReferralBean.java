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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareProvisionRequestType;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveComplete;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdministeredByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Referral</p>
 * 
 * <p>REPC_MT210002CA.PatientCareProvisionRequest: C:Referral</p>
 * 
 * <p><p>Discrete information about the type of care being 
 * requested.</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 * 
 * <p>REPC_MT210003CA.PatientCareProvisionRequest: C:Referral</p>
 * 
 * <p><p>Discrete information about the type of care being 
 * requested.</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.PatientCareProvisionRequest","REPC_MT210002CA.PatientCareProvisionRequest","REPC_MT210003CA.PatientCareProvisionRequest"})
public class ReferralBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt210001ca.DocumentContent, DocumentContent_1 {

    private static final long serialVersionUID = 20110906L;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private CD referralType = new CDImpl();
    private CS referralStatus = new CSImpl();
    private IVL<TS, Interval<Date>> referralRequestedByTime = new IVLImpl<TS, Interval<Date>>();
    private AdministeredByBean performer;
    private OccurredAtBean location;
    private ActRequest2Bean componentActRequest;
    private CareCompositionsBean fulfillmentPatientCareProvisionEvent;


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>ReferralType</p>
     * 
     * <p>C: Referral Type</p>
     * 
     * <p>C: Referral Type</p>
     * 
     * <p><p>Concepts identifying different types of referral 
     * request document. These codes identify the general type of 
     * care services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareProvisionRequestType getReferralType() {
        return (ActCareProvisionRequestType) this.referralType.getValue();
    }
    public void setReferralType(ActCareProvisionRequestType referralType) {
        this.referralType.setValue(referralType);
    }


    /**
     * <p>ReferralStatus</p>
     * 
     * <p>D: Referral Status</p>
     * 
     * <p></p><p>If the status is 'active' it means the request is 
     * still outstanding or in progress. If the status is 
     * 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p></p>
     * 
     * <p></p><p>If the status is 'active' it means the request is 
     * still outstanding or in progress. If the status is 
     * 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p></p>
     * 
     * <p></p><p>It is important to note that the EHR is not 
     * expected to perform status management of referrals. Thus it 
     * is up to clinicians to amend the status of a referral when 
     * it has changed to complete.</p></p>
     * 
     * <p></p><p>It is important to note that the EHR is not 
     * expected to perform status management of referrals. Thus it 
     * is up to clinicians to amend the status of a referral when 
     * it has changed to complete.</p></p>
     * 
     * <p></p><p>It is important to note that the EHR is not 
     * expected to perform status management of referrals. Thus it 
     * is up to clinicians to amend the status of a referral when 
     * it has changed to complete.</p></p>
     * 
     * <p>D: Referral Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveComplete getReferralStatus() {
        return (x_ActStatusActiveComplete) this.referralStatus.getValue();
    }
    public void setReferralStatus(x_ActStatusActiveComplete referralStatus) {
        this.referralStatus.setValue(referralStatus);
    }


    /**
     * <p>ReferralRequestedByTime</p>
     * 
     * <p>F: Referral Requested By Time</p>
     * 
     * <p>F: Referral Requested By Time</p>
     * 
     * <p><p>Indicates the target date by which the referring 
     * provider hopes the requested assessment could be 
     * completed.</p></p>
     * 
     * <p></p><p>Identifies the time-period of relevance to the 
     * record which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data.</p></p>
     * 
     * <p></p><p>Identifies the time-period of relevance to the 
     * record which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReferralRequestedByTime() {
        return this.referralRequestedByTime.getValue();
    }
    public void setReferralRequestedByTime(Interval<Date> referralRequestedByTime) {
        this.referralRequestedByTime.setValue(referralRequestedByTime);
    }


    @Hl7XmlMapping({"performer"})
    public AdministeredByBean getPerformer() {
        return this.performer;
    }
    public void setPerformer(AdministeredByBean performer) {
        this.performer = performer;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"component/actRequest"})
    public ActRequest2Bean getComponentActRequest() {
        return this.componentActRequest;
    }
    public void setComponentActRequest(ActRequest2Bean componentActRequest) {
        this.componentActRequest = componentActRequest;
    }


    @Hl7XmlMapping({"fulfillment/patientCareProvisionEvent"})
    public CareCompositionsBean getFulfillmentPatientCareProvisionEvent() {
        return this.fulfillmentPatientCareProvisionEvent;
    }
    public void setFulfillmentPatientCareProvisionEvent(CareCompositionsBean fulfillmentPatientCareProvisionEvent) {
        this.fulfillmentPatientCareProvisionEvent = fulfillmentPatientCareProvisionEvent;
    }

}
