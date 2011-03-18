/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>CareCompositions</p>
 * 
 * <p>QUQI_MT020000CA.Component: Care Compositions</p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p></p>
 * 
 * <p>MCAI_MT700211CA.Component: Care Compositions</p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p></p>
 * 
 * <p>MCAI_MT700210CA.Component: Care Compositions</p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p></p>
 * 
 * <p>QUQI_MT120006CA.Component: Care Compositions</p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p></p>
 * 
 * <p><p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p></p>
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Component","MCAI_MT700211CA.Component","QUQI_MT020000CA.Component","QUQI_MT120006CA.Component"})
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ca.infoway.messagebuilder.model.v02_r02.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent;
    private BL contextConductionInd = new BLImpl();
    private CS typeCode = new CSImpl();


    @Hl7XmlMapping({"patientCareProvisionEvent"})
    public ca.infoway.messagebuilder.model.v02_r02.common.coct_mt011001ca.CareCompositionsBean getPatientCareProvisionEvent() {
        return this.patientCareProvisionEvent;
    }
    public void setPatientCareProvisionEvent(ca.infoway.messagebuilder.model.v02_r02.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent) {
        this.patientCareProvisionEvent = patientCareProvisionEvent;
    }


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }

}
