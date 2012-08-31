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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;

public class ParserRegistry extends Registry<ElementParser> {

    private static ParserRegistry instance = new ParserRegistry();

    private ParserRegistry() {
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected void registerAll() {
        register(new AdElementParser());
        register(new AnyElementParser());
        register(new BagElementParser());
        register(new BlElementParser());
        register(new CsElementParser());
        register(new CvElementParser());
        register(new EdElementParser());
        register(new EdSignatureElementParser());
        register(new EnElementParser());
        register(new IiElementParser());
        register(new IntElementParser());
        register(new GtsBoundedPivlElementParser());
        register(new PivlTsElementParser());
        register(new PivlTsDateTimeElementParser());
        register(new IvlIntElementParser());
        register(new IvlPqElementParser());
        register(new IvlTsElementParser());
        register(new ListElementParser());
        register(new SetElementParser());
        register(new MoElementParser());
        register(new OnElementParser());
        register(new PnElementParser());
        register(new PqElementParser());
        register(new RealElementParser());
        register(new RtoPqPqElementParser());
        register(new RtoMoPqElementParser());
        register(new ScElementParser());
        register(new StElementParser());
        register(new TelElementParser());
        register(new TnElementParser());
        register(new TsElementParser());
        register(new UrgPqElementParser());
        register(new UrgTsElementParser());
    }

    public static ParserRegistry getInstance() {
        return instance;
    }
}
