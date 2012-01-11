/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>ServiceDeliveryLocation</p>
 * 
 * <p>PRPM_MT306011CA.ServiceDeliveryLocation: Service Delivery 
 * Location</p>
 * 
 * <p><p>A role played by a place at which services may be 
 * provided. The RIM defines two specializations of service 
 * delivery location: 1. incidental service delivery location - 
 * A role played by a place at which health care services may 
 * be provided without prior designation or authorization and 
 * 2. dedicated service delivery location - A role played by a 
 * place that is intended to house the provision of services. 
 * Scoper is the Entity (typically Organization) that provides 
 * these services. This is not synonymous with 
 * &quot;ownership&quot;. This can be further characterized by 
 * a role code of: A)DedicatedClinicalLocationRoleType - A role 
 * of a place that further classifies the clinical setting 
 * (e.g., cardiology clinic, primary care clinic, 
 * rehabilitation hospital, skilled nursing facility) in which 
 * care is delivered during an encounter or 
 * B)DedicatedNonClinicalLocationRoleType - A role of a place 
 * that further classifies the setting in which non-clinical 
 * services are delivered. A given physical place can play 
 * multiple service delivery location roles each with its own 
 * attributes. For example, a Podiatric clinic and Research 
 * clinic may meet on alternate days in the same physical 
 * location; each clinic uses its own mailing address and 
 * telephone number.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * the physical location where healthcare services are 
 * provided</p></p>
 * 
 * <p>PRPM_MT309000CA.ServiceDeliveryLocation: Service Delivery 
 * Location</p>
 * 
 * <p><p>A role played by a place at which services may be 
 * provided. The RIM defines two specializations of service 
 * delivery location: 1. incidental service delivery location - 
 * A role played by a place at which health care services may 
 * be provided without prior designation or authorization and 
 * 2. dedicated service delivery location - A role played by a 
 * place that is intended to house the provision of services. 
 * Scoper is the Entity (typically Organization) that provides 
 * these services. This is not synonymous with 
 * &quot;ownership&quot;. This can be further characterized by 
 * a role code of: A)DedicatedClinicalLocationRoleType - A role 
 * of a place that further classifies the clinical setting 
 * (e.g., cardiology clinic, primary care clinic, 
 * rehabilitation hospital, skilled nursing facility) in which 
 * care is delivered during an encounter or 
 * B)DedicatedNonClinicalLocationRoleType - A role of a place 
 * that further classifies the setting in which non-clinical 
 * services are delivered. A given physical place can play 
 * multiple service delivery location roles each with its own 
 * attributes. For example, a Podiatric clinic and Research 
 * clinic may meet on alternate days in the same physical 
 * location; each clinic uses its own mailing address and 
 * telephone number.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * the physical location where healthcare services are 
 * provided</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.ServiceDeliveryLocation","PRPM_MT309000CA.ServiceDeliveryLocation"})
public class ServiceDeliveryLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice {

    private static final long serialVersionUID = 20120106L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST locationName = new STImpl();


    /**
     * <p>ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Service Delivery Location Identifier</p>
     * 
     * <p><p>A unique identifier for the service delivery 
     * location.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     * 
     * <p>Service Delivery Location Identifier</p>
     * 
     * <p><p>A unique identifier for the service delivery 
     * location.</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>ServiceDeliveryLocationType</p>
     * 
     * <p>Service Delivery Location Type</p>
     * 
     * <p><p>The code identifying the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }
    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>ServiceDeliveryLocationAddress</p>
     * 
     * <p>Service Delivery Location Address</p>
     * 
     * <p><p>Address of the specific service delivery location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Service Delivery Location Telecom</p>
     * 
     * <p><p>The telecom for the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Service Delivery Location Effective Date</p>
     * 
     * <p><p>Effective date of the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ServiceDeliveryLocationName</p>
     * 
     * <p>Service Delivery Location Name</p>
     * 
     * <p><p>The name of the service delivery location</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getLocationName() {
        return this.locationName.getValue();
    }
    public void setLocationName(String locationName) {
        this.locationName.setValue(locationName);
    }

}
