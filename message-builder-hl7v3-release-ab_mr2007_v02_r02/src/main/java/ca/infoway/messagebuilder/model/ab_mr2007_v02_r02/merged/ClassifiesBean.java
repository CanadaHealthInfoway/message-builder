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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PORX_MT060340CA.Component4: classifies</p>
 * 
 * <p>Indicates the clinical use category in which the 
 * prescription has been put.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p>
 * 
 * <p>PORX_MT010120CA.Component4: classified by</p>
 * 
 * <p>Indicates the clinical use category in which the 
 * prescription has been put.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p>
 * 
 * <p>PORX_MT060160CA.Component4: classifies</p>
 * 
 * <p>Indicates the clinical use category in which the 
 * prescription has been put.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p><p>Attribute is marked &quot;populated' to ensure 
 * that an item on the medication profile is categorized or 
 * 'null' value specified.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p><p>Attribute is marked &quot;populated' to ensure 
 * that an item on the medication profile is categorized or 
 * 'null' value specified.</p>
 * 
 * <p>PORX_MT030040CA.Component4: classifies</p>
 * 
 * <p>Indicates the clinical use category in which the 
 * prescription has been put.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p>
 * 
 * <p>PORX_MT060190CA.Component4: classifies</p>
 * 
 * <p>Indicates the clinical use category in which the 
 * prescription has been put.</p>
 * 
 * <p>Allows prescriptions to be categorized in multiple 
 * ways.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Component4","PORX_MT030040CA.Component4","PORX_MT060160CA.Component4","PORX_MT060190CA.Component4","PORX_MT060340CA.Component4"})
public class ClassifiesBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private DrugUseBean workingListEvent;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"workingListEvent"})
    public DrugUseBean getWorkingListEvent() {
        return this.workingListEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Component4.workingListEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setWorkingListEvent(DrugUseBean workingListEvent) {
        this.workingListEvent = workingListEvent;
    }

}
