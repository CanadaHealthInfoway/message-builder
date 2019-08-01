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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.SubstanceAdministrationType;



@Hl7PartTypeMapping({"PORX_MT060190CA.AdministrationInstructions"})
public class AdministrationInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CD code = new CDImpl();
    private ST text = new STImpl();


    /**
     * <p>Business Name: Medication type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    @Hl7XmlMapping({"code"})
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
    }

    /**
     * <p>Business Name: Medication type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.AdministrationInstructions.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in providing the context of the rendered dosage 
     * instruction.</p><p>For this reason the attribute is 
     * Mandatory.</p>
     * 
     * <p>Differentiates the type of medication e.g. drug, 
     * vaccine</p>
     */
    public void setCode(SubstanceAdministrationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p>
     * 
     * <p>A textual rendition of structured (or non-structure) 
     * original dosage instruction specified by the prescriber.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Rendered Dosage Instruction</p>
     * 
     * <p>Relationship: 
     * PORX_MT060190CA.AdministrationInstructions.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p>
     * 
     * <p>A textual rendition of structured (or non-structure) 
     * original dosage instruction specified by the prescriber.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
