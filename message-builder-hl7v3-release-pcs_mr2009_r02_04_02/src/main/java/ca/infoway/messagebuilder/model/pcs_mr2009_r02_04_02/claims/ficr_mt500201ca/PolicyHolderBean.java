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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT500201CA.PolicyHolder"})
public class PolicyHolderBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private PN policyHolderPersonName = new PNImpl();
    private TS policyHolderPersonBirthTime = new TSImpl();


    /**
     * <p>Business Name: Policy Holder Name</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PolicyHolderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyHolderPerson/name"})
    public PersonName getPolicyHolderPersonName() {
        return this.policyHolderPersonName.getValue();
    }

    /**
     * <p>Business Name: Policy Holder Name</p>
     * 
     * <p>Relationship: FICR_MT500201CA.PolicyHolderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyHolderPersonName(PersonName policyHolderPersonName) {
        this.policyHolderPersonName.setValue(policyHolderPersonName);
    }


    /**
     * <p>Business Name: Policy Holder Date of birth</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyHolderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"policyHolderPerson/birthTime"})
    public Date getPolicyHolderPersonBirthTime() {
        return this.policyHolderPersonBirthTime.getValue();
    }

    /**
     * <p>Business Name: Policy Holder Date of birth</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.PolicyHolderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPolicyHolderPersonBirthTime(Date policyHolderPersonBirthTime) {
        this.policyHolderPersonBirthTime.setValue(policyHolderPersonBirthTime);
    }

}
