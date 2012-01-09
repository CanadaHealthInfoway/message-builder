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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
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
import java.util.Set;



/**
 * <p>ParentPrescription</p>
 * 
 * <p>PORX_MT060040CA.PriorSupplyRequest: Parent Prescription</p>
 * 
 * <p><p>This is the original prescription that is being 
 * renewed. The current prescription uses the original 
 * prescription as the basis for its information.</p></p>
 * 
 * <p><p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p></p>
 * 
 * <p>PORX_MT060340CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p><p>This is the original prescription that is being 
 * renewed. The current prescription uses the original 
 * prescription as the basis for its information.</p></p>
 * 
 * <p><p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p></p>
 * 
 * <p>PORX_MT060160CA.PriorCombinedMedicationRequest: Parent 
 * Prescription</p>
 * 
 * <p><p>This is the original prescription that is being 
 * renewed. The current prescription uses the original 
 * prescription as the basis for its information.</p></p>
 * 
 * <p><p>Helps link prescriptions together, and subsequently 
 * indications for prescribing.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.PriorSupplyRequest","PORX_MT060160CA.PriorCombinedMedicationRequest","PORX_MT060340CA.PriorCombinedMedicationRequest"})
public class ParentPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();


    /**
     * <p>PreviousPrescriptionOrderNumber</p>
     * 
     * <p>B:Previous Prescription Order Number</p>
     * 
     * <p><p>A reference to a previous prescription which the 
     * current prescription replaces.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     * 
     * <p><p>Allows a prescription renewal (this prescription) to 
     * note the previous prescription id that was 
     * renewed;</p><p>Allows tracking a therapy across multiple 
     * renewal prescriptions.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>PrescriptionType</p>
     * 
     * <p>Prescription Type</p>
     * 
     * <p><p>It signifies the type of prescription (same as it is 
     * on the prescription pointed to by the Previous Prescription 
     * Order Number )</p></p>
     * 
     * <p><p>This allows for instant identification of the type of 
     * prescription being replaced/renewed, etc; and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

}
