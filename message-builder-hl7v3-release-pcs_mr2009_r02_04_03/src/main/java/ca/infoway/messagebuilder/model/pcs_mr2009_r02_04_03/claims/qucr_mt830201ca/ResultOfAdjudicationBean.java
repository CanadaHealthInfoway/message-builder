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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicationResult"})
public class ResultOfAdjudicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private List<II> referenceInvoiceElementGroupId = new ArrayList<II>();


    /**
     * <p>Business Name: Adjudication ID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicationResult.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Unique identifier for this adjudication</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Adjudication ID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.AdjudicationResult.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Unique identifier for this adjudication</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Invoice Group ID</p>
     * 
     * <p>Relationship: QUCR_MT830201CA.InvoiceElementGroup.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p></p><p>For example:</p><p>1. unique invoice group 
     * identifier, independent of adjudicator recipient.</p><p>2. 
     * sequential invoice grouping identifier by 
     * adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p>
     * 
     * <p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p>
     */
    @Hl7XmlMapping({"reference/invoiceElementGroup/id"})
    public List<Identifier> getReferenceInvoiceElementGroupId() {
        return new RawListWrapper<II, Identifier>(referenceInvoiceElementGroupId, IIImpl.class);
    }

}
