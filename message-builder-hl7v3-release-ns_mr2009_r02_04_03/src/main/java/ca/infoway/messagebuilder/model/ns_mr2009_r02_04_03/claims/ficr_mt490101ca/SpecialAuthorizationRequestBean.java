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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.ficr_mt490101ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.merged.SpecialAuthorizationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.merged.SpecialAuthorizationChoice_1;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.ActiveMedicationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.Subject5Bean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490101CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private HealthcareWorkerBean authorAssignedEntity;
    private List<Subject5Bean> subject1 = new ArrayList<Subject5Bean>();
    private SpecialAuthorizationChoice_1 subject2SpecialAuthorizationChoice;
    private SpecialAuthorizationBean fulfillmentSpecialAuthorization;


    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.id</p>
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
     * FICR_MT490101CA.SpecialAuthorizationRequest.id</p>
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
     * FICR_MT490101CA.SpecialAuthorizationRequest.code</p>
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
     * FICR_MT490101CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: FICR_MT490101CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: FICR_MT490101CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.subject1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"subject1"})
    public List<Subject5Bean> getSubject1() {
        return this.subject1;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490101CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject2/specialAuthorizationChoice"})
    public SpecialAuthorizationChoice_1 getSubject2SpecialAuthorizationChoice() {
        return this.subject2SpecialAuthorizationChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT490101CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject2SpecialAuthorizationChoice(SpecialAuthorizationChoice_1 subject2SpecialAuthorizationChoice) {
        this.subject2SpecialAuthorizationChoice = subject2SpecialAuthorizationChoice;
    }

    public ActiveMedicationBean getSubject2SpecialAuthorizationChoiceAsSubstanceAdministration() {
        return this.subject2SpecialAuthorizationChoice instanceof ActiveMedicationBean ? (ActiveMedicationBean) this.subject2SpecialAuthorizationChoice : null;
    }
    public boolean hasSubject2SpecialAuthorizationChoiceAsSubstanceAdministration() {
        return (this.subject2SpecialAuthorizationChoice instanceof ActiveMedicationBean);
    }

    public DevicePassThruBean getSubject2SpecialAuthorizationChoiceAsDevicePassThru() {
        return this.subject2SpecialAuthorizationChoice instanceof DevicePassThruBean ? (DevicePassThruBean) this.subject2SpecialAuthorizationChoice : null;
    }
    public boolean hasSubject2SpecialAuthorizationChoiceAsDevicePassThru() {
        return (this.subject2SpecialAuthorizationChoice instanceof DevicePassThruBean);
    }


    /**
     * <p>Relationship: 
     * FICR_MT490101CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/specialAuthorization"})
    public SpecialAuthorizationBean getFulfillmentSpecialAuthorization() {
        return this.fulfillmentSpecialAuthorization;
    }

    /**
     * <p>Relationship: 
     * FICR_MT490101CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setFulfillmentSpecialAuthorization(SpecialAuthorizationBean fulfillmentSpecialAuthorization) {
        this.fulfillmentSpecialAuthorization = fulfillmentSpecialAuthorization;
    }

}
