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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt290000ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.DiagnosisInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareProviderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ManufacturedProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.PatientEncounterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActBillableClinicalServiceReason;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActProcedureCode;



/**
 * <p>Business Name: Billable Clinical Service</p>
 * 
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient</p>
 * 
 * <p>Service which was provided and is referenced in this 
 * encounter</p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.BillableClinicalService"})
@Hl7RootType
public class BillableClinicalServiceBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20130307L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> reasonCode = new SETImpl<CV, Code>(CVImpl.class);
    private List<ManufacturedProductBean> productManufacturedProduct = new ArrayList<ManufacturedProductBean>();
    private HealthcareProviderBean secondaryPerformerHealthCareProvider;
    private HealthcareProviderBean performerHealthCareProvider;
    private HealthcareProviderBean referrerHealthCareProvider;
    private HealthcareProviderBean consultantHealthCareProvider;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<AccidentInformationBean> pertinentInformation1 = new ArrayList<AccidentInformationBean>();
    private PatientEncounterBean pertinentInformation2PatientEncounter;
    private List<DiagnosisInformationBean> pertinentInformation3 = new ArrayList<DiagnosisInformationBean>();


    /**
     * <p>Business Name: Service event ID</p>
     * 
     * <p>Relationship: COCT_MT290000CA.BillableClinicalService.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to uniquely identify a service event</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Service event ID</p>
     * 
     * <p>Relationship: COCT_MT290000CA.BillableClinicalService.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to uniquely identify a service event</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Procedure code</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>procedure cd, CPT cd, supply cd</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProcedureCode getCode() {
        return (ActProcedureCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Procedure code</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>procedure cd, CPT cd, supply cd</p>
     */
    public void setCode(ActProcedureCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Duration, date/time of occurrence</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Duration, date/time of occurrence</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Duration, date/time of occurrence</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Duration, date/time of occurrence</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Service Reason</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>(clinical reasons for service, not related or specified 
     * by a diagnosis e.g. duplicate therapy, fraudulent 
     * prescription</p>
     * 
     * <p>clinical reasons for service, not related or specified by 
     * diagnosis. e.g. duplicate therapy, fraudulent 
     * prescription</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Set<ActBillableClinicalServiceReason> getReasonCode() {
        return this.reasonCode.rawSet(ActBillableClinicalServiceReason.class);
    }


    /**
     * <p>Relationship: COCT_MT290000CA.Product.manufacturedProduct</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"product/manufacturedProduct"})
    public List<ManufacturedProductBean> getProductManufacturedProduct() {
        return this.productManufacturedProduct;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ProviderSupervisor.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"secondaryPerformer/healthCareProvider"})
    public HealthcareProviderBean getSecondaryPerformerHealthCareProvider() {
        return this.secondaryPerformerHealthCareProvider;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ProviderSupervisor.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSecondaryPerformerHealthCareProvider(HealthcareProviderBean secondaryPerformerHealthCareProvider) {
        this.secondaryPerformerHealthCareProvider = secondaryPerformerHealthCareProvider;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ResponsibleProvider.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"performer/healthCareProvider"})
    public HealthcareProviderBean getPerformerHealthCareProvider() {
        return this.performerHealthCareProvider;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ResponsibleProvider.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPerformerHealthCareProvider(HealthcareProviderBean performerHealthCareProvider) {
        this.performerHealthCareProvider = performerHealthCareProvider;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ServiceReferrer.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"referrer/healthCareProvider"})
    public HealthcareProviderBean getReferrerHealthCareProvider() {
        return this.referrerHealthCareProvider;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ServiceReferrer.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setReferrerHealthCareProvider(HealthcareProviderBean referrerHealthCareProvider) {
        this.referrerHealthCareProvider = referrerHealthCareProvider;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.Consultant.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"consultant/healthCareProvider"})
    public HealthcareProviderBean getConsultantHealthCareProvider() {
        return this.consultantHealthCareProvider;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.Consultant.healthCareProvider</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConsultantHealthCareProvider(HealthcareProviderBean consultantHealthCareProvider) {
        this.consultantHealthCareProvider = consultantHealthCareProvider;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ServiceLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.ServiceLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.pertinentInformation1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"pertinentInformation1"})
    public List<AccidentInformationBean> getPertinentInformation1() {
        return this.pertinentInformation1;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.EncounterInformation.patientEncounter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation2/patientEncounter"})
    public PatientEncounterBean getPertinentInformation2PatientEncounter() {
        return this.pertinentInformation2PatientEncounter;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.EncounterInformation.patientEncounter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPertinentInformation2PatientEncounter(PatientEncounterBean pertinentInformation2PatientEncounter) {
        this.pertinentInformation2PatientEncounter = pertinentInformation2PatientEncounter;
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.BillableClinicalService.pertinentInformation3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     */
    @Hl7XmlMapping({"pertinentInformation3"})
    public List<DiagnosisInformationBean> getPertinentInformation3() {
        return this.pertinentInformation3;
    }

}
