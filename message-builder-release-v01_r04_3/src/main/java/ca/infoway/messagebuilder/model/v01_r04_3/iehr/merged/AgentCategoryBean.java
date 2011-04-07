/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT000002CA.MaterialKind","REPC_MT000006CA.MaterialKind","REPC_MT000012CA.MaterialKind"})
public class AgentCategoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV exposedMaterialType = new CVImpl();
    private ST exposedMaterialName = new STImpl();


    /**
     * <p>ExposedMaterialType</p>
     * 
     * <p>A:Exposed Material Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ExposureAgentEntityType getExposedMaterialType() {
        return (ExposureAgentEntityType) this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }


    /**
     * <p>ExposedMaterialName</p>
     * 
     * <p>Exposed Material Name</p>
     */
    @Hl7XmlMapping({"name"})
    public String getExposedMaterialName() {
        return this.exposedMaterialName.getValue();
    }
    public void setExposedMaterialName(String exposedMaterialName) {
        this.exposedMaterialName.setValue(exposedMaterialName);
    }

}
