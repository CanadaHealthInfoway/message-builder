/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.common.porx_mt020050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.DispensedPrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.merged.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.ServiceLocationBean;
import java.util.Date;



/**
 * <p>Office Supply 
 * 
 * <p>This is the detailed information about a medication being 
 * supplied for office use. 
 * 
 * <p>Allows for tracking of medications supplied to an office. 
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private II localDispenseID = new IIImpl();
    private CV<ActCode> dispenseType = new CVImpl<ActCode>();
    private TS supplyDate = new TSImpl();
    private PQ suppliedQuantity = new PQImpl();
    private DrugProductBean productMedication = new DrugProductBean();
    private ServiceLocationBean destinationServiceDeliveryLocation = new ServiceLocationBean();
    private DispensedPrescriptionReferenceBean fulfillment;
    private NotesBean subjectOfAnnotation;

    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseID() {
        return this.localDispenseID.getValue();
    }
    public void setLocalDispenseID(Identifier localDispenseID) {
        this.localDispenseID.setValue(localDispenseID);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getDispenseType() {
        return this.dispenseType.getValue();
    }
    public void setDispenseType(ActCode dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getSupplyDate() {
        return this.supplyDate.getValue();
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate.setValue(supplyDate);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getSuppliedQuantity() {
        return this.suppliedQuantity.getValue();
    }
    public void setSuppliedQuantity(PhysicalQuantity suppliedQuantity) {
        this.suppliedQuantity.setValue(suppliedQuantity);
    }

    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(ServiceLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"fulfillment"})
    public DispensedPrescriptionReferenceBean getFulfillment() {
        return this.fulfillment;
    }
    public void setFulfillment(DispensedPrescriptionReferenceBean fulfillment) {
        this.fulfillment = fulfillment;
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
