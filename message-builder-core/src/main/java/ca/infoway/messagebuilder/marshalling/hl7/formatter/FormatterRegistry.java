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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;

public class FormatterRegistry extends Registry<PropertyFormatter> {

    private static FormatterRegistry instance = new FormatterRegistry();

    public static FormatterRegistry getInstance() {
        return instance;
    }

    private FormatterRegistry() {
    }

    @Override
    protected void registerAll() {
        register(new AdBasicPropertyFormatter());
        register(new AdPropertyFormatter());
        register(new AnyPropertyFormatter());
        register(new BagPropertyFormatter());
        register(new BlPropertyFormatter());
        register(new GtsBoundedPivlFormatter());
        register(new CdPropertyFormatter());
        register(new CsPropertyFormatter());
        register(new CvPropertyFormatter());
        register(new EdPropertyFormatter());
        register(new EdSignaturePropertyFormatter());
        register(new EnPropertyFormatter());
        register(new IiPropertyFormatter());
        register(new IntPropertyFormatter());
        register(new IntNonNegPropertyFormatter());
        register(new IntPosPropertyFormatter());
        register(new IvlIntPropertyFormatter());
        register(new IvlPqPropertyFormatter());
        register(new IvlTsPropertyFormatter());
        register(new PivlTsPropertyFormatter());
        register(new MoPropertyFormatter());
        register(new OnPropertyFormatter());
        register(new PnPropertyFormatter());
        register(new PqPropertyFormatter());
        register(new RealConfPropertyFormatter());
        register(new RealCoordPropertyFormatter());
        register(new RtoMoPqPropertyFormatter());
        register(new RtoPqPqPropertyFormatter());
        register(new ScPropertyFormatter());
        register(new SetPropertyFormatter());
        register(new ListPropertyFormatter());
        register(new StPropertyFormatter());
        registerTelPhonemailFormatter();
        registerTelUriFormatter();
        register(new TnPropertyFormatter());
        register(new TsFullDateWithTimePropertyFormatter());
        register(new TsFullDatePropertyFormatter());
        register(new TsFullDateTimePropertyFormatter());
        register(new UrgPqPropertyFormatter());
        register(new UrgTsPropertyFormatter());
    }

    private void registerTelPhonemailFormatter() {
        if (isLenientFormatting()) {
            register(new LenientTelPhonemailPropertyFormatter());
        } else {
            register(new TelPhonemailPropertyFormatter());
        }
    }

    private void registerTelUriFormatter() {
        if (isLenientFormatting()) {
            register(new LenientTelUriPropertyFormatter());
        } else {
            register(new TelUriPropertyFormatter());
        }
    }

    private boolean isLenientFormatting() {
        return true;//BooleanUtils.toBoolean(System.getProperty("lenientCeRxFormatter", "true"))
    }
}
