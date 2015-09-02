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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.SupportingClinicalInformationCode;



/**
 * <p>Business Name: SupportingClinicalInformation</p>
 * 
 * <p>POLB_MT004200NB.SupportingClinicalObservationEvent1: 
 * Supporting Clinical Information</p>
 * 
 * <p>Describes any supporting clinical observations at the 
 * report-level including the drugs the patient has taken if 
 * relevant.</p>
 * 
 * <p>POLB_MT004100NB.SupportingClinicalObservationEvent1: 
 * Supporting Clinical Information</p>
 * 
 * <p>Describes any observations at the report-level including 
 * the drugs the patient has taken if relevant.</p>
 * 
 * <p>POLB_MT001010NB.SupportingClinicalObservationEvent: 
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
 * <p>POLB_MT001001NB.SupportingClinicalObservationEvent: 
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
 * <p>POLB_MT001000NB.SupportingClinicalObservationEvent: 
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
 * <p>POLB_MT004000NB.SupportingClinicalObservationEvent: 
 * Supporting Clinical Information</p>
 * 
 * <p>Includes data relevant to the result or result 
 * processing.</p>
 * 
 * <p>The supporting observation event contains information 
 * which is pertinent to the result.</p>
 * 
 * <p>POLB_MT001999NB.SupportingClinicalObservationEvent: 
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
 */
@Hl7PartTypeMapping({"POLB_MT001000NB.SupportingClinicalObservationEvent","POLB_MT001001NB.SupportingClinicalObservationEvent","POLB_MT001010NB.SupportingClinicalObservationEvent","POLB_MT001999NB.SupportingClinicalObservationEvent","POLB_MT002000NB.SupportingClinicalObservationEvent","POLB_MT004000NB.SupportingClinicalObservationEvent","POLB_MT004100NB.SupportingClinicalObservationEvent1","POLB_MT004100NB.SupportingClinicalObservationEvent2","POLB_MT004200NB.SupportingClinicalObservationEvent1"})
public class SupportingClinicalInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CD code = new CDImpl();
    private ANY<Object> value = new ANYImpl<Object>();


    /**
     * <p>Business Name: SupportingClinicalObservationCode</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200NB.SupportingClinicalObservationEvent1.code</p>
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
     * POLB_MT004100NB.SupportingClinicalObservationEvent2.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT001010NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT004100NB.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * POLB_MT002000NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT004000NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of supporting information being communicated 
     * with this result.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
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
     * POLB_MT004200NB.SupportingClinicalObservationEvent1.code</p>
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
     * POLB_MT004100NB.SupportingClinicalObservationEvent2.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT001010NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT004100NB.SupportingClinicalObservationEvent1.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * POLB_MT002000NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000NB.SupportingClinicalObservationEvent.code</p>
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
     * POLB_MT004000NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The type of supporting information being communicated 
     * with this result.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999NB.SupportingClinicalObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to include that clinical information pertinent to 
     * the performance of the requested test(s).</p>
     * 
     * <p>Describes the type of supporting clinical 
     * information.</p>
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
     * POLB_MT004200NB.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the supporting clinical observation to be 
     * communicated at the report level.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100NB.SupportingClinicalObservationEvent2.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100NB.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drug taken (values).</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting information value (itself).</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
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
     * POLB_MT004200NB.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the supporting clinical observation to be 
     * communicated at the report level.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100NB.SupportingClinicalObservationEvent2.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100NB.SupportingClinicalObservationEvent1.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The value is mandatory as this is the information to 
     * communication (categorized or described by the code 
     * attribute).</p>
     * 
     * <p>The value of the observation to be communicated at the 
     * report level (as opposed to at the culture, isolate, or 
     * sensitivity level). This includes drug taken (values).</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting information value (itself).</p>
     * 
     * <p>Un-merged Business Name: 
     * SupportingClinicalObservationValue</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999NB.SupportingClinicalObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The supporting clinical information. Could be coded 
     * information or text-based.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }

}
