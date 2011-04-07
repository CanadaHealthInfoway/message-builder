/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Sensitivity Battery</p>
 * 
 * <p><p>This act &quot;groups&quot; all the sensitivity tests 
 * performed on a particular isolate. The battery may be made 
 * up of individual sensitivity tests using all the same 
 * testing method or using differing methods.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.SensitivityBattery"})
public class SensitivityBatteryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CD sensitivityBatteryType = new CDImpl();
    private List<AntibioticSensitivityObservationBean> componentSensitivityObservationEvent = new ArrayList<AntibioticSensitivityObservationBean>();


    /**
     * <p>Sensitivity Battery Type</p>
     * 
     * <p><p>Generally describes the sensitivity battery being 
     * performed, e.g. viral, microbial, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getSensitivityBatteryType() {
        return (Code) this.sensitivityBatteryType.getValue();
    }
    public void setSensitivityBatteryType(Code sensitivityBatteryType) {
        this.sensitivityBatteryType.setValue(sensitivityBatteryType);
    }


    @Hl7XmlMapping({"component/sensitivityObservationEvent"})
    public List<AntibioticSensitivityObservationBean> getComponentSensitivityObservationEvent() {
        return this.componentSensitivityObservationEvent;
    }

}
