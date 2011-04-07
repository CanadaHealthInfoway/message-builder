/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.Component","MCAI_MT700211CA.Component","MCAI_MT700212CA.Component","QUQI_MT020000CA.Component","QUQI_MT120006CA.Component"})
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS typeCode = new CSImpl();
    private BL contextConductionInd = new BLImpl();
    private ca.infoway.messagebuilder.model.v02_r01.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent;


    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"patientCareProvisionEvent"})
    public ca.infoway.messagebuilder.model.v02_r01.common.coct_mt011001ca.CareCompositionsBean getPatientCareProvisionEvent() {
        return this.patientCareProvisionEvent;
    }
    public void setPatientCareProvisionEvent(ca.infoway.messagebuilder.model.v02_r01.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent) {
        this.patientCareProvisionEvent = patientCareProvisionEvent;
    }

}
