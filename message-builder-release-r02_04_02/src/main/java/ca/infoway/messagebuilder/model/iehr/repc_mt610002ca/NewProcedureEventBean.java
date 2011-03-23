/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt610002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT610002CA.NewProcedureEvent"})
public class NewProcedureEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II replacedByRecordId = new IIImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getReplacedByRecordId() {
        return this.replacedByRecordId.getValue();
    }
    public void setReplacedByRecordId(Identifier replacedByRecordId) {
        this.replacedByRecordId.setValue(replacedByRecordId);
    }

}
