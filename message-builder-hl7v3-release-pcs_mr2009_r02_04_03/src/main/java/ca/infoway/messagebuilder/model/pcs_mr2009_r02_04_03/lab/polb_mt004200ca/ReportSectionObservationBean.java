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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.SectionHeadingObservationCode;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: Report Section Observation</p>
 * 
 * <p>Any report sections reported at the header or report 
 * level (not specific to a specimen or diagnosis).</p>
 */
@Hl7PartTypeMapping({"POLB_MT004200CA.ReportLevelObservationEvent"})
public class ReportSectionObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private TS effectiveTime = new TSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private ANY<Object> value = new ANYImpl<Object>();


    /**
     * <p>Business Name: Section Identifier</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Unique identifier for a section of the report at the 
     * ObservationReport level.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Section Identifier</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Unique identifier for a section of the report at the 
     * ObservationReport level.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Report Section Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Specifies the type of report section.</p>
     */
    @Hl7XmlMapping({"code"})
    public SectionHeadingObservationCode getCode() {
        return (SectionHeadingObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Report Section Observation Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Specifies the type of report section.</p>
     */
    public void setCode(SectionHeadingObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Note Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Type of comment or note.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Note Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Type of comment or note.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Report Section Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time this report section was 
     * &quot;reported&quot;.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Report Section Observation Date/Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time this report section was 
     * &quot;reported&quot;.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Result Masking Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Business Name: Report Section Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The report section values - usually this is text-based. 
     * If a coded value applies, values must be selected from the 
     * SectionHeadingObservationValue Concept Domain.</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Report Section Observation Value</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ReportLevelObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The report section values - usually this is text-based. 
     * If a coded value applies, values must be selected from the 
     * SectionHeadingObservationValue Concept Domain.</p>
     */
    public void setValue(Object value) {
        this.value.setValue(value);
    }

}
