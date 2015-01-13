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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-19 09:34:53 -0500 (Wed, 19 Nov 2014) $
 * Revision:      $LastChangedRevision: 9080 $
 */
package ca.infoway.messagebuilder.domainvalue.util;

import ca.infoway.messagebuilder.Code;

public interface CodeTypeHandler {

	public Class<? extends Code> getCodeType(String domainType, String version);

}