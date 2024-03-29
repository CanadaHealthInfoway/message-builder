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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.SupervisedByBean;
import java.util.Set;



/**
 * <p>PORX_MT020050CA.SupplyRequest: Supply Order</p>
 * 
 * <p>Ensures that dispenses to offices (non-patient 
 * identifiable dispenses) follow the normal dispensing 
 * rules.</p>
 * 
 * <p>Identification of the supply information. This 
 * prescription will have a supply order portion but no 
 * administration part.</p>
 * 
 * <p>PORX_MT060020CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p>Links a dispense with its parent prescription.</p>
 * 
 * <p>A reference to the prescription order being dispensed</p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyRequest","PORX_MT060020CA.SupplyRequest"})
public class SupplyOrderBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private SupervisedByBean responsibleParty;
    private PrescribedByBean author;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CS statusCode = new CSImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.SupplyRequest.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.SupplyRequest.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"responsibleParty"})
    public SupervisedByBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT020050CA.SupplyRequest.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060020CA.SupplyRequest.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setResponsibleParty(SupervisedByBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.SupplyRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: PrescriptionIdentifier</p>
     * 
     * <p>Un-merged Business Name: PrescriptionIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060020CA.SupplyRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS would always assign a Prescription 
     * Number.</p>
     * 
     * <p>This is an identifier assigned to a specific device 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: PORX_MT060020CA.SupplyRequest.statusCode</p>
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
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: PORX_MT060020CA.SupplyRequest.statusCode</p>
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

}
