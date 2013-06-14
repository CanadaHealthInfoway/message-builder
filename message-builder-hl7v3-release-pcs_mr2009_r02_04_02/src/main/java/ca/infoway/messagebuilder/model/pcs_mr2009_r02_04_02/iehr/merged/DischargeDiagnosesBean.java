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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.iehr.merged;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.domainvalue.ActDiagnosisCode;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DischargeDiagnoses</p>
 * 
 * <p>REPC_MT220002CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p>
 * 
 * <p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p>
 * 
 * <p>REPC_MT220001CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p>
 * 
 * <p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p>
 * 
 * <p>REPC_MT220003CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p>
 * 
 * <p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.ConditionEvent","REPC_MT220002CA.ConditionEvent","REPC_MT220003CA.ConditionEvent"})
public class DischargeDiagnosesBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDiagnosisCode getCode() {
        return (ActDiagnosisCode) this.code.getValue();
    }

    /**
     * <p>Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     * 
     * <p>Un-merged Business Name: DischargeDiagnosisType</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ConditionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>The diagnosis is core information around which the care 
     * provision revolves, therefore this is a mandatory 
     * attribute.</p><p> <i>This element makes use of the CD 
     * datatype to allow for use of the SNOMED code system that in 
     * some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifications of the type of diagnosis at the time of 
     * discharge.</p>
     */
    public void setCode(ActDiagnosisCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: DiagnosisCode</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: DiagnosisCode</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ConditionEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides context into the result of the care 
     * provision.</p><p> <i>The attribute is optional because for 
     * systems that support SNOMED, this concept will be 
     * communicated as part of the Discharge Diagnosis Type</i> 
     * </p>
     * 
     * <p>Identifies the actual discharge diagnosis.</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
