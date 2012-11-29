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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ParentTest</p>
 * 
 * <p>POLB_MT001999CA.ActParentPointer: Parent Test</p>
 * 
 * <p>Communicates the parent order (id) in a repeating child 
 * order.</p>
 * 
 * <p>Associates a repeating child order with it's parent 
 * order.</p>
 * 
 * <p>POLB_MT001010CA.ActParentPointer: Parent Test</p>
 * 
 * <p>The classCode shall carry one of ACT, BATTERY or OBS 
 * according to the parent order classCode.</p>
 * 
 * <p>Communicates the parent order (id) in a repeating child 
 * order.</p>
 * 
 * <p>Associates a repeating child order with it's parent 
 * order.</p>
 * 
 * <p>POLB_MT001001CA.ActParentPointer: Parent Test</p>
 * 
 * <p>The classCode shall carry one of ACT, BATTERY or OBS 
 * according to the parent order classCode.</p>
 * 
 * <p>Communicates the parent order (id) in a repeating child 
 * order.</p>
 * 
 * <p>Associates a repeating child order with it's parent 
 * order.</p>
 * 
 * <p>POLB_MT001000CA.ActParentPointer: Parent Test</p>
 * 
 * <p>The classCode shall carry one of ACT, BATTERY or OBS 
 * according to the parent order classCode.</p>
 * 
 * <p>Communicates the parent order (id) in a repeating child 
 * order.</p>
 * 
 * <p>Associates a repeating child order with it's parent 
 * order.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.ActParentPointer","POLB_MT001001CA.ActParentPointer","POLB_MT001010CA.ActParentPointer","POLB_MT001999CA.ActParentPointer"})
public class ParentTestBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();


    /**
     * <p>ParentTestIdentifier</p>
     * 
     * <p>Parent Test Identifier</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>ParentTestIdentifier</p>
     * 
     * <p>Parent Test Identifier</p>
     * 
     * <p>Communicates the parent order (id) in a repeating child 
     * order.</p>
     * 
     * <p>Used to associate a repeating child order with it's 
     * parent order.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
