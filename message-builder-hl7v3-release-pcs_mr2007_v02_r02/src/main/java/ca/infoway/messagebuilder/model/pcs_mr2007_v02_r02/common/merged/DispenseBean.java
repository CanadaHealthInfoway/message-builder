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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.TargetedToPharmacyBean;
import java.util.Date;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>COCT_MT260010CA.SupplyEvent: Dispense</p>
 * 
 * <p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p>
 * 
 * <p>Indicates a particular dispense event that resulted in 
 * the issue.</p>
 * 
 * <p>COCT_MT260020CA.SupplyEvent: Dispense</p>
 * 
 * <p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p>
 * 
 * <p>Indicates a particular dispense event that resulted in 
 * the issue.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SupplyEvent","COCT_MT260020CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private DispensedBean product;
    private TargetedToPharmacyBean location;


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispense event that triggered 
     * the issue.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p>
     * 
     * <p>Unique identifier of the dispense event that triggered 
     * the issue.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: DispenseStatus</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatus</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: DispensedDate</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was dispensed to 
     * the patient.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: DispensedDate</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: DispensedDate</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     * 
     * <p>The date and time on which the product was dispensed to 
     * the patient.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: DispenseMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Un-merged Business Name: DispenseMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug.</p><p>The attribute is optional because not all 
     * systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the implicated 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: DispenseMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Un-merged Business Name: DispenseMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug.</p><p>The attribute is optional because not all 
     * systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the implicated 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260020CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

}
