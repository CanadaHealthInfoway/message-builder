package ca.infoway.messagebuilder.model.cerx;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.QueryCriteria;

public abstract class PatientQueryCriteria extends QueryCriteria {

    private static final long serialVersionUID = -7329016267310522056L;

    public abstract Identifier getPatientId();

    public abstract PersonName getPatientName();

    public abstract Date getPatientBirthDate();

    public abstract AdministrativeGender getPatientGender();
}
