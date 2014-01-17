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
 * Last modified: $LastChangedDate: 2013-11-01 15:27:47 -0300 (Fri, 01 Nov 2013) $
 * Revision:      $LastChangedRevision: 8051 $
 */

package ca.infoway.messagebuilder.datatype;

import java.util.List;

/**
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface ANYMetaData {

	public String getLanguage();
	public void setLanguage(String language);
	
	public String getDisplayName();
	public void setDisplayName(String displayName);
	
	public List<CD> getTranslations();
	
	public String getOriginalText();
	public void setOriginalText(String originalText);
	
}
