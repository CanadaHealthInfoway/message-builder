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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.Underwriter","PORX_MT010120CA.Underwriter","PORX_MT060040CA.Underwriter"})
public class UnderwriterBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private ResponsibleOrganizationBean underwritingOrganization;


    /**
     * <p>Business Name: PayorIdentifier</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PayorIdentifier</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     * 
     * <p>Un-merged Business Name: PayorIdentifier</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Underwriter.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p>
     * 
     * <p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"underwritingOrganization"})
    public ResponsibleOrganizationBean getUnderwritingOrganization() {
        return this.underwritingOrganization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Underwriter.underwritingOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setUnderwritingOrganization(ResponsibleOrganizationBean underwritingOrganization) {
        this.underwritingOrganization = underwritingOrganization;
    }

}
