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
package ca.infoway.messagebuilder.model.common.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.FirstFillBean;
import java.util.Date;



/**
 * <p>includes 
 * 
 * <p>Identifies the dispense instructions for each drug to be 
 * dispensed 
 * 
 * <p>Handled as a separate class to allow for multi-drug 
 * prescriptions. E.g. 40mg tablets + 50mg tablets. Note that 
 * this is NOT intended to combine independent drugs, but 
 * rather multiple strengths of the same overall drug. 
 * 
 * <p>The association is mandatory because specific supply 
 * instructions must be given for at least one medication. 
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Component"})
public class ComponentBean extends MessagePartBean {

    private PQ totalPrescribedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean supplyRequestItemProductMedication = new DrugProductBean();
    private FirstFillBean supplyRequestItemComponent2InitialSupplyRequest;
    private IVL<TS, Interval<Date>> dispenseInterval = new IVLImpl<TS, Interval<Date>>();
    private INT numberOfFills = new INTImpl();
    private PQ fillQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> daysSupply = new IVLImpl<TS, Interval<Date>>();

    @Hl7XmlMapping({"supplyRequestItem/quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"supplyRequestItem/expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"supplyRequestItem/product/medication"})
    public DrugProductBean getSupplyRequestItemProductMedication() {
        return this.supplyRequestItemProductMedication;
    }
    public void setSupplyRequestItemProductMedication(DrugProductBean supplyRequestItemProductMedication) {
        this.supplyRequestItemProductMedication = supplyRequestItemProductMedication;
    }

    @Hl7XmlMapping({"supplyRequestItem/component2/initialSupplyRequest"})
    public FirstFillBean getSupplyRequestItemComponent2InitialSupplyRequest() {
        return this.supplyRequestItemComponent2InitialSupplyRequest;
    }
    public void setSupplyRequestItemComponent2InitialSupplyRequest(FirstFillBean supplyRequestItemComponent2InitialSupplyRequest) {
        this.supplyRequestItemComponent2InitialSupplyRequest = supplyRequestItemComponent2InitialSupplyRequest;
    }

    @Hl7XmlMapping({"supplyRequestItem/component1/subsequentSupplyRequest/effectiveTime"})
    public Interval<Date> getDispenseInterval() {
        return this.dispenseInterval.getValue();
    }
    public void setDispenseInterval(Interval<Date> dispenseInterval) {
        this.dispenseInterval.setValue(dispenseInterval);
    }

    @Hl7XmlMapping({"supplyRequestItem/component1/subsequentSupplyRequest/repeatNumber"})
    public java.lang.Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }
    public void setNumberOfFills(java.lang.Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }

    @Hl7XmlMapping({"supplyRequestItem/component1/subsequentSupplyRequest/quantity"})
    public PhysicalQuantity getFillQuantity() {
        return this.fillQuantity.getValue();
    }
    public void setFillQuantity(PhysicalQuantity fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }

    @Hl7XmlMapping({"supplyRequestItem/component1/subsequentSupplyRequest/expectedUseTime"})
    public Interval<Date> getDaysSupply() {
        return this.daysSupply.getValue();
    }
    public void setDaysSupply(Interval<Date> daysSupply) {
        this.daysSupply.setValue(daysSupply);
    }

}
