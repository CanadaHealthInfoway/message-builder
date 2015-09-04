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
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActAntigenInvalidReason;



/**
 * <p>Business Name: AntigenValidity</p>
 * 
 * <p>POIZ_MT030050CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p>
 * 
 * <p>Indicates whether an antigen administered to a patient is 
 * considered valid according to an immunization schedule.</p>
 * 
 * <p>POIZ_MT061150CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p>
 * 
 * <p>Indicates whether an antigen administered to a patient is 
 * considered valid according to an immunization schedule.</p>
 * 
 * <p>POIZ_MT030060CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p>
 * 
 * <p>Indicates whether an antigen administered to a patient is 
 * considered valid according to an immunization schedule.</p>
 * 
 * <p>POIZ_MT060150CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p>
 * 
 * <p>Indicates whether an antigen administered to a patient is 
 * considered valid according to an immunization schedule.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AntigenValidity","POIZ_MT030060CA.AntigenValidity","POIZ_MT060150CA.AntigenValidity","POIZ_MT061150CA.AntigenValidity"})
public class AntigenValidityBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private CV reasonCode = new CVImpl();
    private BL value = new BLImpl();


    /**
     * <p>Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActAntigenInvalidReason getReasonCode() {
        return (ActAntigenInvalidReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     * 
     * <p>Un-merged Business Name: InvalidAntigenReasonCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenValidity.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>reasonCode only populated if value is 
     * &quot;false&quot;</p>
     * 
     * <p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p>
     * 
     * <p>A coded value to describe why an antigen is considered to 
     * be invalid.</p>
     */
    public void setReasonCode(ActAntigenInvalidReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     */
    @Hl7XmlMapping({"value"})
    public Boolean getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenValidityIndicator</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenValidity.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p>
     * 
     * <p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p>
     */
    public void setValue(Boolean value) {
        this.value.setValue(value);
    }

}
