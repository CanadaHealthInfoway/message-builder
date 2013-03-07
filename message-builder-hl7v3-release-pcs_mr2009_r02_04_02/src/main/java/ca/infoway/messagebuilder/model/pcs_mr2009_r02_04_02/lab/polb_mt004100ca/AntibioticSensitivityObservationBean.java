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
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretationSusceptibility;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.SensitivityObservationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Antibiotic Sensitivity Observation</p>
 * 
 * <p>Act for the antibiotic sensitivity test result 
 * information. The code attribute is a LOINC code and 
 * &quot;carries&quot; the testing method as part of the code 
 * itself. Therefore, the methodCode attribute has been removed 
 * as a constraint on the lab result event model.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.SensitivityObservationEvent"})
public class AntibioticSensitivityObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST value = new STImpl();
    private CV interpretationCode = new CVImpl();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;


    /**
     * <p>Business Name: Sensitivity Test Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>pCLOCD code describing the drug which is being tested for 
     * sensitivities.</p>
     */
    @Hl7XmlMapping({"code"})
    public SensitivityObservationCode getCode() {
        return (SensitivityObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Test Code</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>pCLOCD code describing the drug which is being tested for 
     * sensitivities.</p>
     */
    public void setCode(SensitivityObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Sensitivity Text</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for any information regarding this information to 
     * be captured.</p>
     * 
     * <p>This observation is coded using LOINC. If any coded 
     * attribute is not able to represent the specificity or 
     * granularity of the observation attribute, additional details 
     * should be placed in this attribute.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Text</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for any information regarding this information to 
     * be captured.</p>
     * 
     * <p>This observation is coded using LOINC. If any coded 
     * attribute is not able to represent the specificity or 
     * granularity of the observation attribute, additional details 
     * should be placed in this attribute.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Sensitivity Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the sensitivity.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the sensitivity.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Sensitivity Test Date/time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date/time interval over which the sensitivity test 
     * was performed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Test Date/time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date/time interval over which the sensitivity test 
     * was performed.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Sensitivity Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Any numeric or quantitative result. Interpretation values 
     * are coded and communicated using the interpretationCode 
     * attribute.</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Any numeric or quantitative result. Interpretation values 
     * are coded and communicated using the interpretationCode 
     * attribute.</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }


    /**
     * <p>Business Name: Sensitivity Value Interpretation</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The result interpretation value of the sensitivity 
     * testing.</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretationSusceptibility getInterpretationCode() {
        return (ObservationInterpretationSusceptibility) this.interpretationCode.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Value Interpretation</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The result interpretation value of the sensitivity 
     * testing.</p>
     */
    public void setInterpretationCode(ObservationInterpretationSusceptibility interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.SensitivityObservationEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004100CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }

}
