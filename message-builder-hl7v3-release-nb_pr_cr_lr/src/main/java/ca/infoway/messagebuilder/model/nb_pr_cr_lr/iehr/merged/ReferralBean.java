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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt240007ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.BecauseOfIndicationsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Referral</p>
 * 
 * <p>REPC_MT210002CA.PatientCareProvisionRequest: C:Referral</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the type of care being 
 * requested.</p>
 * 
 * <p>REPC_MT210001CA.PatientCareProvisionRequest: C:Referral</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the type of care being 
 * requested.</p>
 * 
 * <p>REPC_MT210003CA.PatientCareProvisionRequest: C:Referral</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the type of care being 
 * requested.</p>
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.PatientCareProvisionRequest","REPC_MT210002CA.PatientCareProvisionRequest","REPC_MT210003CA.PatientCareProvisionRequest"})
public class ReferralBean extends MessagePartBean implements DocumentContent_1 {

    private static final long serialVersionUID = 20151013L;
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ProviderBean performerAssignedEntity;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<BecauseOfIndicationsBean> reason = new ArrayList<BecauseOfIndicationsBean>();
    private ActRequest2Bean componentActRequest;
    private PatientCareProvisionEvent2Bean fulfillmentPatientCareProvisionEvent;


    /**
     * <p>Business Name: ReferralType</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareProvisionRequestType getCode() {
        return (ActCareProvisionRequestType) this.code.getValue();
    }

    /**
     * <p>Business Name: ReferralType</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     * 
     * <p>Un-merged Business Name: ReferralType</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Referral Type is used for searching and for 
     * organizing Referral records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Concepts identifying different types of referral request 
     * document. These codes identify the general type of care 
     * services requested. They are not used to represent the 
     * indication or diagnosis which triggered the need for the 
     * referral.</p>
     */
    public void setCode(ActCareProvisionRequestType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ReferralStatus</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveComplete getStatusCode() {
        return (x_ActStatusActiveComplete) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: ReferralStatus</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     * 
     * <p>Un-merged Business Name: ReferralStatus</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Referral record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p><p>It is important to note that the EHR is 
     * not expected to perform status management of referrals. Thus 
     * it is up to clinicians to amend the status of a referral 
     * when it has changed to complete.</p>
     * 
     * <p> <i>This identifies the current state of the Referral 
     * record.</i> </p><p>If the status is 'active' it means the 
     * request is still outstanding or in progress. If the status 
     * is 'complete' it means that the referral has been acted upon 
     * and the referral is considered closed. If the status is 
     * 'aborted' it means the request made by the referral has been 
     * withdrawn.</p>
     */
    public void setStatusCode(x_ActStatusActiveComplete statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     * 
     * <p>Un-merged Business Name: ReferralRequestedByTime</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.PatientCareProvisionRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p><p>Identifies the time-period 
     * of relevance to the record which is useful in filtering and 
     * organizing &quot;time-view&quot; presentations of data.</p>
     * 
     * <p>Indicates the target date by which the referring provider 
     * hopes the requested assessment could be completed.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity"})
    public ProviderBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerAssignedEntity(ProviderBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfIndicationsBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/actRequest"})
    public ActRequest2Bean getComponentActRequest() {
        return this.componentActRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Component8.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentActRequest(ActRequest2Bean componentActRequest) {
        this.componentActRequest = componentActRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/patientCareProvisionEvent"})
    public PatientCareProvisionEvent2Bean getFulfillmentPatientCareProvisionEvent() {
        return this.fulfillmentPatientCareProvisionEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.InFulfillmentOf2.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentPatientCareProvisionEvent(PatientCareProvisionEvent2Bean fulfillmentPatientCareProvisionEvent) {
        this.fulfillmentPatientCareProvisionEvent = fulfillmentPatientCareProvisionEvent;
    }

}
