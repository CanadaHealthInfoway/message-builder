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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.Subject","PORX_MT060160CA.Subject8","PORX_MT060340CA.Subject8"})
public class AuthorizesBean extends MessagePartBean {

    private BL substitutionNotAllowedIndicator = new BLImpl();
    private CV<SubstanceAdminSubstitutionNotAllowedReason> notAllowedReason = new CVImpl<SubstanceAdminSubstitutionNotAllowedReason>();

    @Hl7XmlMapping({"substitutionPermission/negationInd"})
    public java.lang.Boolean getSubstitutionNotAllowedIndicator() {
        return this.substitutionNotAllowedIndicator.getValue();
    }
    public void setSubstitutionNotAllowedIndicator(java.lang.Boolean substitutionNotAllowedIndicator) {
        this.substitutionNotAllowedIndicator.setValue(substitutionNotAllowedIndicator);
    }

    @Hl7XmlMapping({"substitutionPermission/reasonCode"})
    public SubstanceAdminSubstitutionNotAllowedReason getNotAllowedReason() {
        return this.notAllowedReason.getValue();
    }
    public void setNotAllowedReason(SubstanceAdminSubstitutionNotAllowedReason notAllowedReason) {
        this.notAllowedReason.setValue(notAllowedReason);
    }

}
