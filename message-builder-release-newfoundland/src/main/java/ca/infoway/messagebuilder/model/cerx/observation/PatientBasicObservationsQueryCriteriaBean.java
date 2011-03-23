package ca.infoway.messagebuilder.model.cerx.observation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "REPC_MT120002CA.ParameterList" })
public class PatientBasicObservationsQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -795480993762933383L;

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private final List<CV> types = Collections.synchronizedList(new ArrayList<CV>());

    private IVL<TS, Interval<Date>> effectivePeriod = new IVLImpl<TS, Interval<Date>>();

    private BL includeNotesIndicator = new BLImpl(false);

    @Override
    @Hl7XmlMapping("patientBirthDate/value")
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Override
    @Hl7XmlMapping("patientGender/value")
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Override
    @Hl7XmlMapping("patientID/value")
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }

    public void setPatientId(Identifier patientID) {
        this.patientId.setValue(patientID);
    }

    @Override
    @Hl7XmlMapping("patientName/value")
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }

    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("measurementEffectivePeriod/value")
    public Interval<Date> getEffectivePeriod() {
        return this.effectivePeriod.getValue();
    }

    public void setEffectivePeriod(Interval<Date> changePeriod) {
        this.effectivePeriod.setValue(changePeriod);
    }

    @Hl7XmlMapping("measurementType/value")
    public List<CommonClinicalObservationType> getTypes() {
    	return new RawListWrapper<CV, CommonClinicalObservationType>(this.types, CVImpl.class);    	
    }
}
