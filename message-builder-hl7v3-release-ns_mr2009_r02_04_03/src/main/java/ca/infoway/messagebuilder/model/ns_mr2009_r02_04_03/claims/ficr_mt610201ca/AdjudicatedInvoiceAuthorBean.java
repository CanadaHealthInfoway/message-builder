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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatedInvoiceAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private TS time = new TSImpl();
    private AdjudicatorRoleBean adjudicatorRole;


    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.adjudicatorRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole"})
    public AdjudicatorRoleBean getAdjudicatorRole() {
        return this.adjudicatorRole;
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicatedInvoiceAuthor.adjudicatorRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAdjudicatorRole(AdjudicatorRoleBean adjudicatorRole) {
        this.adjudicatorRole = adjudicatorRole;
    }

}
