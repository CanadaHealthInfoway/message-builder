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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RelatedPersonBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>FICR_MT510201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p>FICR_MT610201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p>FICR_MT600201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p>FICR_MT500201CA.CoveredPartyAsPatient: (no business name)</p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p></p>
 * 
 * <p><p>Covered Person Identifier</p><p>(Assigned by
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.CoveredPartyAsPatient","FICR_MT510201CA.CoveredPartyAsPatient","FICR_MT600201CA.CoveredPartyAsPatient","FICR_MT610201CA.CoveredPartyAsPatient"})
public class CoveredPartyAsPatientBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private RelatedPersonBean indirectAuthorityPersonalRelationship;
    private CoveredPartyAsPatientChoice coveredPartyAsPatientChoice;
    private List<SubjectBean> subjectOf = new ArrayList<SubjectBean>();


    /**
     * <p>CoveredPartyIdentifier</p>
     * 
     * <p>Covered party Identifier</p>
     * 
     * <p>Covered Party Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship to Policy Holder</p>
     * 
     * <p>Covered Party Relationship to Policy Holder</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"indirectAuthority/personalRelationship"})
    public RelatedPersonBean getIndirectAuthorityPersonalRelationship() {
        return this.indirectAuthorityPersonalRelationship;
    }
    public void setIndirectAuthorityPersonalRelationship(RelatedPersonBean indirectAuthorityPersonalRelationship) {
        this.indirectAuthorityPersonalRelationship = indirectAuthorityPersonalRelationship;
    }


    @Hl7XmlMapping({"coveredPartyAsPatientChoice"})
    public CoveredPartyAsPatientChoice getCoveredPartyAsPatientChoice() {
        return this.coveredPartyAsPatientChoice;
    }
    public void setCoveredPartyAsPatientChoice(CoveredPartyAsPatientChoice coveredPartyAsPatientChoice) {
        this.coveredPartyAsPatientChoice = coveredPartyAsPatientChoice;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<SubjectBean> getSubjectOf() {
        return this.subjectOf;
    }

}