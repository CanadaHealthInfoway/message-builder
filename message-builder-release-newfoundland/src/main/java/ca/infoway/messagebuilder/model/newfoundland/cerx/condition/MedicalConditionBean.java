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

package ca.infoway.messagebuilder.model.newfoundland.cerx.condition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.InformantParty;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "REPC_MT000003CA.MedicalCondition", "REPC_MT000014CA.MedicalCondition", "REPC_MT000007CA.MedicalCondition" })
public class MedicalConditionBean extends MessagePartBean implements OfPatient, VeryBasicConfidentiality, Serializable {

    private static final long serialVersionUID = 5640733227201462283L;

    private final II id = new IIImpl();

    private final CD code = new CDImpl();

    private final CD statusCode = new CDImpl();

    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final CD confidentialityCode = new CDImpl();

    private final CD diagnosisValue = new CDImpl();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private InformantParty informant;

    private final TS informantTime = new TSImpl();

    private BL annotationIndicator = new BLImpl(false);

    private BL chronicIndicatorBean = new BLImpl(false);

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    private AuthorBean author;

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("value")
    public DiagnosisValue getDiagnosisValue() {
        return (DiagnosisValue) this.diagnosisValue.getValue();
    }

    public void setDiagnosisValue(DiagnosisValue diagnosisValue) {
        this.diagnosisValue.setValue(diagnosisValue);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("subjectOf2/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    @Hl7XmlMapping({ "informant/party", "informant/consenter" })
    public InformantParty getInformant() {
        return informant;
    }

    public void setInformant(InformantParty informant) {
        this.informant = informant;
    }

    @Hl7XmlMapping({ "informant/time" })
    public Date getInformantTime() {
        return this.informantTime.getValue();
    }

    public void setInformantTime(Date informantTime) {
        this.informantTime.setValue(informantTime);
    }

    @Hl7XmlMapping({ "location/serviceDeliveryLocation" })
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({ "responsibleParty/assignedPerson" })
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping({ "author" })
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("subjectOf1/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    public boolean isChronicIndicator() {
        return this.chronicIndicatorBean.getValue();
    }

    public void setChronicIndicator(boolean chronicIndicator) {
        this.chronicIndicatorBean.setValue(chronicIndicator);
    }

    @Hl7XmlMapping({ "subjectOf3/chronicIndicator", "subjectOf1/chronicIndicator", "subjectOf/chronicIndicator" })
    public Boolean getChronicIndicatorBean() {
        return chronicIndicatorBean.getValue();
    }

    public void setChronicIndicatorBean(Boolean chronicIndicatorBean) {
        this.chronicIndicatorBean.setValue(chronicIndicatorBean);
    }
}
