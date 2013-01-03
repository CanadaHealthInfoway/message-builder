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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.Sequencing;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: SortControl</p>
 * 
 * <p>QUQI_MT120006CA.SortControl: Sort Control</p>
 * 
 * <p>Please consult the implementation guide for further 
 * constraints on using this class</p>
 * 
 * <p>Optional for systems which can receive query requests and 
 * sort the results before returning to the query 
 * requestor.</p>
 * 
 * <p>Holds specification of sort order for instance matches to 
 * a query.</p>
 * 
 * <p>QUQI_MT120008CA.SortControl: Sort Control</p>
 * 
 * <p>Please consult the implementation guide for further 
 * constraints on using this class</p>
 * 
 * <p>Optional for systems which can receive query requests and 
 * sort the results before returning to the query 
 * requestor.</p>
 * 
 * <p>Holds specification of sort order for instance matches to 
 * a query.</p>
 * 
 * <p>QUQI_MT020002CA.SortControl: Sort Control</p>
 * 
 * <p>Please consult the implementation guide for further 
 * constraints on using this class</p>
 * 
 * <p>Optional for systems which can receive query requests and 
 * sort the results before returning to the query 
 * requestor.</p>
 * 
 * <p>Holds specification of sort order for instance matches to 
 * a query.</p>
 * 
 * <p>MFMI_MT700751CA.SortControl: Sort Control</p>
 * 
 * <p>Please consult the implementation guide for further 
 * constraints on using this class</p>
 * 
 * <p>Optional for systems which can receive query requests and 
 * sort the results before returning to the query 
 * requestor.</p>
 * 
 * <p>Holds specification of sort order for instance matches to 
 * a query.</p>
 * 
 * <p>MFMI_MT700746CA.SortControl: Sort Control</p>
 * 
 * <p>Please consult the implementation guide for further 
 * constraints on using this class</p>
 * 
 * <p>Optional for systems which can receive query requests and 
 * sort the results before returning to the query 
 * requestor.</p>
 * 
 * <p>Holds specification of sort order for instance matches to 
 * a query.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700746CA.SortControl","MFMI_MT700751CA.SortControl","QUQI_MT020000CA.SortControl","QUQI_MT020002CA.SortControl","QUQI_MT120006CA.SortControl","QUQI_MT120008CA.SortControl"})
public class SortControlBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private INT sequenceNumber = new INTImpl();
    private ST elementName = new STImpl();
    private CS directionCode = new CSImpl();


    /**
     * <p>Business Name: SequenceNumber</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: SequenceNumber</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     * 
     * <p>Un-merged Business Name: SequenceNumber</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p>
     * 
     * <p>When more than one sort control is specified, this is the 
     * order of this sort element amongst the others.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: SortElementName</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     */
    @Hl7XmlMapping({"elementName"})
    public String getElementName() {
        return this.elementName.getValue();
    }

    /**
     * <p>Business Name: SortElementName</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     * 
     * <p>Un-merged Business Name: SortElementName</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.elementName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the element is mandatory.</p>
     * 
     * <p>Name of the element to sort.</p>
     */
    public void setElementName(String elementName) {
        this.elementName.setValue(elementName);
    }


    /**
     * <p>Business Name: SortControlDirection</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     */
    @Hl7XmlMapping({"directionCode"})
    public Sequencing getDirectionCode() {
        return (Sequencing) this.directionCode.getValue();
    }

    /**
     * <p>Business Name: SortControlDirection</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: MFMI_MT700751CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     * 
     * <p>Un-merged Business Name: SortControlDirection</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.SortControl.directionCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This element is required.</p>
     * 
     * <p>Sets the ascending or descending nature of the sort 
     * request.</p>
     */
    public void setDirectionCode(Sequencing directionCode) {
        this.directionCode.setValue(directionCode);
    }

}
