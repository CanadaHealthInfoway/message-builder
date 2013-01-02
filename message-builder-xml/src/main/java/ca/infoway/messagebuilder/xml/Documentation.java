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

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <p>Documentation about a particular HL7 construct.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root(strict=false)
public class Documentation {
	
	@Element(required=false)
	private String title;
	@Element(required=false)
	private String businessName;
	
	@ElementList(required=false,inline=true,entry="annotation")
	private List<Annotation> annotations = new ArrayList<Annotation>();

	/**
	 * <p>Standard constructor.
	 */
	public Documentation() {
	}
	/**
	 * <p>Standard constructor.
	 * @param annotations - annotations of documentation.
	 */
	public Documentation(List<Annotation> annotations) {
		this.annotations = annotations;
	}
	
	/**
	 * <p>Standard constructor.
	 * @param paragraphs - annotations of documentation.
	 */	
	public Documentation(Annotation... annotations) {
		if (!ArrayUtils.isEmpty(annotations)) {
			this.annotations.addAll(Arrays.asList(annotations));
		}
	}	
	
	/**
	 * <p>Get the title.
	 * @return - the title.
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * <p>Set the title.
	 * @param title - the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * <p>Get the business name.
	 * @return the business name
	 */
	public String getBusinessName() {
		return this.businessName;
	}
	/**
	 * <p>Set the business name.
	 * @param businessName - the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * <p>Standard equals implementation.
	 * 
	 * @param obj - the other object
	 * @return true if the objects are equal; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			Documentation that = (Documentation) obj;
			return new EqualsBuilder()
					.append(this.businessName, that.businessName)
					.append(this.title, that.title)
					.append(this.getAnnotations(), that.getAnnotations())
					.isEquals();
		}
	}
	
	/**
	 * <p>Standard hash code method.
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(this.businessName)
		.append(this.title)
		.append(this.getAnnotations())
		.toHashCode();
	}
	/**
	 * <p>Get all annotations of documentation.
	 * @return - the annotations of documentation.
	 */
	public List<Annotation> getAnnotations() {
		return annotations;
	}
	/**
	 * <p>Set the annotations for one annotation type.
	 * @param annotations - the new annotations of documentation.
	 */
	public void setAnnotations(List<Annotation> annotations) {
		this.annotations = annotations;
	}
}
