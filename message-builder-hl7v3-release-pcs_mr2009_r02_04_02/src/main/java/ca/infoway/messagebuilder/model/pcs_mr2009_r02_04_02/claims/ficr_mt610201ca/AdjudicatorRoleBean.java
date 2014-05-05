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
 * Last modified: $LastChangedDate: 2013-12-09 12:33:15 -0400 (Mon, 09 Dec 2013) $
 * Revision:      $LastChangedRevision: 8228 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.InsuranceCarrierRoleBean;



/**
 * <p>NECST only: To note a contact person (adjudicator) for 
 * the Provider to contact in case of questions on the EOB, use 
 * Adjudication Information codes</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatorRole"})
public class AdjudicatorRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private PN playingAdjudicatorPersonName = new PNImpl();
    private InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole;


    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Adjudicator Person Name</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"playingAdjudicatorPerson/name"})
    public PersonName getPlayingAdjudicatorPersonName() {
        return this.playingAdjudicatorPersonName.getValue();
    }

    /**
     * <p>Business Name: Adjudicator Person Name</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPlayingAdjudicatorPersonName(PersonName playingAdjudicatorPersonName) {
        this.playingAdjudicatorPersonName.setValue(playingAdjudicatorPersonName);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.DirectAuthorityOver.insuranceCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directAuthority/insuranceCarrierRole"})
    public InsuranceCarrierRoleBean getDirectAuthorityInsuranceCarrierRole() {
        return this.directAuthorityInsuranceCarrierRole;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.DirectAuthorityOver.insuranceCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDirectAuthorityInsuranceCarrierRole(InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole) {
        this.directAuthorityInsuranceCarrierRole = directAuthorityInsuranceCarrierRole;
    }

}
