/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>RefersTo</p>
 * 
 * <p>MCAI_MT700210CA.Subject2: f:refers to</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the item(s) being acted upon by this trigger event.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * information about the thing being created or modified.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If there are 
 * multiple subject items, the changes to all of them must be 
 * either accepted or rejected as a single action. I.e. One 
 * trigger event = 1 unit of work.</p></p>
 * 
 * <p>MCAI_MT700211CA.Subject2: f:refers to</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the item(s) being acted upon by this trigger event.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * information about the thing being created or modified.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If there are 
 * multiple subject items, the changes to all of them must be 
 * either accepted or rejected as a single action. I.e. One 
 * trigger event = 1 unit of work.</p></p>
 * 
 * <p>MCAI_MT700221CA.Subject2: f:refers to</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the item(s) being acted upon by this trigger event.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * information about the thing being created or modified.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If there are 
 * multiple subject items, the changes to all of them must be 
 * either accepted or rejected as a single action. I.e. One 
 * trigger event = 1 unit of work.</p></p>
 * 
 * <p>QUQI_MT120000CA.Subject2: f:refers to</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the item(s) being acted upon by this trigger event.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * information about the thing being created or modified.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If there are 
 * multiple subject items, the changes to all of them must be 
 * either accepted or rejected as a single action. I.e. One 
 * trigger event = 1 unit of work.</p></p>
 * 
 * <p>MCAI_MT700220CA.Subject2: f:refers to</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * the item(s) being acted upon by this trigger event.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * information about the thing being created or modified.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If there are 
 * multiple subject items, the changes to all of them must be 
 * either accepted or rejected as a single action. I.e. One 
 * trigger event = 1 unit of work.</p></p>
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject2","MCAI_MT700211CA.Subject2","MCAI_MT700220CA.Subject2","MCAI_MT700221CA.Subject2","QUQI_MT120000CA.Subject2"})
public class RefersToBean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private BL cascadeResponsibilityIndicator = new BLImpl();
    private ACT act;


    /**
     * <p>CascadeResponsibilityIndicator</p>
     * 
     * <p>Cascade Responsibility Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether or not objects of the trigger event are to be 
     * cascaded to the payload.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Cascading of 
     * trigger event objects allows different messages to employ 
     * consistent and common objects.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Attribute is 
     * mandatory to ensure that cascading will be specified one way 
     * or another.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Cascading of 
     * trigger event objects allows different messages to employ 
     * consistent and common objects.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Attribute is 
     * mandatory to ensure that cascading will be specified one way 
     * or another.</p></p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }


    @Hl7XmlMapping({"act"})
    public ACT getAct() {
        return this.act;
    }
    public void setAct(ACT act) {
        this.act = act;
    }

}
