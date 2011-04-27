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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>ReferencedRecord</p>
 * 
 * <p>COMT_MT001101CA.ActRequest: Referenced Record</p>
 * 
 * <p><p>References an existing event record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p>COMT_MT001103CA.ActEvent: Referenced Record</p>
 * 
 * <p><p>References an existing event record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT001101CA.ActRequest","COMT_MT001103CA.ActEvent"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> recordIds = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>RecordIds</p>
     * 
     * <p>Record Ids</p>
     * 
     * <p><p>The identifier assigned by the central system (EHR) to 
     * the Event record being referred to.</p></p>
     * 
     * <p><p>Allows the event record to be uniquely referenced and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getRecordIds() {
        return this.recordIds.rawSet();
    }

}
