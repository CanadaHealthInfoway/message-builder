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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.WorkingListEvent","PORX_MT030040CA.WorkingListEvent","PORX_MT060160CA.WorkingListEvent","PORX_MT060190CA.WorkingListEvent","PORX_MT060340CA.WorkingListEvent"})
public class DrugUseBean extends MessagePartBean {

    private static final long serialVersionUID = 20120130L;
    private CV code = new CVImpl();


    /**
     * <p>D:Treatment Type</p>
     * 
     * <p>D:Prescription Treatment Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActTherapyDurationWorkingListCode getCode() {
        return (ActTherapyDurationWorkingListCode) this.code.getValue();
    }
    public void setCode(ActTherapyDurationWorkingListCode code) {
        this.code.setValue(code);
    }

}
