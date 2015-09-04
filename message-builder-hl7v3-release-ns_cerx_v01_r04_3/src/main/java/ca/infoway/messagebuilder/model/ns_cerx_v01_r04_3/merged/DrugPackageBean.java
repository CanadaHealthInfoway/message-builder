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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.CompliancePackageEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DrugPackage</p>
 * 
 * <p>POME_MT010100CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Used for informing dispenser of the need and 
 * authorization to dispense medication in a clinically 
 * approved container. Aids patients in adhering to 
 * administration instructions. May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 * 
 * <p>COCT_MT220100CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Aids patients in adhering to administration instructions 
 * (e.g. snap caps). May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 * 
 * <p>COCT_MT220110CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Aids patients in adhering to administration instructions 
 * (e.g. snap caps). May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 * 
 * <p>POME_MT010040CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Used for informing dispenser of the need and 
 * authorization to dispense medication in a clinically 
 * approved container. Aids patients in adhering to 
 * administration instructions. May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 * 
 * <p>COCT_MT220200CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Aids patients in adhering to administration instructions 
 * (e.g. snap caps). May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 * 
 * <p>COCT_MT220210CA.PackagedMedicine: Drug Package</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Aids patients in adhering to administration instructions 
 * (e.g. snap caps). May also influence the quantity 
 * prescribed.</p>
 * 
 * <p>Describes the container in which a drug product can be or 
 * should be provided to the patient.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.PackagedMedicine","COCT_MT220110CA.PackagedMedicine","COCT_MT220200CA.PackagedMedicine","COCT_MT220210CA.PackagedMedicine","POME_MT010040CA.PackagedMedicine","POME_MT010100CA.PackagedMedicine"})
public class DrugPackageBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV formCode = new CVImpl();


    /**
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220110CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010040CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220200CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220210CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     */
    @Hl7XmlMapping({"formCode"})
    public CompliancePackageEntityType getFormCode() {
        return (CompliancePackageEntityType) this.formCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220110CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010040CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220200CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220210CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     */
    public void setFormCode(CompliancePackageEntityType formCode) {
        this.formCode.setValue(formCode);
    }

}