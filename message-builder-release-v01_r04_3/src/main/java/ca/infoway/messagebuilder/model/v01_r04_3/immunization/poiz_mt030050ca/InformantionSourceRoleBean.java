/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.immunization.poiz_mt030050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.x_InformationSource;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.InformantionSourceRole"})
public class InformantionSourceRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CS informationSource = new CSImpl();


    /**
     * <p>Information Source</p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_InformationSource getInformationSource() {
        return (x_InformationSource) this.informationSource.getValue();
    }
    public void setInformationSource(x_InformationSource informationSource) {
        this.informationSource.setValue(informationSource);
    }

}