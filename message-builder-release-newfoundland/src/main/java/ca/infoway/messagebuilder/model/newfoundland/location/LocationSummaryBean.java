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

package ca.infoway.messagebuilder.model.newfoundland.location;

import java.io.Serializable;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.util.Identifiable;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;

@Hl7PartTypeMapping({ "PRLO_MT000001CA.ServiceDeliveryLocation" })
public class LocationSummaryBean extends BaseLocationBean implements Serializable, Identifiable, Location {

    private static final long serialVersionUID = -3396146035262969266L;

    private final II id = new IIImpl();

    private final CD code = new CDImpl();

    private final LIST<ST, String> name = new LISTImpl<ST, String>(STImpl.class);

    private final AD addr = new ADImpl();

    private final CD statusCode = new CDImpl();

    private final CD placeCode = new CDImpl();

    private final BL mobileInd = new BLImpl();

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("name")
    public List<String> getName() {
        return this.name.rawList();
    }

    @Hl7XmlMapping("addr")
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

    @Hl7XmlMapping("statusCode")
    public ServiceDeliveryRoleStatus getStatusCode() {
        return (ServiceDeliveryRoleStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ServiceDeliveryRoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("location/code")
    public ServiceDeliveryLocationPlaceType getPlaceCode() {
        return (ServiceDeliveryLocationPlaceType) this.placeCode.getValue();
    }

    public void setPlaceCode(ServiceDeliveryLocationPlaceType placeCode) {
        this.placeCode.setValue(placeCode);
    }

    @Hl7XmlMapping("location/mobileInd")
    public Boolean getMobileInd() {
        return this.mobileInd.getValue();
    }

    public void setMobileInd(Boolean mobileInd) {
        this.mobileInd.setValue(mobileInd);
    }
}
