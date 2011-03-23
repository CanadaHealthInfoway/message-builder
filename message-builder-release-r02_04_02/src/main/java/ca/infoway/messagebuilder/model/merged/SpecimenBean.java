/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT500001CA.Specimen","REPC_MT500002CA.Specimen","REPC_MT500003CA.Specimen","REPC_MT500004CA.Specimen"})
public class SpecimenBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private ST focusArea = new STImpl();

    @Hl7XmlMapping({"specimenMaterial/desc"})
    public String getFocusArea() {
        return this.focusArea.getValue();
    }
    public void setFocusArea(String focusArea) {
        this.focusArea.setValue(focusArea);
    }

}
