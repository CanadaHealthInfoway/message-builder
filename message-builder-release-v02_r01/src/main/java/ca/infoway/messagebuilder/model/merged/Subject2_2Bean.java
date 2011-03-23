/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090310ca.EHRRepositoryBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject2","MFMI_MT700716CA.Subject2"})
public class Subject2_2Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private BL cascadeResponsibilityIndicator = new BLImpl();
    private List<ReplacesBean> registrationRequestReplacementOf = new ArrayList<ReplacesBean>();
    private RR registrationRequestSubjectRegisteredRole;
    private EHRRepositoryBean registrationRequestCustodianAssignedDevice;

    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }

    @Hl7XmlMapping({"registrationRequest/replacementOf"})
    public List<ReplacesBean> getRegistrationRequestReplacementOf() {
        return this.registrationRequestReplacementOf;
    }

    @Hl7XmlMapping({"registrationRequest/subject/registeredRole"})
    public RR getRegistrationRequestSubjectRegisteredRole() {
        return this.registrationRequestSubjectRegisteredRole;
    }
    public void setRegistrationRequestSubjectRegisteredRole(RR registrationRequestSubjectRegisteredRole) {
        this.registrationRequestSubjectRegisteredRole = registrationRequestSubjectRegisteredRole;
    }

    @Hl7XmlMapping({"registrationRequest/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationRequestCustodianAssignedDevice() {
        return this.registrationRequestCustodianAssignedDevice;
    }
    public void setRegistrationRequestCustodianAssignedDevice(EHRRepositoryBean registrationRequestCustodianAssignedDevice) {
        this.registrationRequestCustodianAssignedDevice = registrationRequestCustodianAssignedDevice;
    }

}
