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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000002CA.Informant","REPC_MT000006CA.Informant"})
public class Informant_2Bean extends MessagePartBean {

    private TS reportedTimestamp = new TSImpl();
    private PartyBean party;

    @Hl7XmlMapping({"time"})
    public Date getReportedTimestamp() {
        return this.reportedTimestamp.getValue();
    }
    public void setReportedTimestamp(Date reportedTimestamp) {
        this.reportedTimestamp.setValue(reportedTimestamp);
    }

    @Hl7XmlMapping({"party"})
    public PartyBean getParty() {
        return this.party;
    }
    public void setParty(PartyBean party) {
        this.party = party;
    }

}
