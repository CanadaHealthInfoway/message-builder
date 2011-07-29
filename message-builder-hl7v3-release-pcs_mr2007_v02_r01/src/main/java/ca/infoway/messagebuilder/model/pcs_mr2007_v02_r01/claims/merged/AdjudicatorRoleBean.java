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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt610201ca.InsuranceCarrierRoleBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatorRole","QUCR_MT830201CA.AdjudicatorRole"})
public class AdjudicatorRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II adjudicatorID = new IIImpl();
    private PN adjudicatorPersonName = new PNImpl();
    private InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole;


    /**
     * <p>AdjudicatorID</p>
     * 
     * <p>Adjudicator ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatorID() {
        return this.adjudicatorID.getValue();
    }
    public void setAdjudicatorID(Identifier adjudicatorID) {
        this.adjudicatorID.setValue(adjudicatorID);
    }


    /**
     * <p>AdjudicatorPersonName</p>
     * 
     * <p>Adjudicator Person Name</p>
     */
    @Hl7XmlMapping({"playingAdjudicatorPerson/name"})
    public PersonName getAdjudicatorPersonName() {
        return this.adjudicatorPersonName.getValue();
    }
    public void setAdjudicatorPersonName(PersonName adjudicatorPersonName) {
        this.adjudicatorPersonName.setValue(adjudicatorPersonName);
    }


    @Hl7XmlMapping({"directAuthority/insuranceCarrierRole"})
    public InsuranceCarrierRoleBean getDirectAuthorityInsuranceCarrierRole() {
        return this.directAuthorityInsuranceCarrierRole;
    }
    public void setDirectAuthorityInsuranceCarrierRole(InsuranceCarrierRoleBean directAuthorityInsuranceCarrierRole) {
        this.directAuthorityInsuranceCarrierRole = directAuthorityInsuranceCarrierRole;
    }

}
