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
package ca.infoway.messagebuilder.model.common.coct_mt490000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt280001ca.A_BillableActChoiceBean;
import ca.infoway.messagebuilder.model.merged.ConsultantBean;
import ca.infoway.messagebuilder.model.merged.DiagnosisInformationBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.merged.ResponsibleProviderBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient 
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.BillableClinicalProduct"})
@Hl7RootType
public class BillableClinicalProductBean extends MessagePartBean implements A_BillableActChoiceBean {

    private CS<x_ActMoodIntentEvent> moodCode = new CSImpl<x_ActMoodIntentEvent>();
    private II id = new IIImpl();
    private CV<Code> code = new CVImpl<Code>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ProductBean product = new ProductBean();
    private ResponsibleProviderBean performer;
    private ProductReferrerBean referrer;
    private ConsultantBean consultant;
    private DispenseShipToLocationBean locationServiceDeliveryLocation;
    private DispenseShipToLocationBean originServiceDeliveryLocation;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private List<DiagnosisInformationBean> pertinentInformation = new ArrayList<DiagnosisInformationBean>();

    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodIntentEvent getMoodCode() {
        return this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodIntentEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping({"product"})
    public ProductBean getProduct() {
        return this.product;
    }
    public void setProduct(ProductBean product) {
        this.product = product;
    }

    @Hl7XmlMapping({"performer"})
    public ResponsibleProviderBean getPerformer() {
        return this.performer;
    }
    public void setPerformer(ResponsibleProviderBean performer) {
        this.performer = performer;
    }

    @Hl7XmlMapping({"referrer"})
    public ProductReferrerBean getReferrer() {
        return this.referrer;
    }
    public void setReferrer(ProductReferrerBean referrer) {
        this.referrer = referrer;
    }

    @Hl7XmlMapping({"consultant"})
    public ConsultantBean getConsultant() {
        return this.consultant;
    }
    public void setConsultant(ConsultantBean consultant) {
        this.consultant = consultant;
    }

    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }
    public void setLocationServiceDeliveryLocation(DispenseShipToLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"origin/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getOriginServiceDeliveryLocation() {
        return this.originServiceDeliveryLocation;
    }
    public void setOriginServiceDeliveryLocation(DispenseShipToLocationBean originServiceDeliveryLocation) {
        this.originServiceDeliveryLocation = originServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public List<DiagnosisInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

}
