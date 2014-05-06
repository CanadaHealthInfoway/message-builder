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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AllergyTestValue;
import ca.infoway.messagebuilder.domainvalue.ObservationAllergyTestType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: AllergyTests</p>
 * 
 * <p>REPC_MT000005CA.AllergyTestEvent: Allergy Tests</p>
 * 
 * <p>Provides evidence for recording the 
 * allergy/intolerance.</p>
 * 
 * <p>Indicates the specific allergy test that supports the 
 * recording of the allergy/intolerance.</p>
 * 
 * <p>REPC_MT000001CA.AllergyTestEvent: Allergy Tests</p>
 * 
 * <p>At least one of Id or Value must be specified.</p>
 * 
 * <p>Provides evidence for recording the 
 * allergy/intolerance.</p>
 * 
 * <p>Indicates the specific allergy test that supports the 
 * recording of the allergy/intolerance.</p>
 * 
 * <p>REPC_MT000013CA.AllergyTestEvent: Allergy Tests</p>
 * 
 * <p>At least one of Id or Value must be specified</p>
 * 
 * <p>Provides evidence for recording the 
 * allergy/intolerance.</p>
 * 
 * <p>Indicates the specific allergy test that supports the 
 * recording of the allergy/intolerance.</p>
 * 
 * <p>REPC_MT000009CA.AllergyTestEvent: Allergy Tests</p>
 * 
 * <p>At least one of Id or Value must be specified.</p>
 * 
 * <p>Provides evidence for recording the 
 * allergy/intolerance.</p>
 * 
 * <p>Indicates the specific allergy test that supports the 
 * recording of the allergy/intolerance.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.AllergyTestEvent","REPC_MT000005CA.AllergyTestEvent","REPC_MT000009CA.AllergyTestEvent","REPC_MT000013CA.AllergyTestEvent"})
public class AllergyTestsBean extends MessagePartBean implements Records {

    private static final long serialVersionUID = 20140506L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private TS effectiveTime = new TSImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: AllergyTestRecordId</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AllergyTestRecordId</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestRecordId</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows an allergy/intolerance test record to be directly 
     * referenced.</p>
     * 
     * <p>An identifier for a specific instance of an 
     * allergy/intolerance test.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: AllergyTestType</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>At least one of Id or Value must be specified.</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationAllergyTestType getCode() {
        return (ObservationAllergyTestType) this.code.getValue();
    }

    /**
     * <p>Business Name: AllergyTestType</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>At least one of Id or Value must be specified.</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestType</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows different kinds of allergy/intolerance tests to be 
     * distinguishable and is therefore mandatory.</p>
     * 
     * <p>A coded value denoting the type of allergy test 
     * conducted.</p>
     */
    public void setCode(ObservationAllergyTestType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: AllergyTestDate</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: AllergyTestDate</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000005CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000001CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000013CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.AllergyTestEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers to evaluate the currency of the 
     * test.</p>
     * 
     * <p>The date on which the allergy test was performed.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: AllergyTestResult</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     */
    @Hl7XmlMapping({"value"})
    public AllergyTestValue getValue() {
        return (AllergyTestValue) this.value.getValue();
    }

    /**
     * <p>Business Name: AllergyTestResult</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000005CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000001CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000013CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     * 
     * <p>Un-merged Business Name: AllergyTestResult</p>
     * 
     * <p>Relationship: REPC_MT000009CA.AllergyTestEvent.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows other providers to evaluate the test.</p>
     * 
     * <p>A code indicating result of the allergy test.</p>
     */
    public void setValue(AllergyTestValue value) {
        this.value.setValue(value);
    }

}
