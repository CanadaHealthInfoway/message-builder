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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.porx_mt060100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.SubstanceAdministrationType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.PrescribedByBean;
import java.util.Set;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>Provides a drill-down link from the prescription to its 
 * corresponding order.</p>
 * 
 * <p>Indicates the order being dispensed</p>
 */
@Hl7PartTypeMapping({"PORX_MT060100CA.SubstanceAdministrationRequest"})
public class PrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;


    /**
     * <p>Business Name: A:Prescription Identifier</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Links the dispense to the prescription it fulfilled.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p><p>As the 'id' is the link to the 
     * prescription, it is Mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding the context of the 
     * prescription being fulfilled. Therefore is Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    @Hl7XmlMapping({"code"})
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
    }

    /**
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding the context of the 
     * prescription being fulfilled. Therefore is Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed in some jurisdictions</p>
     * 
     * <p>Provides the status of the prescription without requiring 
     * additional queries</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }

}
