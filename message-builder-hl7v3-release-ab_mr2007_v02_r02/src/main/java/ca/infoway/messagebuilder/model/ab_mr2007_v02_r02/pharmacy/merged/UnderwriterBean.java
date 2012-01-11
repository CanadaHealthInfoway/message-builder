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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

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

    private static final long serialVersionUID = 20111208L;
    private II id = new IIImpl();
    private ST underwritingOrganizationName = new STImpl();


    /**
     * <p>PayorIdentifier</p>
     * 
     * <p>Payor Identifier</p>
     * 
     * <p><p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p></p>
     * 
     * <p><p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p></p>
     * 
     * <p>B:Payor Identifier</p>
     * 
     * <p><p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p></p>
     * 
     * <p><p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>C:Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     * 
     * <p>Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension.</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     */
    @Hl7XmlMapping({"underwritingOrganization/name"})
    public String getUnderwritingOrganizationName() {
        return this.underwritingOrganizationName.getValue();
    }
    public void setUnderwritingOrganizationName(String underwritingOrganizationName) {
        this.underwritingOrganizationName.setValue(underwritingOrganizationName);
    }

}
