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
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.PositionCoordinateObservationCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



/**
 * <p>defined by 
 * 
 * <p>Identifies the relative position of the location along a 
 * particular axis 
 * 
 * <p>Used to geographically describe the location. There is no 
 * point specifying a coordinate system without identifying the 
 * coordinates. Therefore this association is mandatory. 
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.Component1"})
public class DefinedByBean extends MessagePartBean {

    private CV<PositionCoordinateObservationCode> coordinateAxisType = new CVImpl<PositionCoordinateObservationCode>();
    private REAL coordinateAxisValue = new REALImpl();

    @Hl7XmlMapping({"positionCoordinate/code"})
    public PositionCoordinateObservationCode getCoordinateAxisType() {
        return this.coordinateAxisType.getValue();
    }
    public void setCoordinateAxisType(PositionCoordinateObservationCode coordinateAxisType) {
        this.coordinateAxisType.setValue(coordinateAxisType);
    }

    @Hl7XmlMapping({"positionCoordinate/value"})
    public BigDecimal getCoordinateAxisValue() {
        return this.coordinateAxisValue.getValue();
    }
    public void setCoordinateAxisValue(BigDecimal coordinateAxisValue) {
        this.coordinateAxisValue.setValue(coordinateAxisValue);
    }

}
