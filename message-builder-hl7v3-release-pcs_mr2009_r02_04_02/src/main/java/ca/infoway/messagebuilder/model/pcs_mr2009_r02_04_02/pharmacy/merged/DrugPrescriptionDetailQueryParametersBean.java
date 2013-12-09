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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>PORX_MT060280CA.ParameterList: Drug Prescription Detail 
 * Query Parameters</p>
 * 
 * <p>Root class for query definition.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>PORX_MT060360CA.ParameterList: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060280CA.ParameterList","PORX_MT060360CA.ParameterList"})
@Hl7RootType
public class DrugPrescriptionDetailQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private BL includeEventHistoryIndicatorValue = new BLImpl();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private BL includePendingChangesIndicatorValue = new BLImpl();
    private SET<II, Identifier> prescriptionOrderNumberValue = new SETImpl<II, Identifier>(IIImpl.class);
    private II prescriptionDispenseNumberValue = new IIImpl();


    /**
     * <p>Business Name: CareCompositionIDs</p>
     * 
     * <p>Un-merged Business Name: CareCompositionIDs</p>
     * 
     * <p>Relationship: PORX_MT060280CA.CareCompositionID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p>
     * 
     * <p>Desc: Filters the records retrieved to only include those 
     * associated with the specified encounter, episode or care 
     * event. If unspecified, no filter is applied.</p><p>Note: 
     * When matching on care composition id, systems should also 
     * retrieve records with a fulfillment id to requisitions 
     * associated with the care composition. E.g. When retrieving 
     * records associated with an encounter which includes a 
     * referral, the retrieved records should also include the care 
     * summary created in fulfillment of the referral.</p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: CareCompositionTypes</p>
     * 
     * <p>Un-merged Business Name: CareCompositionTypes</p>
     * 
     * <p>Relationship: PORX_MT060280CA.CareCompositionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: IncludeEventHistoryIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeEventHistoryIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is always either 'TRUE' or 'FALSE' it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not history of selected medication 
     * records are to be returned along with the detailed 
     * information.</p><p>&quot;Pending&quot; changes will be 
     * returned regardless of the setting of this flag.</p>
     */
    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public Boolean getIncludeEventHistoryIndicatorValue() {
        return this.includeEventHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: IncludeEventHistoryIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeEventHistoryIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is always either 'TRUE' or 'FALSE' it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not history of selected medication 
     * records are to be returned along with the detailed 
     * information.</p><p>&quot;Pending&quot; changes will be 
     * returned regardless of the setting of this flag.</p>
     */
    public void setIncludeEventHistoryIndicatorValue(Boolean includeEventHistoryIndicatorValue) {
        this.includeEventHistoryIndicatorValue.setValue(includeEventHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not issues (detected and/or managed) 
     * attached to the prescriptions, dispenses and other active 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Un-merged Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescription dispense record to be returned 
     * along with the detailed information.</p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicatorValue() {
        return this.includeIssuesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not issues (detected and/or managed) 
     * attached to the prescriptions, dispenses and other active 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Un-merged Business Name: IncludeIssuesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescription dispense record to be returned 
     * along with the detailed information.</p>
     */
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Relationship: PORX_MT060280CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the selected 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Un-merged Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Relationship: PORX_MT060360CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Relationship: PORX_MT060280CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the selected 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Un-merged Business Name: IncludeNotesIndicator</p>
     * 
     * <p>Relationship: PORX_MT060360CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: IncludePendingChangesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludePendingChangesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludePendingChangesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including future 
     * events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether to include future changes (e.g. status 
     * changes that aren't effective yet) associated with a 
     * prescription order and/or prescription dispense are to be 
     * returned along with the detailed information.</p>
     */
    @Hl7XmlMapping({"includePendingChangesIndicator/value"})
    public Boolean getIncludePendingChangesIndicatorValue() {
        return this.includePendingChangesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: IncludePendingChangesIndicator</p>
     * 
     * <p>Un-merged Business Name: IncludePendingChangesIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.IncludePendingChangesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including future 
     * events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether to include future changes (e.g. status 
     * changes that aren't effective yet) associated with a 
     * prescription order and/or prescription dispense are to be 
     * returned along with the detailed information.</p>
     */
    public void setIncludePendingChangesIndicatorValue(Boolean includePendingChangesIndicatorValue) {
        this.includePendingChangesIndicatorValue.setValue(includePendingChangesIndicatorValue);
    }


    /**
     * <p>Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060280CA.PrescriptionOrderNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Identifies the prescription that is to be retrieved, and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p>
     */
    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Set<Identifier> getPrescriptionOrderNumberValue() {
        return this.prescriptionOrderNumberValue.rawSet();
    }


    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     */
    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumberValue() {
        return this.prescriptionDispenseNumberValue.getValue();
    }

    /**
     * <p>Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Un-merged Business Name: PrescriptionDispenseNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     */
    public void setPrescriptionDispenseNumberValue(Identifier prescriptionDispenseNumberValue) {
        this.prescriptionDispenseNumberValue.setValue(prescriptionDispenseNumberValue);
    }

}
