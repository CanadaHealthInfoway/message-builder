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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.IsolateObservationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.LabResultReportingProcessStepCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Isolate Observations</p>
 * 
 * <p>Allows for further observations to be documentation at 
 * the isolate level, e.g. growth, colony count, etc.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.IsolateObservationEvent"})
public class IsolateObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST value = new STImpl();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private CD subjectOf2ResultStatusProcessStepCode = new CDImpl();


    /**
     * <p>Business Name: Isolate Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of isolate observation and is bound to 
     * the LOINC code domain.</p>
     */
    @Hl7XmlMapping({"code"})
    public IsolateObservationCode getCode() {
        return (IsolateObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Isolate Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of isolate observation and is bound to 
     * the LOINC code domain.</p>
     */
    public void setCode(IsolateObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Isolate Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the Isolate Observation.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Isolate Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the Isolate Observation.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Isolate Observation Effective Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time of the Isolate Observation.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Isolate Observation Effective Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time of the Isolate Observation.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Isolate Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The value of the isolate observation.</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Isolate Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>The value of the isolate observation.</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.IsolateObservationEvent.subjectOf1</p>
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
