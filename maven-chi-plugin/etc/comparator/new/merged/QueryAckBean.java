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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUQI_MT120006CA.QueryAck","QUQI_MT120008CA.QueryAck"})
public class QueryAckBean extends MessagePartBean {

    private II queryIdentifier = new IIImpl();
    private CS<Code> queryStatus = new CSImpl<Code>();
    private INT totalMatchingRows = new INTImpl();
    private INT returnedRows = new INTImpl();
    private INT remainingRows = new INTImpl();

    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

    @Hl7XmlMapping({"queryResponseCode"})
    public Code getQueryStatus() {
        return this.queryStatus.getValue();
    }
    public void setQueryStatus(Code queryStatus) {
        this.queryStatus.setValue(queryStatus);
    }

    @Hl7XmlMapping({"resultTotalQuantity"})
    public java.lang.Integer getTotalMatchingRows() {
        return this.totalMatchingRows.getValue();
    }
    public void setTotalMatchingRows(java.lang.Integer totalMatchingRows) {
        this.totalMatchingRows.setValue(totalMatchingRows);
    }

    @Hl7XmlMapping({"resultCurrentQuantity"})
    public java.lang.Integer getReturnedRows() {
        return this.returnedRows.getValue();
    }
    public void setReturnedRows(java.lang.Integer returnedRows) {
        this.returnedRows.setValue(returnedRows);
    }

    @Hl7XmlMapping({"resultRemainingQuantity"})
    public java.lang.Integer getRemainingRows() {
        return this.remainingRows.getValue();
    }
    public void setRemainingRows(java.lang.Integer remainingRows) {
        this.remainingRows.setValue(remainingRows);
    }

}
