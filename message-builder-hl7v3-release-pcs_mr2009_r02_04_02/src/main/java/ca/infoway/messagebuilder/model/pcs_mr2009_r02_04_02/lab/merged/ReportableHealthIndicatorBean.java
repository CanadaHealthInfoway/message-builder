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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POLB_MT004200CA.ReportableTestIndicator: Reportable 
 * Health Indicator</p>
 * 
 * <p><p>This must not be linked at ObservationReport 
 * level.</p></p>
 * 
 * <p><p>Indicates whether or not this result is reportable to 
 * another party such as an agency, study, or other 
 * authority.</p></p>
 * 
 * <p>POLB_MT004000CA.ReportableTestIndicator: Reportable 
 * Observation</p>
 * 
 * <p><p>Report test and test results to Public Health and or 
 * other entities</p></p>
 * 
 * <p>POLB_MT004100CA.ReportableTestIndicator: Reportable 
 * Health Indicator</p>
 * 
 * <p><p>Indicates whether or not this result is reportable to 
 * another agency, study, or authority.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ReportableTestIndicator","POLB_MT004100CA.ReportableTestIndicator","POLB_MT004200CA.ReportableTestIndicator"})
public class ReportableHealthIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CD observationTypeReportableIndicator = new CDImpl();
    private BL reportableIndicator = new BLImpl();


    /**
     * <p>ObservationTypeReportableIndicator</p>
     * 
     * <p>Observation Type - Reportable Indicator</p>
     * 
     * <p><p>Specifies this observation as a reportable test 
     * indicator</p></p>
     * 
     * <p>Observation Type - Reportable Indicator</p>
     * 
     * <p><p>Describes this observation as an indicator as to 
     * whether or not this result is to be reported to public 
     * health.</p></p>
     * 
     * <p>Observation Type - Reportable Indicator</p>
     * 
     * <p><p>Specifies this observation as indicating whether the 
     * associated result is reportable to an agency, ministry, 
     * study, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getObservationTypeReportableIndicator() {
        return (Code) this.observationTypeReportableIndicator.getValue();
    }
    public void setObservationTypeReportableIndicator(Code observationTypeReportableIndicator) {
        this.observationTypeReportableIndicator.setValue(observationTypeReportableIndicator);
    }


    /**
     * <p>ReportableIndicator</p>
     * 
     * <p>Reportable Indicator</p>
     * 
     * <p><p>Report test and test results to another entity.</p></p>
     * 
     * <p>Reportable Indicator</p>
     * 
     * <p><p>This boolean value set whether this result is 
     * reportable. True=reportable, false=not reportable.</p></p>
     * 
     * <p>Reportable Indicator</p>
     * 
     * <p><p>This boolean value set whether this result is 
     * reportable to another agency, study, panel, authority, etc. 
     * True=reportable, false=not reportable.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Boolean getReportableIndicator() {
        return this.reportableIndicator.getValue();
    }
    public void setReportableIndicator(Boolean reportableIndicator) {
        this.reportableIndicator.setValue(reportableIndicator);
    }

}
