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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.CoveredPartyAsPatientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.PatientConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca.PersonPatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RelatedPersonBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatient","FICR_MT610201CA.CoveredPartyAsPatient"})
public class CoveredPartyInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II coveredPartyIdentifier = new IIImpl();
    private CV code = new CVImpl();
    private RelatedPersonBean indirectAuthorityPersonalRelationship;
    private CoveredPartyAsPatientChoice coveredPartyAsPatientChoice;
    private List<PatientConsentBean> subjectOf = new ArrayList<PatientConsentBean>();


    /**
     * <p>CoveredPartyIdentifier</p>
     * 
     * <p>Covered Party Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoveredPartyIdentifier() {
        return this.coveredPartyIdentifier.getValue();
    }
    public void setCoveredPartyIdentifier(Identifier coveredPartyIdentifier) {
        this.coveredPartyIdentifier.setValue(coveredPartyIdentifier);
    }


    /**
     * <p>Relationship to Policy Holder</p>
     * 
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
    public List<PatientConsentBean> getSubjectOf() {
        return this.subjectOf;
    }

}
