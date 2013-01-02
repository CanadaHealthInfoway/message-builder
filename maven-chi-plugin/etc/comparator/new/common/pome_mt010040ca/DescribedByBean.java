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
package ca.infoway.messagebuilder.model.common.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ResponsibleOrganizationBean;
import java.util.Date;



/**
 * <p>described by 
 * 
 * <p>Provides detailed written information about the 
 * characteristics and use of the drug. Different types of 
 * monographs may be available, including patient monographs 
 * (providing guidance to a patient taking the medication), 
 * manufacturer's monographs (providing technical information 
 * to prescribers and pharmacists) and clinical practice 
 * guidelines providing recommendations from practice groups or 
 * regulatory bodies. 
 * 
 * <p>Monographs provide additional background information in 
 * an 'un-coded' manner intended to be easy to scan and read. 
 * Patient monographs allow prescribers and pharmacists to 
 * easily distribute relevant educational information. 
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Subject9"})
public class DescribedByBean extends MessagePartBean {

    private II monographId = new IIImpl();
    private CV<ActMedicationDocumentCode> monographType = new CVImpl<ActMedicationDocumentCode>();
    private ED<EncapsulatedData> monographContent = new EDImpl<EncapsulatedData>();
    private IVL<TS, Interval<Date>> monographEffectiveExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private CV<HumanLanguage> writtenIn = new CVImpl<HumanLanguage>();
    private ResponsibleOrganizationBean documentAuthorAssignedEntityAssignedOrganization = new ResponsibleOrganizationBean();

    @Hl7XmlMapping({"document/id"})
    public Identifier getMonographId() {
        return this.monographId.getValue();
    }
    public void setMonographId(Identifier monographId) {
        this.monographId.setValue(monographId);
    }

    @Hl7XmlMapping({"document/code"})
    public ActMedicationDocumentCode getMonographType() {
        return this.monographType.getValue();
    }
    public void setMonographType(ActMedicationDocumentCode monographType) {
        this.monographType.setValue(monographType);
    }

    @Hl7XmlMapping({"document/text"})
    public EncapsulatedData getMonographContent() {
        return this.monographContent.getValue();
    }
    public void setMonographContent(EncapsulatedData monographContent) {
        this.monographContent.setValue(monographContent);
    }

    @Hl7XmlMapping({"document/effectiveTime"})
    public Interval<Date> getMonographEffectiveExpiryDate() {
        return this.monographEffectiveExpiryDate.getValue();
    }
    public void setMonographEffectiveExpiryDate(Interval<Date> monographEffectiveExpiryDate) {
        this.monographEffectiveExpiryDate.setValue(monographEffectiveExpiryDate);
    }

    @Hl7XmlMapping({"document/languageCode"})
    public HumanLanguage getWrittenIn() {
        return this.writtenIn.getValue();
    }
    public void setWrittenIn(HumanLanguage writtenIn) {
        this.writtenIn.setValue(writtenIn);
    }

    @Hl7XmlMapping({"document/author/assignedEntity/assignedOrganization"})
    public ResponsibleOrganizationBean getDocumentAuthorAssignedEntityAssignedOrganization() {
        return this.documentAuthorAssignedEntityAssignedOrganization;
    }
    public void setDocumentAuthorAssignedEntityAssignedOrganization(ResponsibleOrganizationBean documentAuthorAssignedEntityAssignedOrganization) {
        this.documentAuthorAssignedEntityAssignedOrganization = documentAuthorAssignedEntityAssignedOrganization;
    }

}
