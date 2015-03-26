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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ReportableToCode;



/**
 * <p>POLB_MT004200CA.ReportableTestIndicator: Reportable 
 * Health Indicator</p>
 * 
 * <p>This must not be linked at ObservationReport level.</p>
 * 
 * <p>Indicates whether or not this result is reportable to 
 * another party such as an agency, study, or other 
 * authority.</p>
 * 
 * <p>POLB_MT004000CA.ReportableTestIndicator: Reportable 
 * Observation</p>
 * 
 * <p>Report test and test results to Public Health and or 
 * other entities</p>
 * 
 * <p>POLB_MT004100CA.ReportableTestIndicator: Reportable 
 * Health Indicator</p>
 * 
 * <p>Indicates whether or not this result is reportable to 
 * another agency, study, or authority.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ReportableTestIndicator","POLB_MT004100CA.ReportableTestIndicator","POLB_MT004200CA.ReportableTestIndicator"})
public class ReportableHealthIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CD code = new CDImpl();
    private BL value = new BLImpl();


    /**
     * <p>Business Name: ObservationTypeReportableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Specifies this observation as indicating whether the 
     * associated result is reportable to an agency, ministry, 
     * study, etc.</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this observation as an indicator as to whether 
     * or not this result is to be reported to public health.</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Specifies this observation as a reportable test 
     * indicator</p>
     */
    @Hl7XmlMapping({"code"})
    public ReportableToCode getCode() {
        return (ReportableToCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ObservationTypeReportableIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Specifies this observation as indicating whether the 
     * associated result is reportable to an agency, ministry, 
     * study, etc.</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this observation as an indicator as to whether 
     * or not this result is to be reported to public health.</p>
     * 
     * <p>Un-merged Business Name: 
     * ObservationTypeReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ReportableTestIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Specifies this observation as a reportable test 
     * indicator</p>
     */
    public void setCode(ReportableToCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ReportableIndicator</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This boolean value set whether this result is reportable. 
     * True=reportable, false=not reportable.</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Report test and test results to another entity.</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This boolean value set whether this result is reportable 
     * to another agency, study, panel, authority, etc. 
     * True=reportable, false=not reportable.</p>
     */
    @Hl7XmlMapping({"value"})
    public Boolean getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: ReportableIndicator</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This boolean value set whether this result is reportable. 
     * True=reportable, false=not reportable.</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Report test and test results to another entity.</p>
     * 
     * <p>Un-merged Business Name: ReportableIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ReportableTestIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This boolean value set whether this result is reportable 
     * to another agency, study, panel, authority, etc. 
     * True=reportable, false=not reportable.</p>
     */
    public void setValue(Boolean value) {
        this.value.setValue(value);
    }

}
