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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT610001CA.ClinicalDocumentEvent","REPC_MT610002CA.ClinicalDocumentEvent"})
public class ClinicalDocumentEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Un-merged Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for a direct link to a report that has been 
     * written on the procedure. Often surgical, and even 
     * psychological procedures can result in numerous 
     * observations, and other information generally captured in 
     * narrative form. When filled in, this attribute allows the 
     * user to drill down to the Clinical Observation Document 
     * record used to capture this additional information.</p>
     * 
     * <p>An identifier for a report associated with the 
     * procedure.</p>
     * 
     * <p>Un-merged Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for a direct link to a report that has been 
     * written on the procedure. Often surgical, and even 
     * psychological procedures can result in numerous 
     * observations, and other information generally captured in 
     * narrative form. When filled in, this attribute allows the 
     * user to drill down to the Clinical Observation Document 
     * record used to capture this additional information.</p>
     * 
     * <p>An identifier for a report associated with the 
     * procedure.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Un-merged Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for a direct link to a report that has been 
     * written on the procedure. Often surgical, and even 
     * psychological procedures can result in numerous 
     * observations, and other information generally captured in 
     * narrative form. When filled in, this attribute allows the 
     * user to drill down to the Clinical Observation Document 
     * record used to capture this additional information.</p>
     * 
     * <p>An identifier for a report associated with the 
     * procedure.</p>
     * 
     * <p>Un-merged Business Name: ServiceReportReferenceId</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ClinicalDocumentEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for a direct link to a report that has been 
     * written on the procedure. Often surgical, and even 
     * psychological procedures can result in numerous 
     * observations, and other information generally captured in 
     * narrative form. When filled in, this attribute allows the 
     * user to drill down to the Clinical Observation Document 
     * record used to capture this additional information.</p>
     * 
     * <p>An identifier for a report associated with the 
     * procedure.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
