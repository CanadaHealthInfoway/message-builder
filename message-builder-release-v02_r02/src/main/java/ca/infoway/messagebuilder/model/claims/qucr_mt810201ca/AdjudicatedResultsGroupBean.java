/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.qucr_mt810201ca;

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
import ca.infoway.messagebuilder.model.claims.coct_mt110101ca.AccountBean;
import ca.infoway.messagebuilder.model.claims.coct_mt110200ca.PayeeAccountBean;
import ca.infoway.messagebuilder.model.merged.BusinessArrangementBean;
import ca.infoway.messagebuilder.model.merged.ServiceDeliveryLocation_2Bean;
import ca.infoway.messagebuilder.model.merged.SummaryDetailsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Adjudicated Results Group</p>
 * 
 * <p>Associations to the right are used for breaking down</p>
 * 
 * <p>a Payment Advice (e.g. provider, sending appl) or</p>
 * 
 * <p>a Statement of Financial Activity (e.g. payee, payor).</p>
 * 
 * <p>Only 1 association can be specified per instance of this 
 * act.</p>
 * 
 * <p>The AdjudResultsGroup.netAmt must equal the sum of all 
 * immediate children AdjudResultsGroup.netAmt</p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsGroup"})
@Hl7RootType
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II adjudicatedResultsGroupID = new IIImpl();
    private CV typeOfSummary = new CVImpl();
    private IVL<TS, Interval<Date>> timePeriodForThePayment = new IVLImpl<TS, Interval<Date>>();
    private MO summaryPeriodAmt = new MOImpl();
    private DevicePlayingTheSendingApplicationRoleBean deviceAdjudResultsSendingAppRole;
    private ProviderIDBean performerAdjudResultsProviderRole;
    private CarrierOrThirdPartyAdministratorBean authorAdjudResultsCarrierRole;
    private ServiceDeliveryLocation_2Bean locationServiceDeliveryLocation;
    private BusinessArrangementBean referenceAdjudResultsFinancialContract;
    private List<SummaryDetailsBean> summaryAdjudResultsGroupSummaryData = new ArrayList<SummaryDetailsBean>();
    private PayeeAccountBean creditAccount;
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
        return (Code) this.typeOfSummary.getValue();
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

    @Hl7XmlMapping({"device/adjudResultsSendingAppRole"})
    public DevicePlayingTheSendingApplicationRoleBean getDeviceAdjudResultsSendingAppRole() {
        return this.deviceAdjudResultsSendingAppRole;
    }
    public void setDeviceAdjudResultsSendingAppRole(DevicePlayingTheSendingApplicationRoleBean deviceAdjudResultsSendingAppRole) {
        this.deviceAdjudResultsSendingAppRole = deviceAdjudResultsSendingAppRole;
    }

    @Hl7XmlMapping({"performer/adjudResultsProviderRole"})
    public ProviderIDBean getPerformerAdjudResultsProviderRole() {
        return this.performerAdjudResultsProviderRole;
    }
    public void setPerformerAdjudResultsProviderRole(ProviderIDBean performerAdjudResultsProviderRole) {
        this.performerAdjudResultsProviderRole = performerAdjudResultsProviderRole;
    }

    @Hl7XmlMapping({"author/adjudResultsCarrierRole"})
    public CarrierOrThirdPartyAdministratorBean getAuthorAdjudResultsCarrierRole() {
        return this.authorAdjudResultsCarrierRole;
    }
    public void setAuthorAdjudResultsCarrierRole(CarrierOrThirdPartyAdministratorBean authorAdjudResultsCarrierRole) {
        this.authorAdjudResultsCarrierRole = authorAdjudResultsCarrierRole;
    }

    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceDeliveryLocation_2Bean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceDeliveryLocation_2Bean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"reference/adjudResultsFinancialContract"})
    public BusinessArrangementBean getReferenceAdjudResultsFinancialContract() {
        return this.referenceAdjudResultsFinancialContract;
    }
    public void setReferenceAdjudResultsFinancialContract(BusinessArrangementBean referenceAdjudResultsFinancialContract) {
        this.referenceAdjudResultsFinancialContract = referenceAdjudResultsFinancialContract;
    }

    @Hl7XmlMapping({"summary/adjudResultsGroupSummaryData"})
    public List<SummaryDetailsBean> getSummaryAdjudResultsGroupSummaryData() {
        return this.summaryAdjudResultsGroupSummaryData;
    }

    @Hl7XmlMapping({"credit/account"})
    public PayeeAccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(PayeeAccountBean creditAccount) {
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
