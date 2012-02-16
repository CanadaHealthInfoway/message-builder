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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt490000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.DiagnosisInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.HealthCareProviderBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged.ManufacturedProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p><p>Patient classes are not referenced in the billable 
 * acts, as they are noted in the parent model (e.g. Invoice 
 * message) as the CoveredPartyAsPatient</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.BillableClinicalProduct"})
@Hl7RootType
public class BillableClinicalProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20120215L;
    private CS moodCode = new CSImpl();
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ManufacturedProductBean productManufacturedProduct;
    private HealthCareProviderBean performerHealthCareProvider;
    private HealthCareProviderBean referrerHealthCareProvider;
    private HealthCareProviderBean consultantHealthCareProvider;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private ServiceLocationBean originServiceDeliveryLocation;
    private ServiceLocationBean destinationServiceDeliveryLocation;
    private List<DiagnosisInformationBean> pertinentInformation = new ArrayList<DiagnosisInformationBean>();


    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodIntentEvent getMoodCode() {
        return (x_ActMoodIntentEvent) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodIntentEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p><p>receipt number for the sale or rental</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p><p>includes duration &amp; date/time of occurence or 
     * period of rental</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"product/manufacturedProduct"})
    public ManufacturedProductBean getProductManufacturedProduct() {
        return this.productManufacturedProduct;
    }
    public void setProductManufacturedProduct(ManufacturedProductBean productManufacturedProduct) {
        this.productManufacturedProduct = productManufacturedProduct;
    }


    @Hl7XmlMapping({"performer/healthCareProvider"})
    public HealthCareProviderBean getPerformerHealthCareProvider() {
        return this.performerHealthCareProvider;
    }
    public void setPerformerHealthCareProvider(HealthCareProviderBean performerHealthCareProvider) {
        this.performerHealthCareProvider = performerHealthCareProvider;
    }


    @Hl7XmlMapping({"referrer/healthCareProvider"})
    public HealthCareProviderBean getReferrerHealthCareProvider() {
        return this.referrerHealthCareProvider;
    }
    public void setReferrerHealthCareProvider(HealthCareProviderBean referrerHealthCareProvider) {
        this.referrerHealthCareProvider = referrerHealthCareProvider;
    }


    @Hl7XmlMapping({"consultant/healthCareProvider"})
    public HealthCareProviderBean getConsultantHealthCareProvider() {
        return this.consultantHealthCareProvider;
    }
    public void setConsultantHealthCareProvider(HealthCareProviderBean consultantHealthCareProvider) {
        this.consultantHealthCareProvider = consultantHealthCareProvider;
    }


    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"origin/serviceDeliveryLocation"})
    public ServiceLocationBean getOriginServiceDeliveryLocation() {
        return this.originServiceDeliveryLocation;
    }
    public void setOriginServiceDeliveryLocation(ServiceLocationBean originServiceDeliveryLocation) {
        this.originServiceDeliveryLocation = originServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(ServiceLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"pertinentInformation"})
    public List<DiagnosisInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

}
