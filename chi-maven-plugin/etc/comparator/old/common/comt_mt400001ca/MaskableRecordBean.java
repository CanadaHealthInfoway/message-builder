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
package ca.infoway.messagebuilder.model.common.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>Maskable Record 
 * 
 * <p>A particular record or type of record for which masking 
 * is supported. 
 * 
 * <p>The root construct for masking and unmasking specific 
 * record or type of record. 
 */
@Hl7PartTypeMapping({"COMT_MT400001CA.MaskableActType"})
@Hl7RootType
public class MaskableRecordBean extends MessagePartBean {

    private II recordIdentifier = new IIImpl();
    private CV<ActInformationCategoryCode> recordType = new CVImpl<ActInformationCategoryCode>();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> maskedIndicator = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private CV<MaskableMaterialEntityType> maskableMaterial = new CVImpl<MaskableMaterialEntityType>();
    private CV<ActCode> reasonDiagnosisCode = new CVImpl<ActCode>();
    private ST reasonDiagnosisText = new STImpl();
    private CV<DiagnosisValue> reasonDiagnosisValue = new CVImpl<DiagnosisValue>();

    @Hl7XmlMapping({"id"})
    public Identifier getRecordIdentifier() {
        return this.recordIdentifier.getValue();
    }
    public void setRecordIdentifier(Identifier recordIdentifier) {
        this.recordIdentifier.setValue(recordIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public ActInformationCategoryCode getRecordType() {
        return this.recordType.getValue();
    }
    public void setRecordType(ActInformationCategoryCode recordType) {
        this.recordType.setValue(recordType);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getMaskedIndicator() {
        return this.maskedIndicator.rawSet();
    }

    @Hl7XmlMapping({"directTarget/role/playingEntityKind/code"})
    public MaskableMaterialEntityType getMaskableMaterial() {
        return this.maskableMaterial.getValue();
    }
    public void setMaskableMaterial(MaskableMaterialEntityType maskableMaterial) {
        this.maskableMaterial.setValue(maskableMaterial);
    }

    @Hl7XmlMapping({"reason/diagnosis/code"})
    public ActCode getReasonDiagnosisCode() {
        return this.reasonDiagnosisCode.getValue();
    }
    public void setReasonDiagnosisCode(ActCode reasonDiagnosisCode) {
        this.reasonDiagnosisCode.setValue(reasonDiagnosisCode);
    }

    @Hl7XmlMapping({"reason/diagnosis/text"})
    public java.lang.String getReasonDiagnosisText() {
        return this.reasonDiagnosisText.getValue();
    }
    public void setReasonDiagnosisText(java.lang.String reasonDiagnosisText) {
        this.reasonDiagnosisText.setValue(reasonDiagnosisText);
    }

    @Hl7XmlMapping({"reason/diagnosis/value"})
    public DiagnosisValue getReasonDiagnosisValue() {
        return this.reasonDiagnosisValue.getValue();
    }
    public void setReasonDiagnosisValue(DiagnosisValue reasonDiagnosisValue) {
        this.reasonDiagnosisValue.setValue(reasonDiagnosisValue);
    }

}