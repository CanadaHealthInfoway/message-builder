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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.porx_mt980030ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.Dispensed_2Bean;
import java.util.Date;



/**
 * <p>Business Name: Dispense</p>
 * 
 * <p>Indicates a particular dispense event that resulted in 
 * the issue.</p>
 * 
 * <p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980030CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CausalActs {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private Dispensed_2Bean product;
    private CreatedAtBean location;


    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p><p>The attribute is 
     * marked as populated because it may be masked.</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p><p>The attribute is 
     * marked as populated because it may be masked.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Dispense Number</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Unique identifier of the dispensed event that triggered 
     * the issue.</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p><p>The attribute is 
     * marked as populated because it may be masked.</p>
     * 
     * <p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p><p>The attribute is 
     * marked as populated because it may be masked.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B:Dispense Status</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Dispense Status</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p>
     * 
     * <p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: B:Dispensed Date</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: B:Dispensed Date</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date and time on which the product was issued to the 
     * patient.</p>
     * 
     * <p>ZDU.4.5</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as &quot;populated&quot; 
     * as a dispense record may not exist without processing 
     * date.</p>
     * 
     * <p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: C:Dispense Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: C:Dispense Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SupplyEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"product"})
    public Dispensed_2Bean getProduct() {
        return this.product;
    }

    /**
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.product</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setProduct(Dispensed_2Bean product) {
        this.product = product;
    }


    /**
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: PORX_MT980030CA.SupplyEvent.location</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

}
