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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
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
import java.util.Date;



/**
 * <p>QUCR_MT800201CA.ParameterList: (no business name)</p>
 * 
 * <p><p>At least one parameter item must be specified.</p></p>
 * 
 * <p><p>Either a AdjudResultsGroup.ID (which implies date, 
 * payee, payor) or date, payee, payor needs to be 
 * specified.</p></p>
 * 
 * <p>QUCR_MT820201CA.ParameterList: (no business name)</p>
 * 
 * <p><p>At least one parameter item must be specified.</p></p>
 * 
 * <p><p>Either a AdjudResultsGroup.ID (which implies date, 
 * payee, payor) or date, payee, payor needs to be 
 * specified.</p></p>
 */
@Hl7PartTypeMapping({"QUCR_MT800201CA.ParameterList","QUCR_MT820201CA.ParameterList"})
@Hl7RootType
public class ParameterList_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private TS adjudicationDate = new TSImpl();
    private II adjudicatedResultsGroupID = new IIImpl();
    private II financialContractID = new IIImpl();
    private II insuranceCarrierID = new IIImpl();
    private II locationIDNumber = new IIImpl();
    private II payeeID = new IIImpl();
    private II payorID = new IIImpl();
    private II providerID = new IIImpl();
    private II sendingApplicationIDNumber = new IIImpl();
    private CV invoiceElementGroupCode = new CVImpl();


    /**
     * <p>AdjudicationDate</p>
     * 
     * <p>Adjudication Date</p>
     * 
     * <p><p>Date of the Adjudication</p></p>
     */
    @Hl7XmlMapping({"adjudResultsGroupAuthorTime/value"})
    public Date getAdjudicationDate() {
        return this.adjudicationDate.getValue();
    }
    public void setAdjudicationDate(Date adjudicationDate) {
        this.adjudicationDate.setValue(adjudicationDate);
    }


    /**
     * <p>AdjudicatedResultsGroupID</p>
     * 
     * <p>Adjudicated Results Group ID</p>
     * 
     * <p><p>Unique Id assigned by Adjudicator to this Group of 
     * results</p></p>
     */
    @Hl7XmlMapping({"adjudResultsGroupId/value"})
    public Identifier getAdjudicatedResultsGroupID() {
        return this.adjudicatedResultsGroupID.getValue();
    }
    public void setAdjudicatedResultsGroupID(Identifier adjudicatedResultsGroupID) {
        this.adjudicatedResultsGroupID.setValue(adjudicatedResultsGroupID);
    }


    /**
     * <p>FinancialContractID</p>
     * 
     * <p>Financial Contract ID</p>
     * 
     * <p><p>ID number of payment arrangements for adjudicated 
     * invoices.</p></p>
     */
    @Hl7XmlMapping({"financialContractId/value"})
    public Identifier getFinancialContractID() {
        return this.financialContractID.getValue();
    }
    public void setFinancialContractID(Identifier financialContractID) {
        this.financialContractID.setValue(financialContractID);
    }


    /**
     * <p>InsuranceCarrierID</p>
     * 
     * <p>Insurance Carrier ID</p>
     * 
     * <p><p>Business ID for Insurance Carrier</p></p>
     */
    @Hl7XmlMapping({"insuranceCarrierRoleId/value"})
    public Identifier getInsuranceCarrierID() {
        return this.insuranceCarrierID.getValue();
    }
    public void setInsuranceCarrierID(Identifier insuranceCarrierID) {
        this.insuranceCarrierID.setValue(insuranceCarrierID);
    }


    /**
     * <p>LocationIDNumber</p>
     * 
     * <p>Location ID Number</p>
     * 
     * <p><p>Unique ID for location (OID)</p></p>
     */
    @Hl7XmlMapping({"locationId/value"})
    public Identifier getLocationIDNumber() {
        return this.locationIDNumber.getValue();
    }
    public void setLocationIDNumber(Identifier locationIDNumber) {
        this.locationIDNumber.setValue(locationIDNumber);
    }


    /**
     * <p>PayeeID</p>
     * 
     * <p>Payee ID</p>
     * 
     * <p><p>ID for person or organisation that received payment 
     * for the previously adjudicated and or paid services being 
     * queried.</p></p>
     */
    @Hl7XmlMapping({"payeeId/value"})
    public Identifier getPayeeID() {
        return this.payeeID.getValue();
    }
    public void setPayeeID(Identifier payeeID) {
        this.payeeID.setValue(payeeID);
    }


    /**
     * <p>PayorID</p>
     * 
     * <p>Payor ID</p>
     * 
     * <p><p>ID number of the organisation responsible for the 
     * payment of adjudicated Invoice elements.</p></p>
     */
    @Hl7XmlMapping({"payorId/value"})
    public Identifier getPayorID() {
        return this.payorID.getValue();
    }
    public void setPayorID(Identifier payorID) {
        this.payorID.setValue(payorID);
    }


    /**
     * <p>ProviderID</p>
     * 
     * <p>Provider ID</p>
     * 
     * <p><p>ID of provider:professional license no., 
     * jurisdictional PHN. eg. Professional registry no.</p></p>
     */
    @Hl7XmlMapping({"providerId/value"})
    public Identifier getProviderID() {
        return this.providerID.getValue();
    }
    public void setProviderID(Identifier providerID) {
        this.providerID.setValue(providerID);
    }


    /**
     * <p>SendingApplicationIDNumber</p>
     * 
     * <p>Sending application ID number</p>
     * 
     * <p><p>Unique ID number of sending application device 
     * (OID)</p></p>
     */
    @Hl7XmlMapping({"sendingApplicationId/value"})
    public Identifier getSendingApplicationIDNumber() {
        return this.sendingApplicationIDNumber.getValue();
    }
    public void setSendingApplicationIDNumber(Identifier sendingApplicationIDNumber) {
        this.sendingApplicationIDNumber.setValue(sendingApplicationIDNumber);
    }


    /**
     * <p>InvoiceElementGroupCode</p>
     * 
     * <p>Invoice element Group Code</p>
     * 
     * <p><p>Code indicating a grouping of invoice elements and 
     * details.</p></p>
     */
    @Hl7XmlMapping({"invoiceElementGroupCode/value"})
    public Code getInvoiceElementGroupCode() {
        return (Code) this.invoiceElementGroupCode.getValue();
    }
    public void setInvoiceElementGroupCode(Code invoiceElementGroupCode) {
        this.invoiceElementGroupCode.setValue(invoiceElementGroupCode);
    }

}
