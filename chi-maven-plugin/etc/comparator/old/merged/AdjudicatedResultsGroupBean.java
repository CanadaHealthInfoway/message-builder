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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.common.qucr_mt810201ca.BusinessArrangementIdentifierBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroup","FICR_MT630000CA.AdjudResultsGroup","QUCR_MT810201CA.AdjudResultsGroup"})
@Hl7RootType
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private II adjudicatedResultsGroupID = new IIImpl();
    private CV<Code> typeOfSummary = new CVImpl<Code>();
    private IVL<TS, Interval<Date>> timePeriodForThePayment = new IVLImpl<TS, Interval<Date>>();
    private MO summaryPeriodAmt = new MOImpl();
    private II deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId = new IIImpl();
    private II performerAdjudResultsProviderRoleId = new IIImpl();
    private II carrierId = new IIImpl();
    private DispenseShipToLocationBean locationServiceDeliveryLocation;
    private BusinessArrangementIdentifierBean reference;
    private List<SummaryRunningTotalsBean> summary = new ArrayList<SummaryRunningTotalsBean>();
    private ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean creditAccount;
    private AccountBean debitAccount;
    private List<AdjudicatedResultsGroupBean> componentAdjudResultsGroup = new ArrayList<AdjudicatedResultsGroupBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatedResultsGroupID() {
        return this.adjudicatedResultsGroupID.getValue();
    }
    public void setAdjudicatedResultsGroupID(Identifier adjudicatedResultsGroupID) {
        this.adjudicatedResultsGroupID.setValue(adjudicatedResultsGroupID);
    }

    @Hl7XmlMapping({"code"})
    public Code getTypeOfSummary() {
        return this.typeOfSummary.getValue();
    }
    public void setTypeOfSummary(Code typeOfSummary) {
        this.typeOfSummary.setValue(typeOfSummary);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTimePeriodForThePayment() {
        return this.timePeriodForThePayment.getValue();
    }
    public void setTimePeriodForThePayment(Interval<Date> timePeriodForThePayment) {
        this.timePeriodForThePayment.setValue(timePeriodForThePayment);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getSummaryPeriodAmt() {
        return this.summaryPeriodAmt.getValue();
    }
    public void setSummaryPeriodAmt(Money summaryPeriodAmt) {
        this.summaryPeriodAmt.setValue(summaryPeriodAmt);
    }

    @Hl7XmlMapping({"device/adjudResultsSendingAppRole/playingAdjudResultsSendingAppDevice/id"})
    public Identifier getDeviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId() {
        return this.deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId.getValue();
    }
    public void setDeviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId(Identifier deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId) {
        this.deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId.setValue(deviceAdjudResultsSendingAppRolePlayingAdjudResultsSendingAppDeviceId);
    }

    @Hl7XmlMapping({"performer/adjudResultsProviderRole/id"})
    public Identifier getPerformerAdjudResultsProviderRoleId() {
        return this.performerAdjudResultsProviderRoleId.getValue();
    }
    public void setPerformerAdjudResultsProviderRoleId(Identifier performerAdjudResultsProviderRoleId) {
        this.performerAdjudResultsProviderRoleId.setValue(performerAdjudResultsProviderRoleId);
    }

    @Hl7XmlMapping({"author/adjudResultsCarrierRole/id"})
    public Identifier getCarrierId() {
        return this.carrierId.getValue();
    }
    public void setCarrierId(Identifier carrierId) {
        this.carrierId.setValue(carrierId);
    }

    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(DispenseShipToLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"reference"})
    public BusinessArrangementIdentifierBean getReference() {
        return this.reference;
    }
    public void setReference(BusinessArrangementIdentifierBean reference) {
        this.reference = reference;
    }

    @Hl7XmlMapping({"summary"})
    public List<SummaryRunningTotalsBean> getSummary() {
        return this.summary;
    }

    @Hl7XmlMapping({"credit/account"})
    public ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(ca.infoway.messagebuilder.model.common.coct_mt110200ca.AccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Hl7XmlMapping({"debit/account"})
    public AccountBean getDebitAccount() {
        return this.debitAccount;
    }
    public void setDebitAccount(AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }

    @Hl7XmlMapping({"component/adjudResultsGroup"})
    public List<AdjudicatedResultsGroupBean> getComponentAdjudResultsGroup() {
        return this.componentAdjudResultsGroup;
    }

}
