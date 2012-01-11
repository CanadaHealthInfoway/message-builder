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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInformation"})
public class AccidentInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private INT sequenceNumber = new INTImpl();
    private AccidentInjuryCodingBean accidentInjuryCoding;


    /**
     * <p>Injury coding priority</p>
     * 
     * <p><p>Sets of injury observations are tied together with the 
     * same sequence number</p></p>
     * 
     * <p><p>Used for more than one set of injury coding.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    @Hl7XmlMapping({"accidentInjuryCoding"})
    public AccidentInjuryCodingBean getAccidentInjuryCoding() {
        return this.accidentInjuryCoding;
    }
    public void setAccidentInjuryCoding(AccidentInjuryCodingBean accidentInjuryCoding) {
        this.accidentInjuryCoding = accidentInjuryCoding;
    }

}
