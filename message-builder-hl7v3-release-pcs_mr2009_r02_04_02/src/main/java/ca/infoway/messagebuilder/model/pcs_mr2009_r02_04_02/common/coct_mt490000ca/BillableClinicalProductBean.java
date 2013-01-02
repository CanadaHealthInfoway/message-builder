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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt490000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.DiagnosisInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareProviderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ManufacturedProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActProductAcquisitionType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Billable Clinical Product</p>
 * 
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient</p>
 * 
 * <p>Product being billed</p>
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.SupplyEvent"})
@Hl7RootType
public class BillableClinicalProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ManufacturedProductBean productManufacturedProduct;
    private HealthcareProviderBean performerHealthCareProvider;
    private HealthcareProviderBean referrerHealthCareProvider;
    private HealthcareProviderBean consultantHealthCareProvider;
    private ServiceLocationBean originServiceDeliveryLocation;
    private ServiceLocationBean destinationServiceDeliveryLocation;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<DiagnosisInformationBean> pertinentInformation = new ArrayList<DiagnosisInformationBean>();


    /**
     * <p>Business Name: Billable Clinical Product ID</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>receipt number for the sale or rental</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Billable Clinical Product ID</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>receipt number for the sale or rental</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Method of payment for product.</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Rent or Sale.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProductAcquisitionType getCode() {
        return (ActProductAcquisitionType) this.code.getValue();
    }

    /**
     * <p>Business Name: Method of payment for product.</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Rent or Sale.</p>
     */
    public void setCode(ActProductAcquisitionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Time of Sale</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Date that the sale is transacted (change of ownership for 
     * a sale) and could be different than the date that it is 
     * invoiced. Similar in concept to the service date.</p><p>For 
     * rentals, this is the rental period.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Time of Sale</p>
     * 
     * <p>Relationship: COCT_MT490000CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Date that the sale is transacted (change of ownership for 
     * a sale) and could be different than the date that it is 
     * invoiced. Similar in concept to the service date.</p><p>For 
     * rentals, this is the rental period.</p>
     */
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
    public HealthcareProviderBean getPerformerHealthCareProvider() {
        return this.performerHealthCareProvider;
    }

    public void setPerformerHealthCareProvider(HealthcareProviderBean performerHealthCareProvider) {
        this.performerHealthCareProvider = performerHealthCareProvider;
    }


    @Hl7XmlMapping({"referrer/healthCareProvider"})
    public HealthcareProviderBean getReferrerHealthCareProvider() {
        return this.referrerHealthCareProvider;
    }

    public void setReferrerHealthCareProvider(HealthcareProviderBean referrerHealthCareProvider) {
        this.referrerHealthCareProvider = referrerHealthCareProvider;
    }


    @Hl7XmlMapping({"consultant/healthCareProvider"})
    public HealthcareProviderBean getConsultantHealthCareProvider() {
        return this.consultantHealthCareProvider;
    }

    public void setConsultantHealthCareProvider(HealthcareProviderBean consultantHealthCareProvider) {
        this.consultantHealthCareProvider = consultantHealthCareProvider;
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


    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"pertinentInformation"})
    public List<DiagnosisInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

}
