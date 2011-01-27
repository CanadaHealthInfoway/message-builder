/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.merged;

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
import ca.infoway.messagebuilder.model.claims.coct_mt110200ca.AccountBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt810201ca.AdjudResultsCarrierRoleBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt810201ca.AdjudResultsSendingAppRoleBean;
import ca.infoway.messagebuilder.model.claims.qucr_mt810201ca.ProviderIDBean;
import ca.infoway.messagebuilder.model.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudResultsGroup","FICR_MT630000CA.AdjudResultsGroup","QUCR_MT810201CA.AdjudResultsGroup"})
@Hl7RootType
public class AdjudicatedResultsGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private AdjudResultsCarrierRoleBean authorAdjudResultsCarrierRole;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<SummaryDetailsBean> summaryAdjudResultsGroupSummaryData = new ArrayList<SummaryDetailsBean>();
    private II adjudicatedResultsGroupID = new IIImpl();
    private BusinessArrangementBean referenceAdjudResultsFinancialContract;
    private ProviderIDBean performerAdjudResultsProviderRole;
    private MO netAmt = new MOImpl();
    private ca.infoway.messagebuilder.model.claims.coct_mt110101ca.AccountBean debitAccount;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private AdjudResultsSendingAppRoleBean deviceAdjudResultsSendingAppRole;
    private List<AdjudicatedResultsGroupBean> componentAdjudResultsGroup = new ArrayList<AdjudicatedResultsGroupBean>();
    private CV code = new CVImpl();
    private AccountBean creditAccount;


    @Hl7XmlMapping({"author/adjudResultsCarrierRole"})
    public AdjudResultsCarrierRoleBean getAuthorAdjudResultsCarrierRole() {
        return this.authorAdjudResultsCarrierRole;
    }
    public void setAuthorAdjudResultsCarrierRole(AdjudResultsCarrierRoleBean authorAdjudResultsCarrierRole) {
        this.authorAdjudResultsCarrierRole = authorAdjudResultsCarrierRole;
    }


    /**
     * <p>Summary Period Date Range</p>
     * 
     * <p>Time period for the payment</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"summary/adjudResultsGroupSummaryData"})
    public List<SummaryDetailsBean> getSummaryAdjudResultsGroupSummaryData() {
        return this.summaryAdjudResultsGroupSummaryData;
    }


    /**
     * <p>AdjudicatedResultsGroupID</p>
     * 
     * <p>Adjudicated Results Group ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatedResultsGroupID() {
        return this.adjudicatedResultsGroupID.getValue();
    }
    public void setAdjudicatedResultsGroupID(Identifier adjudicatedResultsGroupID) {
        this.adjudicatedResultsGroupID.setValue(adjudicatedResultsGroupID);
    }


    @Hl7XmlMapping({"reference/adjudResultsFinancialContract"})
    public BusinessArrangementBean getReferenceAdjudResultsFinancialContract() {
        return this.referenceAdjudResultsFinancialContract;
    }
    public void setReferenceAdjudResultsFinancialContract(BusinessArrangementBean referenceAdjudResultsFinancialContract) {
        this.referenceAdjudResultsFinancialContract = referenceAdjudResultsFinancialContract;
    }


    @Hl7XmlMapping({"performer/adjudResultsProviderRole"})
    public ProviderIDBean getPerformerAdjudResultsProviderRole() {
        return this.performerAdjudResultsProviderRole;
    }
    public void setPerformerAdjudResultsProviderRole(ProviderIDBean performerAdjudResultsProviderRole) {
        this.performerAdjudResultsProviderRole = performerAdjudResultsProviderRole;
    }


    /**
     * <p>Summary Period Amount</p>
     * 
     * <p>Summary Period Amt</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"debit/account"})
    public ca.infoway.messagebuilder.model.claims.coct_mt110101ca.AccountBean getDebitAccount() {
        return this.debitAccount;
    }
    public void setDebitAccount(ca.infoway.messagebuilder.model.claims.coct_mt110101ca.AccountBean debitAccount) {
        this.debitAccount = debitAccount;
    }


    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"device/adjudResultsSendingAppRole"})
    public AdjudResultsSendingAppRoleBean getDeviceAdjudResultsSendingAppRole() {
        return this.deviceAdjudResultsSendingAppRole;
    }
    public void setDeviceAdjudResultsSendingAppRole(AdjudResultsSendingAppRoleBean deviceAdjudResultsSendingAppRole) {
        this.deviceAdjudResultsSendingAppRole = deviceAdjudResultsSendingAppRole;
    }


    @Hl7XmlMapping({"component/adjudResultsGroup"})
    public List<AdjudicatedResultsGroupBean> getComponentAdjudResultsGroup() {
        return this.componentAdjudResultsGroup;
    }


    /**
     * <p>Type of Summary</p>
     * 
     * <p>Type of summary</p>
     * 
     * <p>Breakdown of Financial Activity</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"credit/account"})
    public AccountBean getCreditAccount() {
        return this.creditAccount;
    }
    public void setCreditAccount(AccountBean creditAccount) {
        this.creditAccount = creditAccount;
    }

}
