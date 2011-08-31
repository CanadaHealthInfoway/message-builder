/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POLB_MT004200CA.ActRequest"})
public class ActRequestBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.FulfillmentChoice {

    private static final long serialVersionUID = 20110831L;
    private II actRequestReference = new IIImpl();


    /**
     * <p>Act Request Reference</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getActRequestReference() {
        return this.actRequestReference.getValue();
    }
    public void setActRequestReference(Identifier actRequestReference) {
        this.actRequestReference.setValue(actRequestReference);
    }

}
