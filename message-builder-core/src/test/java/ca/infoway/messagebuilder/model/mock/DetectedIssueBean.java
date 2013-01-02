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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060040CA.DetectedIssueEvent", "PORX_MT060060CA.DetectedIssueEvent", "PORX_MT980010CA.DetectedIssueEvent", "PORX_MT980030CA.DetectedIssueEvent", "PORX_MT030040CA.DetectedIssueEvent", "PORX_MT060190CA.DetectedIssueEvent" })
public class DetectedIssueBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -3496935518970888871L;

    protected CD code = new CDImpl();

    protected ST text = new STImpl();

    protected CD statusCode = new CDImpl();

    protected CD priorityCode = new CDImpl();

    protected SeverityObservationBean severityObservation = new SeverityObservationBean();

    protected DetectedIssueDefinition issueDescription;

    protected List<DetectedIssueManagementBean> issueManagements = new ArrayList<DetectedIssueManagementBean>();

    public DetectedIssueBean() {
    }

    public DetectedIssueBean(ActIssuePriority priorityCode, ActDetectedIssueCode code, ActStatus statusCode, String text) {
        setCode(code);
        setPriorityCode(priorityCode);
        setStatusCode(statusCode);
        setText(text);
    }

    @Hl7XmlMapping("code")
    public ActDetectedIssueCode getCode() {
        return (ActDetectedIssueCode) this.code.getValue();
    }

    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("priorityCode")
    public ActIssuePriority getPriorityCode() {
        return (ActIssuePriority) this.priorityCode.getValue();
    }

    public void setPriorityCode(ActIssuePriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }

    @Hl7XmlMapping({ "subjectOf/severityObservation", "subjectOf2/severityObservation" })
    public SeverityObservationBean getSeverityObservation() {
        return this.severityObservation;
    }

    public void setSeverityObservation(SeverityObservationBean severityObservation) {
        this.severityObservation = severityObservation;
    }

    @Hl7XmlMapping("instantiation/detectedIssueDefinition")
    public DetectedIssueDefinition getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(DetectedIssueDefinition issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Hl7XmlMapping("mitigatedBy/detectedIssueManagement")
    public List<DetectedIssueManagementBean> getIssueManagements() {
        return this.issueManagements;
    }

    public void setIssueManagements(List<DetectedIssueManagementBean> issueManagements) {
        this.issueManagements = issueManagements;
    }
}
