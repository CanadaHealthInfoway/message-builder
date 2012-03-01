/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.x_InformationSource;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030060CA.InformationSourceRole","POIZ_MT060150CA.InformationSourceRole"})
public class InformationSourceRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20120301L;
    private CS classCode = new CSImpl();


    /**
     * <p>InformationSource</p>
     * 
     * <p>Information Source</p>
     * 
     * <p><p>A coded value denoting a patient, patient's agent, or 
     * a provider as the source of the recorded immunization 
     * information.</p></p>
     * 
     * <p><p>Allows for the explicit identification of the source 
     * of the recorded information.</p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_InformationSource getClassCode() {
        return (x_InformationSource) this.classCode.getValue();
    }
    public void setClassCode(x_InformationSource classCode) {
        this.classCode.setValue(classCode);
    }

}
