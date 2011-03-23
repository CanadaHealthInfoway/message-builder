/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.qucr_mt800201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Either a AdjudResultsGroup.ID (which implies date, payee, 
 * payor) or date, payee, payor needs to be specified.</p>
 * 
 * <p>At least one parameter item must be specified.</p>
 */
@Hl7PartTypeMapping({"QUCR_MT800201CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private IVL<TS, Interval<Date>> adjudResultsGroupAuthorTimeValue = new IVLImpl<TS, Interval<Date>>();
    private II adjudResultsGroupIdValue = new IIImpl();
    private II financialContractIdValue = new IIImpl();
    private II insuranceCarrierRoleIdValue = new IIImpl();
    private II locationIdValue = new IIImpl();
    private II payeeIdValue = new IIImpl();
    private II payorIdValue = new IIImpl();
    private II providerID = new IIImpl();
    private II sendingApplicationIdValue = new IIImpl();

    @Hl7XmlMapping({"adjudResultsGroupAuthorTime/value"})
    public Interval<Date> getAdjudResultsGroupAuthorTimeValue() {
        return this.adjudResultsGroupAuthorTimeValue.getValue();
    }
    public void setAdjudResultsGroupAuthorTimeValue(Interval<Date> adjudResultsGroupAuthorTimeValue) {
        this.adjudResultsGroupAuthorTimeValue.setValue(adjudResultsGroupAuthorTimeValue);
    }

    @Hl7XmlMapping({"adjudResultsGroupId/value"})
    public Identifier getAdjudResultsGroupIdValue() {
        return this.adjudResultsGroupIdValue.getValue();
    }
    public void setAdjudResultsGroupIdValue(Identifier adjudResultsGroupIdValue) {
        this.adjudResultsGroupIdValue.setValue(adjudResultsGroupIdValue);
    }

    @Hl7XmlMapping({"financialContractId/value"})
    public Identifier getFinancialContractIdValue() {
        return this.financialContractIdValue.getValue();
    }
    public void setFinancialContractIdValue(Identifier financialContractIdValue) {
        this.financialContractIdValue.setValue(financialContractIdValue);
    }

    @Hl7XmlMapping({"insuranceCarrierRoleId/value"})
    public Identifier getInsuranceCarrierRoleIdValue() {
        return this.insuranceCarrierRoleIdValue.getValue();
    }
    public void setInsuranceCarrierRoleIdValue(Identifier insuranceCarrierRoleIdValue) {
        this.insuranceCarrierRoleIdValue.setValue(insuranceCarrierRoleIdValue);
    }

    @Hl7XmlMapping({"locationId/value"})
    public Identifier getLocationIdValue() {
        return this.locationIdValue.getValue();
    }
    public void setLocationIdValue(Identifier locationIdValue) {
        this.locationIdValue.setValue(locationIdValue);
    }

    @Hl7XmlMapping({"payeeId/value"})
    public Identifier getPayeeIdValue() {
        return this.payeeIdValue.getValue();
    }
    public void setPayeeIdValue(Identifier payeeIdValue) {
        this.payeeIdValue.setValue(payeeIdValue);
    }

    @Hl7XmlMapping({"payorId/value"})
    public Identifier getPayorIdValue() {
        return this.payorIdValue.getValue();
    }
    public void setPayorIdValue(Identifier payorIdValue) {
        this.payorIdValue.setValue(payorIdValue);
    }

    @Hl7XmlMapping({"providerId/value"})
    public Identifier getProviderID() {
        return this.providerID.getValue();
    }
    public void setProviderID(Identifier providerID) {
        this.providerID.setValue(providerID);
    }

    @Hl7XmlMapping({"sendingApplicationId/value"})
    public Identifier getSendingApplicationIdValue() {
        return this.sendingApplicationIdValue.getValue();
    }
    public void setSendingApplicationIdValue(Identifier sendingApplicationIdValue) {
        this.sendingApplicationIdValue.setValue(sendingApplicationIdValue);
    }

}
