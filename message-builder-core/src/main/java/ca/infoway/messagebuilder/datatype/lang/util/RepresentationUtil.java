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
 * Last modified: $LastChangedDate: 2013-07-10 20:33:34 -0300 (Wed, 10 Jul 2013) $
 * Revision:      $LastChangedRevision: 7799 $
 */

package ca.infoway.messagebuilder.datatype.lang.util;

import static ca.infoway.messagebuilder.datatype.lang.util.Representation.CENTRE;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.CENTRE_HIGH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.CENTRE_WIDTH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.HIGH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.LOW;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.LOW_CENTER;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.LOW_HIGH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.LOW_WIDTH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.WIDTH;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.WIDTH_HIGH;

/**
 * <p>A utility for interval representations.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class RepresentationUtil {

	public static boolean hasLow(Representation representation) {
	return representation == LOW || representation == LOW_CENTER || representation == LOW_WIDTH || representation == LOW_HIGH;
	}
	
	public static boolean hasHigh(Representation representation) {
		return representation == HIGH || representation == LOW_HIGH || representation == WIDTH_HIGH || representation == CENTRE_HIGH;
	}
	
	public static boolean hasCentre(Representation representation) {
		return representation == CENTRE || representation == LOW_CENTER || representation == CENTRE_HIGH || representation == CENTRE_WIDTH;
	}
	
	public static boolean hasWidth(Representation representation) {
		return representation == WIDTH || representation == CENTRE_WIDTH || representation == LOW_WIDTH || representation == WIDTH_HIGH;
	}
	
}
