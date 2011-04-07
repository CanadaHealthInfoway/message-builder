/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged.ProtocolsBean;



/**
 * <p>references</p>
 * 
 * <p><p>Enables the communication of a reference to a 
 * protocol, study or guideline id, specific to the 
 * jurisdiction;</p></p>
 * 
 * <p><p>Provides support for non-traditional therapies. Needed 
 * when seeking to prescribe '''Special Access''' medications, 
 * for example, Ontario Limited Use.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Definition"})
public class ReferencesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private BL contextConductionInd = new BLImpl();
    private ProtocolsBean substanceAdministrationDefinition;


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"substanceAdministrationDefinition"})
    public ProtocolsBean getSubstanceAdministrationDefinition() {
        return this.substanceAdministrationDefinition;
    }
    public void setSubstanceAdministrationDefinition(ProtocolsBean substanceAdministrationDefinition) {
        this.substanceAdministrationDefinition = substanceAdministrationDefinition;
    }

}
