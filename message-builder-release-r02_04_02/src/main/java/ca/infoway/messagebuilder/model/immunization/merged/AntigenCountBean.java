/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AntigenCount</p>
 * 
 * <p>POIZ_MT030050CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 * 
 * <p>POIZ_MT060150CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 * 
 * <p>POIZ_MT030060CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AntigenCount","POIZ_MT030060CA.AntigenCount","POIZ_MT060150CA.AntigenCount"})
public class AntigenCountBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private INT antigenCountValue = new INTImpl();


    /**
     * <p>AntigenCountValue</p>
     * 
     * <p>Antigen Count Value</p>
     * 
     * <p><p>Represents the asserted antigen count.</p></p>
     * 
     * <p><p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Integer getAntigenCountValue() {
        return this.antigenCountValue.getValue();
    }
    public void setAntigenCountValue(Integer antigenCountValue) {
        this.antigenCountValue.setValue(antigenCountValue);
    }

}
