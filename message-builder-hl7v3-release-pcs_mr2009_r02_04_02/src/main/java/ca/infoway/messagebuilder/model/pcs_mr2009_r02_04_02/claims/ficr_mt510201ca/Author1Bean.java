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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT510201CA.Author1"})
public class Author1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private TS time = new TSImpl();
    private CV modeCode = new CVImpl();
    private II adjudicatorRoleId = new IIImpl();
    private AdjudicatorPersonBean adjudicatorRolePlayingAdjudicatorPerson;
    private II adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId = new IIImpl();


    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Author1.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Author1.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: Adjudicator Id</p>
     * 
     * <p>Relationship: FICR_MT510201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/id"})
    public Identifier getAdjudicatorRoleId() {
        return this.adjudicatorRoleId.getValue();
    }

    /**
     * <p>Business Name: Adjudicator Id</p>
     * 
     * <p>Relationship: FICR_MT510201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdjudicatorRoleId(Identifier adjudicatorRoleId) {
        this.adjudicatorRoleId.setValue(adjudicatorRoleId);
    }


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicatorRole.playingAdjudicatorPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorPerson"})
    public AdjudicatorPersonBean getAdjudicatorRolePlayingAdjudicatorPerson() {
        return this.adjudicatorRolePlayingAdjudicatorPerson;
    }

    /**
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicatorRole.playingAdjudicatorPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAdjudicatorRolePlayingAdjudicatorPerson(AdjudicatorPersonBean adjudicatorRolePlayingAdjudicatorPerson) {
        this.adjudicatorRolePlayingAdjudicatorPerson = adjudicatorRolePlayingAdjudicatorPerson;
    }


    /**
     * <p>Business Name: Adjudicator Insurance Carrier ID</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InsuranceCarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/directAuthority/insuranceCarrierRole/id"})
    public Identifier getAdjudicatorRoleDirectAuthorityInsuranceCarrierRoleId() {
        return this.adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId.getValue();
    }

    /**
     * <p>Business Name: Adjudicator Insurance Carrier ID</p>
     * 
     * <p>Relationship: FICR_MT510201CA.InsuranceCarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdjudicatorRoleDirectAuthorityInsuranceCarrierRoleId(Identifier adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId) {
        this.adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId.setValue(adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId);
    }

}
