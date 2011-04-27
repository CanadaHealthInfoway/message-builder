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
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT300000CA.DispenseInstructions"})
public class DispenseInstructionsBean extends MessagePartBean {

    private II dispenseID = new IIImpl();
    private IVL<TS, Interval<Date>> substanceAdministrationTime = new IVLImpl<TS, Interval<Date>>();
    private CV<Code> substanceAdministrationIntentPriorityCode = new CVImpl<Code>();
    private List<IssuesBean> substanceAdministrationIntentSubjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private II prescriberID = new IIImpl();
    private PN prescriberName = new PNImpl();
    private LIST<TEL, TelecommunicationAddress> prescriberTelephoneNumber = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private IVL<TS, Interval<Date>> lastAllowedDispense = new IVLImpl<TS, Interval<Date>>();
    private INT numberOfRefills1 = new INTImpl();
    private DispenseSubstitutionBean substanceAdministrationIntentComponentSubstitution;
    private DispenseSubstitutionBean substanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution;

    @Hl7XmlMapping({"substanceAdministrationIntent/id"})
    public Identifier getDispenseID() {
        return this.dispenseID.getValue();
    }
    public void setDispenseID(Identifier dispenseID) {
        this.dispenseID.setValue(dispenseID);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/effectiveTime"})
    public Interval<Date> getSubstanceAdministrationTime() {
        return this.substanceAdministrationTime.getValue();
    }
    public void setSubstanceAdministrationTime(Interval<Date> substanceAdministrationTime) {
        this.substanceAdministrationTime.setValue(substanceAdministrationTime);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/priorityCode"})
    public Code getSubstanceAdministrationIntentPriorityCode() {
        return this.substanceAdministrationIntentPriorityCode.getValue();
    }
    public void setSubstanceAdministrationIntentPriorityCode(Code substanceAdministrationIntentPriorityCode) {
        this.substanceAdministrationIntentPriorityCode.setValue(substanceAdministrationIntentPriorityCode);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubstanceAdministrationIntentSubjectOfDetectedIssueEvent() {
        return this.substanceAdministrationIntentSubjectOfDetectedIssueEvent;
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/author/presriberRole/id"})
    public Identifier getPrescriberID() {
        return this.prescriberID.getValue();
    }
    public void setPrescriberID(Identifier prescriberID) {
        this.prescriberID.setValue(prescriberID);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/author/presriberRole/playingPrescriberPerson/name"})
    public PersonName getPrescriberName() {
        return this.prescriberName.getValue();
    }
    public void setPrescriberName(PersonName prescriberName) {
        this.prescriberName.setValue(prescriberName);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/author/presriberRole/playingPrescriberPerson/telecom"})
    public List<TelecommunicationAddress> getPrescriberTelephoneNumber() {
        return this.prescriberTelephoneNumber.rawList();
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/component2/supplyOrder/effectiveTime"})
    public Interval<Date> getLastAllowedDispense() {
        return this.lastAllowedDispense.getValue();
    }
    public void setLastAllowedDispense(Interval<Date> lastAllowedDispense) {
        this.lastAllowedDispense.setValue(lastAllowedDispense);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/component2/supplyOrder/repeatNumber"})
    public java.lang.Integer getNumberOfRefills1() {
        return this.numberOfRefills1.getValue();
    }
    public void setNumberOfRefills1(java.lang.Integer numberOfRefills1) {
        this.numberOfRefills1.setValue(numberOfRefills1);
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/component/substitution"})
    public DispenseSubstitutionBean getSubstanceAdministrationIntentComponentSubstitution() {
        return this.substanceAdministrationIntentComponentSubstitution;
    }
    public void setSubstanceAdministrationIntentComponentSubstitution(DispenseSubstitutionBean substanceAdministrationIntentComponentSubstitution) {
        this.substanceAdministrationIntentComponentSubstitution = substanceAdministrationIntentComponentSubstitution;
    }

    @Hl7XmlMapping({"substanceAdministrationIntent/inFulfillmentOf/substanceAdministrationOrder/component1/substitution"})
    public DispenseSubstitutionBean getSubstanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution() {
        return this.substanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution;
    }
    public void setSubstanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution(DispenseSubstitutionBean substanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution) {
        this.substanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution = substanceAdministrationIntentInFulfillmentOfSubstanceAdministrationOrderComponent1Substitution;
    }

}
