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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT000007NB.NewCondition","REPC_MT000010NB.NewCondition"})
public class NewConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ReplacedByRecordId</p>
     * 
     * <p>Un-merged Business Name: ReplacedByRecordId</p>
     * 
     * <p>Relationship: REPC_MT000007NB.NewCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacedByRecordId</p>
     * 
     * <p>Relationship: REPC_MT000010NB.NewCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ReplacedByRecordId</p>
     * 
     * <p>Un-merged Business Name: ReplacedByRecordId</p>
     * 
     * <p>Relationship: REPC_MT000007NB.NewCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacedByRecordId</p>
     * 
     * <p>Relationship: REPC_MT000010NB.NewCondition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where a newer or corrected 
     * version of the record of this event exists.</i> </p>
     * 
     * <p> <i>Used to identify the record that supersedes the 
     * current record. This attribute is set when a new record 
     * identifies the current record as being replaced.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
