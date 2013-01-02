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

package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum QueryResponse. Values in this domain allow a query response system to return a precise response status.
 */
public class QueryResponse extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.QueryResponse {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = -6211467438802392184L;
	
	public static final QueryResponse APPLICATION_ERROR = new QueryResponse("APPLICATION_ERROR", "AE", true);
	public static final QueryResponse NO_DATA_FOUND = new QueryResponse("NO_DATA_FOUND", "NF", false);
	public static final QueryResponse DATA_FOUND = new QueryResponse("DATA_FOUND", "OK", false);
	public static final QueryResponse QUERY_PARAMETER_ERROR = new QueryResponse("QUERY_PARAMETER_ERROR", "QE", true);
	
	private final String codeValue;
	private final boolean error;

	private QueryResponse(String name, String codeValue, boolean error) {
		super(name);
		this.codeValue = codeValue;
		this.error = error;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_QUERY_RESPONSE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
	
	/**
	 * <p>Checks if is error.
	 *
	 * @return true, if is error
	 */
	public boolean isError() {
		return this.error;
	}
}
