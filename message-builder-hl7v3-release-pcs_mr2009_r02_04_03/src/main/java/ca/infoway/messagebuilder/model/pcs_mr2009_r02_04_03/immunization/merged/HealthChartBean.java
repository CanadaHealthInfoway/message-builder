/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.HealthChart","POIZ_MT030060CA.HealthChart","POIZ_MT060150CA.HealthChart"})
public class HealthChartBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private AntigenValidityBean subjectOf1AntigenValidity;
    private AntigenCountBean subjectOf2AntigenCount;


    @Hl7XmlMapping({"subjectOf1/antigenValidity"})
    public AntigenValidityBean getSubjectOf1AntigenValidity() {
        return this.subjectOf1AntigenValidity;
    }
    public void setSubjectOf1AntigenValidity(AntigenValidityBean subjectOf1AntigenValidity) {
        this.subjectOf1AntigenValidity = subjectOf1AntigenValidity;
    }


    @Hl7XmlMapping({"subjectOf2/antigenCount"})
    public AntigenCountBean getSubjectOf2AntigenCount() {
        return this.subjectOf2AntigenCount;
    }
    public void setSubjectOf2AntigenCount(AntigenCountBean subjectOf2AntigenCount) {
        this.subjectOf2AntigenCount = subjectOf2AntigenCount;
    }

}
