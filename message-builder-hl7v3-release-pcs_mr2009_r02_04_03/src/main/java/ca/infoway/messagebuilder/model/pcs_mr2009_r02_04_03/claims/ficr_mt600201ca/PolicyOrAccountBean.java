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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.PolicyUnderwriterBean;



/**
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PolicyOrAccount"})
public class PolicyOrAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient;
    private PolicyUnderwriterBean author;


    /**
     * <p>Business Name: Policy ID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Policy ID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }

    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    /**
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }

}
