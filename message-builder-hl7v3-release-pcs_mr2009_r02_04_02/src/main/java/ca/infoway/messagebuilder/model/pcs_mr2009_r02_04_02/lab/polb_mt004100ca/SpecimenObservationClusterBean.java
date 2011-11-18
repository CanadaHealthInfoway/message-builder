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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.WasPerformedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Specimen Observation Cluster</p>
 * 
 * <p><p>This act groups all the communicated objects for one 
 * or more isolate(s) including any antibiotic sensitivity 
 * tests all performed on those isolate(s). Typically the 
 * isolate determines the sensitivities to run.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.SpecimenObservationCluster"})
public class SpecimenObservationClusterBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<WasPerformedByBean> performer = new ArrayList<WasPerformedByBean>();
    private List<IsolateObservationsBean> component1IsolateObservationEvent = new ArrayList<IsolateObservationsBean>();
    private HasComponentBean component2;
    private List<SensitivityBatteryBean> component3SensitivityBattery = new ArrayList<SensitivityBatteryBean>();
    private ResultStatusProcessStepBean subjectOfResultStatusProcessStep;


    /**
     * <p>Cluster Comment</p>
     * 
     * <p><p>Comments associated with the Isolate Cluster.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Cluster Status</p>
     * 
     * <p><p>Status associated with the isolate cluster.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Cluster Effective Time</p>
     * 
     * <p><p>Effective time associated with the Isolate 
     * Cluster.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"performer"})
    public List<WasPerformedByBean> getPerformer() {
        return this.performer;
    }


    @Hl7XmlMapping({"component1/isolateObservationEvent"})
    public List<IsolateObservationsBean> getComponent1IsolateObservationEvent() {
        return this.component1IsolateObservationEvent;
    }


    @Hl7XmlMapping({"component2"})
    public HasComponentBean getComponent2() {
        return this.component2;
    }
    public void setComponent2(HasComponentBean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"component3/sensitivityBattery"})
    public List<SensitivityBatteryBean> getComponent3SensitivityBattery() {
        return this.component3SensitivityBattery;
    }


    @Hl7XmlMapping({"subjectOf/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOfResultStatusProcessStep() {
        return this.subjectOfResultStatusProcessStep;
    }
    public void setSubjectOfResultStatusProcessStep(ResultStatusProcessStepBean subjectOfResultStatusProcessStep) {
        this.subjectOfResultStatusProcessStep = subjectOfResultStatusProcessStep;
    }

}
