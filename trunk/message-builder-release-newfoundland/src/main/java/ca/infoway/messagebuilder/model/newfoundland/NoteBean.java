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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "Annotation" })
public class NoteBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = -6522996299712253453L;

    private ST text = new STImpl();

    private AuthorBean author = new AuthorBean();

    private CD languageCode = new CDImpl();

    private II recordIdentifier = new IIImpl();

    private IdentifiedPersonBean patient;

    private CD annotationCode = new CDImpl();

    private ServiceDeliveryLocationBean location;

    private AssignedPersonBean responsibleParty;

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping({ "author" })
    public AuthorBean getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public Date getTime() {
        return this.author == null ? null : this.author.getTime();
    }

    public void setTime(Date time) {
        if (this.author == null) {
            this.author = new AuthorBean();
        }
        this.author.setTime(time);
    }

    @Hl7XmlMapping("languageCode")
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }

    @Hl7XmlMapping({ "subject/annotatedAct/id", "id" })
    public Identifier getRecordIdentifier() {
        return this.recordIdentifier.getValue();
    }

    public void setRecordIdentifier(Identifier recordIdentifier) {
        this.recordIdentifier.setValue(recordIdentifier);
    }

    @Hl7XmlMapping({ "subject/annotatedAct/subject/patient", "recordTarget/patient" })
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean identifiedPersonBean) {
        this.patient = identifiedPersonBean;
    }

    @Hl7XmlMapping("code")
    public ActPatientAnnotationCode getAnnotationCode() {
        return (ActPatientAnnotationCode) this.annotationCode.getValue();
    }

    public void setAnnotationCode(ActPatientAnnotationCode annotationCode) {
        this.annotationCode.setValue(annotationCode);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    public Identifier getId() {
        return this.getRecordIdentifier();
    }

    public void setId(Identifier id) {
        this.setRecordIdentifier(id);
    }
}
