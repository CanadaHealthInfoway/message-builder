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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101991ab;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.ActRegistryCode;



@Hl7PartTypeMapping({"PRPA_MT101991AB.RegistrationEvent"})
public class RegistrationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CD code = new CDImpl();


    /**
     * <p>Business Name: Registration Type</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.RegistrationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActRegistryCode getCode() {
        return (ActRegistryCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Registration Type</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.RegistrationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActRegistryCode code) {
        this.code.setValue(code);
    }

}
