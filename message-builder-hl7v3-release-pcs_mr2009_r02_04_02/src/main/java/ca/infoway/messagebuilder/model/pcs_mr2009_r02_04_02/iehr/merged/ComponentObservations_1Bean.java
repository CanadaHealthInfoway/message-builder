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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ComponentObservations</p>
 * 
 * <p>REPC_MT410001CA.SubObservationEvent: Component 
 * Observations</p>
 * 
 * <p><p>Captures components of a more complex observation, 
 * such as apgar or blood pressure.</p></p>
 * 
 * <p><p>Not all observations can be expressed as a single code 
 * or code and value.</p></p>
 * 
 * <p>REPC_MT410003CA.SubObservationEvent: Component 
 * Observations</p>
 * 
 * <p><p>Captures components of a more complex observation, 
 * such as apgar or blood pressure.</p></p>
 * 
 * <p><p>Not all observations can be expressed as a single code 
 * or code and value.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT410001CA.SubObservationEvent","REPC_MT410003CA.SubObservationEvent"})
public class ComponentObservations_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD componentObservationType = new CDImpl();
    private PQ componentObservationValue = new PQImpl();


    /**
     * <p>ComponentObservationType</p>
     * 
     * <p>Q: Component Observation Type</p>
     * 
     * <p><p>Identifies the type of sub-observation being 
     * made.</p><p>E.g. systolic blood pressure.</p></p>
     * 
     * <p><p>Identifies the type of sub-observation being 
     * made.</p><p>E.g. systolic blood pressure.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>EPHS: need fixed value for 
     * &quot;COMPLICATIONS&quot;</p><p>EPHS:need fixed value for 
     * IMMUNIZATION VACCINE; VALID IMMUNIZATION DOSES 
     * RECEIVED;IMMUNIZATION DOSES NEEDED;ADDITIONAL 
     * COMPLICATION;CAUSE OF DEATH;OTHER COMPLICATION; RISK FACTOR 
     * CATEGORY;RISK FACTOR FREQUENCY; RISK FACTOR 
     * COMMENT;</p><p>EPHS: need fixed value for OUTBREAK 
     * COMPLICATION AGGREGATE COUNT; OUTBREAK SIGN AND SYMPTOM 
     * UNIDENTIFIED AGGREGATE COUNT</p></p>
     * 
     * <p><p>EPHS: need fixed value for 
     * &quot;COMPLICATIONS&quot;</p><p>EPHS:need fixed value for 
     * IMMUNIZATION VACCINE; VALID IMMUNIZATION DOSES 
     * RECEIVED;IMMUNIZATION DOSES NEEDED;ADDITIONAL 
     * COMPLICATION;CAUSE OF DEATH;OTHER COMPLICATION; RISK FACTOR 
     * CATEGORY;RISK FACTOR FREQUENCY; RISK FACTOR 
     * COMMENT;</p><p>EPHS: need fixed value for OUTBREAK 
     * COMPLICATION AGGREGATE COUNT; OUTBREAK SIGN AND SYMPTOM 
     * UNIDENTIFIED AGGREGATE COUNT</p></p>
     * 
     * <p><p>EPHS: need fixed value for 
     * &quot;COMPLICATIONS&quot;</p><p>EPHS:need fixed value for 
     * IMMUNIZATION VACCINE; VALID IMMUNIZATION DOSES 
     * RECEIVED;IMMUNIZATION DOSES NEEDED;ADDITIONAL 
     * COMPLICATION;CAUSE OF DEATH;OTHER COMPLICATION; RISK FACTOR 
     * CATEGORY;RISK FACTOR FREQUENCY; RISK FACTOR 
     * COMMENT;</p><p>EPHS: need fixed value for OUTBREAK 
     * COMPLICATION AGGREGATE COUNT; OUTBREAK SIGN AND SYMPTOM 
     * UNIDENTIFIED AGGREGATE COUNT</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getComponentObservationType() {
        return (Code) this.componentObservationType.getValue();
    }
    public void setComponentObservationType(Code componentObservationType) {
        this.componentObservationType.setValue(componentObservationType);
    }


    /**
     * <p>ComponentObservationValue</p>
     * 
     * <p>Component Observation Value</p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * sub-observation was made.</p><p>E.g. 120 mmHg for systolic 
     * blood pressure.</p></p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * sub-observation was made.</p><p>E.g. 120 mmHg for systolic 
     * blood pressure.</p></p>
     * 
     * <p><p>PHS 07-feb-02. Some appropriate vocab concept is 
     * needed for observation.code, to pair with EPHS mappings.</p></p>
     * 
     * <p><p>Conveys the clinical information resulting from the 
     * sub-observation in a standardized 
     * representation.</p><p>There's no point sending a 
     * sub-observation if no value is known. Therefore, the 
     * attribute is mandatory.</p></p>
     * 
     * <p><p>Conveys the clinical information resulting from the 
     * sub-observation in a standardized 
     * representation.</p><p>There's no point sending a 
     * sub-observation if no value is known. Therefore, the 
     * attribute is mandatory.</p></p>
     * 
     * <p><p>EPHS: datatype needs to be constrained at runtime to 
     * CV, PQ or ST depending upon type of observation being 
     * reported. EPHS: vocab domains needed for CAUSE OF 
     * DEATH;VACCINE</p></p>
     * 
     * <p>R: Component Observation Value</p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * sub-observation was made.</p><p>E.g. 120 mmHg for systolic 
     * blood pressure.</p></p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * sub-observation was made.</p><p>E.g. 120 mmHg for systolic 
     * blood pressure.</p></p>
     * 
     * <p><p>PHS 07-feb-02. Some appropriate vocab concept is 
     * needed for observation.code, to pair with EPHS mappings.</p></p>
     * 
     * <p><p>Conveys the clinical information resulting from the 
     * sub-observation in a standardized 
     * representation.</p><p>There's no point sending a 
     * sub-observation if no value is known. Therefore, the 
     * attribute is mandatory.</p></p>
     * 
     * <p><p>Conveys the clinical information resulting from the 
     * sub-observation in a standardized 
     * representation.</p><p>There's no point sending a 
     * sub-observation if no value is known. Therefore, the 
     * attribute is mandatory.</p></p>
     * 
     * <p><p>EPHS: datatype needs to be constrained at runtime to 
     * CV, PQ or ST depending upon type of observation being 
     * reported. EPHS: vocab domains needed for CAUSE OF 
     * DEATH;VACCINE</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getComponentObservationValue() {
        return this.componentObservationValue.getValue();
    }
    public void setComponentObservationValue(PhysicalQuantity componentObservationValue) {
        this.componentObservationValue.setValue(componentObservationValue);
    }

}
