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



@Hl7PartTypeMapping({"REPC_MT230001CA.ActEvent","REPC_MT230002CA.ActEvent","REPC_MT230003CA.ActEvent","REPC_MT500001CA.ActEvent","REPC_MT500002CA.ActEvent","REPC_MT500004CA.ActEvent"})
public class ActEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();


    /**
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230002CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References any existing health service event records that 
     * should be associated with this care composition when it is 
     * created</p>
     * 
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230003CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References health service event records to be added to or 
     * removed from the care composition.</p>
     * 
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230001CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References existing health service event records that are 
     * associated this care composition</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230002CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References any existing health service event records that 
     * should be associated with this care composition when it is 
     * created</p>
     * 
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230003CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References health service event records to be added to or 
     * removed from the care composition.</p>
     * 
     * <p>Un-merged Business Name: ReportedOnServiceLink</p>
     * 
     * <p>Relationship: REPC_MT230001CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p>
     * 
     * <p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p>
     * 
     * <p>Un-merged Business Name: ContainedServiceEventIds</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>One of the primary purposes of a care composition is to 
     * 'group' information. This attribute is the representation of 
     * that grouping.</p>
     * 
     * <p>References existing health service event records that are 
     * associated this care composition</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
