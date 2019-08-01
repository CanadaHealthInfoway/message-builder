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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CS typeCode = new CSImpl();
    private INT sequenceNumber = new INTImpl();
    private InformRequestBean informRequest;


    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.informRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informRequest"})
    public InformRequestBean getInformRequest() {
        return this.informRequest;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.informRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformRequest(InformRequestBean informRequest) {
        this.informRequest = informRequest;
    }

}
