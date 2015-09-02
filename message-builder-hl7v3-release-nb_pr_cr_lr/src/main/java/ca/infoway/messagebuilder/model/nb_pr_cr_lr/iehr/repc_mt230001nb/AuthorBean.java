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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.repc_mt230001nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108nb.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090508nb.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt910108nb.RelatedPersonBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT230001NB.Author"})
public class AuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private TS time = new TSImpl();
    private CE signatureCode = new CEImpl();
    private ActingPerson actingPerson;


    /**
     * <p>Business Name: X: Authored Datetime</p>
     * 
     * <p>Relationship: REPC_MT230001NB.Author.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: X: Authored Datetime</p>
     * 
     * <p>Relationship: REPC_MT230001NB.Author.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Business Name: K: Attested Indicator</p>
     * 
     * <p>Relationship: REPC_MT230001NB.Author.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"signatureCode"})
    public ParticipationSignature getSignatureCode() {
        return (ParticipationSignature) this.signatureCode.getValue();
    }

    /**
     * <p>Business Name: K: Attested Indicator</p>
     * 
     * <p>Relationship: REPC_MT230001NB.Author.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSignatureCode(ParticipationSignature signatureCode) {
        this.signatureCode.setValue(signatureCode);
    }


    /**
     * <p>Relationship: REPC_MT230001NB.Author.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }

    /**
     * <p>Relationship: REPC_MT230001NB.Author.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
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
