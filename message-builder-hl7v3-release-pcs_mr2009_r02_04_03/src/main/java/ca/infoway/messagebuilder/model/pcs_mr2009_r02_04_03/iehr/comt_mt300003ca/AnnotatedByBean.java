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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.comt_mt300003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean;
import java.util.Date;



/**
 * <p>Business Name: *b:annotated by</p>
 * 
 * <p>Allows other providers to communicator with the author of 
 * the note for follow-up enquiries. The author of an 
 * annotation must always be known and is therefore 
 * mandatory.</p>
 * 
 * <p>Identifier of the provider who created the patient 
 * note.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300003CA.Author"})
public class AnnotatedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private TS time = new TSImpl();
    private HealthcareWorkerBean assignedEntity;


    /**
     * <p>Business Name: B:Patient Note Date</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows other provider to evaluate the currency of the 
     * information contained in the note.</p><p>The date of the 
     * note creation is always known and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the patient note was created.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: B:Patient Note Date</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Author.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows other provider to evaluate the currency of the 
     * information contained in the note.</p><p>The date of the 
     * note creation is always known and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the patient note was created.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
