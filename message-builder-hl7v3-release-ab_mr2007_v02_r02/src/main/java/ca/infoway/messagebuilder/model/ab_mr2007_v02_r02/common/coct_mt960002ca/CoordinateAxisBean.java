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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt960002ca;

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
 * <p>Business Name: Coordinate Axis</p>
 * 
 * <p>Describes the postion of the location along a specific 
 * axis.</p>
 * 
 * <p>Defines the position of the location</p>
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.PositionCoordinate"})
public class CoordinateAxisBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private REAL value = new REALImpl();


    /**
     * <p>Business Name: Coordinate Axis Type</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     * 
     * <p>Acts as the &quot;name&quot; in the name-value pair that 
     * expresses a coordinate and is therefore mandatory</p>
     */
    @Hl7XmlMapping({"code"})
    public PositionCoordinateObservationCode getCode() {
        return (PositionCoordinateObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Coordinate Axis Type</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     * 
     * <p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p>
     * 
     * <p>Acts as the &quot;name&quot; in the name-value pair that 
     * expresses a coordinate and is therefore mandatory</p>
     */
    public void setCode(PositionCoordinateObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Coordinate Axis Value</p>
     * 
     * <p>Relationship: COCT_MT960002CA.PositionCoordinate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Denotes the individual coordinate value as a a physical 
     * quantity. For example, lot number, range number, latitude, 
     * etc.</p>
     * 
     * <p>Actually expresses the location along the axis. Because 
     * unknown axis positions can simply be omitted, this attribute 
     * is mandatory.</p>
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
     * <p>Denotes the individual coordinate value as a a physical 
     * quantity. For example, lot number, range number, latitude, 
     * etc.</p>
     * 
     * <p>Actually expresses the location along the axis. Because 
     * unknown axis positions can simply be omitted, this attribute 
     * is mandatory.</p>
     */
    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

}
