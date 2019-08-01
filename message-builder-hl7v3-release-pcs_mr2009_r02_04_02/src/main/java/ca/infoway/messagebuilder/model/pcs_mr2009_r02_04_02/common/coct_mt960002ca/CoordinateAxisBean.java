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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt960002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ObservationCoordinateAxisType;
import java.math.BigDecimal;



/**
 * <p>Business Name: Coordinate Axis</p>
 * 
 * <p>Defines the position of the location</p>
 * 
 * <p>Describes the postion of the location along a specific 
 * axis.</p>
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.PositionCoordinate"})
public class CoordinateAxisBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private CV code = new CVImpl();
    private REAL value = new REALImpl();


    /**
     * <p>Business Name: Coordinate Axis Type</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Acts as the &quot;name&quot; in the name-value pair that 
     * expresses a coordinate and is therefore mandatory</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationCoordinateAxisType getCode() {
        return (ObservationCoordinateAxisType) this.code.getValue();
    }

    /**
     * <p>Business Name: Coordinate Axis Type</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Acts as the &quot;name&quot; in the name-value pair that 
     * expresses a coordinate and is therefore mandatory</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     */
    public void setCode(ObservationCoordinateAxisType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Coordinate Axis Value</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Actually expresses the location along the axis. Because 
     * unknown axis positions can simply be omitted, this attribute 
     * is mandatory.</p>
     * 
     * <p>Denotes the individual coordinate value as a a physical 
     * quantity. For example, lot number, range number, latitude, 
     * etc.</p>
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Coordinate Axis Value</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Actually expresses the location along the axis. Because 
     * unknown axis positions can simply be omitted, this attribute 
     * is mandatory.</p>
     * 
     * <p>Denotes the individual coordinate value as a a physical 
     * quantity. For example, lot number, range number, latitude, 
     * etc.</p>
     */
    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

}
