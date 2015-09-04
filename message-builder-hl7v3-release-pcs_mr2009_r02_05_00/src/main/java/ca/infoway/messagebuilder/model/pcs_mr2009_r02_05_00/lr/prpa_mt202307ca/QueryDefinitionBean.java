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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.prpa_mt202307ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Query Definition</p>
 * 
 * <p>Allows the user and/or the point-of-service application 
 * to constrain what EHR information they wish to retrieve.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202307CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private List<II> protocolIdValue = new ArrayList<II>();
    private List<II> recordIdValue = new ArrayList<II>();


    /**
     * <p>Business Name: ZI: Protocol Ids</p>
     * 
     * <p>Relationship: PRPA_MT202307CA.ProtocolId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a neccesity for many healthcare 
     * providers.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified protocols. If unspecified, no 
     * filter is applied.</p>
     */
    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIdValue() {
        return new RawListWrapper<II, Identifier>(protocolIdValue, IIImpl.class);
    }


    /**
     * <p>Business Name: E: Record Ids</p>
     * 
     * <p>Relationship: PRPA_MT202307CA.RecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Specifically identifies the record to be 
     * returned.</p><p>Because the primary purpose of the query is 
     * to retrieve identified records, the element is 
     * mandatory.</p><p>Multiple repetitions are allowed to support 
     * multiple detail records as part of one query for efficiency 
     * reasons.</p>
     * 
     * <p>A globally unique identifier assigned by the EHR to the 
     * record (or records) to be retrieved.</p>
     */
    @Hl7XmlMapping({"recordId/value"})
    public List<Identifier> getRecordIdValue() {
        return new RawListWrapper<II, Identifier>(recordIdValue, IIImpl.class);
    }

}
