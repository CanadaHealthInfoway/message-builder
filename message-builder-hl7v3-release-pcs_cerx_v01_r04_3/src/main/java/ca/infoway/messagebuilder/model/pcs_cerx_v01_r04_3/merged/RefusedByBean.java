/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT120600CA.Author","COCT_MT130001CA.Author3","COMT_MT300003CA.Author","MCAI_MT700210CA.Author","MCAI_MT700221CA.Author","MCAI_MT700223CA.Author","POIZ_MT060150CA.Author","PORX_MT020060CA.Author","PORX_MT020070CA.Author","PORX_MT030040CA.Author","PORX_MT060010CA.Author5","PORX_MT060040CA.Author","PORX_MT060060CA.Author","PORX_MT060090CA.Author5","PORX_MT060160CA.Author","PORX_MT060160CA.Author5","PORX_MT060190CA.Author","PORX_MT060190CA.Author3","PORX_MT060210CA.Author","PORX_MT060340CA.Author","QUQI_MT020000CA.Author","REPC_MT000005CA.Author","REPC_MT000006CA.Author","REPC_MT000007CA.Author","REPC_MT000009CA.Author","REPC_MT000009CA.Author3","REPC_MT000010CA.Author","REPC_MT000010CA.Author3","REPC_MT000017CA.Author","REPC_MT100001CA.Author","REPC_MT100002CA.Author3"})
public class RefusedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS time = new TSImpl();
    private ProviderBean assignedPerson;
    private CV informationReceivedMethod = new CVImpl();
    private ED<String> digitalSignature = new EDImpl<String>();


    /**
     * <p>Change Datetime</p>
     * 
     * <p>D:Time of Creation</p>
     * 
     * <p>Prescription Order Date</p>
     * 
     * <p>Change Time</p>
     * 
     * <p>Note Timestamp</p>
     * 
     * <p>Recording Datetime</p>
     * 
     * <p>B:Patient Note Date</p>
     * 
     * <p>Create Timestamp</p>
     * 
     * <p>*Create Timestamp</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>InformationReceivedMethod</p>
     * 
     * <p>F:Information Received Method</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getInformationReceivedMethod() {
        return (ParticipationMode) this.informationReceivedMethod.getValue();
    }
    public void setInformationReceivedMethod(ParticipationMode informationReceivedMethod) {
        this.informationReceivedMethod.setValue(informationReceivedMethod);
    }


    /**
     * <p>DigitalSignature</p>
     * 
     * <p>G:Digital Signature</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getDigitalSignature() {
        return this.digitalSignature.getValue();
    }
    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature.setValue(digitalSignature);
    }

}
