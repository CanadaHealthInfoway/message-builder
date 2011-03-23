/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt610001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.common.coct_mt911107ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.merged.ActRequest_5Bean;
import ca.infoway.messagebuilder.model.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.merged.ClinicalDocumentEventBean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.merged.OldProcedureEventBean;
import ca.infoway.messagebuilder.model.merged.Patient_1Bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Professional Service</p>
 * 
 * <p>This is the information that is recorded and maintained 
 * on a consultative, surgical or physical service (procedure) 
 * provided to the patient.</p>
 * 
 * <p>Counseling, education, surgeries and physical therapy are 
 * examples of the types of services that can be captured.</p>
 * 
 * <p>Information about surgeries, councilling and other 
 * professional services is a key element of the EHR. It 
 * provides context around services provided and may inform 
 * choices about how best to manage the patient's healthcare.</p>
 * 
 * <p>A_BillableClinicalService</p>
 */
@Hl7PartTypeMapping({"REPC_MT610001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CD serviceType = new CDImpl();
    private BL refutedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> serviceTimeAndLength = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> serviceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private List<ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean> performerActingPerson = new ArrayList<ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean>();
    private ActingPersonBean informantActingPerson;
    private OccurredAtBean location;
    private ActRequest_5Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldProcedureEventBean> predecessorOldProcedureEvent = new ArrayList<OldProcedureEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private HasNotesBean subjectOf1;
    private ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();

    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getServiceType() {
        return (ActProfessionalServiceCode) this.serviceType.getValue();
    }
    public void setServiceType(ActProfessionalServiceCode serviceType) {
        this.serviceType.setValue(serviceType);
    }

    @Hl7XmlMapping({"negationInd"})
    public Boolean getRefutedIndicator() {
        return this.refutedIndicator.getValue();
    }
    public void setRefutedIndicator(Boolean refutedIndicator) {
        this.refutedIndicator.setValue(refutedIndicator);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getServiceTimeAndLength() {
        return this.serviceTimeAndLength.getValue();
    }
    public void setServiceTimeAndLength(Interval<Date> serviceTimeAndLength) {
        this.serviceTimeAndLength.setValue(serviceTimeAndLength);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getServiceMaskingIndicators() {
        return this.serviceMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }

    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean> getPerformerActingPerson() {
        return this.performerActingPerson;
    }

    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPersonBean getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ActingPersonBean informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareWorkerBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public Patient_1Bean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof Patient_1Bean ? (Patient_1Bean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof Patient_1Bean);
    }

    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public ActRequest_5Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(ActRequest_5Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }

    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }

    @Hl7XmlMapping({"predecessor/oldProcedureEvent"})
    public List<OldProcedureEventBean> getPredecessorOldProcedureEvent() {
        return this.predecessorOldProcedureEvent;
    }

    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }

    @Hl7XmlMapping({"subjectOf1"})
    public HasNotesBean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(HasNotesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }

    @Hl7XmlMapping({"subjectOf2/clinicalDocumentEvent"})
    public ClinicalDocumentEventBean getSubjectOf2ClinicalDocumentEvent() {
        return this.subjectOf2ClinicalDocumentEvent;
    }
    public void setSubjectOf2ClinicalDocumentEvent(ClinicalDocumentEventBean subjectOf2ClinicalDocumentEvent) {
        this.subjectOf2ClinicalDocumentEvent = subjectOf2ClinicalDocumentEvent;
    }

    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
