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
package ca.infoway.messagebuilder.html.generator;

import java.util.HashMap;
import java.util.Map;

public class HtmlMessageSetRenderDefault {
	public static final String INTERACTION_PATH = "../interactions";
	public static final String PACKAGE_PATH = "../packages";
	public static final String DATATYPE_PATH = "../datatypes";
	public static final String CODESYSTEM_PATH = "../codeSystems";
	public static final String VALUESET_PATH = "../valueSets";
	public static final String CONCEPTDOMAIN_PATH = "../conceptDomains";
	public static final String RESOURCE_PATH = "../resources";
	public static final String JAVASCRIPT_PATH = "../resources/js";
	
	public static final String NAV_BAR_SCRIPT_NAME = "mainNavBar.js";
	public static final String CONTENT_DIV_ID = "content";
	public static final String CONTAINER_DIV_ID = "container";
	public static final String WRAPPER_DIV_ID = "wrapper";
	public static final String DEFAULT_RESOURCE_PATH = "/ca/infoway/smct/html";
	public static final String PAGE_DIV_ID = "page";
	public static final String LEFT_NAV_BAR_ID = "leftNavBar";
	public static final String MAIN_CONTENT_ID = "mainColumn";
	public static final String MESSAGE_SET_ROOT_TREE_NODE_ID = "messageSetRootNode";
	public static final String PACKAGE_TOC_DIV_ID = "packageTocDiv";
	public static final String DIAGRAM_DIV_ID = "diagramDiv";
	public static final String TOC_LIST_CLASS = "tocList";
	public static final String TOC_LIST_ITEM_CLASS = "tocListItem";
	public static final String DETAILS_TABLE_VALUE_COL_CLASS = "detailsTableValueCol";
	public static final String DETAILS_TABLE_LABEL_COL_CLASS = "detailsTableLabelCol";
	
	public static final String DEFAULT_DATATYPE_FILE_PREFIX = "datatypeSet";
	
	public static final Map<String, String> DOMAIN_DESCRIPTIONS = new HashMap<String, String>();
	static {	
		DOMAIN_DESCRIPTIONS.put("FICR", "Claims and Reimbursement");
		DOMAIN_DESCRIPTIONS.put("MCCI", "Transmission Wrappers");
		DOMAIN_DESCRIPTIONS.put("MCAI", "Control Act Wrappers");
		DOMAIN_DESCRIPTIONS.put("MFMI", "Master File Management");
		DOMAIN_DESCRIPTIONS.put("QUQI", "Queries");
		DOMAIN_DESCRIPTIONS.put("COCT", "Common Message Element (CMETs)");
		DOMAIN_DESCRIPTIONS.put("COMT", "Common Message Content (Shared Messages)");
		DOMAIN_DESCRIPTIONS.put("POIZ", "Immunization");
		DOMAIN_DESCRIPTIONS.put("POLB", "Laboratory");
		DOMAIN_DESCRIPTIONS.put("POME", "Medication");
		DOMAIN_DESCRIPTIONS.put("PORR", "Regulated Reporting");
		DOMAIN_DESCRIPTIONS.put("PRPM", "Provider Registry");
		DOMAIN_DESCRIPTIONS.put("QUCR", "Claims Query");
		DOMAIN_DESCRIPTIONS.put("QUQI", "Queries");
		DOMAIN_DESCRIPTIONS.put("RCMR", "Medical Records");
		DOMAIN_DESCRIPTIONS.put("REPC", "Care Provision");
		DOMAIN_DESCRIPTIONS.put("POOO", "Orders and Observations");
		DOMAIN_DESCRIPTIONS.put("PORX", "Pharmacy");
	}
}
