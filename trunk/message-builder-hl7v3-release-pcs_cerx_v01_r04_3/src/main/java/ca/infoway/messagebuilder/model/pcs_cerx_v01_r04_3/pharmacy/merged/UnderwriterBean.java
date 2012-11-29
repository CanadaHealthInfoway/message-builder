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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.Underwriter","PORX_MT010120CA.Underwriter","PORX_MT060040CA.Underwriter"})
public class UnderwriterBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private ST underwritingOrganizationName = new STImpl();


    /**
     * <p>PayorIdentifier</p>
     * 
     * <p>Payor Identifier</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>B:Payor Identifier</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>PayorIdentifier</p>
     * 
     * <p>Payor Identifier</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>B:Payor Identifier</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>C:Payor Name</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>Payor Name</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     * 
     * <p>Mandatory for display purposes.</p>
     */
    @Hl7XmlMapping({"underwritingOrganization/name"})
    public String getUnderwritingOrganizationName() {
        return this.underwritingOrganizationName.getValue();
    }

    /**
     * <p>PayorName</p>
     * 
     * <p>C:Payor Name</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>Payor Name</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     * 
     * <p>Mandatory for display purposes.</p>
     */
    public void setUnderwritingOrganizationName(String underwritingOrganizationName) {
        this.underwritingOrganizationName.setValue(underwritingOrganizationName);
    }

}
