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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatedInvoiceAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private TS time = new TSImpl();
    private II adjudicatorRoleId = new IIImpl();
    private PN adjudicatorRolePlayingAdjudicatorPersonName = new PNImpl();
    private II adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId = new IIImpl();


    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.time</p>
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
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/id"})
    public Identifier getAdjudicatorRoleId() {
        return this.adjudicatorRoleId.getValue();
    }

    /**
     * <p>Business Name: Adjudicator ID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdjudicatorRoleId(Identifier adjudicatorRoleId) {
        this.adjudicatorRoleId.setValue(adjudicatorRoleId);
    }


    /**
     * <p>Business Name: Adjudicator Person Name</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorPerson/name"})
    public PersonName getAdjudicatorRolePlayingAdjudicatorPersonName() {
        return this.adjudicatorRolePlayingAdjudicatorPersonName.getValue();
    }

    /**
     * <p>Business Name: Adjudicator Person Name</p>
     * 
     * <p>Relationship: FICR_MT610201CA.AdjudicatorPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAdjudicatorRolePlayingAdjudicatorPersonName(PersonName adjudicatorRolePlayingAdjudicatorPersonName) {
        this.adjudicatorRolePlayingAdjudicatorPersonName.setValue(adjudicatorRolePlayingAdjudicatorPersonName);
    }


    /**
     * <p>Business Name: Adjudicator Insurance Carrier ID</p>
     * 
     * <p>Relationship: FICR_MT610201CA.InsuranceCarrierRole.id</p>
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
     * <p>Relationship: FICR_MT610201CA.InsuranceCarrierRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdjudicatorRoleDirectAuthorityInsuranceCarrierRoleId(Identifier adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId) {
        this.adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId.setValue(adjudicatorRoleDirectAuthorityInsuranceCarrierRoleId);
    }

}
