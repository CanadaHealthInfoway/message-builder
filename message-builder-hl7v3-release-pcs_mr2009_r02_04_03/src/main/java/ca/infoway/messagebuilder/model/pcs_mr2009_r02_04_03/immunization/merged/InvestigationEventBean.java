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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.IndividualCaseSafetyReportType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: InvestigationEvent</p>
 * 
 * <p>POIZ_MT060150CA.InvestigationEvent: Investigation Event</p>
 * 
 * <p>Provides additional information about the immunization 
 * event by indicating an adverse event is associated and also 
 * provides a mechanism for communicating information about the 
 * report that was filed.</p>
 * 
 * <p>Provides information about an adverse event report 
 * associated with the immunization event.</p>
 * 
 * <p>POIZ_MT030060CA.InvestigationEvent: Investigation Event</p>
 * 
 * <p>Provides additional information about the immunization 
 * event by indicating an adverse event is associated and also 
 * provides a mechanism for communicating information about the 
 * report that was filed.</p>
 * 
 * <p>Provides information about an adverse event report 
 * associated with the immunization event.</p>
 * 
 * <p>POIZ_MT061150CA.InvestigationEvent: Investigation Event</p>
 * 
 * <p>Provides additional information about the immunization 
 * event by indicating an adverse event is associated and also 
 * provides a mechanism for communicating information about the 
 * report that was filed.</p>
 * 
 * <p>Provides information about an adverse event report 
 * associated with the immunization event.</p>
 * 
 * <p>POIZ_MT030050CA.InvestigationEvent: Investigation Event</p>
 * 
 * <p>Provides additional information about the immunization 
 * event by indicating an adverse event is associated and also 
 * provides a mechanism for communicating information about the 
 * report that was filed.</p>
 * 
 * <p>Provides information about an adverse event report 
 * associated with the immunization event.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.InvestigationEvent","POIZ_MT030060CA.InvestigationEvent","POIZ_MT060150CA.InvestigationEvent","POIZ_MT061150CA.InvestigationEvent"})
public class InvestigationEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CS statusCode = new CSImpl();


    /**
     * <p>Business Name: AdverseEventReportID</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AdverseEventReportID</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     * 
     * <p>Un-merged Business Name: AdverseEventReportID</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Provides reference to the Adverse Event Report in the 
     * case that follow up is needed. However, this ID may not 
     * always be known.</p>
     * 
     * <p>Identifier associated with the Adverse Event Report. An 
     * example would be the unique episode number assigned to the 
     * Report of Adverse Events Following Immunization (AEFI).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ReportType</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     */
    @Hl7XmlMapping({"code"})
    public IndividualCaseSafetyReportType getCode() {
        return (IndividualCaseSafetyReportType) this.code.getValue();
    }

    /**
     * <p>Business Name: ReportType</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     * 
     * <p>Un-merged Business Name: ReportType</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism to categorizing the report.</p>
     * 
     * <p>A coded value that indicates the type of report that was 
     * filed.</p>
     */
    public void setCode(IndividualCaseSafetyReportType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: AdverseEventReportText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Un-merged Business Name: AdverseEventReportText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known.</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     * 
     * <p>Un-merged Business Name: AdverseEventText</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.InvestigationEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides information about the adverse event in addition 
     * to an indication that an adverse event occurred - 
     * information that would not otherwise be known</p>
     * 
     * <p>Textual description of the Adverse Event Following 
     * Immunization reported</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ReportStatus</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: ReportStatus</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     * 
     * <p>Un-merged Business Name: ReportStatus</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150CA.InvestigationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides additional context to the receiver as to the 
     * state of the referenced report. As a result, this attribute 
     * is mandatory.</p>
     * 
     * <p>Code indicating the operative status of the business 
     * process, which in this case is an Adverse Event Report. 
     * Status examples: active, completed, etc.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

}
