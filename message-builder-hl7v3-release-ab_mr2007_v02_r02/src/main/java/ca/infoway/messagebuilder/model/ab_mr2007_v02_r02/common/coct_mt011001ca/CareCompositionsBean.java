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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Care Compositions</p>
 * 
 * <p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p>
 * 
 * <p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p>
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.PatientCareProvisionEvent"})
@Hl7RootType
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Business Name: B: Care Composition Identifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier of an encounter, condition or 
     * care-based collection.</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>Allows care compositions to be uniquely identified and 
     * referenced, and is therefore mandatory</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B: Care Composition Identifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier of an encounter, condition or 
     * care-based collection.</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>Allows care compositions to be uniquely identified and 
     * referenced, and is therefore mandatory</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A: Care Composition Type</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the kind of composition represented. Examples 
     * include encounters (&quot;Emergency Encounter&quot;, 
     * &quot;Long Term Care Encounter&quot;, etc), health condition 
     * (episode)-based collections (e.g. &quot;Diabetes&quot;, 
     * &quot;Hypertension&quot;, etc) and general care-based 
     * collections such as &quot;gynecological care&quot;.</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>EPHS: vocab concepts needed for LAB ID, Special 
     * Considerations ID etc.</p>
     * 
     * <p>Allows care compositions to be captured and categorized 
     * at different levels of abstraction, and is therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCode() {
        return (ActCareEventType) this.code.getValue();
    }

    /**
     * <p>Business Name: A: Care Composition Type</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.PatientCareProvisionEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the kind of composition represented. Examples 
     * include encounters (&quot;Emergency Encounter&quot;, 
     * &quot;Long Term Care Encounter&quot;, etc), health condition 
     * (episode)-based collections (e.g. &quot;Diabetes&quot;, 
     * &quot;Hypertension&quot;, etc) and general care-based 
     * collections such as &quot;gynecological care&quot;.</p>
     * 
     * <p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p>
     * 
     * <p>EPHS: vocab concepts needed for LAB ID, Special 
     * Considerations ID etc.</p>
     * 
     * <p>Allows care compositions to be captured and categorized 
     * at different levels of abstraction, and is therefore 
     * mandatory.</p>
     */
    public void setCode(ActCareEventType code) {
        this.code.setValue(code);
    }

}
