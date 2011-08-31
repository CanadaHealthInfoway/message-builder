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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.Consenter;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000001CA.Informant","REPC_MT000002CA.Informant","REPC_MT000003CA.Informant","REPC_MT000005CA.Informant","REPC_MT000006CA.Informant","REPC_MT000007CA.Informant","REPC_MT000009CA.Informant","REPC_MT000010CA.Informant","REPC_MT000012CA.Informant","REPC_MT000013CA.Informant","REPC_MT000014CA.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS time = new TSImpl();
    private Party party;
    private Consenter consenter;
    private Choice choice;


    /**
     * <p>Reported Date</p>
     * 
     * <p>Reported Timestamp</p>
     * 
     * <p>Reported date</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    @Hl7XmlMapping({"party"})
    public Party getParty() {
        return this.party;
    }
    public void setParty(Party party) {
        this.party = party;
    }


    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }


    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
