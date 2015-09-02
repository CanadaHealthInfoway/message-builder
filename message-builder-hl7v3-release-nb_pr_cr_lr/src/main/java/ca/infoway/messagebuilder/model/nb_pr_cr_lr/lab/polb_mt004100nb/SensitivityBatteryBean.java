/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.polb_mt004100nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.SensitivityBatteryCode;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Sensitivity Battery</p>
 * 
 * <p>This act &quot;groups&quot; all the sensitivity tests 
 * performed on a particular isolate. The battery may be made 
 * up of individual sensitivity tests using all the same 
 * testing method or using differing methods.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100NB.SensitivityBattery"})
public class SensitivityBatteryBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CD code = new CDImpl();
    private List<AntibioticSensitivityObservationBean> componentSensitivityObservationEvent = new ArrayList<AntibioticSensitivityObservationBean>();


    /**
     * <p>Business Name: Sensitivity Battery Type</p>
     * 
     * <p>Relationship: POLB_MT004100NB.SensitivityBattery.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Generally describes the sensitivity battery being 
     * performed, e.g. viral, microbial, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public SensitivityBatteryCode getCode() {
        return (SensitivityBatteryCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Sensitivity Battery Type</p>
     * 
     * <p>Relationship: POLB_MT004100NB.SensitivityBattery.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Generally describes the sensitivity battery being 
     * performed, e.g. viral, microbial, etc.</p>
     */
    public void setCode(SensitivityBatteryCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100NB.Component6.sensitivityObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/sensitivityObservationEvent"})
    public List<AntibioticSensitivityObservationBean> getComponentSensitivityObservationEvent() {
        return this.componentSensitivityObservationEvent;
    }

}
