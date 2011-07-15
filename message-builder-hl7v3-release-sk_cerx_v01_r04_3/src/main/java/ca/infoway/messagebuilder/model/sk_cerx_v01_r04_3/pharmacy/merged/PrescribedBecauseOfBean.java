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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980050ca.DiagnosisIndicationsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980050ca.Indications;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980050ca.OtherIndicationsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980050ca.SymptomIndicationsBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.Reason2","PORX_MT010120CA.Reason2","PORX_MT030040CA.Reason","PORX_MT060040CA.Reason2","PORX_MT060060CA.Reason","PORX_MT060160CA.Reason2","PORX_MT060190CA.Reason","PORX_MT060340CA.Reason2"})
public class PrescribedBecauseOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20110715L;
    private INT indicationPriority = new INTImpl();
    private Indications indications;


    /**
     * <p>IndicationPriority</p>
     * 
     * <p>B:Indication Priority</p>
     * 
     * <p>Indication Priority</p>
     */
    @Hl7XmlMapping({"priorityNumber"})
    public Integer getIndicationPriority() {
        return this.indicationPriority.getValue();
    }
    public void setIndicationPriority(Integer indicationPriority) {
        this.indicationPriority.setValue(indicationPriority);
    }


    @Hl7XmlMapping({"indications"})
    public Indications getIndications() {
        return this.indications;
    }
    public void setIndications(Indications indications) {
        this.indications = indications;
    }

    public DiagnosisIndicationsBean getIndicationsAsObservationDiagnosis() {
        return this.indications instanceof DiagnosisIndicationsBean ? (DiagnosisIndicationsBean) this.indications : null;
    }
    public boolean hasIndicationsAsObservationDiagnosis() {
        return (this.indications instanceof DiagnosisIndicationsBean);
    }

    public SymptomIndicationsBean getIndicationsAsObservationSymptom() {
        return this.indications instanceof SymptomIndicationsBean ? (SymptomIndicationsBean) this.indications : null;
    }
    public boolean hasIndicationsAsObservationSymptom() {
        return (this.indications instanceof SymptomIndicationsBean);
    }

    public OtherIndicationsBean getIndicationsAsOtherIndication() {
        return this.indications instanceof OtherIndicationsBean ? (OtherIndicationsBean) this.indications : null;
    }
    public boolean hasIndicationsAsOtherIndication() {
        return (this.indications instanceof OtherIndicationsBean);
    }

}
