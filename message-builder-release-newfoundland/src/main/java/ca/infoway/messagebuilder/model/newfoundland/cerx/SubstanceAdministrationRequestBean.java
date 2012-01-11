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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;

/**
 * 
 * Represents a prescription
 *
 */
@Hl7PartTypeMapping({ "PORX_MT020070CA.SubstanceAdministrationRequest", "PORX_MT060100CA.SubstanceAdministrationRequest", "PORX_MT060090CA.SubstanceAdministrationRequest" })
public class SubstanceAdministrationRequestBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 395039840760676306L;

    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);

    private AuthorBean author;

    private AssignedPersonBean supervisor;

    private BL contextConductionIndicator = new BLImpl(false);

    private SupplyRequestBean supplyRequest;

    @Hl7XmlMapping("id")
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(AssignedPersonBean supervisor) {
        this.supervisor = supervisor;
    }

    @Hl7XmlMapping("component/contextConductionInd")
    public boolean isContextConductionIndicator() {
        return this.contextConductionIndicator.getValue();
    }

    public void setContextConductionIndicator(boolean contextConductionIndicator) {
        this.contextConductionIndicator.setValue(contextConductionIndicator);
    }

    @Hl7XmlMapping({ "supplyRequest", "component/supplyRequest" })
    public SupplyRequestBean getSupplyRequest() {
        return supplyRequest;
    }

    public void setSupplyRequest(SupplyRequestBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }
}
