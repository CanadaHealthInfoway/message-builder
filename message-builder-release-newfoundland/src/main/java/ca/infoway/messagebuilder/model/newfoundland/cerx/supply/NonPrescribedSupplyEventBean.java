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

package ca.infoway.messagebuilder.model.newfoundland.cerx.supply;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;

@Hl7PartTypeMapping("PORX_MT020050CA.SupplyEvent")
public class NonPrescribedSupplyEventBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -9155767159658357971L;

    private II dispenseId = new IIImpl();

    private CD code = new CDImpl();

    private TS effectiveTime = new TSImpl();

    private PQ quantity = new PQImpl();

    private MedicineBean product;

    private ServiceDeliveryLocationBean destination;

    private NoteBean annotation;

    @Hl7XmlMapping("id")
    public Identifier getDispenseId() {
        return this.dispenseId.getValue();
    }

    public void setDispenseId(Identifier dispenseId) {
        this.dispenseId.setValue(dispenseId);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("product/medication/player")
    public MedicineBean getProduct() {
        return product;
    }

    public void setProduct(MedicineBean product) {
        this.product = product;
    }

    @Hl7XmlMapping("destination/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getDestination() {
        return destination;
    }

    public void setDestination(ServiceDeliveryLocationBean destination) {
        this.destination = destination;
    }

    @Hl7XmlMapping("subjectOf/annotation")
    public NoteBean getAnnotation() {
        return annotation;
    }

    public void setAnnotation(NoteBean annotation) {
        this.annotation = annotation;
    }
}
