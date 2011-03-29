/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.OldClinicalDocumentEvent","REPC_MT210002CA.OldClinicalDocumentEvent","REPC_MT210003CA.OldClinicalDocumentEvent","REPC_MT220001CA.OldClinicalDocumentEvent","REPC_MT220002CA.OldClinicalDocumentEvent","REPC_MT220003CA.OldClinicalDocumentEvent","REPC_MT230001CA.OldClinicalDocumentEvent","REPC_MT230002CA.OldClinicalDocumentEvent","REPC_MT230003CA.OldClinicalDocumentEvent"})
public class OldClinicalDocumentEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II replacesRecordIds = new IIImpl();


    /**
     * <p>ReplacesRecordIds</p>
     * 
     * <p>G:Replaces Record Ids</p>
     * 
     * <p>G:Replaces Record Ids</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>G:Replaces Record Ids</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>G:Replaces Record Ids</p>
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