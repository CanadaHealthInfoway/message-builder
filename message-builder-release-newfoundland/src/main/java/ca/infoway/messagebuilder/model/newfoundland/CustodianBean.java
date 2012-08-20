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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.Identifiable;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "MFMI_MT700746CA.Custodian" })
public class CustodianBean extends MessagePartBean implements Identifiable, Serializable {

    private static final long serialVersionUID = -6388133292530751488L;

    private II id = new IIImpl();

    private ST repositoryName = new STImpl();

    private ST jurisdictionName = new STImpl();

    @Hl7XmlMapping("assignedDevice/id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("assignedDevice/assignedRepository/name")
    public String getRepositoryName() {
        return this.repositoryName.getValue();
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName.setValue(repositoryName);
    }

    @Hl7XmlMapping("assignedDevice/representedRepositoryJurisdiction/name")
    public String getJurisdictionName() {
        return this.jurisdictionName.getValue();
    }

    public void setJurisdictionName(String jurisdictionName) {
        this.jurisdictionName.setValue(jurisdictionName);
    }
}
