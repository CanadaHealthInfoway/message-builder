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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 * 
 * <p>COCT_MT220200CA.Content: drug dispensed in</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 * 
 * <p>POME_MT010040CA.Content: dispensed in</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 * 
 * <p>COCT_MT220210CA.Content: drug dispensed in</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 * 
 * <p>COCT_MT220110CA.Content: dispensed in</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 * 
 * <p>COCT_MT220100CA.Content: dispensed in</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * about how the dispensed drug is or should be contained</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May 
 * influence prescribing quantities, and also allows conveying 
 * instructions with respect to special packaging such as 
 * compliance packaging.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Content","COCT_MT220110CA.Content","COCT_MT220200CA.Content","COCT_MT220210CA.Content","POME_MT010040CA.Content","POME_MT010100CA.Content"})
public class DispensedInBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private PQ quantity = new PQImpl();
    private CV containerPackagedMedicineFormCode = new CVImpl();


    /**
     * <p>Package Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The quantity 
     * of the medication dosage form contained in the package given 
     * or to be given to the patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Sometimes 
     * ordering and dispensing is by package rather than individual 
     * units, and package is important in calculating total amount 
     * supplied.</p></p>
     * 
     * <p>B:Drug Package Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The quantity 
     * of the medication dosage form contained in the package given 
     * or to be given to the patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Sometimes 
     * ordering and dispensing is by package rather than individual 
     * units, and package is important in calculating total amount 
     * supplied.</p></p>
     * 
     * <p>F:Drug Package Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The quantity 
     * of the medication dosage form contained in the package given 
     * or to be given to the patient.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.2</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Sometimes 
     * ordering and dispensing is by package rather than individual 
     * units, and package is important in calculating total amount 
     * supplied.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>A:Drug Container Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a specific kind of a container. Used to 
     * identify a requirement for a particular type of compliance 
     * packaging</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Many 
     * insurance plans require that a prescriber specifically 
     * authorize the use of compliance packaging before it will be 
     * covered by the plan.</p></p>
     * 
     * <p>Drug Container Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a specific kind of a container. Used to 
     * identify a requirement for a particular type of compliance 
     * packaging</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Many 
     * insurance plans require that a prescriber specifically 
     * authorize the use of compliance packaging before it will be 
     * covered by the plan.</p></p>
     * 
     * <p>Container Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a specific kind of a container. Used to 
     * identify a requirement for a particular type of compliance 
     * packaging</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Many 
     * insurance plans require that a prescriber specifically 
     * authorize the use of compliance packaging before it will be 
     * covered by the plan.</p></p>
     * 
     * <p>E:Drug Container Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a specific kind of a container. Used to 
     * identify a requirement for a particular type of compliance 
     * packaging</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Many 
     * insurance plans require that a prescriber specifically 
     * authorize the use of compliance packaging before it will be 
     * covered by the plan.</p></p>
     * 
     * <p>H:Container Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting a specific kind of a container. Used to 
     * identify a requirement for a particular type of compliance 
     * packaging</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Many 
     * insurance plans require that a prescriber specifically 
     * authorize the use of compliance packaging before it will be 
     * covered by the plan.</p></p>
     */
    @Hl7XmlMapping({"containerPackagedMedicine/formCode"})
    public CompliancePackageEntityType getContainerPackagedMedicineFormCode() {
        return (CompliancePackageEntityType) this.containerPackagedMedicineFormCode.getValue();
    }
    public void setContainerPackagedMedicineFormCode(CompliancePackageEntityType containerPackagedMedicineFormCode) {
        this.containerPackagedMedicineFormCode.setValue(containerPackagedMedicineFormCode);
    }

}
