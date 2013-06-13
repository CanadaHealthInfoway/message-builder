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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.CultureObservationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.LabResultReportingProcessStepCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Culture Observations</p>
 * 
 * <p>Act for describing any observations about the culture 
 * e.g. Protein measurements, gram stains, culture-level 
 * supporting clinical information observations use this act 
 * and are associated using the pertinentInformation act 
 * relationship. Those test (result) components which are not 
 * supporting but are observation which are &quot;part of&quot; 
 * the resulted values should be associated using this act and 
 * the component act relationship.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.CultureObservationEvent"})
public class CultureObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ANY<Object> value = new ANYImpl<Object>();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private CD subjectOf2ResultStatusProcessStepCode = new CDImpl();


    /**
     * <p>Business Name: Culture Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Act for describing the type of observations about the 
     * culture e.g. gram stain, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public CultureObservationCode getCode() {
        return (CultureObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Culture Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Act for describing the type of observations about the 
     * culture e.g. gram stain, etc.</p>
     */
    public void setCode(CultureObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Culture Observation Comment</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Comments associated with the Culture Observation.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Culture Observation Comment</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Comments associated with the Culture Observation.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Culture Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the Culture Observation.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Culture Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the Culture Observation.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Culture Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time interval when this culture observation took 
     * place.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Culture Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time interval when this culture observation took 
     * place.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Culture Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The result value of this culture observation e.g. the 
     * number value associated with a protein measurement, etc. 
     * When a coded value applies, values must be selected from the 
     * CultureObservationValue Concept Domain.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Culture Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The result value of this culture observation e.g. the 
     * number value associated with a protein measurement, etc. 
     * When a coded value applies, values must be selected from the 
     * CultureObservationValue Concept Domain.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.CultureObservationEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep/code"})
    public LabResultReportingProcessStepCode getSubjectOf2ResultStatusProcessStepCode() {
        return (LabResultReportingProcessStepCode) this.subjectOf2ResultStatusProcessStepCode.getValue();
    }

    /**
     * <p>Business Name: Result Status Process Step Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    public void setSubjectOf2ResultStatusProcessStepCode(LabResultReportingProcessStepCode subjectOf2ResultStatusProcessStepCode) {
        this.subjectOf2ResultStatusProcessStepCode.setValue(subjectOf2ResultStatusProcessStepCode);
    }

}
