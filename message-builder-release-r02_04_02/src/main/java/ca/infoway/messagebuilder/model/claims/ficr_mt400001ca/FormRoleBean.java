/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.FormRole"})
public class FormRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private II formNumberVersion = new IIImpl();


    /**
     * <p>Form Number + Version</p>
     */
    @Hl7XmlMapping({"playingForm/id"})
    public Identifier getFormNumberVersion() {
        return this.formNumberVersion.getValue();
    }
    public void setFormNumberVersion(Identifier formNumberVersion) {
        this.formNumberVersion.setValue(formNumberVersion);
    }

}
