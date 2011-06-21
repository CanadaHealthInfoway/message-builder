/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Other indications</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
 * indications that are not diagnosis or symptom-related (e.g. 
 * contrast agents)</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * separation of conditions from symptoms from other forms of 
 * indication.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980050CA.OtherIndication"})
public class OtherIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20110621L;
    private CV otherIndication = new CVImpl();
    private ST otherIndicationAdHocDescription = new STImpl();


    /**
     * <p>Other Indication</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A code 
     * indicating some other action which is the reason for a 
     * therapy.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * coded representation of a non-condition based indication 
     * such as administration of a contrast agent for a lab 
     * test.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActNonConditionIndicationCode getOtherIndication() {
        return (ActNonConditionIndicationCode) this.otherIndication.getValue();
    }
    public void setOtherIndication(ActNonConditionIndicationCode otherIndication) {
        this.otherIndication.setValue(otherIndication);
    }


    /**
     * <p>Other indication ad-hoc description</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A textual 
     * description of an indication not meant to be either 
     * diagnosis or symptom.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * ability to describe indication without labeling it a 
     * diagnosis or symptom. Attribute as free form text is the 
     * only information allowed.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getOtherIndicationAdHocDescription() {
        return this.otherIndicationAdHocDescription.getValue();
    }
    public void setOtherIndicationAdHocDescription(String otherIndicationAdHocDescription) {
        this.otherIndicationAdHocDescription.setValue(otherIndicationAdHocDescription);
    }

}
