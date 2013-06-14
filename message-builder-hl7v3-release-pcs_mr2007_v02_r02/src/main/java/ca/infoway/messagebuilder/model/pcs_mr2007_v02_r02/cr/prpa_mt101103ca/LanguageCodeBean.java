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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.QueryParameterValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.LanguageCode"})
public class LanguageCodeBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV value = new CVImpl();


    /**
     * <p>Business Name: Language of Communication Code</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.LanguageCode.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>A code indicating the language of communication</p>
     */
    @Hl7XmlMapping({"value"})
    public QueryParameterValue getValue() {
        return (QueryParameterValue) this.value.getValue();
    }

    /**
     * <p>Business Name: Language of Communication Code</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.LanguageCode.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Mandatory attribute conveying the expected language 
     * message elements are to be transmitted in</p>
     * 
     * <p>A code indicating the language of communication</p>
     */
    public void setValue(QueryParameterValue value) {
        this.value.setValue(value);
    }

}
