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

import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CONTAINER_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.CONTENT_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.MAIN_CONTENT_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.PAGE_DIV_ID;
import static ca.infoway.messagebuilder.html.generator.HtmlMessageSetRenderDefault.WRAPPER_DIV_ID;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.datatype.model.StaticExampleAnnotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.MessageSet;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.Pre;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Tbody;
import com.hp.gagawa.java.elements.Thead;

public class DatatypeHtml extends BaseHtmlGenerator {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private Datatype datatype;
	private DatatypeSet datatypeSet;
	private MessageSet messageSet;
	
	public DatatypeHtml(Datatype datatype, DatatypeSet datatypeSet, MessageSet messageSet) {
		this.datatype = datatype;
		this.datatypeSet = datatypeSet;
		this.messageSet = messageSet;
	}
	
	@Override
	public String write() {
		return writeDatatype().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		filterTypes.add(AnnotationType.STATIC_EXAMPLE);
		//filterTypes.add(AnnotationType.DESIGN_COMMENTS);
		return filterTypes;
	}
	
	protected Document writeDatatype() {
		Document doc = new Document(DocumentType.XHTMLStrict);
			
		addHeadParamaters(getDatatype().getName(), "Datatype", getDatatypeSet().getVersion(), doc);
		
		Div wrapperDiv = new Div();
		wrapperDiv.setId(WRAPPER_DIV_ID);
		
		Div containerDiv = new Div();
		containerDiv.setId(CONTAINER_DIV_ID);
		containerDiv.setCSSClass(CONTENT_DIV_ID);
		
		addDatatypeDetailsMetaHeader(getDatatype().getName(), containerDiv);
		
		addBreadcrumbHeader(getMessageSet(), containerDiv);
		
		Div pageDiv = new Div();
		pageDiv.setId(PAGE_DIV_ID);
		containerDiv.appendChild(pageDiv);
		
		Div mainContentDiv = new Div();
		mainContentDiv.setId(MAIN_CONTENT_ID);
		
		if (StringUtils.isNotBlank(getBusinessName(getDatatype().getDocumentation()))) {
			mainContentDiv.appendChild(createHeader(getDatatype().getName(), "", "titleHeader"));
			
			mainContentDiv.appendChild(createSubHeader("(" +
					getBusinessName(getDatatype().getDocumentation()) + ")", 
					"titleHeader-"+getMessagePartName(getDatatype().getName()), "subTitleHeader"));

		} else {
			mainContentDiv.appendChild(createHeader(
					getHl7TypeName(getDatatype().getName()), 
					"titleHeader-"+getMessagePartName(getDatatype().getName()), "titleHeader"));
		}
		mainContentDiv.appendChild(createDatatypeSummaryDiv());
		mainContentDiv.appendChild(createExampleDiv());		
		
		pageDiv.appendChild(getLeftSideColumn());
		pageDiv.appendChild(mainContentDiv);
		
		wrapperDiv.appendChild(getHeaderDiv());
		wrapperDiv.appendChild(containerDiv);
		wrapperDiv.appendChild(getFooterDiv());
		
		doc.body.appendChild(wrapperDiv);
		
		return doc;
	}

	private Div createExampleDiv() {
		Div result = new Div();
		result.setCSSClass("datatypeExampleDiv");
		
		addExamples(getDatatype().getStaticExamples(), result);
		
		return result;
	}

	private void addExamples(List<StaticExampleAnnotation> exampleAnnotations, Div parentDiv) {
		
		for (StaticExampleAnnotation annotation : exampleAnnotations) {
			if (AnnotationType.STATIC_EXAMPLE.equals(annotation.getAnnotationTypeAsEnum())) {
				H3 exampleHeader = new H3();
				exampleHeader.setCSSClass("staticExampleHeader");
				exampleHeader.appendText("Example: ");
				parentDiv.appendChild(exampleHeader);
				Div headerTextDiv = new Div();
				headerTextDiv.setCSSClass("datatypeExampleHeaderDiv");
				headerTextDiv.appendText(annotation.getBusinessName());
				parentDiv.appendChild(headerTextDiv);
				Pre exampleSection = new Pre();
				exampleSection.appendText(annotation.getText());
				Div exampleTextDiv = new Div();
				exampleTextDiv.setCSSClass("datatypeExampleTextDiv");
				exampleTextDiv.appendText(LINE_SEPARATOR);
				exampleTextDiv.appendChild(exampleSection);
				parentDiv.appendChild(exampleTextDiv);
			}
		}
	}

	private Div createDatatypeSummaryDiv() {
		Div result = new Div();
		result.setCSSClass("datatypeSummaryDiv");
		result.setId("datatypeSummary_" + getDatatype().getName());
		result.appendChild(createSummaryTable());
		return result;
	}

	private Table createSummaryTable() {
		Table result = new Table();
		result.setCSSClass("datatypeSummaryTable");
		Thead tHead = new Thead();
		Tbody tBody = new Tbody();
		
		String superType = getDatatype().getSuperType();
		if (superType != null) {
			tBody.appendChild(createDataRow("Super Type:", createDatatypeLinks(superType, getDatatypeSet()), ""));
		}
		
		addAnnotationDetails(getDatatype().getDocumentation(), "Description:", tBody);
		
		result.appendChild(tHead);
		result.appendChild(tBody);
		return result;
	}

	public Datatype getDatatype() {
		return datatype;
	}
	public void setDatatype(Datatype datatype) {
		this.datatype = datatype;
	}

	public DatatypeSet getDatatypeSet() {
		return datatypeSet;
	}
	public void setDatatypeSet(DatatypeSet datatypeSet) {
		this.datatypeSet = datatypeSet;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet) {
		this.messageSet = messageSet;
	}
}
