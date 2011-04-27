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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;

public class ControlActEventBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 6665317827119227996L;

    @Hl7BusinessName("eventIdentifier")
    private final II eventId = new IIImpl();

    @Hl7BusinessName("eventType")
    private final CD code = new CDImpl();

    private final CD statusCode = new CDImpl();

    private final TS effectiveTime = new TSImpl();

    private AuthorBean author;

    private final List<DetectedIssueBean> issues = new ArrayList<DetectedIssueBean>();

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    private final CD reasonCode = new CDImpl();

    private AssignedPersonBean dataEnterer;

    @Hl7XmlMapping("id")
    public Identifier getEventId() {
        return this.eventId.getValue();
    }

    public void setEventId(Identifier eventId) {
        this.eventId.setValue(eventId);
    }

    @Hl7XmlMapping("code")
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    public Interval<Date> getEffectiveTimeAsInterval() {
        return this.effectiveTime.isNull() ? null : IntervalFactory.<Date>createLow(this.effectiveTime.getValue());
    }

    public void setEffectiveTimeAsInterval(Interval<Date> date) {
        this.effectiveTime.setValue(date == null ? null : date.getLow());
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date date) {
        this.effectiveTime.setValue(date);
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({ "subjectOf1/detectedIssueEvent", "subjectOf/detectedIssueEvent" })
    public List<DetectedIssueBean> getIssues() {
        return this.issues;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return this.location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({ "responsibleParty/assignedPerson", "responsibleParty/assignedEntity" })
    public AssignedPersonBean getResponsibleParty() {
        return this.responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("reasonCode")
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("dataEnterer/assignedPerson")
    public AssignedPersonBean getDataEnterer() {
        return dataEnterer;
    }

    public void setDataEnterer(AssignedPersonBean dataEnterer) {
        this.dataEnterer = dataEnterer;
    }
}
