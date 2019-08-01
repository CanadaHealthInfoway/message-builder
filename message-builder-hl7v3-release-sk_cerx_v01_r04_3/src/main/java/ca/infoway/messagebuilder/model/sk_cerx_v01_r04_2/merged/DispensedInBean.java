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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CompliancePackageEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POME_MT010100CA.Content: dispensed in</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 * 
 * <p>COCT_MT220100CA.Content: dispensed in</p>
 * 
 * <p>Must specify at least one of Drug Package quantity and 
 * Drug Container Type</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 * 
 * <p>COCT_MT220200CA.Content: drug dispensed in</p>
 * 
 * <p>Must specify at least one of Drug Package quantity and 
 * Drug Container Type.</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 * 
 * <p>COCT_MT220210CA.Content: drug dispensed in</p>
 * 
 * <p>Must specify at least one of Drug Package quantity and 
 * Drug Container Type.</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 * 
 * <p>POME_MT010040CA.Content: dispensed in</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 * 
 * <p>COCT_MT220110CA.Content: dispensed in</p>
 * 
 * <p>Must specify at least one of Drug Package quantity and 
 * Drug Container Type;</p>
 * 
 * <p>Information about how the dispensed drug is or should be 
 * contained</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May influence prescribing quantities, and also allows 
 * conveying instructions with respect to special packaging 
 * such as compliance packaging.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Content","COCT_MT220110CA.Content","COCT_MT220200CA.Content","COCT_MT220210CA.Content","POME_MT010040CA.Content","POME_MT010100CA.Content"})
public class DispensedInBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private PQ quantity = new PQImpl();
    private CV containerPackagedMedicineFormCode = new CVImpl();


    /**
     * <p>Un-merged Business Name: PackageQuantity</p>
     * 
     * <p>Relationship: POME_MT010100CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: PackageQuantity</p>
     * 
     * <p>Relationship: POME_MT010040CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Un-merged Business Name: PackageQuantity</p>
     * 
     * <p>Relationship: POME_MT010100CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: PackageQuantity</p>
     * 
     * <p>Relationship: POME_MT010040CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     * 
     * <p>Un-merged Business Name: DrugPackageQuantity</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The quantity of the medication dosage form contained in 
     * the package given or to be given to the patient.</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>ZDP.10.2.2</p><p>ZDP.9.2.2</p>
     * 
     * <p>Sometimes ordering and dispensing is by package rather 
     * than individual units, and package is important in 
     * calculating total amount supplied.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220200CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220210CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010040CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220110CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     */
    @Hl7XmlMapping({"containerPackagedMedicine/formCode"})
    public CompliancePackageEntityType getContainerPackagedMedicineFormCode() {
        return (CompliancePackageEntityType) this.containerPackagedMedicineFormCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220100CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220200CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220210CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: ContainerType</p>
     * 
     * <p>Relationship: POME_MT010040CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     * 
     * <p>Un-merged Business Name: DrugContainerType</p>
     * 
     * <p>Relationship: COCT_MT220110CA.PackagedMedicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value denoting a specific kind of a container. 
     * Used to identify a requirement for a particular type of 
     * compliance packaging</p>
     * 
     * <p>Many insurance plans require that a prescriber 
     * specifically authorize the use of compliance packaging 
     * before it will be covered by the plan.</p>
     */
    public void setContainerPackagedMedicineFormCode(CompliancePackageEntityType containerPackagedMedicineFormCode) {
        this.containerPackagedMedicineFormCode.setValue(containerPackagedMedicineFormCode);
    }

}
