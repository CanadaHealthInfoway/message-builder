/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

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

    private static final long serialVersionUID = 20111117L;
    private CD code = new CDImpl();
    private List<AntibioticSensitivityObservationBean> componentSensitivityObservationEvent = new ArrayList<AntibioticSensitivityObservationBean>();


    /**
     * <p>Sensitivity Battery Type</p>
     * 
     * <p><p>Generally describes the sensitivity battery being 
     * performed, e.g. viral, microbial, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"component/sensitivityObservationEvent"})
    public List<AntibioticSensitivityObservationBean> getComponentSensitivityObservationEvent() {
        return this.componentSensitivityObservationEvent;
    }

}
