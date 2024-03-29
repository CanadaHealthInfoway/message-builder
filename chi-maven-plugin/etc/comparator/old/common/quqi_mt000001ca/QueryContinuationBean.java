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
package ca.infoway.messagebuilder.model.common.quqi_mt000001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUQI_MT000001CA.QueryContinuation"})
public class QueryContinuationBean extends MessagePartBean {

    private II queryIdentifier = new IIImpl();
    private INT startPosition = new INTImpl();
    private INT queryLimit = new INTImpl();

    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

    @Hl7XmlMapping({"startResultNumber"})
    public java.lang.Integer getStartPosition() {
        return this.startPosition.getValue();
    }
    public void setStartPosition(java.lang.Integer startPosition) {
        this.startPosition.setValue(startPosition);
    }

    @Hl7XmlMapping({"continuationQuantity"})
    public java.lang.Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(java.lang.Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }

}
