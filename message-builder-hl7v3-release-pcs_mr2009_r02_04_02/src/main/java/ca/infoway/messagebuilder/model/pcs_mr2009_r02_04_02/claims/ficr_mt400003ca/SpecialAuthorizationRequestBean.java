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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt400003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.SpecialAuthorizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.SpecialAuthorizationChoice_2;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActiveMedicationBean;



@Hl7PartTypeMapping({"FICR_MT400003CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean authorAssignedEntity;
    private SpecialAuthorizationChoice_2 subjectSpecialAuthorizationChoice;
    private SpecialAuthorizationBean fulfillmentSpecialAuthorization;


    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecialAuthorizationCode getCode() {
        return (ActSpecialAuthorizationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Request Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Request Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: FICR_MT400003CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: FICR_MT400003CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * FICR_MT400003CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/specialAuthorizationChoice"})
    public SpecialAuthorizationChoice_2 getSubjectSpecialAuthorizationChoice() {
        return this.subjectSpecialAuthorizationChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT400003CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectSpecialAuthorizationChoice(SpecialAuthorizationChoice_2 subjectSpecialAuthorizationChoice) {
        this.subjectSpecialAuthorizationChoice = subjectSpecialAuthorizationChoice;
    }

    public ActiveMedicationBean getSubjectSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return this.subjectSpecialAuthorizationChoice instanceof ActiveMedicationBean ? (ActiveMedicationBean) this.subjectSpecialAuthorizationChoice : null;
    }
    public boolean hasSubjectSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return (this.subjectSpecialAuthorizationChoice instanceof ActiveMedicationBean);
    }

    public DevicePassThruBean getSubjectSpecialAuthorizationChoiceAsDevicePassThru() {
        return this.subjectSpecialAuthorizationChoice instanceof DevicePassThruBean ? (DevicePassThruBean) this.subjectSpecialAuthorizationChoice : null;
    }
    public boolean hasSubjectSpecialAuthorizationChoiceAsDevicePassThru() {
        return (this.subjectSpecialAuthorizationChoice instanceof DevicePassThruBean);
    }


    /**
     * <p>Relationship: 
     * FICR_MT400003CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/specialAuthorization"})
    public SpecialAuthorizationBean getFulfillmentSpecialAuthorization() {
        return this.fulfillmentSpecialAuthorization;
    }

    /**
     * <p>Relationship: 
     * FICR_MT400003CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentSpecialAuthorization(SpecialAuthorizationBean fulfillmentSpecialAuthorization) {
        this.fulfillmentSpecialAuthorization = fulfillmentSpecialAuthorization;
    }

}
