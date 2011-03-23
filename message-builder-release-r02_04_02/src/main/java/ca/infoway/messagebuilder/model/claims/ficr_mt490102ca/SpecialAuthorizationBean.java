/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.MaximumLimitsBean;
import ca.infoway.messagebuilder.model.merged.Subject3Bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490102CA.SpecialAuthorization"})
public class SpecialAuthorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CS specialAuthorizationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> specialAuthorizationEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private HealthcareOrganizationBean authorAssignedEntity;
    private List<Subject3Bean> subject = new ArrayList<Subject3Bean>();
    private PolicyOrAccountBean coveragePolicyOrAccount;
    private RemainingLimitsBean limitation1RemainingLimits;
    private MaximumLimitsBean limitation2MaximumLimits;
    private List<HasNotesBean> subjectOf = new ArrayList<HasNotesBean>();

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getSpecialAuthorizationStatus() {
        return (ActStatus) this.specialAuthorizationStatus.getValue();
    }
    public void setSpecialAuthorizationStatus(ActStatus specialAuthorizationStatus) {
        this.specialAuthorizationStatus.setValue(specialAuthorizationStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSpecialAuthorizationEffectiveDate() {
        return this.specialAuthorizationEffectiveDate.getValue();
    }
    public void setSpecialAuthorizationEffectiveDate(Interval<Date> specialAuthorizationEffectiveDate) {
        this.specialAuthorizationEffectiveDate.setValue(specialAuthorizationEffectiveDate);
    }

    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareOrganizationBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareOrganizationBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }

    @Hl7XmlMapping({"subject"})
    public List<Subject3Bean> getSubject() {
        return this.subject;
    }

    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccountBean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }
    public void setCoveragePolicyOrAccount(PolicyOrAccountBean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }

    @Hl7XmlMapping({"limitation1/remainingLimits"})
    public RemainingLimitsBean getLimitation1RemainingLimits() {
        return this.limitation1RemainingLimits;
    }
    public void setLimitation1RemainingLimits(RemainingLimitsBean limitation1RemainingLimits) {
        this.limitation1RemainingLimits = limitation1RemainingLimits;
    }

    @Hl7XmlMapping({"limitation2/maximumLimits"})
    public MaximumLimitsBean getLimitation2MaximumLimits() {
        return this.limitation2MaximumLimits;
    }
    public void setLimitation2MaximumLimits(MaximumLimitsBean limitation2MaximumLimits) {
        this.limitation2MaximumLimits = limitation2MaximumLimits;
    }

    @Hl7XmlMapping({"subjectOf"})
    public List<HasNotesBean> getSubjectOf() {
        return this.subjectOf;
    }

}
