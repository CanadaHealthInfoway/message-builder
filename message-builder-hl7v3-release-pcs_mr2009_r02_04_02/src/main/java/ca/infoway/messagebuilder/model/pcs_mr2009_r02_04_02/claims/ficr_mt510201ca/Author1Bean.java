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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicatorIdBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT510201CA.Author1"})
public class Author1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private TS adjudicationDateTime = new TSImpl();
    private CV modeCode = new CVImpl();
    private AdjudicatorIdBean adjudicatorRole;


    /**
     * <p>Adjudication date/time</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getAdjudicationDateTime() {
        return this.adjudicationDateTime.getValue();
    }
    public void setAdjudicationDateTime(Date adjudicationDateTime) {
        this.adjudicationDateTime.setValue(adjudicationDateTime);
    }


    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    @Hl7XmlMapping({"adjudicatorRole"})
    public AdjudicatorIdBean getAdjudicatorRole() {
        return this.adjudicatorRole;
    }
    public void setAdjudicatorRole(AdjudicatorIdBean adjudicatorRole) {
        this.adjudicatorRole = adjudicatorRole;
    }

}
