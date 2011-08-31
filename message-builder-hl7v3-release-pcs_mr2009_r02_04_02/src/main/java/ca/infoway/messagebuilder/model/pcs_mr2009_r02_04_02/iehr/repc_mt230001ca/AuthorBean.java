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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt230001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt910108ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT230001CA.Author"})
public class AuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS authoredDatetime = new TSImpl();
    private CE attestedIndicator = new CEImpl();
    private ActingPerson actingPerson;


    /**
     * <p>X: Authored Datetime</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getAuthoredDatetime() {
        return this.authoredDatetime.getValue();
    }
    public void setAuthoredDatetime(Date authoredDatetime) {
        this.authoredDatetime.setValue(authoredDatetime);
    }


    /**
     * <p>K: Attested Indicator</p>
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

    public HealthcareWorkerBean getActingPersonAsAssignedEntity1() {
        return this.actingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsAssignedEntity1() {
        return (this.actingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getActingPersonAsAssignedEntity2() {
        return this.actingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsAssignedEntity2() {
        return (this.actingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getActingPersonAsPersonalRelationship() {
        return this.actingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.actingPerson : null;
    }
    public boolean hasActingPersonAsPersonalRelationship() {
        return (this.actingPerson instanceof RelatedPersonBean);
    }

}