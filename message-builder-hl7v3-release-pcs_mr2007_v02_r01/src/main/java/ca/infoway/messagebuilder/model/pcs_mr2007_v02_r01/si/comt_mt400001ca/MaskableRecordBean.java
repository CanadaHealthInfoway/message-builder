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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.si.comt_mt400001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.DiagnosisBean;
import java.util.Set;



/**
 * <p>Business Name: Maskable Record</p>
 * 
 * <p>The root construct for masking and unmasking specific 
 * record or type of record.</p>
 * 
 * <p>A particular record or type of record for which masking 
 * is supported.</p>
 */
@Hl7PartTypeMapping({"COMT_MT400001CA.MaskableActType"})
@Hl7RootType
public class MaskableRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private RoleBean directTargetRole;
    private DiagnosisBean reasonDiagnosis;


    /**
     * <p>Business Name: C:Record Identifier</p>
     * 
     * <p>Relationship: COMT_MT400001CA.MaskableActType.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows unique reference to a particular record to be 
     * masked or unmasked.</p>
     * 
     * <p>In many systems, masking a 'child' may result in 
     * automatic masking of the parent. For example, masking a 
     * dispense record may cause the prescription to become masked 
     * as well.</p>
     * 
     * <p>The identifier of the prescription, dispense, allergy, 
     * lab test result or other record for which the masking status 
     * is being changed.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: C:Record Identifier</p>
     * 
     * <p>Relationship: COMT_MT400001CA.MaskableActType.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows unique reference to a particular record to be 
     * masked or unmasked.</p>
     * 
     * <p>In many systems, masking a 'child' may result in 
     * automatic masking of the parent. For example, masking a 
     * dispense record may cause the prescription to become masked 
     * as well.</p>
     * 
     * <p>The identifier of the prescription, dispense, allergy, 
     * lab test result or other record for which the masking status 
     * is being changed.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B:Record Type</p>
     * 
     * <p>Relationship: COMT_MT400001CA.MaskableActType.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows automatic masking of a particular type of record 
     * rather than requiring each occurrence to be masked 
     * individually.</p>
     * 
     * <p>Indicates a detailed type of record to be masked. E.g. 
     * All lab tests of a given type.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInformationCategoryCode getCode() {
        return (ActInformationCategoryCode) this.code.getValue();
    }

    /**
     * <p>Business Name: B:Record Type</p>
     * 
     * <p>Relationship: COMT_MT400001CA.MaskableActType.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows automatic masking of a particular type of record 
     * rather than requiring each occurrence to be masked 
     * individually.</p>
     * 
     * <p>Indicates a detailed type of record to be masked. E.g. 
     * All lab tests of a given type.</p>
     */
    public void setCode(ActInformationCategoryCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: A:Masked Indicator</p>
     * 
     * <p>Relationship: 
     * COMT_MT400001CA.MaskableActType.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Forces the sender of the message to assert what the new 
     * value should be, rather than performing a 'toggle' and 
     * potentially ending up in the wrong state. Therefore, the 
     * attribute is mandatory.</p>
     * 
     * <p>Indicates the new value for the masking status of the 
     * item.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Relationship: COMT_MT400001CA.DirectTarget.role</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/role"})
    public RoleBean getDirectTargetRole() {
        return this.directTargetRole;
    }

    /**
     * <p>Relationship: COMT_MT400001CA.DirectTarget.role</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDirectTargetRole(RoleBean directTargetRole) {
        this.directTargetRole = directTargetRole;
    }


    /**
     * <p>Relationship: COMT_MT400001CA.Reason.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reason/diagnosis"})
    public DiagnosisBean getReasonDiagnosis() {
        return this.reasonDiagnosis;
    }

    /**
     * <p>Relationship: COMT_MT400001CA.Reason.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setReasonDiagnosis(DiagnosisBean reasonDiagnosis) {
        this.reasonDiagnosis = reasonDiagnosis;
    }

}
