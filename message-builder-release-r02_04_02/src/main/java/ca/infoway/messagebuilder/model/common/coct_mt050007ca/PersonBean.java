/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.OtherIdentifiersBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT050007CA.Person"})
public class PersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private PN patientName = new PNImpl();
    private CV patientGender = new CVImpl();
    private TS patientBirthDatetime = new TSImpl();
    private BL patientDeceasedIndicator = new BLImpl();
    private TS patientDeceasedDatetime = new TSImpl();
    private List<OtherIdentifiersBean> asIdentifiedEntity = new ArrayList<OtherIdentifiersBean>();

    @Hl7XmlMapping({"name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Hl7XmlMapping({"birthTime"})
    public Date getPatientBirthDatetime() {
        return this.patientBirthDatetime.getValue();
    }
    public void setPatientBirthDatetime(Date patientBirthDatetime) {
        this.patientBirthDatetime.setValue(patientBirthDatetime);
    }

    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getPatientDeceasedIndicator() {
        return this.patientDeceasedIndicator.getValue();
    }
    public void setPatientDeceasedIndicator(Boolean patientDeceasedIndicator) {
        this.patientDeceasedIndicator.setValue(patientDeceasedIndicator);
    }

    @Hl7XmlMapping({"deceasedTime"})
    public Date getPatientDeceasedDatetime() {
        return this.patientDeceasedDatetime.getValue();
    }
    public void setPatientDeceasedDatetime(Date patientDeceasedDatetime) {
        this.patientDeceasedDatetime.setValue(patientDeceasedDatetime);
    }

    @Hl7XmlMapping({"asIdentifiedEntity"})
    public List<OtherIdentifiersBean> getAsIdentifiedEntity() {
        return this.asIdentifiedEntity;
    }

}
