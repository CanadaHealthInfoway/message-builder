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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>has a component</p>
 * 
 * <p><p>Associates a Culture with a 
 * SpecimenObservationCluster.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.Component2"})
public class HasAComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private BL contextConductionInd = new BLImpl();
    private SpecimenObservationClusterBean specimenObservationCluster;


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"specimenObservationCluster"})
    public SpecimenObservationClusterBean getSpecimenObservationCluster() {
        return this.specimenObservationCluster;
    }
    public void setSpecimenObservationCluster(SpecimenObservationClusterBean specimenObservationCluster) {
        this.specimenObservationCluster = specimenObservationCluster;
    }

}
