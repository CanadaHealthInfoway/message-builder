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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActDiagnosisCode;



/**
 * <p>DischargeDiagnosis</p>
 * 
 * <p>REPC_MT500001CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p>Describes the health conditions which were identified or 
 * determined as part of the encounter.</p>
 * 
 * <p>These are key elements in defining the encounter.</p>
 * 
 * <p>REPC_MT500003CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p>Describes the health conditions which were identified or 
 * determined as part of the encounter.</p>
 * 
 * <p>These are key elements in defining the encounter.</p>
 * 
 * <p>REPC_MT500002CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p>Describes the health conditions which were identified or 
 * determined as part of the encounter.</p>
 * 
 * <p>These are key elements in defining the encounter.</p>
 * 
 * <p>REPC_MT500004CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p>Describes the health conditions which were identified or 
 * determined as part of the encounter.</p>
 * 
 * <p>These are key elements in defining the encounter.</p>
 */
@Hl7PartTypeMapping({"REPC_MT500001CA.DiagnosisEvent","REPC_MT500002CA.DiagnosisEvent","REPC_MT500003CA.DiagnosisEvent","REPC_MT500004CA.DiagnosisEvent"})
public class DischargeDiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();


    /**
     * <p>DiagnosisType</p>
     * 
     * <p>A:Diagnosis Type</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>Identifies the type of diagnosis</p>
     * 
     * <p>Identifies this observation as a type of diagnosis and is 
     * therefore mandatory.</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Identifies this observation as a type of diagnosis and is 
     * therefore mandatory.</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     */
    @Hl7XmlMapping({"code"})
    public ActDiagnosisCode getCode() {
        return (ActDiagnosisCode) this.code.getValue();
    }

    /**
     * <p>DiagnosisType</p>
     * 
     * <p>A:Diagnosis Type</p>
     * 
     * <p>Code is fixed to DX if not using SNOMED</p>
     * 
     * <p>Identifies the type of diagnosis</p>
     * 
     * <p>Identifies this observation as a type of diagnosis and is 
     * therefore mandatory.</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Identifies this observation as a type of diagnosis and is 
     * therefore mandatory.</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     */
    public void setCode(ActDiagnosisCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>DiagnosisCode</p>
     * 
     * <p>Diagnosis Code</p>
     * 
     * <p>A coded form of the condition that was identified as part 
     * of the care delivery described by this Care Composition.</p>
     * 
     * <p>Allows tracking outcomes and provides key information 
     * about the encounter</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Allows tracking outcomes and provides key information 
     * about the encounter</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>DiagnosisCode</p>
     * 
     * <p>Diagnosis Code</p>
     * 
     * <p>A coded form of the condition that was identified as part 
     * of the care delivery described by this Care Composition.</p>
     * 
     * <p>Allows tracking outcomes and provides key information 
     * about the encounter</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     * 
     * <p>Allows tracking outcomes and provides key information 
     * about the encounter</p><p> <i>This element makes use of the 
     * CD datatype to allow for use of the SNOMED code system that 
     * in some circumstances requires the use of post-coordination. 
     * Post-coordination is only supported by the CD datatype.</i> 
     * </p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
