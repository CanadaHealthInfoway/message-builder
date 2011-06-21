/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.poiz_mt030050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.x_InformationSource;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.InformantionSourceRole"})
public class InformantionSourceRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CS informationSource = new CSImpl();


    /**
     * <p>Information Source</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a patient, patient's agent, or a provider as 
     * the source of the recorded immunization information.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the explicit identification of the source of the recorded 
     * information.</p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_InformationSource getInformationSource() {
        return (x_InformationSource) this.informationSource.getValue();
    }
    public void setInformationSource(x_InformationSource informationSource) {
        this.informationSource.setValue(informationSource);
    }

}
