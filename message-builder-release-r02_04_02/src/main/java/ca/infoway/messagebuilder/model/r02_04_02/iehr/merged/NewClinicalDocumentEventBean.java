/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210002CA.NewClinicalDocumentEvent","REPC_MT210003CA.NewClinicalDocumentEvent","REPC_MT220002CA.NewClinicalDocumentEvent","REPC_MT220003CA.NewClinicalDocumentEvent","REPC_MT230002CA.NewClinicalDocumentEvent","REPC_MT230003CA.NewClinicalDocumentEvent"})
public class NewClinicalDocumentEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II replacedByRecordId = new IIImpl();


    /**
     * <p>ReplacedByRecordId</p>
     * 
     * <p>H:Replaced by Record Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>H:Replaced by Record Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>H:Replaced by Record Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReplacedByRecordId() {
        return this.replacedByRecordId.getValue();
    }
    public void setReplacedByRecordId(Identifier replacedByRecordId) {
        this.replacedByRecordId.setValue(replacedByRecordId);
    }

}
