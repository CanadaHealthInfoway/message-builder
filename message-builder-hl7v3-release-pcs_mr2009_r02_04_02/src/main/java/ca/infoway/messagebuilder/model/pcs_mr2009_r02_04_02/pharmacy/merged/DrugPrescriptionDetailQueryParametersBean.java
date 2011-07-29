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
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition.</p></p>
 * 
 * <p>PORX_MT060360CA.ParameterList: Generic Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060280CA.ParameterList","PORX_MT060360CA.ParameterList"})
@Hl7RootType
public class DrugPrescriptionDetailQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private List<II> careCompositionIDs = new ArrayList<II>();
    private List<CV> careCompositionTypes = new ArrayList<CV>();
    private BL includeEventHistoryIndicator = new BLImpl();
    private BL includeIssuesIndicator = new BLImpl();
    private BL includeNotesIndicator = new BLImpl();
    private BL includePendingChangesIndicator = new BLImpl();
    private SET<II, Identifier> prescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private II prescriptionDispenseNumber = new IIImpl();


    /**
     * <p>CareCompositionIDs</p>
     * 
     * <p>Care Composition IDs</p>
     * 
     * <p><p>Desc: Filters the records retrieved to only include 
     * those associated with the specified encounter, episode or 
     * care event. If unspecified, no filter is 
     * applied.</p><p>Note: When matching on care composition id, 
     * systems should also retrieve records with a fulfillment id 
     * to requisitions associated with the care composition. E.g. 
     * When retrieving records associated with an encounter which 
     * includes a referral, the retrieved records should also 
     * include the care summary created in fulfillment of the 
     * referral.</p></p>
     * 
     * <p><p>Desc: Filters the records retrieved to only include 
     * those associated with the specified encounter, episode or 
     * care event. If unspecified, no filter is 
     * applied.</p><p>Note: When matching on care composition id, 
     * systems should also retrieve records with a fulfillment id 
     * to requisitions associated with the care composition. E.g. 
     * When retrieving records associated with an encounter which 
     * includes a referral, the retrieved records should also 
     * include the care summary created in fulfillment of the 
     * referral.</p></p>
     * 
     * <p><p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p></p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDs() {
        return new RawListWrapper<II, Identifier>(careCompositionIDs, IIImpl.class);
    }


    /**
     * <p>CareCompositionTypes</p>
     * 
     * <p>Care Composition Types</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p></p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypes() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypes, CVImpl.class);
    }


    /**
     * <p>IncludeEventHistoryIndicator</p>
     * 
     * <p>Include Event History Indicator</p>
     * 
     * <p><p>Indicates whether or not history of selected 
     * medication records are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p></p>
     * 
     * <p><p>Indicates whether or not history of selected 
     * medication records are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * history in the retrieval of the requested 
     * information.</p><p>Because the attribute is always either 
     * 'TRUE' or 'FALSE' it is mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * history in the retrieval of the requested 
     * information.</p><p>Because the attribute is always either 
     * 'TRUE' or 'FALSE' it is mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public Boolean getIncludeEventHistoryIndicator() {
        return this.includeEventHistoryIndicator.getValue();
    }
    public void setIncludeEventHistoryIndicator(Boolean includeEventHistoryIndicator) {
        this.includeEventHistoryIndicator.setValue(includeEventHistoryIndicator);
    }


    /**
     * <p>IncludeIssuesIndicator</p>
     * 
     * <p>Include Issues Indicator</p>
     * 
     * <p><p>Indicates whether or not issues (detected and/or 
     * managed) attached to the prescriptions, dispenses and other 
     * active medication records are to be returned along with the 
     * detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Issues Indicator</p>
     * 
     * <p><p>Indicates whether or not Issues (detected and/or 
     * managed) attached to the prescription dispense record to be 
     * returned along with the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of patient medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of patient medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }
    public void setIncludeIssuesIndicator(Boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }


    /**
     * <p>IncludeNotesIndicator</p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the 
     * selected medication records are to be returned along with 
     * the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }


    /**
     * <p>IncludePendingChangesIndicator</p>
     * 
     * <p>Include Pending Changes Indicator</p>
     * 
     * <p><p>Indicates whether to include future changes (e.g. 
     * status changes that aren't effective yet) associated with a 
     * prescription order and/or prescription dispense are to be 
     * returned along with the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * future events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * future events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includePendingChangesIndicator/value"})
    public Boolean getIncludePendingChangesIndicator() {
        return this.includePendingChangesIndicator.getValue();
    }
    public void setIncludePendingChangesIndicator(Boolean includePendingChangesIndicator) {
        this.includePendingChangesIndicator.setValue(includePendingChangesIndicator);
    }


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>Prescription order Number</p>
     * 
     * <p><p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p></p>
     * 
     * <p><p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p></p>
     * 
     * <p><p>Identifies the prescription that is to be retrieved, 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Set<Identifier> getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.rawSet();
    }


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>D:Prescription Dispense Number</p>
     * 
     * <p><p>Identifies which prescription dispense record should 
     * be retrieved.</p></p>
     * 
     * <p><p>Allows for the retrieval of medication records 
     * relating to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

}
