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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "REPC_MT000002CA.CausalityAssessment", "REPC_MT000012CA.CausalityAssessment", "REPC_MT000001CA.CausalityAssessment", "REPC_MT000013CA.CausalityAssessment", "REPC_MT000005CA.CausalityAssessment", "REPC_MT000009CA.CausalityAssessment" })
public class CausalityAssessmentBean extends MessagePartBean implements Serializable, AllergyRecord {

    private static final long serialVersionUID = -3060211460788776735L;

    private II id = new IIImpl();

    private CD code = new CDImpl();

    private CD observationValue = new CDImpl();

    private CD routeCode = new CDImpl();

    private CD materialCode = new CDImpl();

    private ST name = new STImpl();

    private ObservationEventBean observationEventBean;

    public CausalityAssessmentBean() {
    }

    @Hl7XmlMapping("startsAfterStartOf/exposureEvent/id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("value")
    public ObservationValue getObservationValue() {
        return (ObservationValue) this.observationValue.getValue();
    }

    public void setObservationValue(ObservationValue observationValue) {
        this.observationValue.setValue(observationValue);
    }

    @Hl7XmlMapping("startsAfterStartOf/exposureEvent/routeCode")
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }

    @Hl7XmlMapping({ "startsAfterStartOf/exposureEvent/consumable/administrableMaterial/administerableMaterialKind/code", "startsAfterStartOf/exposureEvent/consumable/administerableMaterial/administerableMaterialKind/code" })
    public ExposureAgentEntityType getMaterialCode() {
        return (ExposureAgentEntityType) this.materialCode.getValue();
    }

    public void setMaterialCode(ExposureAgentEntityType materialCode) {
        this.materialCode.setValue(materialCode);
    }

    @Hl7XmlMapping({ "startsAfterStartOf/exposureEvent/consumable/administrableMaterial/administerableMaterialKind/name", "startsAfterStartOf/exposureEvent/consumable/administerableMaterial/administerableMaterialKind/name" })
    public String getName() {
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    @Hl7XmlMapping("subject/observationEvent")
    public ObservationEventBean getObservationEventBean() {
        return observationEventBean;
    }

    public void setObservationEventBean(ObservationEventBean observationEventBean) {
        this.observationEventBean = observationEventBean;
    }
}
