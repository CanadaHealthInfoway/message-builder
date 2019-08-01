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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.OldClinicalDocumentEvent","REPC_MT210002CA.OldClinicalDocumentEvent"})
public class OldClinicalDocumentEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ReplacesRecordIds</p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: REPC_MT210001CA.OldClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: REPC_MT210002CA.OldClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where information initially 
     * captured about an event is erroneous, incomplete or not 
     * captured at the desired level of detail and the change 
     * cannot be made by retracting the original record. (E.g. Too 
     * much time has elapsed, change is being made by a provider 
     * other than the original author of the vent record, etc.) May 
     * also be used to reference multiple records in the case where 
     * the same event has been accidentally captured more than 
     * once. May also be used when this is a newer 
     * &quot;version&quot; of the type of Referral than those 
     * records being referenced.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ReplacesRecordIds</p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: REPC_MT210001CA.OldClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: REPC_MT210002CA.OldClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Used in circumstances where information initially 
     * captured about an event is erroneous, incomplete or not 
     * captured at the desired level of detail and the change 
     * cannot be made by retracting the original record. (E.g. Too 
     * much time has elapsed, change is being made by a provider 
     * other than the original author of the vent record, etc.) May 
     * also be used to reference multiple records in the case where 
     * the same event has been accidentally captured more than 
     * once. May also be used when this is a newer 
     * &quot;version&quot; of the type of Referral than those 
     * records being referenced.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
