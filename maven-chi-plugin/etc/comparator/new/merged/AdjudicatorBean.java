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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceAuthor","QUCR_MT830201CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatorBean extends MessagePartBean {

    private CS<ContextControl> contextControlCode = new CSImpl<ContextControl>();
    private TS adjudicationDateTime = new TSImpl();
    private CV<ParticipationMode> modeCode = new CVImpl<ParticipationMode>();
    private II adjudicatorRoleId = new IIImpl();
    private PN adjudicatorPersonName = new PNImpl();
    private II adjudicatorInsuranceCarrierID = new IIImpl();

    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }

    @Hl7XmlMapping({"time"})
    public Date getAdjudicationDateTime() {
        return this.adjudicationDateTime.getValue();
    }
    public void setAdjudicationDateTime(Date adjudicationDateTime) {
        this.adjudicationDateTime.setValue(adjudicationDateTime);
    }

    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }

    @Hl7XmlMapping({"adjudicatorRole/id"})
    public Identifier getAdjudicatorRoleId() {
        return this.adjudicatorRoleId.getValue();
    }
    public void setAdjudicatorRoleId(Identifier adjudicatorRoleId) {
        this.adjudicatorRoleId.setValue(adjudicatorRoleId);
    }

    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorPerson/name"})
    public PersonName getAdjudicatorPersonName() {
        return this.adjudicatorPersonName.getValue();
    }
    public void setAdjudicatorPersonName(PersonName adjudicatorPersonName) {
        this.adjudicatorPersonName.setValue(adjudicatorPersonName);
    }

    @Hl7XmlMapping({"adjudicatorRole/directAuthority/insuranceCarrierRole/id"})
    public Identifier getAdjudicatorInsuranceCarrierID() {
        return this.adjudicatorInsuranceCarrierID.getValue();
    }
    public void setAdjudicatorInsuranceCarrierID(Identifier adjudicatorInsuranceCarrierID) {
        this.adjudicatorInsuranceCarrierID.setValue(adjudicatorInsuranceCarrierID);
    }

}
