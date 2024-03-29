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
 * Last modified: $LastChangedDate: 2014-01-06 14:03:13 -0500 (Mon, 06 Jan 2014) $
 * Revision:      $LastChangedRevision: 8266 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Java datatype backing the R2 coded types.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying code type
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class CodedTypeR2<T extends Code> {
    
    private T code;
    private String codeSystemName;
	private String codeSystemVersion;
    private String displayName;

    private NullFlavor nullFlavorForTranslationOnly; 
    
    private EncapsulatedData originalText;
    private List<CodeRole> qualifier = new ArrayList<CodeRole>();
    private List<CodedTypeR2<Code>> translation = new ArrayList<CodedTypeR2<Code>>();
    
    private String simpleValue; // SC only
    private SetOperator operator; // SCXM<CD> only
    private BigDecimal value; //PQR only
    private Interval<Date> validTime; // HXIT_CE only
    private Integer qty; // BXIT_CD only

    public CodedTypeR2() {
    	this(null);
	}
    
    public CodedTypeR2(T code) {
    	setCode(code);
	}
    
	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public String getCodeValue() {
		return this.code == null ? null : this.code.getCodeValue();
	}
	
	public String getCodeSystem() {
		return this.code == null ? null : this.code.getCodeSystem();
	}
	
	public String getCodeSystemName() {
		// If the code happens to contain a code system name, we should always treat it as
		// correct and authoritative. However, if the code resolver we are using hasn't
		// provided a value and we happen to have one from another source (e.g., an 
		// incoming document), we can use that as a backup.
		if (this.code != null && this.code.getCodeSystemName() != null) {
			return this.code.getCodeSystemName();
		}
		return codeSystemName;
	}

	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}

	public String getCodeSystemVersion() {
		return codeSystemVersion;
	}

	public void setCodeSystemVersion(String codeSystemVersion) {
		this.codeSystemVersion = codeSystemVersion;
	}

	public String getDisplayName() {
		// If the code happens to contain a display name, we should always treat it as
		// correct and authoritative. However, if the code resolver we are using hasn't
		// provided a value and we happen to have one from another source (e.g., an 
		// incoming document), we can use that as a backup.
		if (this.code != null && Describable.class.isAssignableFrom(this.code.getClass())) {
			Describable describableCode = (Describable) this.code;
			String englishDescription = describableCode.getDescription();
			if (englishDescription != null) {
				return englishDescription;
			}
		}
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public EncapsulatedData getOriginalText() {
		return originalText;
	}

	public void setOriginalText(EncapsulatedData originalText) {
		this.originalText = originalText;
	}

	public List<CodeRole> getQualifier() {
		return qualifier;
	}

	public void setQualifier(List<CodeRole> qualifier) {
		this.qualifier = qualifier;
	}

	public List<CodedTypeR2<Code>> getTranslation() {
		return translation;
	}

	public void setTranslation(List<CodedTypeR2<Code>> translation) {
		this.translation = translation;
	}

	public String getSimpleValue() {
		return simpleValue;
	}

	public void setSimpleValue(String simpleValue) {
		this.simpleValue = simpleValue;
	}

	public SetOperator getOperator() {
		return operator;
	}

	public void setOperator(SetOperator setOperator) {
		this.operator = setOperator;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

    public Interval<Date> getValidTime() {
		return validTime;
	}

	public void setValidTime(Interval<Date> validTime) {
		this.validTime = validTime;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	/**
	 * @return the nullFlavor of this coded type - only used if this instance is a translation
	 */
    public NullFlavor getNullFlavorForTranslationOnly() {
		return this.nullFlavorForTranslationOnly;
	}

    /**
     * @param nullFlavorForTranslationOnly the nullFlavor of this coded type - only used if this instance is a translation
     */
	public void setNullFlavorForTranslationOnly(NullFlavor nullFlavorForTranslationOnly) {
		this.nullFlavorForTranslationOnly = nullFlavorForTranslationOnly;
	}

	public boolean isEmpty() {
		return this.code == null
			&& this.codeSystemName == null
			&& this.codeSystemVersion == null
			&& this.displayName == null
			&& this.operator == null
			&& this.simpleValue == null
			&& this.originalText == null
			&& this.value == null
			&& (this.translation == null || this.translation.isEmpty())
			&& (this.qualifier == null || this.qualifier.isEmpty())
			&& this.validTime == null
			&& this.qty == null
			&& this.nullFlavorForTranslationOnly == null
			;
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.code)
		        .append(this.codeSystemName)
		        .append(this.codeSystemVersion)
		        .append(this.displayName)
		        .append(this.originalText)
		        .append(this.qualifier)
		        .append(this.translation)
		        .append(this.simpleValue)
		        .append(this.operator)
		        .append(this.value)
		        .append(this.validTime)
		        .append(this.qty)
		        .append(this.nullFlavorForTranslationOnly)
                .toHashCode();
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((CodedTypeR2<T>) obj);
        }
    }
    
    private boolean equals(CodedTypeR2<T> that) {
        return new EqualsBuilder()
                .append(this.code, that.code)
                .append(this.codeSystemName, that.codeSystemName)
                .append(this.codeSystemVersion, that.codeSystemVersion)
		        .append(this.displayName, that.displayName)
		        .append(this.originalText, that.originalText)
		        .append(this.qualifier, that.qualifier)
		        .append(this.translation, that.translation)
		        .append(this.simpleValue, that.simpleValue)
		        .append(this.operator, that.operator)
		        .append(this.value, that.value)
		        .append(this.validTime, that.validTime)
		        .append(this.qty, that.qty)
		        .append(this.nullFlavorForTranslationOnly, that.nullFlavorForTranslationOnly)
                .isEquals();
    }
}
