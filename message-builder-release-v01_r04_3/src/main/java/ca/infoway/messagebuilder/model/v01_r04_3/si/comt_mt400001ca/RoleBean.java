/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.si.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COMT_MT400001CA.Role"})
public class RoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV maskableMaterial = new CVImpl();


    /**
     * <p>Maskable Material</p>
     */
    @Hl7XmlMapping({"playingEntityKind/code"})
    public MaskableMaterialEntityType getMaskableMaterial() {
        return (MaskableMaterialEntityType) this.maskableMaterial.getValue();
    }
    public void setMaskableMaterial(MaskableMaterialEntityType maskableMaterial) {
        this.maskableMaterial.setValue(maskableMaterial);
    }

}
