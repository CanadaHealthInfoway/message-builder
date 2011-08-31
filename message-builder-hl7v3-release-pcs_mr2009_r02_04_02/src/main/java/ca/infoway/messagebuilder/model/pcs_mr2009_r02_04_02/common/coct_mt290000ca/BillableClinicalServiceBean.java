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



/**
 * <p>Billable Clinical Service</p>
 * 
 * <p><p>Service which was provided and is referenced in this 
 * encounter</p></p>
 * 
 * <p><p>Patient classes are not referenced in the billable 
 * acts, as they are noted in the parent model (e.g. Invoice 
 * message) as the CoveredPartyAsPatient</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.BillableClinicalService"})
@Hl7RootType
public class BillableClinicalServiceBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20110831L;
    private II serviceEventID = new IIImpl();
    private CV procedureCode = new CVImpl();
    private IVL<TS, Interval<Date>> durationDateTimeOfOccurrence = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> serviceReason = new SETImpl<CV, Code>(CVImpl.class);
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
     * <p>Service event ID</p>
     * 
     * <p><p>Can be used to uniquely identify a service event</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceEventID() {
        return this.serviceEventID.getValue();
    }
    public void setServiceEventID(Identifier serviceEventID) {
        this.serviceEventID.setValue(serviceEventID);
    }


    /**
     * <p>Procedure code</p>
     * 
     * <p><p>procedure cd, CPT cd, supply cd</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getProcedureCode() {
        return (Code) this.procedureCode.getValue();
    }
    public void setProcedureCode(Code procedureCode) {
        this.procedureCode.setValue(procedureCode);
    }


    /**
     * <p>Duration, date/time of occurrence</p>
     * 
     * <p><p>Duration, date/time of occurrence</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDurationDateTimeOfOccurrence() {
        return this.durationDateTimeOfOccurrence.getValue();
    }
    public void setDurationDateTimeOfOccurrence(Interval<Date> durationDateTimeOfOccurrence) {
        this.durationDateTimeOfOccurrence.setValue(durationDateTimeOfOccurrence);
    }


    /**
     * <p>Service Reason</p>
     * 
     * <p><p>clinical reasons for service, not related or specified 
     * by diagnosis. e.g. duplicate therapy, fraudulent 
     * prescription</p></p>
     * 
     * <p><p>(clinical reasons for service, not related or 
     * specified by a diagnosis e.g. duplicate therapy, fraudulent 
     * prescription</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Set<Code> getServiceReason() {
        return this.serviceReason.rawSet(Code.class);
    }


    @Hl7XmlMapping({"product/manufacturedProduct"})
    public List<ManufacturedProductBean> getProductManufacturedProduct() {
        return this.productManufacturedProduct;
    }


    @Hl7XmlMapping({"secondaryPerformer/healthCareProvider"})
    public HealthcareProviderBean getSecondaryPerformerHealthCareProvider() {
        return this.secondaryPerformerHealthCareProvider;
    }
    public void setSecondaryPerformerHealthCareProvider(HealthcareProviderBean secondaryPerformerHealthCareProvider) {
        this.secondaryPerformerHealthCareProvider = secondaryPerformerHealthCareProvider;
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


    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"pertinentInformation1"})
    public List<AccidentInformationBean> getPertinentInformation1() {
        return this.pertinentInformation1;
    }


    @Hl7XmlMapping({"pertinentInformation2/patientEncounter"})
    public PatientEncounterBean getPertinentInformation2PatientEncounter() {
        return this.pertinentInformation2PatientEncounter;
    }
    public void setPertinentInformation2PatientEncounter(PatientEncounterBean pertinentInformation2PatientEncounter) {
        this.pertinentInformation2PatientEncounter = pertinentInformation2PatientEncounter;
    }


    @Hl7XmlMapping({"pertinentInformation3"})
    public List<DiagnosisInformationBean> getPertinentInformation3() {
        return this.pertinentInformation3;
    }

}
