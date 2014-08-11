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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;

public class FormatterR2Registry extends Registry<PropertyFormatter> {

    private static FormatterR2Registry instance = new FormatterR2Registry();

    public static FormatterR2Registry getInstance() {
        return instance;
    }

    private FormatterR2Registry() {
    }

    @Override
    protected void registerAll() {
    	register(new AdR2PropertyFormatter());
    	register(new AnyR2PropertyFormatter());
    	register(new BlR2PropertyFormatter());
    	register(new BagR2PropertyFormatter());
    	register(new BxitCdR2PropertyFormatter());
    	register(new CdR2PropertyFormatter());
    	register(new CeR2PropertyFormatter());
    	register(new CrR2PropertyFormatter());
    	register(new CsR2PropertyFormatter());
    	register(new CvR2PropertyFormatter());
    	register(new EdR2PropertyFormatter());
    	register(new EivlTsR2PropertyFormatter());
    	register(new EnR2PropertyFormatter());
        register(new HxitCeR2PropertyFormatter());
        register(new IiR2PropertyFormatter());
        register(new IntR2PropertyFormatter());
        register(new IvlIntR2PropertyFormatter());
        register(new IvlMoR2PropertyFormatter());
        register(new IvlPqR2PropertyFormatter());
        register(new IvlRealR2PropertyFormatter());
        register(new IvlTsR2PropertyFormatter());
        register(new ListR2PropertyFormatter());
        register(new MoR2PropertyFormatter());
    	register(new PivlTsR2PropertyFormatter());
    	register(new PqR2PropertyFormatter());
    	register(new PqrR2PropertyFormatter());
        register(new RealR2PropertyFormatter());
        register(new RtoMoPqR2PropertyFormatter());
        register(new RtoPqPqR2PropertyFormatter());
        register(new ScR2PropertyFormatter());
        register(new SetR2PropertyFormatter());
        register(new StR2PropertyFormatter());
        register(new SxcmCdR2PropertyFormatter());
        register(new TelR2PropertyFormatter());
        register(new TsR2PropertyFormatter());
        

    }

}
