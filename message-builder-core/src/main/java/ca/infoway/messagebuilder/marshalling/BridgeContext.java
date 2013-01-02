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

/**
 * 
 */
package ca.infoway.messagebuilder.marshalling;

class BridgeContext {
	
	private final boolean collapsed;
	private final Integer index;

	BridgeContext() {
		this(false);
	}
	BridgeContext(boolean collapsed) {
		this.collapsed = collapsed;
		this.index = null;
	}
	BridgeContext(boolean collapsed, Integer index) {
		this.collapsed = collapsed;
		this.index = index;
	}
	public boolean isCollapsed() {
		return this.collapsed;
	}
	public Integer getOriginalIndex() {
		return this.index;
	}
	public int getIndex() {
		if (this.index == null) {
			throw new IllegalStateException("index is null");
		} else {
			return this.index.intValue();
		}
	}
	public boolean isIndexed() {
		return this.index != null;
	}
}