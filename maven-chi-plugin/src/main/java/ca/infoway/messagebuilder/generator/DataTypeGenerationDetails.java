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

package ca.infoway.messagebuilder.generator;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.BN;
import ca.infoway.messagebuilder.datatype.BXIT;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CO;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.CR;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.CV_R2;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.EIVL;
import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.HXIT;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.PIVL_R2;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.PQR;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.SC;
import ca.infoway.messagebuilder.datatype.SC_R2;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.SXCM;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.SXPR;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.URL;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EventRelatedPeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.ParentheticSetExpr;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.SetComponent;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.CodedTypeEvaluator;
import ca.infoway.messagebuilder.xml.Hl7TypeName;

/**
 * <p>A list of standard HL7 data types.
 * 
 * <p> Each enum maps to the appropriate HL7 datatype name, actual HL7 datatype, and underlying datatype. An enum
 * will also map to a Simple XMl datatype where appropriate.
 * 
 * <p>This enum class contains numerous helper methods for determining properties about types, and for converting
 * between type variations, eg. determining the HL7 datatype from the Simple Xm ldatatype.
 *
 * <p>An attempt has been made to try to consistently use the following naming standards:
 * 
 *   <p><b>enum datatype (or enum):</b>          a datatype represented by the StandardDataType enum 
 *   <p><b>HL7 datatype:</b>                     the HL7-defined datatype, eg. URG or URG&lt;TS.DATE&gt; or TS.DATE
 *   <p><b>java datatype (or just datatype):</b> the underlying java class used for a datatype, eg. String, PostalAddress
 *   <p><b>simple xml datatype:</b>              the datatype equivalent used for the Simple XML variant
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
enum DataTypeGenerationDetails implements Typed {

	ANY("ANY", ANY.class.getName(), Object.class.getName(), "System.object"), 
	ANY_LAB("ANY.LAB", ANY.class.getName(), Object.class.getName(), "System.object"), 
	ANY_CA_IZ("ANY.CA.IZ", ANY.class.getName(), Object.class.getName(), "System.object"), 
	ANY_PATH("ANY.PATH", ANY.class.getName(), Object.class.getName(), "System.object"),
	ANY_X1("ANY.x1", ANY.class.getName(), Object.class.getName(), "System.object"),
	ANY_X2("ANY.x2", ANY.class.getName(), Object.class.getName(), "System.object"),
	
	AD("AD", AD.class.getName(), PostalAddress.class.getName(), null), 
	AD_BASIC("AD.BASIC", AD.class.getName(), PostalAddress.class.getName(), null), 
	AD_FULL("AD.FULL", AD.class.getName(), PostalAddress.class.getName(), null),
	AD_SEARCH("AD.SEARCH", AD.class.getName(), PostalAddress.class.getName(), null),
	
	BL("BL", BL.class.getName(), Boolean.class.getName(), "System.bool?"),
	BN_R2("BN", BN.class.getName(), Boolean.class.getName(), "System.bool?"),
	
	ON("ON", ON.class.getName(), OrganizationName.class.getName(), null),
	
	SC("SC", SC.class.getName(), CodedString.class.getName(), null),
	SC_R2("SC", SC_R2.class.getName(), CodedTypeR2.class.getName(), null),
	
	EN("EN", EN.class.getName(), EntityName.class.getName(), null),
	
	TN("TN", TN.class.getName(), TrivialName.class.getName(), null),
	
	QTY("QTY", QTY.class.getName(), BigDecimal.class.getName(), "Ca.Infoway.Messagebuilder.BigDecimal"),
	
	GTS("GTS", GTS.class.getName(), GeneralTimingSpecification.class.getName(), null), 
	GTS_BOUNDEDPIVL("GTS.BOUNDEDPIVL", GTS.class.getName(), GeneralTimingSpecification.class.getName(), null),
	
	II("II", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null), 
	II_TOKEN("II.TOKEN", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null), 
	II_BUS("II.BUS", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null), 
	II_PUBLIC("II.PUBLIC", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null), 
	II_OID("II.OID", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null), 
	II_VER("II.VER", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null),
	II_PUBLICVER("II.PUBLICVER", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null),
	II_BUS_AND_VER("II.BUS_AND_VER", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null),
	II_BUSVER("II.BUSVER", "InstanceIdentifier", II.class.getName(), Identifier.class.getName(), null),
	
	CV("CV", "CodedValue", CV.class.getName(), Code.class.getName(), null), 
	CV_R2("CV", "CodedValue", CV_R2.class.getName(), CodedTypeR2.class.getName(), null), 
	CD("CD", "CodedType", CD.class.getName(), Code.class.getName(), null), 
	CD_R2("CD", "CodedType", CD_R2.class.getName(), CodedTypeR2.class.getName(), null), 
	CD_LAB("CD.LAB", "CodedTypeLab", CD.class.getName(), Code.class.getName(), null), 
	CE("CE", CE.class.getName(), Code.class.getName(), null), 
	CE_R2("CE", CE_R2.class.getName(), CodedTypeR2.class.getName(), null), 
	CS("CS", "SimpleCodedType", CS.class.getName(), Code.class.getName(), null),
	CS_R2("CS", "SimpleCodedType", CS_R2.class.getName(), CodedTypeR2.class.getName(), null),
	CR_R2("CR", CR.class.getName(), CodeRole.class.getName(), null), 
	CO_R2("CO", "CodedValue", CO.class.getName(), CodedTypeR2.class.getName(), null), 
	PQR_R2("PQR", "CodedValue", PQR.class.getName(), CodedTypeR2.class.getName(), null),
	
	HXIT_R2("HXIT", HXIT.class.getName(), CodedTypeR2.class.getName(), null), 
	HXIT_CE_R2("HXIT<CE>", HXIT.class.getName(), CodedTypeR2.class.getName(), null), 
	BXIT_R2("BXIT", BXIT.class.getName(), CodedTypeR2.class.getName(), null), 
	BXIT_CD_R2("BXIT<CD>", BXIT.class.getName(), CodedTypeR2.class.getName(), null), 
	
	ST("ST", ST.class.getName(), String.class.getName(), "System.String"), 
	ST_LANG("ST.LANG", "LocalizedString", ST.class.getName(), String.class.getName(), "System.String"), 
	
	ED("ED", ED.class.getName(), EncapsulatedData.class.getName(), null), 
	ED_DOC_OR_REF("ED.DOCORREF", "EncapsulatedDocumentOrReference", ED.class.getName(), EncapsulatedData.class.getName(), null), 
	ED_DOC("ED.DOC", "EncapsulatedDocumentType", ED.class.getName(), EncapsulatedData.class.getName(), null), 
	ED_DOC_REF("ED.DOCREF", "EncapsulatedReferenceType", ED.class.getName(), EncapsulatedData.class.getName(), null),
	ED_SIGNATURE("ED.SIGNATURE", "EncapsulatedSignatureType", ED.class.getName(), String.class.getName(), "System.String"),
	ED_R2("ED", ED.class.getName(), EncapsulatedDataR2.class.getName(), null), 
	
	PN("PN", PN.class.getName(), PersonName.class.getName(), null), 
	PN_BASIC("PN.BASIC", PN.class.getName(), PersonName.class.getName(), null), 
	PN_SIMPLE("PN.SIMPLE", PN.class.getName(), PersonName.class.getName(), null), 
	PN_FULL("PN.FULL", PN.class.getName(), PersonName.class.getName(), null), 
	PN_SEARCH("PN.SEARCH", PN.class.getName(), PersonName.class.getName(), null),
	
	IVL("IVL", "Interval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_INT("IVL<INT>", "IntInterval", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_MO_R2("IVL<MO>", "MoneyInterval", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_PQ("IVL<PQ>", "PhysicalQuantityInterval", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_REAL_R2("IVL<REAL>", "RealInterval", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_TS("IVL<TS>", "DateInterval", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_TS_R2("IVL<TS>", "DateInterval", IVL_TS.class.getName(), DateInterval.class.getName(), null), 
	IVL_DATE("IVL<TS.DATE>", IVL.class.getName(), Interval.class.getName(), null),
	IVL_DATETIME("IVL<TS.DATETIME>", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_FULL_DATE("IVL<TS.FULLDATE>", IVL.class.getName(), Interval.class.getName(), null),
	IVL_FULL_DATE_TIME("IVL<TS.FULLDATETIME>", IVL.class.getName(), Interval.class.getName(), null),
	IVL_FULL_DATE_PART_TIME("IVL<TS.FULLDATEPARTTIME>", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_FULL_DATE_WITH_TIME("IVL<TS.FULLDATEWITHTIME>", IVL.class.getName(), Interval.class.getName(), null), 
	IVL_HIGH_TS_FULLDATE("IVL.HIGH<TS.FULLDATE>", "DateInterval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_WIDTH_TS_FULLDATE("IVL.WIDTH<TS.FULLDATE>", "DateInterval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_LOW_TS_DATE("IVL.LOW<TS.DATE>", "DateInterval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_LOW_TS_FULLDATE("IVL.LOW<TS.FULLDATE>", "DateInterval", IVL.class.getName(), Interval.class.getName(), null),
	
	IVL_WIDTH("IVL.WIDTH", "Interval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_LOW("IVL.LOW", "Interval", IVL.class.getName(), Interval.class.getName(), null),
	IVL_HIGH("IVL.HIGH", "Interval", IVL.class.getName(), Interval.class.getName(), null),
	
	MO("MO", "Money", MO.class.getName(), Money.class.getName(), null), 
	MO_CAD("MO.CAD", "Money", MO.class.getName(), Money.class.getName(), null), 
	
	PIVL("PIVL", PIVL.class.getName(), PeriodicIntervalTime.class.getName(), null),
	PIVL_R2("PIVL", PIVL_R2.class.getName(), PeriodicIntervalTimeR2.class.getName(), null),
	PIVL_TS_R2("PIVL<TS>", PIVL_R2.class.getName(), PeriodicIntervalTimeR2.class.getName(), null),
	PIVL_TS_DATETIME("PIVL<TS.DATETIME>", "PeriodicIntervalOfTime", PIVL.class.getName(), PeriodicIntervalTime.class.getName(), null),
	
	INT("INT", "integer", INT.class.getName(), Integer.class.getName(), "System.int?"), 
	INT_NONNEG("INT.NONNEG", "integer", INT.class.getName(), Integer.class.getName(), "System.int?"), 
	INT_POS("INT.POS", "integer", INT.class.getName(), Integer.class.getName(), "System.int?"),
	
	PQ("PQ", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null), 
	PQ_BASIC("PQ.BASIC", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null), 
	PQ_DRUG("PQ.DRUG", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null), 
	PQ_TIME("PQ.TIME", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null), 
	PQ_LAB("PQ.LAB", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null), 
	PQ_HEIGHTWEIGHT("PQ.HEIGHTWEIGHT", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null),
	PQ_DISTANCE("PQ.DISTANCE", "PhysicalQuantity", PQ.class.getName(), PhysicalQuantity.class.getName(), null),
	
	REAL("REAL", REAL.class.getName(), BigDecimal.class.getName(), "Ca.Infoway.Messagebuilder.BigDecimal"), 
	REAL_COORD("REAL.COORD", REAL.class.getName(), BigDecimal.class.getName(), "Ca.Infoway.Messagebuilder.BigDecimal"), 
	REAL_CONF("REAL.CONF", REAL.class.getName(), BigDecimal.class.getName(), "Ca.Infoway.Messagebuilder.BigDecimal"),
	
	RTO("RTO", RTO.class.getName(), Ratio.class.getName(), null), 
	RTO_PQ_PQ_R2("RTO<PQ,PQ>", RTO.class.getName(), Ratio.class.getName(), null), 
	RTO_MO_PQ_R2("RTO<MO,PQ>", RTO.class.getName(), Ratio.class.getName(), null),
	RTO_PQ_DRUG_PQ_TIME("RTO<PQ.DRUG, PQ.TIME>", RTO.class.getName(), Ratio.class.getName(), null), 
	RTO_MO_CAD_PQ_BASIC("RTO<MO.CAD, PQ.BASIC>", RTO.class.getName(), Ratio.class.getName(), null),
	
	TS("TS", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_R2("TS", TS_R2.class.getName(), MbDate.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"), // need to correct for .NET
	TS_DATE("TS.DATE", "PartialDate", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_DATETIME("TS.DATETIME", "PartialDateTime", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_FULLDATEPARTTIME("TS.FULLDATEPARTTIME", "FullDatePartTime", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_FULLDATEWITHTIME("TS.FULLDATEWITHTIME", "FullDateWithTime", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_FULLDATE("TS.FULLDATE", "FullDate", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	TS_FULLDATETIME("TS.FULLDATETIME", "FullDateTime", TS.class.getName(), Date.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),

	EIVL_R2("EIVL", "FullDateTime", EIVL.class.getName(), EventRelatedPeriodicIntervalTime.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),  // need to correct for .NET
	EIVL_TS_R2("EIVL<TS>", "FullDateTime", EIVL.class.getName(), EventRelatedPeriodicIntervalTime.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),  // need to correct for .NET
	
	TEL("TEL", "BaseTelecommunicationAddress", TEL.class.getName(), TelecommunicationAddress.class.getName(), null), 
	TEL_PHONEMAIL("TEL.PHONEMAIL", "PhonemailTelecommunicationAddress", TEL.class.getName(), TelecommunicationAddress.class.getName(), null), 
	TEL_PHONE("TEL.PHONE", "PhoneNumber", TEL.class.getName(), TelecommunicationAddress.class.getName(), null), 
	TEL_EMAIL("TEL.EMAIL", "EmailAddress", TEL.class.getName(), TelecommunicationAddress.class.getName(), null), 
	TEL_URI("TEL.URI", "Uri", TEL.class.getName(), TelecommunicationAddress.class.getName(), null),
	
	URG("URG", URG.class.getName(), UncertainRange.class.getName(), null),
	URG_TS_DATE("URG<TS.DATE>", URG.class.getName(), UncertainRange.class.getName(), null),
	URG_PQ("URG<PQ>", URG.class.getName(), UncertainRange.class.getName(), null),
	URG_PQ_DRUG("URG<PQ.DRUG>", URG.class.getName(), UncertainRange.class.getName(), null),
	URG_PQ_TIME("URG<PQ.TIME>", URG.class.getName(), UncertainRange.class.getName(), null),

	URL("URL", URL.class.getName(), TelecommunicationAddress.class.getName(), null),
	
	SXPR("SXPR", SXPR.class.getName(), ParentheticSetExpr.class.getName(), null),
	
	SXCM("SXCM", SXCM.class.getName(), SetComponent.class.getName(), null),
	SXCM_R2("SXCM", SXCM_R2.class.getName(), Object.class.getName(), null),
	SXCM_TS_R2("SXCM<TS>", SXCM_R2.class.getName(), MbDate.class.getName(), "Ca.Infoway.Messagebuilder.PlatformDate"),
	SXCM_PQ_R2("SXCM<PQ>", "PhysicalQuantity", SXCM_R2.class.getName(), PhysicalQuantity.class.getName(), null), 
	SXCM_MO_R2("SXCM<MO>", "Money", SXCM_R2.class.getName(), Money.class.getName(), null), 
	SXCM_INT_R2("SXCM<INT>", "integer", SXCM_R2.class.getName(), Integer.class.getName(), "System.int?"), 
	SXCM_REAL_R2("SXCM<REAL>", SXCM_R2.class.getName(), BigDecimal.class.getName(), "Ca.Infoway.Messagebuilder.BigDecimal"), 
	SXCM_CD_R2("SXCM<CD>", SXCM_R2.class.getName(), CodedTypeR2.class.getName(), null),
	
	LIST("LIST", LIST.class.getName(), List.class.getName(), "System.Collections.Generic.IList"), 
	SET("SET", SET.class.getName(), Set.class.getName(), "System.Collections.Generic.ICollection"), 
	BAG("BAG", COLLECTION.class.getName(), Collection.class.getName(), "System.Collections.Generic.IList"), 
	COLLECTION("COLLECTION", COLLECTION.class.getName(), Collection.class.getName(), "System.Collections.Generic.ICollection"); 
	
	private static final Map<DataTypeGenerationDetails,DataTypeGenerationDetails> widthType;
	
	static {
		Map<DataTypeGenerationDetails,DataTypeGenerationDetails> map = new HashMap<DataTypeGenerationDetails, DataTypeGenerationDetails>();
		map.put(IVL_FULL_DATE, PQ_TIME);
		map.put(IVL_DATE, PQ_TIME);
		map.put(IVL_DATETIME, PQ_TIME);
		map.put(IVL_FULL_DATE_TIME, PQ_TIME);
		map.put(IVL_FULL_DATE_WITH_TIME, PQ_TIME);
		map.put(IVL_FULL_DATE_PART_TIME, PQ_TIME);
		map.put(IVL_TS, PQ_TIME);
		
		widthType = Collections.unmodifiableMap(map);
	}
	
	private static Map<String,DataTypeGenerationDetails> simpleXmlMap;
	
	private final String name;
	private final String simpleXmlType;
	
	private final String hl7TypeName;
	private final String javaTypeName;
	private final String csharpTypeName;

	private DataTypeGenerationDetails(String name, String hl7TypeName, String javaTypeName, String csharpTypeName) {
		this(name, null, hl7TypeName, javaTypeName, csharpTypeName);
	}

	private DataTypeGenerationDetails(String name, String simpleXmlType, String hl7TypeName, String javaTypeName, String csharpTypeName) {
		this.name = name;
		this.simpleXmlType = simpleXmlType;
		this.hl7TypeName = hl7TypeName;
		this.javaTypeName = javaTypeName;
		this.csharpTypeName = csharpTypeName == null ? javaTypeName : csharpTypeName;
	}
	
	/**
	 * <p>Gets the type name and parameter types.
	 * 
	 * @return this enum's HL7TypeName, an objecting defining the type's name and parameter types.
	 */
	public Hl7TypeName getTypeName() {
		return Hl7TypeName.parse(getType());
	}

	/**
	 * <p>Obtains the type name.
	 * 
	 * @return the HL7 name of the data type (eg. "INT.NONNEG")
	 */
	public String getType() {
		return this.name;
	}

	/**
	 * <p>Returns the root datatype of this data type. 
	 * 
	 * @return the root data type of this data type, as an enum.
	 */
	public DataTypeGenerationDetails getRootDataType(boolean isR2) {
		return DataTypeGenerationDetails.getByTypeName(getRootType(), isR2);
	}
	
	/**
	 * <p>Returns the root datatype of this data type. 
	 * 
	 * @return the root data type of this data type, as a string.
	 */
	public String getRootType() {
		return getTypeName().getRootName();
	}

	/**
	 * <p>Returns the classname of the HL7 datatype used for this enum.
	 * 
	 * @return the classname of the HL7 datatype for this enum.
	 */
	public String getHl7TypeName() {
		return this.hl7TypeName;
	}

	/**
	 * <p>Returns the classname of the underlying datatype used for this enum.
	 * 
	 * @return the classname of the underlying datatype for this enum.
	 */
	public String getJavaTypeName() {
		return this.javaTypeName;
	}

	/**
	 * <p>Determines if the enum represents a coded type.
	 * 
	 * @return whether or not the enum is a coded type.
	 */
	public boolean isCoded() {
		// SC (for R1) is not a coded type (though it likely should be modified to be one)
		return SC == this ? false : CodedTypeEvaluator.isCodedType(getType());
	}

	/**
	 * <p>Determines if the given datatype shares the same root HL7 datatype.
	 * 
	 * @param dataType the type to compare
	 * @return whether the datatypes are equivalent, that is, do they share the same root HL7 datatype
	 */
	public boolean isEquivalent(DataTypeGenerationDetails dataType) {
		return dataType!=null && getRootType().equals(dataType.getRootType());
	}

	/**
	 * <p>Determines if a given HL7 datatype name is a SET. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a SET type
	 */
	public static boolean isSet(String dataTypeName) {
		return dataTypeName!=null && dataTypeName.startsWith(SET.getRootType());
	}

	/**
	 * <p>Determines if a given HL7 datatype name is a LIST. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a LIST type
	 */
	public static boolean isList(String dataTypeName) {
		return dataTypeName!=null && dataTypeName.startsWith(LIST.getRootType());
	}

	/**
	 * <p>Determines if a given HL7 datatype name is a COLLECTION. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a COLLECTION type
	 */
	public static boolean isCollection(String dataTypeName) {
		return dataTypeName!=null && dataTypeName.startsWith(COLLECTION.getRootType());
	}

	/**
	 * <p>Determines if a given HL7 datatype name is a BAG. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a BAG type
	 */
	public static boolean isBag(String dataTypeName) {
		return dataTypeName!=null && dataTypeName.startsWith(BAG.getRootType());
	}

	/**
	 * <p>Determines the enum datatype for the given type (Typed) object. 
	 * 
	 * @param typed the object to get the type name from
	 * @return the type enum corresponding to the input parameter type
	 */
	public static DataTypeGenerationDetails getByTypeName(Typed typed, boolean isR2) {
		return typed == null ? null : getByTypeName(typed.getType(), isR2);
	}
	
	/**
	 * <p>Determines the enum datatype for a given HL7 type name. 
	 * 
	 * @param name the HL7 name of a datatype 
	 * @return the type enum corresponding to the input parameter name
	 */
	public static DataTypeGenerationDetails getByTypeName(String name, boolean isR2) {
		DataTypeGenerationDetails result = null;
		
		if (isList(name)) {
			result = DataTypeGenerationDetails.LIST;
		} else if (isSet(name)) {
			result = DataTypeGenerationDetails.SET;
		} else if (isCollection(name)) {
			result = DataTypeGenerationDetails.COLLECTION;
		} else {
			// check for R2 matches first
			if (isR2) {
				for (DataTypeGenerationDetails type : values()) {
					if (type.name().endsWith("_R2")) {
						if (StringUtils.equals(name, type.getType())) {
							result = type;
							break;
						}
					}
				}
			}
			if (result == null) {
				for (DataTypeGenerationDetails type : values()) {
					// don't compare against R2 types at this point
					if (!type.name().endsWith("_R2")) {
						if (StringUtils.equals(name, type.getType())) {
							result = type;
							break;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * <p>Determines the enum datatype for the width attribute of the given enum datatype.
	 * 
	 * @param type the enum datatype for which its width datetype needs to be determined 
	 * @return the enum datatype representing the width attribute of the given enum datatype
	 */
	public static DataTypeGenerationDetails getWidthType(DataTypeGenerationDetails type) {
		DataTypeGenerationDetails result = type == null ? null : widthType.get(type);
		if (type == null) {
			throw new IllegalArgumentException("Cannot determine the width type of an unknown interval type.");
		} else if (result == null) {
			throw new IllegalArgumentException(type.getType() + " is not an interval");
		} else {
			return result;
		}
	}
	
	/**
	 * <p>Returns the simple xml equivalent name for this enum.
	 * 
	 * @return the simple xml type name for this enum.
	 */
	public String getSimpleXmlType() {
		return this.simpleXmlType;
	}
	
	/**
	 * <p>Obtains the datatype enum corresponding to a given simple xml type name.
	 * 
	 * @param simpleXmlType the simple xml type name to convert
	 * @param isR2 
	 * @return the corresponding enum datatype
	 */
	public static DataTypeGenerationDetails convertSimpleXmlToDataType(String simpleXmlType, boolean isR2) {
		if (simpleXmlMap == null) {
			initializeSimpleXmlMap(isR2);
		}
		return simpleXmlMap.get(simpleXmlType);
	}

	private synchronized static void initializeSimpleXmlMap(boolean isR2) {
		if (simpleXmlMap == null) {
			Map<String, DataTypeGenerationDetails> map = new HashMap<String, DataTypeGenerationDetails>();
			for (DataTypeGenerationDetails type : values()) {
				String simpleXmlType = type.simpleXmlType;
				if (StringUtils.isNotBlank(simpleXmlType)) {
					if (map.containsKey(simpleXmlType)) {
						DataTypeGenerationDetails other = map.get(simpleXmlType);
						if (StringUtils.equals(other.getRootType(), type.getRootType())) {
							map.put(simpleXmlType, DataTypeGenerationDetails.getByTypeName(type.getRootType(), isR2));
						} else {
							throw new IllegalStateException("Simple XML type " + simpleXmlType 
									+ " is mapped to two incompatible types: " 
									+ type.getType() + ", " + other.getType());
						}
					} else {
						map.put(simpleXmlType, type);
					}
				}
			}
			simpleXmlMap = Collections.unmodifiableMap(map);
		}		
	}

	public String getCsharpTypeName() {
		return this.csharpTypeName;
	}
	
	public String getLanguageSpecificTypeName(ProgrammingLanguage language) {
		return language == ProgrammingLanguage.JAVA ? getJavaTypeName() : getCsharpTypeName();
	}

}
