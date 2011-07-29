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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.AdministrableDrugForm;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Vaccine</p>
 * 
 * <p>POIZ_MT030060CA.Vaccine: Vaccine</p>
 * 
 * <p><p>A pharmaceutical product to be supplied and/or 
 * administered to a patient. Encompasses manufactured vaccines 
 * and generic classifications.</p></p>
 * 
 * <p><p>Allows vaccines to be clearly described and 
 * referenced. Also allows searching for and examining 
 * information about vaccines that have been administered to a 
 * patient.</p></p>
 * 
 * <p>POIZ_MT060150CA.Vaccine: Vaccine</p>
 * 
 * <p><p>A pharmaceutical product to be supplied and/or 
 * administered to a patient. Encompasses manufactured vaccines 
 * and generic classifications.</p></p>
 * 
 * <p><p>Allows vaccines to be clearly described and 
 * referenced. Also allows searching for and examining 
 * information about vaccines that have been administered to a 
 * patient.</p></p>
 * 
 * <p>POIZ_MT030050CA.Vaccine: Vaccine</p>
 * 
 * <p><p>A pharmaceutical product to be supplied and/or 
 * administered to a patient. Encompasses manufactured vaccines 
 * and generic classifications.</p></p>
 * 
 * <p><p>Allows vaccines to be clearly described and 
 * referenced. Also allows searching for and examining 
 * information about vaccines that have been administered to a 
 * patient.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Vaccine","POIZ_MT030060CA.Vaccine","POIZ_MT060150CA.Vaccine"})
public class VaccineBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private CV vaccineCode = new CVImpl();
    private ST vaccineName = new STImpl();
    private ST vaccineDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private ST vaccineLotNumber = new STImpl();
    private IVL<TS, Interval<Date>> vaccineExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private ManufacturerBean asManufacturedProductManufacturer;
    private List<AntigensBean> ingredientsIngredient = new ArrayList<AntigensBean>();


    /**
     * <p>VaccineCode</p>
     * 
     * <p>Vaccine Code</p>
     * 
     * <p><p>An identifier for a type of drug. Depending on where 
     * the drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccine).</p></p>
     * 
     * <p><p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some custom compounds will not have unique 
     * identifiers.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getVaccineCode() {
        return (ClinicalDrug) this.vaccineCode.getValue();
    }
    public void setVaccineCode(ClinicalDrug vaccineCode) {
        this.vaccineCode.setValue(vaccineCode);
    }


    /**
     * <p>VaccineName</p>
     * 
     * <p>Vaccine Name</p>
     * 
     * <p><p>The name assigned to a vaccine.</p></p>
     * 
     * <p><p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getVaccineName() {
        return this.vaccineName.getValue();
    }
    public void setVaccineName(String vaccineName) {
        this.vaccineName.setValue(vaccineName);
    }


    /**
     * <p>VaccineDescription</p>
     * 
     * <p>Vaccine Description</p>
     * 
     * <p><p>A free form textual description of a vaccine. This 
     * usually is only populated for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p></p>
     * 
     * <p><p>Allows description of compound ingredients and/or 
     * recipe in free text form.</p></p>
     */
    @Hl7XmlMapping({"desc"})
    public String getVaccineDescription() {
        return this.vaccineDescription.getValue();
    }
    public void setVaccineDescription(String vaccineDescription) {
        this.vaccineDescription.setValue(vaccineDescription);
    }


    /**
     * <p>DrugForm</p>
     * 
     * <p>Drug Form</p>
     * 
     * <p><p>Indicates the form in which the drug product must be, 
     * or has been manufactured or custom prepared.</p></p>
     * 
     * <p><p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p></p>
     * 
     * <p><p>Must be populated if the Vaccine Code does not specify 
     * the Drug Form.</p></p>
     */
    @Hl7XmlMapping({"formCode"})
    public AdministrableDrugForm getDrugForm() {
        return (AdministrableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(AdministrableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    /**
     * <p>VaccineLotNumber</p>
     * 
     * <p>Vaccine Lot Number</p>
     * 
     * <p><p>Identification of a batch in which a specific 
     * manufactured drug belongs.</p></p>
     * 
     * <p><p>Useful in tracking for recalls but may not always be 
     * known (e.g. historical immunization records).</p></p>
     */
    @Hl7XmlMapping({"lotNumberText"})
    public String getVaccineLotNumber() {
        return this.vaccineLotNumber.getValue();
    }
    public void setVaccineLotNumber(String vaccineLotNumber) {
        this.vaccineLotNumber.setValue(vaccineLotNumber);
    }


    /**
     * <p>VaccineExpiryDate</p>
     * 
     * <p>Vaccine Expiry Date</p>
     * 
     * <p><p>Indicates either the length of time a drug product can 
     * remain viable (when talking about a drug in general terms), 
     * or the date on which the drug product is no longer 
     * considered viable (when talking about a specific medication 
     * that has been dispensed).</p></p>
     * 
     * <p><p>The potency, effectiveness and safety of drug products 
     * changes over time. When determining quantities to be 
     * supplied to a patient, one of the considerations is how long 
     * the drug will remain viable.</p></p>
     * 
     * <p><p>To indicate the length of time after opening a product 
     * remains viable, specify the 'Width' property. To indicate a 
     * specific end date for an actual dispensed product, specify 
     * the 'High' property</p></p>
     */
    @Hl7XmlMapping({"expirationTime"})
    public Interval<Date> getVaccineExpiryDate() {
        return this.vaccineExpiryDate.getValue();
    }
    public void setVaccineExpiryDate(Interval<Date> vaccineExpiryDate) {
        this.vaccineExpiryDate.setValue(vaccineExpiryDate);
    }


    @Hl7XmlMapping({"asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAsManufacturedProductManufacturer() {
        return this.asManufacturedProductManufacturer;
    }
    public void setAsManufacturedProductManufacturer(ManufacturerBean asManufacturedProductManufacturer) {
        this.asManufacturedProductManufacturer = asManufacturedProductManufacturer;
    }


    @Hl7XmlMapping({"ingredients/ingredient"})
    public List<AntigensBean> getIngredientsIngredient() {
        return this.ingredientsIngredient;
    }

}
