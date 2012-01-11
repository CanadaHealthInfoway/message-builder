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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POME_MT010040CA.Document","PORR_MT050016CA.Document"})
@Hl7RootType
public class MonographsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV languageCode = new CVImpl();
    private AssignedEntity3Bean authorAssignedEntity;
    private ED<EncapsulatedData> componentDocumentBodyEventText = new EDImpl<EncapsulatedData>();


    /**
     * <p>B:Medication Document Id</p>
     * 
     * <p>Monograph Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Monograph Type</p>
     * 
     * <p>A:Medication Document Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMedicationDocumentCode getCode() {
        return (ActMedicationDocumentCode) this.code.getValue();
    }
    public void setCode(ActMedicationDocumentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>MonographContent</p>
     * 
     * <p>Monograph Content</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Monograph Effective/Expiry Date</p>
     * 
     * <p>C:Medication Document Effective/Expiry Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>WrittenIn</p>
     * 
     * <p>Written in</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntity3Bean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(AssignedEntity3Bean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>MedicationDocumentContentLanguage</p>
     * 
     * <p>F:Medication Document Content + Language</p>
     */
    @Hl7XmlMapping({"component/documentBodyEvent/text"})
    public EncapsulatedData getComponentDocumentBodyEventText() {
        return this.componentDocumentBodyEventText.getValue();
    }
    public void setComponentDocumentBodyEventText(EncapsulatedData componentDocumentBodyEventText) {
        this.componentDocumentBodyEventText.setValue(componentDocumentBodyEventText);
    }

}
