/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementCrossReference","FICR_MT600201CA.InvoiceElementCrossReference"})
public class InvoiceElementCrossReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II crossReferenceIdentifier = new IIImpl();


    /**
     * <p>CrossReferenceIdentifier</p>
     * 
     * <p>Cross Reference Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCrossReferenceIdentifier() {
        return this.crossReferenceIdentifier.getValue();
    }
    public void setCrossReferenceIdentifier(Identifier crossReferenceIdentifier) {
        this.crossReferenceIdentifier.setValue(crossReferenceIdentifier);
    }

}
