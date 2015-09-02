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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt010120nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.SubstanceAdministrationType;



/**
 * <p>Links prescriptions into a 'chain', allowing easier 
 * monitoring.</p>
 * 
 * <p>Links the current order to a previous order</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120NB.PriorCombinedMedicationRequest"})
public class PriorCombinedMedicationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120NB.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p><p>As this is the direct link to the 
     * previous prescription, it is Mandatory.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120NB.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p><p>As this is the direct link to the 
     * previous prescription, it is Mandatory.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Prescription type</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120NB.PriorCombinedMedicationRequest.code</p>
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
     * <p>Business Name: Prescription type</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120NB.PriorCombinedMedicationRequest.code</p>
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
