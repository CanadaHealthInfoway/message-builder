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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.QueryParameterValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.PersonalRelationshipCode"})
public class PersonalRelationshipCodeBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private CV value = new CVImpl();


    /**
     * <p>Client Next of Kin</p>
     * 
     * <p><p>A code further specifying the kind of Role such as 
     * Mother, Father, Natural Parent or Step Parent</p></p>
     * 
     * <p><p>Mandatory attribute that supports understanding the 
     * relationship between the client and the ParentClient</p></p>
     */
    @Hl7XmlMapping({"value"})
    public QueryParameterValue getValue() {
        return (QueryParameterValue) this.value.getValue();
    }
    public void setValue(QueryParameterValue value) {
        this.value.setValue(value);
    }

}
