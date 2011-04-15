package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

public class PersonNameBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 5314758781647785313L;

    private ST firstName = new STImpl();

    private ST lastName = new STImpl();

    public String getFirstName() {
        return this.firstName.getValue();
    }

    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    public String getLastName() {
        return this.lastName.getValue();
    }

    public void setLastName(String lastName) {
        this.lastName.setValue(lastName);
    }
}
