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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.Component4","PORX_MT030040CA.Component4","PORX_MT060160CA.Component4","PORX_MT060190CA.Component4","PORX_MT060340CA.Component4"})
public class ClassifiesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private DrugUseBean workingListEvent;


    @Hl7XmlMapping({"workingListEvent"})
    public DrugUseBean getWorkingListEvent() {
        return this.workingListEvent;
    }
    public void setWorkingListEvent(DrugUseBean workingListEvent) {
        this.workingListEvent = workingListEvent;
    }

}
