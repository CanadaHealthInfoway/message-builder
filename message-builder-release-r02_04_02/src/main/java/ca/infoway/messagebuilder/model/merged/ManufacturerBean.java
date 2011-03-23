/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220110CA.Manufacturer","COCT_MT220210CA.Manufacturer","POIZ_MT030050CA.Manufacturer","POIZ_MT030060CA.Manufacturer","POIZ_MT060150CA.Manufacturer","POIZ_MT061150CA.Manufacturer","POME_MT010040CA.Manufacturer","POME_MT010100CA.Manufacturer"})
public class ManufacturerBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II manufacturerID = new IIImpl();
    private ST manufacturerName = new STImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getManufacturerID() {
        return this.manufacturerID.getValue();
    }
    public void setManufacturerID(Identifier manufacturerID) {
        this.manufacturerID.setValue(manufacturerID);
    }

    @Hl7XmlMapping({"name"})
    public String getManufacturerName() {
        return this.manufacturerName.getValue();
    }
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName.setValue(manufacturerName);
    }

}
