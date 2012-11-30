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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.prpm_mt303010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPM_MT303010CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private INT sequenceNumber = new INTImpl();
    private CV<ActCode> informRequestCode = new CVImpl<ActCode>();
    private ChoiceBean informRequestIndirectTargetChoice;
    private CV<ParticipationMode> informRequestSubjectModeCode = new CVImpl<ParticipationMode>();
    private II serviceDeliveryLocationIdentifier = new IIImpl();
    private CV<ServiceDeliveryLocationRoleType> serviceDeliveryLocationType = new CVImpl<ServiceDeliveryLocationRoleType>();
    private AD serviceDeliveryLocationAddress = new ADImpl();
    private TEL serviceDeliveryLocationTelecom = new TELImpl();
    private IVL<TS, Interval<Date>> serviceDeliveryLocationEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private ST serviceLocationName = new STImpl();

    @Hl7XmlMapping({"sequenceNumber"})
    public java.lang.Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(java.lang.Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping({"informRequest/code"})
    public ActCode getInformRequestCode() {
        return this.informRequestCode.getValue();
    }
    public void setInformRequestCode(ActCode informRequestCode) {
        this.informRequestCode.setValue(informRequestCode);
    }

    @Hl7XmlMapping({"informRequest/indirectTarget/choice"})
    public ChoiceBean getInformRequestIndirectTargetChoice() {
        return this.informRequestIndirectTargetChoice;
    }
    public void setInformRequestIndirectTargetChoice(ChoiceBean informRequestIndirectTargetChoice) {
        this.informRequestIndirectTargetChoice = informRequestIndirectTargetChoice;
    }

    @Hl7XmlMapping({"informRequest/subject/modeCode"})
    public ParticipationMode getInformRequestSubjectModeCode() {
        return this.informRequestSubjectModeCode.getValue();
    }
    public void setInformRequestSubjectModeCode(ParticipationMode informRequestSubjectModeCode) {
        this.informRequestSubjectModeCode.setValue(informRequestSubjectModeCode);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/id"})
    public Identifier getServiceDeliveryLocationIdentifier() {
        return this.serviceDeliveryLocationIdentifier.getValue();
    }
    public void setServiceDeliveryLocationIdentifier(Identifier serviceDeliveryLocationIdentifier) {
        this.serviceDeliveryLocationIdentifier.setValue(serviceDeliveryLocationIdentifier);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/code"})
    public ServiceDeliveryLocationRoleType getServiceDeliveryLocationType() {
        return this.serviceDeliveryLocationType.getValue();
    }
    public void setServiceDeliveryLocationType(ServiceDeliveryLocationRoleType serviceDeliveryLocationType) {
        this.serviceDeliveryLocationType.setValue(serviceDeliveryLocationType);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/addr"})
    public PostalAddress getServiceDeliveryLocationAddress() {
        return this.serviceDeliveryLocationAddress.getValue();
    }
    public void setServiceDeliveryLocationAddress(PostalAddress serviceDeliveryLocationAddress) {
        this.serviceDeliveryLocationAddress.setValue(serviceDeliveryLocationAddress);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/telecom"})
    public TelecommunicationAddress getServiceDeliveryLocationTelecom() {
        return this.serviceDeliveryLocationTelecom.getValue();
    }
    public void setServiceDeliveryLocationTelecom(TelecommunicationAddress serviceDeliveryLocationTelecom) {
        this.serviceDeliveryLocationTelecom.setValue(serviceDeliveryLocationTelecom);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/effectiveTime"})
    public Interval<Date> getServiceDeliveryLocationEffectiveDate() {
        return this.serviceDeliveryLocationEffectiveDate.getValue();
    }
    public void setServiceDeliveryLocationEffectiveDate(Interval<Date> serviceDeliveryLocationEffectiveDate) {
        this.serviceDeliveryLocationEffectiveDate.setValue(serviceDeliveryLocationEffectiveDate);
    }

    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation/location/name"})
    public java.lang.String getServiceLocationName() {
        return this.serviceLocationName.getValue();
    }
    public void setServiceLocationName(java.lang.String serviceLocationName) {
        this.serviceLocationName.setValue(serviceLocationName);
    }

}
