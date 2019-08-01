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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>PORX_MT060060CA.Author2: *b:prescribed by</p>
 * 
 * <p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>PORX_MT020050CA.Author2: prescribed by</p>
 * 
 * <p>The person who ordered the office supply.</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p><p>The attribute is marked as &quot;populated&quot; 
 * as the prescriber must be known or null flavour 
 * specified.</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p><p>The attribute is marked as &quot;populated&quot; 
 * as the prescriber must be known or null flavour 
 * specified.</p>
 * 
 * <p>PORX_MT030040CA.Author2: *b:prescribed by</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>PORX_MT060020CA.Author2: *b:prescribed by</p>
 * 
 * <p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>RCMR_MT010001CA.Author2: c:overridden by</p>
 * 
 * <p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent.</p>
 * 
 * <p>Authorization.signatory(PROV)</p>
 * 
 * <p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p>
 * 
 * <p>PORX_MT060100CA.Author2: *b:prescribed by</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>COCT_MT470000CA.Author2: c:consent overridden by</p>
 * 
 * <p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent, and is used for the purposes 
 * of 'breaking the glass' only.</p>
 * 
 * <p>Authorization.signatory(PROV)</p>
 * 
 * <p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p>
 * 
 * <p>PORX_MT060190CA.Author2: *c:prescribed by</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>Prescription.Prescriber</p><p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.Author2","PORX_MT020050CA.Author2","PORX_MT030040CA.Author2","PORX_MT060020CA.Author2","PORX_MT060060CA.Author2","PORX_MT060100CA.Author2","PORX_MT060190CA.Author2","RCMR_MT010001CA.Author2"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private TS time = new TSImpl();
    private ProviderBean assignedPerson;


    /**
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the prescription was written by the 
     * prescriber.</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Prescription.prescribedDate</p><p>Date prescription 
     * written</p><p>ZDP.8</p><p>DRU.040-02 (low, qualifier=85, 
     * format=102)</p><p>DRU.040-02 (low, qualifier=LO, format=102, 
     * where filter type = most recent)</p><p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the prescription was written by the 
     * prescriber.</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

}
