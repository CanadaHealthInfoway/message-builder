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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT030040CA.AdministrationInstructions","PORX_MT060100CA.AdministrationInstructions"})
public class PrescribedAdminidtrationInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST text = new STImpl();


    /**
     * <p>PrescriptionType</p>
     * 
     * <p>Prescription Type</p>
     * 
     * <p><p>Differentiates the type of medication e.g. drug, 
     * vaccine</p></p>
     * 
     * <p><p>Important in providing the context of the rendered 
     * dosage instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p></p>
     * 
     * <p><p>Important in providing the context of the rendered 
     * dosage instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p></p>
     * 
     * <p>Prescription Type</p>
     * 
     * <p><p>Differentiates the type of medication e.g. drug, 
     * vaccine</p></p>
     * 
     * <p><p>Important in providing the context of the rendered 
     * dosage instruction.</p><p>For this reason the attribute is 
     * Mandatory</p></p>
     * 
     * <p><p>Important in providing the context of the rendered 
     * dosage instruction.</p><p>For this reason the attribute is 
     * Mandatory</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>RenderedDosageInstruction</p>
     * 
     * <p>Rendered Dosage Instruction</p>
     * 
     * <p><p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p></p>
     * 
     * <p><p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p></p>
     * 
     * <p><p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>For dosage instructions which cannot be summarized in 
     * the space allocated, a string such as &quot;Complex 
     * dose&quot; or &quot;Scaling dose&quot; or something similar 
     * should be sent. Dosage instructions should never be 
     * truncated.</p></p>
     * 
     * <p>Rendered Dosage Instruction</p>
     * 
     * <p><p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p></p>
     * 
     * <p><p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p></p>
     * 
     * <p><p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}
