/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POIZ_MT030050CA.Informant","POIZ_MT030060CA.Informant"})
public class InformantBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private IVL<TS, Interval<Date>> dateOfInformation = new IVLImpl<TS, Interval<Date>>();
    private CV informationSourceForm = new CVImpl();
    private InformationSourceChoiceBean informationSourceChoice;

    @Hl7XmlMapping({"time"})
    public Interval<Date> getDateOfInformation() {
        return this.dateOfInformation.getValue();
    }
    public void setDateOfInformation(Interval<Date> dateOfInformation) {
        this.dateOfInformation.setValue(dateOfInformation);
    }

    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationSourceForm() {
        return (ParticipationMode) this.informationSourceForm.getValue();
    }
    public void setInformationSourceForm(ParticipationMode informationSourceForm) {
        this.informationSourceForm.setValue(informationSourceForm);
    }

    @Hl7XmlMapping({"informationSourceChoice"})
    public InformationSourceChoiceBean getInformationSourceChoice() {
        return this.informationSourceChoice;
    }
    public void setInformationSourceChoice(InformationSourceChoiceBean informationSourceChoice) {
        this.informationSourceChoice = informationSourceChoice;
    }

    public PersonalRelationshipRoleBean getInformationSourceChoiceAsPersonalRelationshipRole() {
        return this.informationSourceChoice instanceof PersonalRelationshipRoleBean ? (PersonalRelationshipRoleBean) this.informationSourceChoice : null;
    }
    public boolean hasInformationSourceChoiceAsPersonalRelationshipRole() {
        return (this.informationSourceChoice instanceof PersonalRelationshipRoleBean);
    }

    public LicensedEntityRoleBean getInformationSourceChoiceAsLicensedEntityRole() {
        return this.informationSourceChoice instanceof LicensedEntityRoleBean ? (LicensedEntityRoleBean) this.informationSourceChoice : null;
    }
    public boolean hasInformationSourceChoiceAsLicensedEntityRole() {
        return (this.informationSourceChoice instanceof LicensedEntityRoleBean);
    }

    public PatientRoleBean getInformationSourceChoiceAsPatientRole() {
        return this.informationSourceChoice instanceof PatientRoleBean ? (PatientRoleBean) this.informationSourceChoice : null;
    }
    public boolean hasInformationSourceChoiceAsPatientRole() {
        return (this.informationSourceChoice instanceof PatientRoleBean);
    }

}
