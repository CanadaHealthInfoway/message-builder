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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.si.comt_mt300002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COMT_MT300002CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV patientNoteCategoryCode = new CVImpl();


    /**
     * <p>Patient Note Category Code</p>
     */
    @Hl7XmlMapping({"patientNoteCategoryCode/value"})
    public ActPatientAnnotationCode getPatientNoteCategoryCode() {
        return (ActPatientAnnotationCode) this.patientNoteCategoryCode.getValue();
    }
    public void setPatientNoteCategoryCode(ActPatientAnnotationCode patientNoteCategoryCode) {
        this.patientNoteCategoryCode.setValue(patientNoteCategoryCode);
    }

}
