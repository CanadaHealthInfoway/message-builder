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



@Hl7PartTypeMapping({"REPC_MT500001CA.OldPatientCareProvisionEvent","REPC_MT500003CA.OldPatientCareProvisionEvent","REPC_MT500004CA.OldPatientCareProvisionEvent"})
public class OldPatientCareProvisionEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ReplacesRecordIds</p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
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
     * <p>Relationship: 
     * REPC_MT500001CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
     * 
     * <p> <i>Used to identify any records that are 
     * &quot;superseded&quot; by the current record. This will 
     * cause the referenced records to be marked as 
     * &quot;obsolete&quot; with a reference pointing to this 
     * record.</i> </p>
     * 
     * <p>Un-merged Business Name: ReplacesRecordIds</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.OldPatientCareProvisionEvent.id</p>
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
     * once.</i> </p>
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
