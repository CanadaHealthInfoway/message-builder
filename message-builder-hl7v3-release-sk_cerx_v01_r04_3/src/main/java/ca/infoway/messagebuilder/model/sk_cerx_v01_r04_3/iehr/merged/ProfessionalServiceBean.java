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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000017CA.ProcedureEvent","REPC_MT100001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private CV serviceCode = new CVImpl();
    private IVL<TS, Interval<Date>> consultationTimeAndLength = new IVLImpl<TS, Interval<Date>>();
    private CV professionalServiceMaskingIndicator = new CVImpl();
    private PatientBean subjectPatient;
    private OrderForServiceBean inFulfillmentOfActRequest;
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private II serviceRecordIdentifier = new IIImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private RecordedAtBean location;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);


    /**
     * <p>ServiceCode</p>
     * 
     * <p>B:Service Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getServiceCode() {
        return (ActProfessionalServiceCode) this.serviceCode.getValue();
    }
    public void setServiceCode(ActProfessionalServiceCode serviceCode) {
        this.serviceCode.setValue(serviceCode);
    }


    /**
     * <p>ConsultationTimeAndLength</p>
     * 
     * <p>C:Consultation Time and Length</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsultationTimeAndLength() {
        return this.consultationTimeAndLength.getValue();
    }
    public void setConsultationTimeAndLength(Interval<Date> consultationTimeAndLength) {
        this.consultationTimeAndLength.setValue(consultationTimeAndLength);
    }


    /**
     * <p>ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>D:Professional Service Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getProfessionalServiceMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.professionalServiceMaskingIndicator.getValue();
    }
    public void setProfessionalServiceMaskingIndicator(x_VeryBasicConfidentialityKind professionalServiceMaskingIndicator) {
        this.professionalServiceMaskingIndicator.setValue(professionalServiceMaskingIndicator);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public OrderForServiceBean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(OrderForServiceBean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    @Hl7XmlMapping({"subjectOf/annotation","subjectOf2/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000017CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT100001CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600CA.Annotation")})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    /**
     * <p>ServiceRecordIdentifier</p>
     * 
     * <p>A:Service Record Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceRecordIdentifier() {
        return this.serviceRecordIdentifier.getValue();
    }
    public void setServiceRecordIdentifier(Identifier serviceRecordIdentifier) {
        this.serviceRecordIdentifier.setValue(serviceRecordIdentifier);
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }

}
