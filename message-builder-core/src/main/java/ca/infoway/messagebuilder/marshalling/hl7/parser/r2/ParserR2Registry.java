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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;
import ca.infoway.messagebuilder.marshalling.hl7.parser.EdElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;

public class ParserR2Registry extends Registry<ElementParser> {

    private static ParserR2Registry instance = new ParserR2Registry();

    private ParserR2Registry() {
    }

	@Override
    protected void registerAll() {
        register(new AnyR2ElementParser());
        register(new AdR2ElementParser());
        register(new BlR2ElementParser());
        register(new BxitCdR2ElementParser());
        register(new EdElementParser(new TelR2ElementParser(), true));
        register(new EivlTsR2ElementParser());
        register(new EnR2ElementParser());
        register(new HxitCeR2ElementParser());
        register(new IiR2ElementParser());
        register(new IntR2ElementParser());
        register(new IvlIntR2ElementParser());
        register(new IvlMoR2ElementParser());
        register(new IvlPqR2ElementParser());
        register(new IvlRealR2ElementParser());
        register(new IvlTsR2ElementParser());
        register(new ListR2ElementParser(this));
        register(new MoR2ElementParser());
        register(new OnR2ElementParser());
        register(new PivlTsR2ElementParser());
        register(new PnR2ElementParser());
        register(new PqR2ElementParser());
        register(new RealR2ElementParser());
        register(new RtoMoPqR2ElementParser());
        register(new RtoPqPqR2ElementParser());
        register(new SetR2ElementParser(this));
        register(new StR2ElementParser());
        register(new TelR2ElementParser());
        register(new TnR2ElementParser());
        register(new TsR2ElementParser());
        
        register(new CsR2ElementParser());
        register(new ScR2ElementParser());
        register(new CvR2ElementParser()); // also for CO
        register(new CeR2ElementParser());
        register(new CdR2ElementParser());
        register(new SxcmCdR2ElementParser());
        register(new PqrR2ElementParser());
        register(new CrR2ElementParser());
    }

    public static ParserR2Registry getInstance() {
        return instance;
    }
}
