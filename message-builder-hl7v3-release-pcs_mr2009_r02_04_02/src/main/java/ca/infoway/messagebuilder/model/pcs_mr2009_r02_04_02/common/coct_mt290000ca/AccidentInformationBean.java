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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInformation"})
public class AccidentInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private INT sequenceNumber = new INTImpl();
    private AccidentInjuryCodingBean accidentInjuryCoding;


    /**
     * <p>Business Name: Injury coding priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sets of injury observations are tied together with the 
     * same sequence number</p>
     * 
     * <p>Used for more than one set of injury coding.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Injury coding priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sets of injury observations are tied together with the 
     * same sequence number</p>
     * 
     * <p>Used for more than one set of injury coding.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.accidentInjuryCoding</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"accidentInjuryCoding"})
    public AccidentInjuryCodingBean getAccidentInjuryCoding() {
        return this.accidentInjuryCoding;
    }

    /**
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.accidentInjuryCoding</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAccidentInjuryCoding(AccidentInjuryCodingBean accidentInjuryCoding) {
        this.accidentInjuryCoding = accidentInjuryCoding;
    }

}
