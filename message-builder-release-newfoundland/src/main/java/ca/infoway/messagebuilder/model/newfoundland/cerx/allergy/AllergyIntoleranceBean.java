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

package ca.infoway.messagebuilder.model.newfoundland.cerx.allergy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.InformantParty;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.AllergyRecord;

@Hl7PartTypeMapping({ "REPC_MT000001CA.IntoleranceCondition", "REPC_MT000013CA.IntoleranceCondition", "REPC_MT000005CA.IntoleranceCondition" })
public class AllergyIntoleranceBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = 3529918339581713360L;

    private II id = new IIImpl();

    private CD code = new CDImpl();

    private BL negationInd = new BLImpl(false);

    private CD status = new CDImpl();

    private TS effectiveTime = new TSImpl();

    private SET<CD, Code> confidentiality = new SETImpl<CD, Code>(CDImpl.class);

    private CD uncertainty = new CDImpl();

    private CD value = new CDImpl();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private InformantParty informant;

    private TS informantTime = new TSImpl();

    private List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    private CD severityObservation = new CDImpl();

    private AuthorBean author;

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    private BL annotationIndicator = new BLImpl(false);

    private List<AllergyRecord> allergyRecords = Collections.synchronizedList(new ArrayList<AllergyRecord>());

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }

    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatus() {
        return (ActStatus) this.status.getValue();
    }

    public void setStatus(ActStatus status) {
        this.status.setValue(status);
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public Set<x_VeryBasicConfidentialityKind> getConfidentiality() {
        return this.confidentiality.rawSet(x_VeryBasicConfidentialityKind.class);
    }


    @Hl7XmlMapping("uncertaintyCode")
    public ActUncertainty getUncertainty() {
        return (ActUncertainty) this.uncertainty.getValue();
    }

    public void setUncertainty(ActUncertainty uncertainty) {
        this.uncertainty.setValue(uncertainty);
    }

    @Hl7XmlMapping("value")
    public IntoleranceValue getValue() {
        return (IntoleranceValue) this.value.getValue();
    }

    public void setValue(IntoleranceValue value) {
        this.value.setValue(value);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean subject) {
        this.patient = subject;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("subjectOf1/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    @Hl7XmlMapping("negationInd")
    public boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    public void setNegationInd(boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

    @Hl7XmlMapping({ "informant/party" })
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

    @Hl7XmlMapping({ "subjectOf2/severityObservation/value", "subjectOf/severityObservation/value" })
    public SeverityObservation getSeverityObservation() {
        return (SeverityObservation) this.severityObservation.getValue();
    }

    public void setSeverityObservation(SeverityObservation severityObservation) {
        this.severityObservation.setValue(severityObservation);
    }

    @Hl7XmlMapping({ "support/records" })
    public List<AllergyRecord> getAllergyRecords() {
        return allergyRecords;
    }

    public void setAllergyRecords(List<AllergyRecord> allergyRecords) {
        this.allergyRecords = allergyRecords;
    }

    @Hl7XmlMapping({ "responsibleParty" })
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("subjectOf3/annotationIndicator")
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }

    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }
}
