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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.SupportingClinicalInformationCode;



/**
 * <p>Business Name: SupportingClinicalInformation</p>
 * 
 * <p>POLB_MT001001CA.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Supporting Information is frequently relevant when 
 * performing healthcare services on/for a patient.</p>
 * 
 * <p>Enables the sending of supporting clinical information 
 * either as categorized (e.g. Travel History), text (e.g. 
 * visited Asia in the last six months) OR provide specific 
 * questions (e.g. Date of last menstrual period?) with textual 
 * answers.</p>
 * 
 * <p>POLB_MT001000CA.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Supporting Information is frequently relevant when 
 * performing healthcare services on/for a patient.</p>
 * 
 * <p>Enables the sending of supporting clinical information 
 * either as categorized (e.g. Travel History), text (e.g. 
 * visited Asia in the last six months) OR provide specific 
 * questions (e.g. Date of last menstrual period?) with textual 
 * answers.</p>
 * 
 * <p>POLB_MT001010CA.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Supporting Information is frequently relevant when 
 * performing healthcare services on/for a patient.</p>
 * 
 * <p>Enables the sending of supporting clinical information 
 * either as categorized (e.g. Travel History), text (e.g. 
 * visited Asia in the last six months) OR provide specific 
 * questions (e.g. Date of last menstrual period?) with textual 
 * answers.</p>
 * 
 * <p>POLB_MT001999CA.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Supporting Information is frequently relevant when 
 * performing healthcare services on/for a patient.</p>
 * 
 * <p>Enables the sending of supporting clinical information 
 * either as categorized (e.g. Travel History), text (e.g. 
 * visited Asia in the last six months) OR provide specific 
 * questions (e.g. Date of last menstrual period?) with textual 
 * answers.</p>
 * 
 * <p>POLB_MT004100CA.SupportingClinicalObservationEvent1: 
 * Supporting Clinical Information</p>
 * 
 * <p>Describes any observations at the report-level including 
 * the drugs the patient has taken if relevant.</p>
 * 
 * <p>POLB_MT004200CA.SupportingClinicalObservationEvent1: 
 * Supporting Clinical Information</p>
 * 
 * <p>Describes any supporting clinical observations at the 
 * report-level including the drugs the patient has taken if 
 * relevant.</p>
 * 
 * <p>POLB_MT004000CA.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Includes data relevant to the result or result 
 * processing.</p>
 * 
 * <p>The supporting observation event contains information 
 * which is pertinent to the result.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.SupportingClinicalObservationEvent","POLB_MT001001CA.SupportingClinicalObservationEvent","POLB_MT001010CA.SupportingClinicalObservationEvent","POLB_MT001999CA.SupportingClinicalObservationEvent","POLB_MT002000CA.SupportingClinicalObservationEvent","POLB_MT004000CA.SupportingClinicalObservationEvent","POLB_MT004100CA.SupportingClinicalObservationEvent1","POLB_MT004100CA.SupportingClinicalObservationEvent2","POLB_MT004200CA.SupportingClinicalObservationEvent1"})
public class SupportingClinicalInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CD code = new CDImpl();
    private ANY<Object> value = new ANYImpl<Object>();


    /**
     * <p>Business Name: SupportingClinicalObservationCode</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent2.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>When a coded value applies, values must be selected from 
     * the SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Used to describe the type of information in this 
     * observation event.</p>
     * 
     * <p>Code used describe this act to communicate information at 
     * the report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drugs taken.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to describe the type of information in this 
     * observation event.</p>
     * 
     * <p>Code used to describe this observation as supporting 
     * clinical information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of supporting information being communicated 
     * with this result.</p>
     */
    @Hl7XmlMapping({"code"})
    public SupportingClinicalInformationCode getCode() {
        return (SupportingClinicalInformationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: SupportingClinicalObservationCode</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent2.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>When a coded value applies, values must be selected from 
     * the SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Used to describe the type of information in this 
     * observation event.</p>
     * 
     * <p>Code used describe this act to communicate information at 
     * the report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drugs taken.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to describe the type of information in this 
     * observation event.</p>
     * 
     * <p>Code used to describe this observation as supporting 
     * clinical information.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of supporting information being communicated 
     * with this result.</p>
     */
    public void setCode(SupportingClinicalInformationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: SupportingClinicalObservationValue</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>If a coded value applies, the value must be selected from 
     * the SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. When a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, values 
     * must be selected from the SupportingClinicalInformationValue 
     * Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent2.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * culture level. When a coded value applies, values must be 
     * selected from the SupportingClinicalInformationValue Concept 
     * Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drug taken (values). When 
     * a coded value applies, values must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the supporting clinical observation to be 
     * communicated at the report level. If a coded value applies, 
     * values must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting information value (itself). If a coded 
     * value applies, the value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: SupportingClinicalObservationValue</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>If a coded value applies, the value must be selected from 
     * the SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. When a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, values 
     * must be selected from the SupportingClinicalInformationValue 
     * Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based. If a coded value applies, the 
     * value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent2.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * culture level. When a coded value applies, values must be 
     * selected from the SupportingClinicalInformationValue Concept 
     * Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drug taken (values). When 
     * a coded value applies, values must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the supporting clinical observation to be 
     * communicated at the report level. If a coded value applies, 
     * values must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting information value (itself). If a coded 
     * value applies, the value must be selected from the 
     * SupportingClinicalInformationValue Concept Domain.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }

}
