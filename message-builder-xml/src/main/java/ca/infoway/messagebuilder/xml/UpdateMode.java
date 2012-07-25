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

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Update mode on an attribute or an association.
 * 
 * <p>Describes how a relationship should be updated.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class UpdateMode {

	@ElementList(entry="allowdUpdateMode",inline=true,required=false)
	private List<String> updateModesAllowed;
	@Attribute(required=false)
	private String updateModeDefault;
	
	/**
	 * <p>Gets the update mode that should be assumed if no updateMode is specified.
	 * @return updateModeDefault
	 */
	public UpdateModeType getUpdateModeDefault() {
		return EnumPattern.valueOf(UpdateModeType.class, updateModeDefault);
	}
	/**
	 * <p>Sets the update mode that should be assumed if no updateMode is specified.
	 * @param updateModeDefault
	 */
	public void setUpdateModeDefault(UpdateModeType updateModeDefault) {
		this.updateModeDefault = updateModeDefault.getName();
	}

	/**
	 * <p>Gets the list of update modes that may be used for this element.
	 * @return updateModesAllowed
	 */
	public List<UpdateModeType> getUpdateModesAllowed() {
		List<UpdateModeType> result = new ArrayList<UpdateModeType>();
		if (updateModesAllowed!= null) {
			for (String updateModeType : updateModesAllowed) {
				result.add(EnumPattern.valueOf(UpdateModeType.class, updateModeType));
			}
		}
		return result;
	}
	/**
	 * <p>Set the list of update modes that may be used for this element.
	 * @param updateModesAllowed
	 */
	public void setUpdateModesAllowed(List<UpdateModeType> updateModes) {
		if (updateModes == null) {
			this.updateModesAllowed = null;
		} else {
			List<String> result = new ArrayList<String>();
			if (updateModes!= null) {
				for (UpdateModeType updateModeType : updateModes) {
					result.add(updateModeType.getName());
				}
			}
			this.updateModesAllowed = result;
		}
	}
}
