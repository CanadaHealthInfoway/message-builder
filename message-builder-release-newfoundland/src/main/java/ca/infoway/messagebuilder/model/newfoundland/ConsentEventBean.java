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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.Identifiable;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT470000CA.ConsentEvent" })
public class ConsentEventBean extends MessagePartBean implements Identifiable, Serializable {

    private static final long serialVersionUID = -647607118325387652L;

    private II id = new IIImpl();

    private CD reasonCode = new CDImpl();

    private IdentifiedPersonBean patient;

    private ST signatureText = new STImpl();

    private Consenter consenter;

    private InformDefinitionBean informDefinition;

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("subject1/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("reasonCode")
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("author2/signatureText")
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }

    @Hl7XmlMapping("author2/consenter")
    public Consenter getConsenter() {
        return consenter;
    }

    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

    @Hl7XmlMapping("subject2/informDefinition")
    public InformDefinitionBean getInformDefinition() {
        return informDefinition;
    }

    public void setInformDefinition(InformDefinitionBean informDefinition) {
        this.informDefinition = informDefinition;
    }
}
