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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>COCT_MT470000CA.Author2: c:consent overridden by</p>
 * 
 * <p>Authorization.signatory(PROV)</p>
 * 
 * <p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p>
 * 
 * <p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent, and is used for the purposes 
 * of 'breaking the glass' only.</p>
 * 
 * <p>PORX_MT060040CA.Author4: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT030040CA.Author2: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT060340CA.Author4: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT020050CA.Author2: prescribed by</p>
 * 
 * <p>Used to create an 'inferred' prescription if an 
 * electronic prescription does not already exist in the 
 * EHR.</p><p>The attribute is marked as &quot;populated&quot; 
 * as the prescriber must be known or null flavour 
 * specified.</p>
 * 
 * <p>The person who ordered the office supply.</p>
 * 
 * <p>RCMR_MT010001CA.Author2: c:overridden by</p>
 * 
 * <p>Authorization.signatory(PROV)</p>
 * 
 * <p>Clinical circumstances may demand that a patient's 
 * information be accessed without consent to ensure patient 
 * safety.</p>
 * 
 * <p>Indicates that information access was approved by a 
 * provider rather than a patient. I.e. This is an override 
 * rather than an actual consent.</p>
 * 
 * <p>PORX_MT060160CA.Author4: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT060020CA.Author2: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT060100CA.Author2: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT060190CA.Author2: *c:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the medication to be 
 * dispensed to the patient.</p>
 * 
 * <p>PORX_MT060060CA.Author2: *b:prescribed by</p>
 * 
 * <p>Prescription.Prescriber</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>To be a legal order, the person responsible for its 
 * creation must be identified. Thus the association is 
 * mandatory.</p>
 * 
 * <p>This is the provider who authorized the device to be 
 * dispensed to the patient.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.Author2","PORX_MT020050CA.Author2","PORX_MT030040CA.Author2","PORX_MT060020CA.Author2","PORX_MT060040CA.Author4","PORX_MT060060CA.Author2","PORX_MT060100CA.Author2","PORX_MT060160CA.Author4","PORX_MT060190CA.Author2","PORX_MT060340CA.Author4","RCMR_MT010001CA.Author2"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private ProviderBean assignedPerson;
    private TS time = new TSImpl();
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.assignedPerson</p>
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
     * <p>Relationship: COCT_MT470000CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * always be known, except for inferred prescriptions.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription may 
     * not be known, as in the case of 'inferred prescription'.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>The date that the prescription was written by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * always be known, except for inferred prescriptions.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation datetime of the prescription 
     * will not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription will 
     * not always be known (as in the case of 'inferred 
     * prescription').</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060020CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated because the creation date of the prescription may 
     * not be known, as in the case of 'inferred prescription'.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * populated as it will not be there for inferred 
     * prescriptions.</p>
     * 
     * <p>The date at which the drug was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or administered for two weeks.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential information for a prescription to be 
     * legal.</p><p>This information may not always be known for an 
     * inferred prescription, and is therefore marked as 
     * &quot;populated&quot;.</p>
     * 
     * <p>The date that the prescription was written by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: PrescribedDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Author2.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescribedDate</p>
     * 
     * <p>Date prescription written</p>
     * 
     * <p>ZDP.8</p>
     * 
     * <p>DRU.040-02 (low, qualifier=85, format=102)</p>
     * 
     * <p>DRU.040-02 (low, qualifier=LO, format=102, where filter 
     * type = most recent)</p>
     * 
     * <p>Claim:414-DE</p>
     * 
     * <p>Indicates when the action was performed, and may 
     * influence expiry dates for the order.</p><p>The attribute is 
     * mandatory because the creation date of the prescription will 
     * always be known.</p>
     * 
     * <p>The date at which the device was prescribed. This may 
     * differ from the date on which the prescription becomes 
     * effective. E.g. A prescription created today may not be 
     * valid to be dispensed or used for two weeks.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionTransmissionMethod</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZDP.4</p>
     * 
     * <p>Claim.419-DJ</p>
     * 
     * <p>Some jurisdictions have a requirement to track how an 
     * order was received. May also be important when orders are 
     * entered into a central repository from the pharmacy.</p>
     * 
     * <p>Indicates the medium in which a prescription was 
     * transmitted to or received by the person who entered it into 
     * the electronic record.</p>
     */
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: Signature</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: Signature</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     * 
     * <p>Un-merged Business Name: Signature</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Author4.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Signature</p>
     * 
     * <p>Allows for pure electronic prescriptions without a 
     * trusted intermediary. The attribute is optional because all 
     * jurisdictions may not support digital signatures.</p>
     * 
     * <p>An electronic signature of the prescription by the 
     * prescriber.</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }

}
