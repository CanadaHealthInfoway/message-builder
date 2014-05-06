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
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt510201ca.AdjudicatorPersonBean;



/**
 * <p>FICR_MT510201CA.AdjudicatorRole: (no business name)</p>
 * 
 * <p>NECST only: To note a contact person (adjudicator) for 
 * the Provider to contact in case of questions on the EOB, use 
 * Adjudication Information codes</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatorRole","QUCR_MT830201CA.AdjudicatorRole"})
public class AdjudicatorIdBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private II id = new IIImpl();
    private AdjudicatorPersonBean playingAdjudicatorPerson;
    private InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole;


    /**
     * <p>Un-merged Business Name: AdjudicatorID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Set of identifiers that uniquely identify the adjudicator 
     * of the invoice.</p>
     * 
     * <p>Un-merged Business Name: AdjudicatorId</p>
     * 
     * <p>Relationship: FICR_MT510201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: AdjudicatorID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Set of identifiers that uniquely identify the adjudicator 
     * of the invoice.</p>
     * 
     * <p>Un-merged Business Name: AdjudicatorId</p>
     * 
     * <p>Relationship: FICR_MT510201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicatorRole.playingAdjudicatorPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"playingAdjudicatorPerson"})
    public AdjudicatorPersonBean getPlayingAdjudicatorPerson() {
        return this.playingAdjudicatorPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicatorRole.playingAdjudicatorPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPlayingAdjudicatorPerson(AdjudicatorPersonBean playingAdjudicatorPerson) {
        this.playingAdjudicatorPerson = playingAdjudicatorPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.DirectAuthorityOver.insuranceCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"directAuthority/insuranceCarrierRole"})
    public InsuranceCarrierRoleBean getDirectAuthorityInsuranceCarrierRole() {
        return this.directAuthorityInsuranceCarrierRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.DirectAuthorityOver.insuranceCarrierRole</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setDirectAuthorityInsuranceCarrierRole(InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole) {
        this.directAuthorityInsuranceCarrierRole = directAuthorityInsuranceCarrierRole;
    }

}
