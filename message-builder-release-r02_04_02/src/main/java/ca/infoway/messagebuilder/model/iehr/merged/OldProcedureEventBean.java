/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT610001CA.OldProcedureEvent","REPC_MT610002CA.OldProcedureEvent"})
public class OldProcedureEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II replacesRecordIds = new IIImpl();


    /**
     * <p>ReplacesRecordIds</p>
     * 
     * <p>H:Replaces Record Ids</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReplacesRecordIds() {
        return this.replacesRecordIds.getValue();
    }
    public void setReplacesRecordIds(Identifier replacesRecordIds) {
        this.replacesRecordIds.setValue(replacesRecordIds);
    }

}
