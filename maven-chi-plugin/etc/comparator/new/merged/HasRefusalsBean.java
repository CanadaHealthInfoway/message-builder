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
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT030040CA.Subject3","PORX_MT060040CA.Subject8","PORX_MT060060CA.Subject3","PORX_MT060160CA.Subject16","PORX_MT060190CA.Subject3","PORX_MT060340CA.Subject9"})
public class HasRefusalsBean extends MessagePartBean {

    private TS refusalToFillDate = new TSImpl();
    private CV<ActSupplyFulfillmentRefusalReason> refusalToFillReason = new CVImpl<ActSupplyFulfillmentRefusalReason>();
    private RefusedByBean refusalToFillAuthor = new RefusedByBean();
    private List<IssuesBean> refusalToFillReasonDetectedIssueEvent = new ArrayList<IssuesBean>();
    private CreatedAtBean refusalToFillLocation = new CreatedAtBean();

    @Hl7XmlMapping({"refusalToFill/effectiveTime"})
    public Date getRefusalToFillDate() {
        return this.refusalToFillDate.getValue();
    }
    public void setRefusalToFillDate(Date refusalToFillDate) {
        this.refusalToFillDate.setValue(refusalToFillDate);
    }

    @Hl7XmlMapping({"refusalToFill/reasonCode"})
    public ActSupplyFulfillmentRefusalReason getRefusalToFillReason() {
        return this.refusalToFillReason.getValue();
    }
    public void setRefusalToFillReason(ActSupplyFulfillmentRefusalReason refusalToFillReason) {
        this.refusalToFillReason.setValue(refusalToFillReason);
    }

    @Hl7XmlMapping({"refusalToFill/author"})
    public RefusedByBean getRefusalToFillAuthor() {
        return this.refusalToFillAuthor;
    }
    public void setRefusalToFillAuthor(RefusedByBean refusalToFillAuthor) {
        this.refusalToFillAuthor = refusalToFillAuthor;
    }

    @Hl7XmlMapping({"refusalToFill/reason/detectedIssueEvent"})
    public List<IssuesBean> getRefusalToFillReasonDetectedIssueEvent() {
        return this.refusalToFillReasonDetectedIssueEvent;
    }

    @Hl7XmlMapping({"refusalToFill/location"})
    public CreatedAtBean getRefusalToFillLocation() {
        return this.refusalToFillLocation;
    }
    public void setRefusalToFillLocation(CreatedAtBean refusalToFillLocation) {
        this.refusalToFillLocation = refusalToFillLocation;
    }

}
