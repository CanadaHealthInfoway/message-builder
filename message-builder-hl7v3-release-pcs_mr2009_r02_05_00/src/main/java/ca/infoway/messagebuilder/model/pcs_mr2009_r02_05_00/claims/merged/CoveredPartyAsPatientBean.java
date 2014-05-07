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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.CoveredPartyRoleType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.RelatedPersonBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>FICR_MT510201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>FICR_MT610201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>FICR_MT600201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>FICR_MT500201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.CoveredPartyAsPatient","FICR_MT510201CA.CoveredPartyAsPatient","FICR_MT600201CA.CoveredPartyAsPatient","FICR_MT610201CA.CoveredPartyAsPatient"})
public class CoveredPartyAsPatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20140507L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private RelatedPersonBean indirectAuthorityPersonalRelationship;
    private CoveredPartyAsPatientChoice coveredPartyAsPatientChoice;
    private List<SubjectBean> subjectOf = new ArrayList<SubjectBean>();


    /**
     * <p>Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CoveredPartyAsPatient.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * CoveredPartyRelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * CoveredPartyRelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public CoveredPartyRoleType getCode() {
        return (CoveredPartyRoleType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT510201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT610201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * CoveredPartyRelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT600201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: 
     * CoveredPartyRelationshipToPolicyHolder</p>
     * 
     * <p>Relationship: FICR_MT500201CA.CoveredPartyAsPatient.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(CoveredPartyRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indirectAuthority/personalRelationship"})
    public RelatedPersonBean getIndirectAuthorityPersonalRelationship() {
        return this.indirectAuthorityPersonalRelationship;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.IndirectAuthorithyOver.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndirectAuthorityPersonalRelationship(RelatedPersonBean indirectAuthorityPersonalRelationship) {
        this.indirectAuthorityPersonalRelationship = indirectAuthorityPersonalRelationship;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatient.coveredPartyAsPatientChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatient.coveredPartyAsPatientChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyAsPatientChoice"})
    public CoveredPartyAsPatientChoice getCoveredPartyAsPatientChoice() {
        return this.coveredPartyAsPatientChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatient.coveredPartyAsPatientChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatient.coveredPartyAsPatientChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyAsPatientChoice(CoveredPartyAsPatientChoice coveredPartyAsPatientChoice) {
        this.coveredPartyAsPatientChoice = coveredPartyAsPatientChoice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.CoveredPartyAsPatient.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.CoveredPartyAsPatient.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<SubjectBean> getSubjectOf() {
        return this.subjectOf;
    }

}
