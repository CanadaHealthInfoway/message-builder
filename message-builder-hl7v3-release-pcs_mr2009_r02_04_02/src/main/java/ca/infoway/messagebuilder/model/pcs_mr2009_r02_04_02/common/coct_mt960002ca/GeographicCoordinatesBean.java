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
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ObservationCoordinateSystemType;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Geographic Coordinates</p>
 * 
 * <p>Some locations cannot be described by postal addresses. 
 * Also, geographic coordinates allow calculation of distances 
 * and proximity</p>
 * 
 * <p>Allows the capturing of a physical location according to 
 * a particular coordinate system, such as GPS, legal 
 * designation (lot, block, plan), range-meridian, etc.</p>
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.Position"})
@Hl7RootType
public class GeographicCoordinatesBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private CV code = new CVImpl();
    private List<CoordinateAxisBean> componentPositionCoordinate = new ArrayList<CoordinateAxisBean>();


    /**
     * <p>Business Name: Coordinate System</p>
     * 
     * <p>Relationship: COCT_MT960002CA.Position.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential for interpretting the specified coordinates and 
     * therefore mandatory</p>
     * 
     * <p>Identifies the coordinate system inclusive of any 
     * transformation projections.</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationCoordinateSystemType getCode() {
        return (ObservationCoordinateSystemType) this.code.getValue();
    }

    /**
     * <p>Business Name: Coordinate System</p>
     * 
     * <p>Relationship: COCT_MT960002CA.Position.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential for interpretting the specified coordinates and 
     * therefore mandatory</p>
     * 
     * <p>Identifies the coordinate system inclusive of any 
     * transformation projections.</p>
     */
    public void setCode(ObservationCoordinateSystemType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * COCT_MT960002CA.Component1.positionCoordinate</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component/positionCoordinate"})
    public List<CoordinateAxisBean> getComponentPositionCoordinate() {
        return this.componentPositionCoordinate;
    }

}
