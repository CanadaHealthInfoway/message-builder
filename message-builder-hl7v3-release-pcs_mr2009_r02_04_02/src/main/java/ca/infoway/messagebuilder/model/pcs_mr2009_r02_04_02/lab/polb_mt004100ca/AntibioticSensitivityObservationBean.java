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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Antibiotic Sensitivity Observation</p>
 * 
 * <p><p>Act for the antibiotic sensitivity test result 
 * information. The code attribute is a LOINC code and 
 * &quot;carries&quot; the testing method as part of the code 
 * itself. Therefore, the methodCode attribute has been removed 
 * as a constraint on the lab result event model.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.SensitivityObservationEvent"})
public class AntibioticSensitivityObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST value = new STImpl();
    private CV interpretationCode = new CVImpl();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;


    /**
     * <p>Sensitivity Test Code</p>
     * 
     * <p><p>pCLOCD code describing the drug which is being tested 
     * for sensitivities.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Sensitivity Text</p>
     * 
     * <p><p>This observation is coded using LOINC. If any coded 
     * attribute is not able to represent the specificity or 
     * granularity of the observation attribute, additional details 
     * should be placed in this attribute.</p></p>
     * 
     * <p><p>Allows for any information regarding this information 
     * to be captured.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Sensitivity Status</p>
     * 
     * <p><p>Status associated with the sensitivity.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Sensitivity Test Date/time Range</p>
     * 
     * <p><p>The date/time interval over which the sensitivity test 
     * was performed.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Sensitivity Value</p>
     * 
     * <p><p>Any numeric or quantitative result. Interpretation 
     * values are coded and communicated using the 
     * interpretationCode attribute.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }
    public void setValue(String value) {
        this.value.setValue(value);
    }


    /**
     * <p>Sensitivity Value Interpretation</p>
     * 
     * <p><p>The result interpretation value of the sensitivity 
     * testing.</p></p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretationSusceptibility getInterpretationCode() {
        return (ObservationInterpretationSusceptibility) this.interpretationCode.getValue();
    }
    public void setInterpretationCode(ObservationInterpretationSusceptibility interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }

}
