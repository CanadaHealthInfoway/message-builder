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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT410003CA.WorkingListEvent","REPC_MT420003CA.WorkingListEvent","REPC_MT610002CA.WorkingListEvent"})
public class WorkingListEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();


    /**
     * <p>K:Service Categories</p>
     * 
     * <p><p>Describes the categorization of the service. E.g. 
     * Psychological Counseling, Smoking Cessation, Cardiac 
     * Surgeries, etc.</p></p>
     * 
     * <p><p>Allows categorizing professional services for 
     * presentation. A given person may have had numerous 
     * procedures related to a particular area. By associating 
     * categories with procedures, a person viewing the EHR 
     * information can first look at a list of categories and then 
     * drill down to the specific procedures.</p><p>The presence of 
     * this field is essential to prevent users from being 
     * overwhelmed, however not all services will necessarily be 
     * categorizable. Therefore this element is marked as 
     * 'populated'.</p></p>
     * 
     * <p><p>Allows categorizing professional services for 
     * presentation. A given person may have had numerous 
     * procedures related to a particular area. By associating 
     * categories with procedures, a person viewing the EHR 
     * information can first look at a list of categories and then 
     * drill down to the specific procedures.</p><p>The presence of 
     * this field is essential to prevent users from being 
     * overwhelmed, however not all services will necessarily be 
     * categorizable. Therefore this element is marked as 
     * 'populated'.</p></p>
     * 
     * <p><p>Categories are inferred from the terminology hierarchy 
     * and thus aren't specified as part of the 'record' 
     * message.</p></p>
     * 
     * <p>J:Observation Categories</p>
     * 
     * <p><p>Describes the categorization of the 
     * observation.</p><p>E.g. signs and symptoms, history 
     * observations, etc.</p></p>
     * 
     * <p><p>Describes the categorization of the 
     * observation.</p><p>E.g. signs and symptoms, history 
     * observations, etc.</p></p>
     * 
     * <p><p>Allows categorizing of observations for presentation. 
     * A given person may have had numerous observations related to 
     * a particular area. By associating categories, a person 
     * viewing the EHR information can first look at a list of 
     * categories and then drill down to the specific 
     * observation.</p><p>The presence of this field is essential 
     * to prevent users from being overwhelmed, however not all 
     * observations will necessarily be categorizable. Therefore 
     * this element is marked as 'populated'.</p></p>
     * 
     * <p><p>Allows categorizing of observations for presentation. 
     * A given person may have had numerous observations related to 
     * a particular area. By associating categories, a person 
     * viewing the EHR information can first look at a list of 
     * categories and then drill down to the specific 
     * observation.</p><p>The presence of this field is essential 
     * to prevent users from being overwhelmed, however not all 
     * observations will necessarily be categorizable. Therefore 
     * this element is marked as 'populated'.</p></p>
     * 
     * <p>J:Observation Categories</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

}