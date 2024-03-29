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
package ca.infoway.messagebuilder.model.common.coct_mt080100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ResponsibleOrganizationBean;



/**
 * <p>Other Specimen Identifications 
 * 
 * <p>Associated specimen identifiers. 
 * 
 * <p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing. 
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity"})
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private II otherSpecimenIdentifiers = new IIImpl();
    private CV<Code> otherSpecimenIdentifierType = new CVImpl<Code>();
    private ResponsibleOrganizationBean assigningOrganization;

    @Hl7XmlMapping({"id"})
    public Identifier getOtherSpecimenIdentifiers() {
        return this.otherSpecimenIdentifiers.getValue();
    }
    public void setOtherSpecimenIdentifiers(Identifier otherSpecimenIdentifiers) {
        this.otherSpecimenIdentifiers.setValue(otherSpecimenIdentifiers);
    }

    @Hl7XmlMapping({"code"})
    public Code getOtherSpecimenIdentifierType() {
        return this.otherSpecimenIdentifierType.getValue();
    }
    public void setOtherSpecimenIdentifierType(Code otherSpecimenIdentifierType) {
        this.otherSpecimenIdentifierType.setValue(otherSpecimenIdentifierType);
    }

    @Hl7XmlMapping({"assigningOrganization"})
    public ResponsibleOrganizationBean getAssigningOrganization() {
        return this.assigningOrganization;
    }
    public void setAssigningOrganization(ResponsibleOrganizationBean assigningOrganization) {
        this.assigningOrganization = assigningOrganization;
    }

}
