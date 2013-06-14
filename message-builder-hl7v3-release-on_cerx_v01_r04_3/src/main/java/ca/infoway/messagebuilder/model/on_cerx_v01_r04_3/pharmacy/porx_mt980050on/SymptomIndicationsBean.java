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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt980050on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Symptom Indications</p>
 * 
 * <p>Code must be fixed to SYMPT if not using SNOMED</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 * 
 * <p>Allows separation of conditions from symptoms from other 
 * forms of indication.</p>
 * 
 * <p>Describes symptom-related indications</p>
 */
@Hl7PartTypeMapping({"PORX_MT980050ON.ObservationSymptom"})
public class SymptomIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20130613L;
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: Symptom Type</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that this observation is expressing a symptom, 
     * and is therefore mandatory. It is set to CD because SNOMED 
     * codes may require post-coordination</p>
     * 
     * <p>For SNOMED, this will communicate the full symptom. For 
     * non-SNOMED this will be a fixed value of SYMPT</p>
     * 
     * <p>Identifies the category of symptom being 
     * communicated.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Symptom Type</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that this observation is expressing a symptom, 
     * and is therefore mandatory. It is set to CD because SNOMED 
     * codes may require post-coordination</p>
     * 
     * <p>For SNOMED, this will communicate the full symptom. For 
     * non-SNOMED this will be a fixed value of SYMPT</p>
     * 
     * <p>Identifies the category of symptom being 
     * communicated.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Free Form Symptom Indication</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides greater flexibility in specifying 
     * indication.</p>
     * 
     * <p>A free form description to augment the specified 
     * symptom.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Free Form Symptom Indication</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides greater flexibility in specifying 
     * indication.</p>
     * 
     * <p>A free form description to augment the specified 
     * symptom.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: A:Symptom Code</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. The 
     * attribute is optional because it is not used for SNOMED.</p>
     * 
     * <p>A coded representation of the symptom that is the reason 
     * for the current therapy.</p>
     */
    @Hl7XmlMapping({"value"})
    public SymptomValue getValue() {
        return (SymptomValue) this.value.getValue();
    }

    /**
     * <p>Business Name: A:Symptom Code</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationSymptom.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. The 
     * attribute is optional because it is not used for SNOMED.</p>
     * 
     * <p>A coded representation of the symptom that is the reason 
     * for the current therapy.</p>
     */
    public void setValue(SymptomValue value) {
        this.value.setValue(value);
    }

}
