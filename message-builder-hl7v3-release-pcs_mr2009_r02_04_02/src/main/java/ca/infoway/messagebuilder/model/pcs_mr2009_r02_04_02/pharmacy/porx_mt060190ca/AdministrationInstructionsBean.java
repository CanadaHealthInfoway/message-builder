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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060190CA.AdministrationInstructions"})
public class AdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD medicationType = new CDImpl();
    private ST renderedDosageInstruction = new STImpl();


    /**
     * <p>Medication type</p>
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
     */
    @Hl7XmlMapping({"code"})
    public Code getMedicationType() {
        return (Code) this.medicationType.getValue();
    }
    public void setMedicationType(Code medicationType) {
        this.medicationType.setValue(medicationType);
    }


    /**
     * <p>Rendered Dosage Instruction</p>
     * 
     * <p><p>A textual rendition of structured (or non-structure) 
     * original dosage instruction specified by the prescriber.</p></p>
     * 
     * <p><p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p></p>
     * 
     * <p><p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getRenderedDosageInstruction() {
        return this.renderedDosageInstruction.getValue();
    }
    public void setRenderedDosageInstruction(String renderedDosageInstruction) {
        this.renderedDosageInstruction.setValue(renderedDosageInstruction);
    }

}