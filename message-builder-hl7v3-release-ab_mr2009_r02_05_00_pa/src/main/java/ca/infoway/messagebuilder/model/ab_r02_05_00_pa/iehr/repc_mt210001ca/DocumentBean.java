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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.iehr.repc_mt210001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ReferralDocumentType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.iehr.merged.OldClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.iehr.merged.Recipients;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.iehr.merged.RequestedByBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"REPC_MT210001CA.Document"})
@Hl7RootType
public class DocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ActingPerson responsiblePartyActingPerson;
    private RequestedByBean author;
    private List<Recipients> primaryInformationRecipientRecipients = new ArrayList<Recipients>();
    private List<OldClinicalDocumentEventBean> predecessorOldClinicalDocumentEvent = new ArrayList<OldClinicalDocumentEventBean>();
    private SectionBean componentStructuredBodyComponentSection;
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ReferralDocumentType getCode() {
        return (ReferralDocumentType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Document Category</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ReferralDocumentType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: J: Document Title</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Document.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }

    /**
     * <p>Business Name: J: Document Title</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Document.title</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    /**
     * <p>Business Name: E: Document Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.Document.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: 
     * REPC_MT210001CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }

    /**
     * <p>Relationship: 
     * REPC_MT210001CA.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }

    public HealthcareOrganizationBean getResponsiblePartyActingPersonAsAssignedEntity1() {
        return this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity1() {
        return (this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean);
    }

    public ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean getResponsiblePartyActingPersonAsAssignedEntity2() {
        return this.responsiblePartyActingPerson instanceof ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean ? (ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity2() {
        return (this.responsiblePartyActingPerson instanceof ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt090508ca.HealthcareOrganizationBean);
    }

    public RelatedPersonBean getResponsiblePartyActingPersonAsPersonalRelationship() {
        return this.responsiblePartyActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsPersonalRelationship() {
        return (this.responsiblePartyActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: REPC_MT210001CA.Document.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * REPC_MT210001CA.InformationRecipient.recipients</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"primaryInformationRecipient/recipients"})
    public List<Recipients> getPrimaryInformationRecipientRecipients() {
        return this.primaryInformationRecipientRecipients;
    }


    /**
     * <p>Relationship: 
     * REPC_MT210001CA.Predecessor2.oldClinicalDocumentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldClinicalDocumentEvent"})
    public List<OldClinicalDocumentEventBean> getPredecessorOldClinicalDocumentEvent() {
        return this.predecessorOldClinicalDocumentEvent;
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/structuredBody/component/section"})
    public SectionBean getComponentStructuredBodyComponentSection() {
        return this.componentStructuredBodyComponentSection;
    }

    /**
     * <p>Relationship: REPC_MT210001CA.Component3.section</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponentStructuredBodyComponentSection(SectionBean componentStructuredBodyComponentSection) {
        this.componentStructuredBodyComponentSection = componentStructuredBodyComponentSection;
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: REPC_MT210001CA.Document.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    /**
     * <p>Relationship: 
     * REPC_MT210001CA.Component6.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
