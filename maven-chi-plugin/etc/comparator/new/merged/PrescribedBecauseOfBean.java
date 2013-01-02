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
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.IndicationsBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;



@Hl7PartTypeMapping({"POME_MT010040CA.Reason","PORX_MT010110CA.Reason2","PORX_MT010120CA.Reason2","PORX_MT030040CA.Reason","PORX_MT060040CA.Reason2","PORX_MT060060CA.Reason","PORX_MT060160CA.Reason2","PORX_MT060190CA.Reason","PORX_MT060340CA.Reason2"})
public class PrescribedBecauseOfBean extends MessagePartBean {

    private INT indicationPriority = new INTImpl();
    private IndicationsBean indications;
    private AdministrationInstructionsBean dosageInstruction;

    @Hl7XmlMapping({"priorityNumber"})
    public java.lang.Integer getIndicationPriority() {
        return this.indicationPriority.getValue();
    }
    public void setIndicationPriority(java.lang.Integer indicationPriority) {
        this.indicationPriority.setValue(indicationPriority);
    }

    @Hl7XmlMapping({"indications"})
    public IndicationsBean getIndications() {
        return this.indications;
    }
    public void setIndications(IndicationsBean indications) {
        this.indications = indications;
    }

    @Hl7XmlMapping({"dosageInstruction"})
    public AdministrationInstructionsBean getDosageInstruction() {
        return this.dosageInstruction;
    }
    public void setDosageInstruction(AdministrationInstructionsBean dosageInstruction) {
        this.dosageInstruction = dosageInstruction;
    }

}
