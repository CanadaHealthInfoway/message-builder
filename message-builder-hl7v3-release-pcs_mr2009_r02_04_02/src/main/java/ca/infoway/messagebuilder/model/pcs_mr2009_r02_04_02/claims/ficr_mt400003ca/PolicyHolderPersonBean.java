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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt400003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400003CA.PolicyHolderPerson"})
public class PolicyHolderPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.PolicyHolderChoice {

    private static final long serialVersionUID = 20121204L;
    private PN name = new PNImpl();


    /**
     * <p>Business Name: Policy Holder Name</p>
     * 
     * <p>Relationship: FICR_MT400003CA.PolicyHolderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: Policy Holder Name</p>
     * 
     * <p>Relationship: FICR_MT400003CA.PolicyHolderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }

}
