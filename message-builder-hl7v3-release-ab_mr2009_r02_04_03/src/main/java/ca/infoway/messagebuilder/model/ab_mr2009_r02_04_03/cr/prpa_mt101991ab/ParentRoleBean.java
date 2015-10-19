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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101991ab;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.PersonalRelationshipRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PRPA_MT101991AB.ParentRole"})
public class ParentRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20151019L;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private INT quantity = new INTImpl();
    private INT positionNumber = new INTImpl();
    private II relationshipHolderId = new IIImpl();


    /**
     * <p>Business Name: Dependent Type</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This is used to convey whether the relationship to the 
     * child is a natural parent, a guardian, an adoptive parent, 
     * or a custodian.</p>
     */
    @Hl7XmlMapping({"code"})
    public PersonalRelationshipRoleType getCode() {
        return (PersonalRelationshipRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Dependent Type</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>This is used to convey whether the relationship to the 
     * child is a natural parent, a guardian, an adoptive parent, 
     * or a custodian.</p>
     */
    public void setCode(PersonalRelationshipRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Date Placed In Care</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Date Placed In Care</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Birth Count</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: Birth Count</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: Birth Order</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.positionNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"positionNumber"})
    public Integer getPositionNumber() {
        return this.positionNumber.getValue();
    }

    /**
     * <p>Business Name: Birth Order</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentRole.positionNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber.setValue(positionNumber);
    }


    /**
     * <p>Business Name: Parent ULI</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>the Reason for No ULI would go here as a Null Flavor.</p>
     */
    @Hl7XmlMapping({"relationshipHolder/id"})
    public Identifier getRelationshipHolderId() {
        return this.relationshipHolderId.getValue();
    }

    /**
     * <p>Business Name: Parent ULI</p>
     * 
     * <p>Relationship: PRPA_MT101991AB.ParentPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>the Reason for No ULI would go here as a Null Flavor.</p>
     */
    public void setRelationshipHolderId(Identifier relationshipHolderId) {
        this.relationshipHolderId.setValue(relationshipHolderId);
    }

}
