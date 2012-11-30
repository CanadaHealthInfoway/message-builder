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
package ca.infoway.messagebuilder.model.common.coct_mt960002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PositionObservationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>Geographic Coordinates 
 * 
 * <p>Allows the capturing of a physical location according to 
 * a particular coordinate system, such as GPS, legal 
 * designation (lot, block, plan), range-meridian, etc. 
 * 
 * <p>Some locations cannot be described by postal addresses. 
 * Also, geographic coordinates allow calculation of distances 
 * and proximity 
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.Position"})
@Hl7RootType
public class GeographicCoordinatesBean extends MessagePartBean {

    private CV<PositionObservationCode> coordinateSystem = new CVImpl<PositionObservationCode>();
    private List<DefinedByBean> component = new ArrayList<DefinedByBean>();

    @Hl7XmlMapping({"code"})
    public PositionObservationCode getCoordinateSystem() {
        return this.coordinateSystem.getValue();
    }
    public void setCoordinateSystem(PositionObservationCode coordinateSystem) {
        this.coordinateSystem.setValue(coordinateSystem);
    }

    @Hl7XmlMapping({"component"})
    public List<DefinedByBean> getComponent() {
        return this.component;
    }

}
