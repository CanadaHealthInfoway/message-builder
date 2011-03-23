/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mfmi_mt700717ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090310ca.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.merged.PriorRegistrationEventBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>f:refers to</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p>
 * 
 * <p>Will be mandatory in wrappers with payload messages, 
 * otherwise not present.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>On '''creation''' interactions (where the state 
 * transition is null->active), this must be true otherwise it 
 * must be false.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700717CA.Subject2"})
public class RefersToBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private BL cascadeResponsibilityIndicator = new BLImpl();
    private EHRRepositoryBean registrationEventCustodianAssignedDevice;
    private List<PriorRegistrationEventBean> registrationEventReplacementOfPriorRegistration = new ArrayList<PriorRegistrationEventBean>();
    private RR registrationEventSubjectRegisteredRole;

    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }

    @Hl7XmlMapping({"registrationEvent/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationEventCustodianAssignedDevice() {
        return this.registrationEventCustodianAssignedDevice;
    }
    public void setRegistrationEventCustodianAssignedDevice(EHRRepositoryBean registrationEventCustodianAssignedDevice) {
        this.registrationEventCustodianAssignedDevice = registrationEventCustodianAssignedDevice;
    }

    @Hl7XmlMapping({"registrationEvent/replacementOf/priorRegistration"})
    public List<PriorRegistrationEventBean> getRegistrationEventReplacementOfPriorRegistration() {
        return this.registrationEventReplacementOfPriorRegistration;
    }

    @Hl7XmlMapping({"registrationEvent/subject/registeredRole"})
    public RR getRegistrationEventSubjectRegisteredRole() {
        return this.registrationEventSubjectRegisteredRole;
    }
    public void setRegistrationEventSubjectRegisteredRole(RR registrationEventSubjectRegisteredRole) {
        this.registrationEventSubjectRegisteredRole = registrationEventSubjectRegisteredRole;
    }

}
