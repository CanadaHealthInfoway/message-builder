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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.AdjudicatorIdBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT510201CA.Author1"})
public class Author1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private TS time = new TSImpl();
    private CV modeCode = new CVImpl();
    private AdjudicatorIdBean adjudicatorRole;


    /**
     * <p>Business Name: Adjudication date/time</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Author1.time</p>
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
     * <p>Relationship: FICR_MT510201CA.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Author1.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Author1.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.Author1.adjudicatorRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"adjudicatorRole"})
    public AdjudicatorIdBean getAdjudicatorRole() {
        return this.adjudicatorRole;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.Author1.adjudicatorRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAdjudicatorRole(AdjudicatorIdBean adjudicatorRole) {
        this.adjudicatorRole = adjudicatorRole;
    }

}
