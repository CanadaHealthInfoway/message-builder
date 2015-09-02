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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.SubstanceAdministrationType;



@Hl7PartTypeMapping({"PORX_MT030040NB.AdministrationInstructions","PORX_MT060100NB.AdministrationInstructions"})
public class PrescribedAdminidtrationInstructionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();
    private ST text = new STImpl();


    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040NB.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100NB.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
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
     * PORX_MT030040NB.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100NB.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Un-merged Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040NB.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>Un-merged Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100NB.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>For dosage instructions which cannot be summarized in the 
     * space allocated, a string such as &quot;Complex dose&quot; 
     * or &quot;Scaling dose&quot; or something similar should be 
     * sent. Dosage instructions should never be truncated.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Un-merged Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT030040NB.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     * 
     * <p>Un-merged Business Name: RenderedDosageInstruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100NB.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to verify the codified structured 
     * dosage information entered and ensure that the exploded 
     * instruction is consistent with the intended 
     * instructions.</p><p>Also useful in bringing back 
     * administration instructions on query responses. Because all 
     * prescriptions and dispenses have dosage, this attribute is 
     * mandatory.</p>
     * 
     * <p>For dosage instructions which cannot be summarized in the 
     * space allocated, a string such as &quot;Complex dose&quot; 
     * or &quot;Scaling dose&quot; or something similar should be 
     * sent. Dosage instructions should never be truncated.</p>
     * 
     * <p>A free form textual specification generated from the 
     * input specifications as created by the provider.</p><p>This 
     * is made up of either an 'Ad-hoc dosage instruction' or 
     * 'Textual rendition of the structured dosage lines', plus 
     * route, dosage unit, and other pertinent administration 
     * information specified by the provider.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
