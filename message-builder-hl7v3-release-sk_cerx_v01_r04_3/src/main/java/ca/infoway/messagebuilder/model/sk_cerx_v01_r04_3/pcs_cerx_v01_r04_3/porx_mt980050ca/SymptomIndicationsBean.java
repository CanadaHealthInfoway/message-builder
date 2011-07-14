/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Symptom Indications</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
 * symptom-related indications</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
 * separation of conditions from symptoms from other forms of 
 * indication.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980050CA.ObservationSymptom"})
public class SymptomIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20110714L;
    private CD symptomType = new CDImpl();
    private ST freeFormSymptomIndication = new STImpl();
    private CV symptomCode = new CVImpl();


    /**
     * <p>Symptom Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * the category of symptom being communicated.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that this observation is expressing a symptom, and is 
     * therefore mandatory. It is set to CD because SNOMED codes 
     * may require post-coordination</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">For SNOMED, 
     * this will communicate the full symptom. For non-SNOMED this 
     * will be a fixed value of SYMPT</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getSymptomType() {
        return (ActCode) this.symptomType.getValue();
    }
    public void setSymptomType(ActCode symptomType) {
        this.symptomType.setValue(symptomType);
    }


    /**
     * <p>Free Form Symptom Indication</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A free form 
     * description to augment the specified symptom.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * greater flexibility in specifying indication.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getFreeFormSymptomIndication() {
        return this.freeFormSymptomIndication.getValue();
    }
    public void setFreeFormSymptomIndication(String freeFormSymptomIndication) {
        this.freeFormSymptomIndication.setValue(freeFormSymptomIndication);
    }


    /**
     * <p>A:Symptom Code</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * representation of the symptom that is the reason for the 
     * current therapy.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * cross-checking the use of a therapy against its indication. 
     * Also allows analysis of best practices, etc. The attribute 
     * is optional because it is not used for SNOMED.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public SymptomValue getSymptomCode() {
        return (SymptomValue) this.symptomCode.getValue();
    }
    public void setSymptomCode(SymptomValue symptomCode) {
        this.symptomCode.setValue(symptomCode);
    }

}
