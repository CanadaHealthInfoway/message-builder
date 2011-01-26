/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.Reference","REPC_MT210003CA.Reference","REPC_MT220001CA.Reference","REPC_MT220003CA.Reference","REPC_MT230001CA.Reference","REPC_MT230003CA.Reference"})
public class ReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II referenceRecordLinks = new IIImpl();


    /**
     * <p>ReferenceRecordLinks</p>
     * 
     * <p>L:Reference Record Links</p>
     * 
     * <p><p>These identifiers allow for referencing other discrete 
     * records within the EHR which are considered relevant to the 
     * document as a whole or a particular section.</p></p>
     * 
     * <p><p>The external references allow accessing discrete data 
     * for additional analysis and manipulation such as graphing, 
     * automated comparison or decision-support.</p></p>
     * 
     * <p><p>For sections, the links may refer specifically to 
     * records which have been rendered as part of the section.</p></p>
     * 
     * <p>L:Reference Record Links</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReferenceRecordLinks() {
        return this.referenceRecordLinks.getValue();
    }
    public void setReferenceRecordLinks(Identifier referenceRecordLinks) {
        this.referenceRecordLinks.setValue(referenceRecordLinks);
    }

}
