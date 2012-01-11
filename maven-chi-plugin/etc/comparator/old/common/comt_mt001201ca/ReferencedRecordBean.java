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
package ca.infoway.messagebuilder.model.common.comt_mt001201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>Referenced Record 
 * 
 * <p>References an existing role record by identifier. 
 * 
 * <p>As a request, refers to the role to be acted upon or 
 * which has been acted upon. 
 * 
 * <p>As a response, may be used to indicate the identifier 
 * assigned to a created object. 
 */
@Hl7PartTypeMapping({"COMT_MT001201CA.Role"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private SET<II, Identifier> recordIds = new SETImpl<II, Identifier>(IIImpl.class);

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getRecordIds() {
        return this.recordIds.rawSet();
    }

}
