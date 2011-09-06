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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import java.util.Date;



/**
 * <p>REPC_MT230002CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220001CA.Author3: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230002CA.Author2: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500001CA.Author2: *requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220002CA.Author3: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500002CA.Author2: *requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230003CA.Author2: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500003CA.Author2: *requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220002CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT210003CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230003CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT210002CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500004CA.Author: *amended by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT420001CA.Author2: *i:requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT230001CA.Author2: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220003CA.Author3: *a: requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500004CA.Author2: *requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT610001CA.Author: *c:requested by</p>
 * 
 * <p></p></p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500003CA.Author: *amended by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220003CA.Author: *a: authored by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT610002CA.Author: *c:requested by</p>
 * 
 * <p></p></p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p><p>ZPS.6</p><p>A_BillableClinicalService</p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT420003CA.Author2: *i:requested by</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 */
@Hl7PartTypeMapping({"REPC_MT210001CA.Author","REPC_MT210002CA.Author","REPC_MT210003CA.Author","REPC_MT220001CA.Author","REPC_MT220001CA.Author3","REPC_MT220002CA.Author","REPC_MT220002CA.Author3","REPC_MT220003CA.Author","REPC_MT220003CA.Author3","REPC_MT230001CA.Author2","REPC_MT230002CA.Author","REPC_MT230002CA.Author2","REPC_MT230003CA.Author","REPC_MT230003CA.Author2","REPC_MT410001CA.Author","REPC_MT410003CA.Author2","REPC_MT410003CA.Author3","REPC_MT420001CA.Author2","REPC_MT420003CA.Author2","REPC_MT500001CA.Author2","REPC_MT500002CA.Author2","REPC_MT500003CA.Author","REPC_MT500003CA.Author2","REPC_MT500004CA.Author","REPC_MT500004CA.Author2","REPC_MT610001CA.Author","REPC_MT610002CA.Author"})
public class RequestedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private TS time = new TSImpl();
    private CV attestedIndicator = new CVImpl();
    private ActingPerson actingPerson;


    /**
     * <p>X: Authored Datetime</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Authored Datetime</p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p>G:Amend Datetime</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>X: Authored Datetime</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>AttestedIndicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p>K:Attested Indicator</p>
     * 
     * <p><p>An indication that the provider attests to the 
     * authenticity of the document that he/she has authored.</p></p>
     * 
     * <p><p>Important for assessing the level of 'officialness' of 
     * a document. Because it must always be known whether a 
     * document has been attested or not, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"signatureCode"})
    public ParticipationSignature getAttestedIndicator() {
        return (ParticipationSignature) this.attestedIndicator.getValue();
    }
    public void setAttestedIndicator(ParticipationSignature attestedIndicator) {
        this.attestedIndicator.setValue(attestedIndicator);
    }


    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }
    public void setActingPerson(ActingPerson actingPerson) {
        this.actingPerson = actingPerson;
    }

}
