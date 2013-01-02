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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT000009CA.StartsAfterStartOf","REPC_MT000012CA.StartsAfterStartOf"})
public class StartsAfterStartOf_2Bean extends MessagePartBean {

    private II incidenceIdentifier = new IIImpl();
    private CV<RouteOfAdministration> exposureMethod = new CVImpl<RouteOfAdministration>();
    private CV<ExposureAgentEntityType> exposedMaterialType = new CVImpl<ExposureAgentEntityType>();
    private ST exposedMaterialName = new STImpl();

    @Hl7XmlMapping({"exposureEvent/id"})
    public Identifier getIncidenceIdentifier() {
        return this.incidenceIdentifier.getValue();
    }
    public void setIncidenceIdentifier(Identifier incidenceIdentifier) {
        this.incidenceIdentifier.setValue(incidenceIdentifier);
    }

    @Hl7XmlMapping({"exposureEvent/routeCode"})
    public RouteOfAdministration getExposureMethod() {
        return this.exposureMethod.getValue();
    }
    public void setExposureMethod(RouteOfAdministration exposureMethod) {
        this.exposureMethod.setValue(exposureMethod);
    }

    @Hl7XmlMapping({"exposureEvent/consumable/administerableMaterial/administerableMaterialKind/code"})
    public ExposureAgentEntityType getExposedMaterialType() {
        return this.exposedMaterialType.getValue();
    }
    public void setExposedMaterialType(ExposureAgentEntityType exposedMaterialType) {
        this.exposedMaterialType.setValue(exposedMaterialType);
    }

    @Hl7XmlMapping({"exposureEvent/consumable/administerableMaterial/administerableMaterialKind/name"})
    public java.lang.String getExposedMaterialName() {
        return this.exposedMaterialName.getValue();
    }
    public void setExposedMaterialName(java.lang.String exposedMaterialName) {
        this.exposedMaterialName.setValue(exposedMaterialName);
    }

}
