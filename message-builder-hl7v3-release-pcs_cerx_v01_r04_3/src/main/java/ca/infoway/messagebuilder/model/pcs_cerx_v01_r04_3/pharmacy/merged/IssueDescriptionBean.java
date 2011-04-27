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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueDefinition","PORX_MT980020CA.DetectedIssueDefinition","PORX_MT980030CA.DetectedIssueDefinition"})
public class IssueDescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II issueMonographId = new IIImpl();
    private ANY<Object> issueDescription = new ANYImpl<Object>();
    private TS issueMonographEffectiveDate = new TSImpl();
    private ST knowledgebaseVendorName = new STImpl();
    private RecommendedDosageBean componentSubstanceAdministrationEventCriterion;


    /**
     * <p>IssueMonographId</p>
     * 
     * <p>A:Issue Monograph Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getIssueMonographId() {
        return this.issueMonographId.getValue();
    }
    public void setIssueMonographId(Identifier issueMonographId) {
        this.issueMonographId.setValue(issueMonographId);
    }


    /**
     * <p>IssueDescription</p>
     * 
     * <p>C:Issue Description</p>
     */
    @Hl7XmlMapping({"text"})
    public Object getIssueDescription() {
        return this.issueDescription.getValue();
    }
    public void setIssueDescription(Object issueDescription) {
        this.issueDescription.setValue(issueDescription);
    }


    /**
     * <p>IssueMonographEffectiveDate</p>
     * 
     * <p>B:Issue Monograph Effective Date</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getIssueMonographEffectiveDate() {
        return this.issueMonographEffectiveDate.getValue();
    }
    public void setIssueMonographEffectiveDate(Date issueMonographEffectiveDate) {
        this.issueMonographEffectiveDate.setValue(issueMonographEffectiveDate);
    }


    /**
     * <p>KnowledgebaseVendorName</p>
     * 
     * <p>C:Knowledgebase Vendor Name</p>
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name"})
    public String getKnowledgebaseVendorName() {
        return this.knowledgebaseVendorName.getValue();
    }
    public void setKnowledgebaseVendorName(String knowledgebaseVendorName) {
        this.knowledgebaseVendorName.setValue(knowledgebaseVendorName);
    }


    @Hl7XmlMapping({"component/substanceAdministrationEventCriterion"})
    public RecommendedDosageBean getComponentSubstanceAdministrationEventCriterion() {
        return this.componentSubstanceAdministrationEventCriterion;
    }
    public void setComponentSubstanceAdministrationEventCriterion(RecommendedDosageBean componentSubstanceAdministrationEventCriterion) {
        this.componentSubstanceAdministrationEventCriterion = componentSubstanceAdministrationEventCriterion;
    }

}
