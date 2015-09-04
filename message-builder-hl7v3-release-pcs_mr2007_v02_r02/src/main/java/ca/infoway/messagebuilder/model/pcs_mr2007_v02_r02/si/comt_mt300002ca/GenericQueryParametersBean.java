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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.comt_mt300002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300002CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private CV patientNoteCategoryCodeValue = new CVImpl();


    /**
     * <p>Business Name: Patient Note Category Code</p>
     * 
     * <p>Relationship: 
     * COMT_MT300002CA.PatientNoteCategoryCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all patient notes pertaining 
     * to a specific note category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those patient annotation pertaining to the 
     * specified annotation category.</p><p>Valid patient note 
     * categories include: General, Medication, Lab, DI, etc.</p>
     */
    @Hl7XmlMapping({"patientNoteCategoryCode/value"})
    public ActPatientAnnotationCode getPatientNoteCategoryCodeValue() {
        return (ActPatientAnnotationCode) this.patientNoteCategoryCodeValue.getValue();
    }

    /**
     * <p>Business Name: Patient Note Category Code</p>
     * 
     * <p>Relationship: 
     * COMT_MT300002CA.PatientNoteCategoryCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all patient notes pertaining 
     * to a specific note category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those patient annotation pertaining to the 
     * specified annotation category.</p><p>Valid patient note 
     * categories include: General, Medication, Lab, DI, etc.</p>
     */
    public void setPatientNoteCategoryCodeValue(ActPatientAnnotationCode patientNoteCategoryCodeValue) {
        this.patientNoteCategoryCodeValue.setValue(patientNoteCategoryCodeValue);
    }

}
