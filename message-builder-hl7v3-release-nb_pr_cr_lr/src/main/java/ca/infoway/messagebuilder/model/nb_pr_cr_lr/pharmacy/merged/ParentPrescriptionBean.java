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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.SubstanceAdministrationType;
import java.util.Set;



/**
 * <p>Business Name: ParentPrescription</p>
 * 
 * <p>PORX_MT060160CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p>
 * 
 * <p>This is the original prescription that is being renewed. 
 * The current prescription uses the original prescription as 
 * the basis for its information.</p>
 * 
 * <p>PORX_MT060340CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p>
 * 
 * <p>This is the original prescription that is being renewed. 
 * The current prescription uses the original prescription as 
 * the basis for its information.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.PriorCombinedMedicationRequest","PORX_MT060340CA.PriorCombinedMedicationRequest"})
public class ParentPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();


    /**
     * <p>Business Name: PreviousPrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PreviousPrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     * 
     * <p>Un-merged Business Name: PreviousPrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.PriorCombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p>
     * 
     * <p>It signifies the type of prescription (same as it is on 
     * the prescription pointed to by the Previous Prescription 
     * Order Number )</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.PriorCombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p>
     * 
     * <p>It signifies the type of prescription (same as it is on 
     * the prescription pointed to by the Previous Prescription 
     * Order Number )</p>
     */
    @Hl7XmlMapping({"code"})
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
    }

    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.PriorCombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p>
     * 
     * <p>It signifies the type of prescription (same as it is on 
     * the prescription pointed to by the Previous Prescription 
     * Order Number )</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.PriorCombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p>
     * 
     * <p>It signifies the type of prescription (same as it is on 
     * the prescription pointed to by the Previous Prescription 
     * Order Number )</p>
     */
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }

}
