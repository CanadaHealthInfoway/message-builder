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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.qucr_mt820201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.ActInvoiceGroupCode;
import java.util.Date;



/**
 * <p>At least one parameter item must be specified.</p>
 * 
 * <p>Either a AdjudResultsGroup.ID (which implies date, payee, 
 * payor) or date, payee, payor needs to be specified.</p>
 */
@Hl7PartTypeMapping({"QUCR_MT820201CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private TS adjudResultsGroupAuthorTimeValue = new TSImpl();
    private II adjudResultsGroupIdValue = new IIImpl();
    private II financialContractIdValue = new IIImpl();
    private II insuranceCarrierRoleIdValue = new IIImpl();
    private CV invoiceElementGroupCodeValue = new CVImpl();
    private II locationIdValue = new IIImpl();
    private II payeeIdValue = new IIImpl();
    private II payorIdValue = new IIImpl();
    private II providerIdValue = new IIImpl();
    private II sendingApplicationIdValue = new IIImpl();


    /**
     * <p>Business Name: Adjudication Date</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.AdjudResultsGroupAuthorTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Date of the Adjudication</p>
     */
    @Hl7XmlMapping({"adjudResultsGroupAuthorTime/value"})
    public Date getAdjudResultsGroupAuthorTimeValue() {
        return this.adjudResultsGroupAuthorTimeValue.getValue();
    }

    /**
     * <p>Business Name: Adjudication Date</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.AdjudResultsGroupAuthorTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Date of the Adjudication</p>
     */
    public void setAdjudResultsGroupAuthorTimeValue(Date adjudResultsGroupAuthorTimeValue) {
        this.adjudResultsGroupAuthorTimeValue.setValue(adjudResultsGroupAuthorTimeValue);
    }


    /**
     * <p>Business Name: Adjudicated Results Group ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.AdjudResultsGroupId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique Id assigned by Adjudicator to this Group of 
     * results</p>
     */
    @Hl7XmlMapping({"adjudResultsGroupId/value"})
    public Identifier getAdjudResultsGroupIdValue() {
        return this.adjudResultsGroupIdValue.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Results Group ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.AdjudResultsGroupId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique Id assigned by Adjudicator to this Group of 
     * results</p>
     */
    public void setAdjudResultsGroupIdValue(Identifier adjudResultsGroupIdValue) {
        this.adjudResultsGroupIdValue.setValue(adjudResultsGroupIdValue);
    }


    /**
     * <p>Business Name: Financial Contract ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.FinancialContractId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID number of payment arrangements for adjudicated 
     * invoices.</p>
     */
    @Hl7XmlMapping({"financialContractId/value"})
    public Identifier getFinancialContractIdValue() {
        return this.financialContractIdValue.getValue();
    }

    /**
     * <p>Business Name: Financial Contract ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.FinancialContractId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID number of payment arrangements for adjudicated 
     * invoices.</p>
     */
    public void setFinancialContractIdValue(Identifier financialContractIdValue) {
        this.financialContractIdValue.setValue(financialContractIdValue);
    }


    /**
     * <p>Business Name: Insurance Carrier ID</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.InsuranceCarrierRoleId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Business ID for Insurance Carrier</p>
     */
    @Hl7XmlMapping({"insuranceCarrierRoleId/value"})
    public Identifier getInsuranceCarrierRoleIdValue() {
        return this.insuranceCarrierRoleIdValue.getValue();
    }

    /**
     * <p>Business Name: Insurance Carrier ID</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.InsuranceCarrierRoleId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Business ID for Insurance Carrier</p>
     */
    public void setInsuranceCarrierRoleIdValue(Identifier insuranceCarrierRoleIdValue) {
        this.insuranceCarrierRoleIdValue.setValue(insuranceCarrierRoleIdValue);
    }


    /**
     * <p>Business Name: Invoice element Group Code</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.InvoiceElementGroupCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code indicating a grouping of invoice elements and 
     * details.</p>
     */
    @Hl7XmlMapping({"invoiceElementGroupCode/value"})
    public ActInvoiceGroupCode getInvoiceElementGroupCodeValue() {
        return (ActInvoiceGroupCode) this.invoiceElementGroupCodeValue.getValue();
    }

    /**
     * <p>Business Name: Invoice element Group Code</p>
     * 
     * <p>Relationship: 
     * QUCR_MT820201CA.InvoiceElementGroupCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Code indicating a grouping of invoice elements and 
     * details.</p>
     */
    public void setInvoiceElementGroupCodeValue(ActInvoiceGroupCode invoiceElementGroupCodeValue) {
        this.invoiceElementGroupCodeValue.setValue(invoiceElementGroupCodeValue);
    }


    /**
     * <p>Business Name: Location ID Number</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.LocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique ID for location (OID)</p>
     */
    @Hl7XmlMapping({"locationId/value"})
    public Identifier getLocationIdValue() {
        return this.locationIdValue.getValue();
    }

    /**
     * <p>Business Name: Location ID Number</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.LocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique ID for location (OID)</p>
     */
    public void setLocationIdValue(Identifier locationIdValue) {
        this.locationIdValue.setValue(locationIdValue);
    }


    /**
     * <p>Business Name: Payee ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.PayeeId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID for person or organisation that received payment for 
     * the previously adjudicated and or paid services being 
     * queried.</p>
     */
    @Hl7XmlMapping({"payeeId/value"})
    public Identifier getPayeeIdValue() {
        return this.payeeIdValue.getValue();
    }

    /**
     * <p>Business Name: Payee ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.PayeeId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID for person or organisation that received payment for 
     * the previously adjudicated and or paid services being 
     * queried.</p>
     */
    public void setPayeeIdValue(Identifier payeeIdValue) {
        this.payeeIdValue.setValue(payeeIdValue);
    }


    /**
     * <p>Business Name: Payor ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.PayorId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID number of the organisation responsible for the payment 
     * of adjudicated Invoice elements.</p>
     */
    @Hl7XmlMapping({"payorId/value"})
    public Identifier getPayorIdValue() {
        return this.payorIdValue.getValue();
    }

    /**
     * <p>Business Name: Payor ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.PayorId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID number of the organisation responsible for the payment 
     * of adjudicated Invoice elements.</p>
     */
    public void setPayorIdValue(Identifier payorIdValue) {
        this.payorIdValue.setValue(payorIdValue);
    }


    /**
     * <p>Business Name: Provider ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.ProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID of provider:professional license no., jurisdictional 
     * PHN. eg. Professional registry no.</p>
     */
    @Hl7XmlMapping({"providerId/value"})
    public Identifier getProviderIdValue() {
        return this.providerIdValue.getValue();
    }

    /**
     * <p>Business Name: Provider ID</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.ProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ID of provider:professional license no., jurisdictional 
     * PHN. eg. Professional registry no.</p>
     */
    public void setProviderIdValue(Identifier providerIdValue) {
        this.providerIdValue.setValue(providerIdValue);
    }


    /**
     * <p>Business Name: Sending application ID number</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.SendingApplicationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique ID number of sending application device (OID)</p>
     */
    @Hl7XmlMapping({"sendingApplicationId/value"})
    public Identifier getSendingApplicationIdValue() {
        return this.sendingApplicationIdValue.getValue();
    }

    /**
     * <p>Business Name: Sending application ID number</p>
     * 
     * <p>Relationship: QUCR_MT820201CA.SendingApplicationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique ID number of sending application device (OID)</p>
     */
    public void setSendingApplicationIdValue(Identifier sendingApplicationIdValue) {
        this.sendingApplicationIdValue.setValue(sendingApplicationIdValue);
    }

}
