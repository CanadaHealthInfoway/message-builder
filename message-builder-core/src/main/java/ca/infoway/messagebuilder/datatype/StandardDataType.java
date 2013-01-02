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

package ca.infoway.messagebuilder.datatype;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.lang.EnumPattern;

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
 * @sharpen.ignore - datatype - translated manually 
 */
public class StandardDataType extends EnumPattern implements Typed {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = 75841345036545890L;
	
	public static final StandardDataType ANY = new StandardDataType("ANY", "ANY"); 
	public static final StandardDataType ANY_LAB = new StandardDataType("ANY_LAB", "ANY.LAB"); 
	public static final StandardDataType ANY_CA_IZ = new StandardDataType("ANY_CA_IZ", "ANY.CA.IZ"); 
	public static final StandardDataType ANY_PATH = new StandardDataType("ANY_PATH", "ANY.PATH");
	
	public static final StandardDataType AD = new StandardDataType("AD", "AD"); 
	public static final StandardDataType AD_BASIC = new StandardDataType("AD_BASIC", "AD.BASIC"); 
	public static final StandardDataType AD_FULL = new StandardDataType("AD_FULL", "AD.FULL");
	public static final StandardDataType AD_SEARCH = new StandardDataType("AD_SEARCH", "AD.SEARCH");
	
	public static final StandardDataType BL = new StandardDataType("BL", "BL");
	
	public static final StandardDataType ON = new StandardDataType("ON", "ON");
	
	public static final StandardDataType SC = new StandardDataType("SC", "SC");
	
	public static final StandardDataType EN = new StandardDataType("EN", "EN");
	
	public static final StandardDataType TN = new StandardDataType("TN", "TN");
	
	public static final StandardDataType QTY = new StandardDataType("QTY", "QTY");
	
	public static final StandardDataType GTS = new StandardDataType("GTS", "GTS"); 
	public static final StandardDataType GTS_BOUNDEDPIVL = new StandardDataType("GTS_BOUNDEDPIVL", "GTS.BOUNDEDPIVL");
	
	public static final StandardDataType II = new StandardDataType("II", "II", "InstanceIdentifier"); 
	public static final StandardDataType II_TOKEN = new StandardDataType("II_TOKEN", "II.TOKEN", "InstanceIdentifier"); 
	public static final StandardDataType II_BUS = new StandardDataType("II_BUS", "II.BUS", "InstanceIdentifier"); 
	public static final StandardDataType II_PUBLIC = new StandardDataType("II_PUBLIC", "II.PUBLIC", "InstanceIdentifier"); 
	public static final StandardDataType II_OID = new StandardDataType("II_OID", "II.OID", "InstanceIdentifier"); 
	public static final StandardDataType II_VER = new StandardDataType("II_VER", "II.VER", "InstanceIdentifier");
	public static final StandardDataType II_PUBLICVER = new StandardDataType("II_PUBLICVER", "II.PUBLICVER", "InstanceIdentifier");
	public static final StandardDataType II_BUS_AND_VER = new StandardDataType("II_BUS_AND_VER", "II.BUS_AND_VER", "InstanceIdentifier");
	public static final StandardDataType II_BUSVER = new StandardDataType("II_BUSVER", "II.BUSVER", "InstanceIdentifier");
	
	public static final StandardDataType CV = new StandardDataType("CV", "CV", "CodedValue"); 
	public static final StandardDataType CD = new StandardDataType("CD", "CD", "CodedType"); 
	public static final StandardDataType CD_LAB = new StandardDataType("CD_LAB", "CD.LAB", "CodedTypeLab"); 
	public static final StandardDataType CE = new StandardDataType("CE", "CE"); 
	public static final StandardDataType CS = new StandardDataType("CS", "CS", "SimpleCodedType");
	
	public static final StandardDataType ST = new StandardDataType("ST", "ST"); 
	public static final StandardDataType ST_LANG = new StandardDataType("ST_LANG", "ST.LANG", "LocalizedString"); 
	
	public static final StandardDataType ED = new StandardDataType("ED", "ED"); 
	public static final StandardDataType ED_DOC = new StandardDataType("ED_DOC", "ED.DOC", "EncapsulatedDocumentType"); 
	public static final StandardDataType ED_DOC_OR_REF = new StandardDataType("ED_DOC_OR_REF", "ED.DOCORREF", "EncapsulatedDocumentOrReference"); 
	public static final StandardDataType ED_REF = new StandardDataType("ED_REF", "ED.REF", "EncapsulatedReferenceType"); //CeRx only
	public static final StandardDataType ED_DOC_REF = new StandardDataType("ED_DOC_REF", "ED.DOCREF", "EncapsulatedReferenceType");
	public static final StandardDataType ED_SIGNATURE = new StandardDataType("ED_SIGNATURE", "ED.SIGNATURE", "EncapsulatedSignatureType");
	
	public static final StandardDataType PN = new StandardDataType("PN", "PN"); 
	public static final StandardDataType PN_BASIC = new StandardDataType("PN_BASIC", "PN.BASIC"); 
	public static final StandardDataType PN_SIMPLE = new StandardDataType("PN_SIMPLE", "PN.SIMPLE"); 
	public static final StandardDataType PN_FULL = new StandardDataType("PN_FULL", "PN.FULL"); 
	public static final StandardDataType PN_SEARCH = new StandardDataType("PN_SEARCH", "PN.SEARCH");
	
	public static final StandardDataType IVL = new StandardDataType("IVL", "IVL", "Interval");
	public static final StandardDataType IVL_DATE = new StandardDataType("IVL_DATE", "IVL<TS.DATE>");
	public static final StandardDataType IVL_DATETIME = new StandardDataType("IVL_DATETIME", "IVL<TS.DATETIME>"); 
	public static final StandardDataType IVL_FULL_DATE = new StandardDataType("IVL_FULL_DATE", "IVL<TS.FULLDATE>");
	public static final StandardDataType IVL_FULL_DATE_TIME = new StandardDataType("IVL_FULL_DATE_TIME", "IVL<TS.FULLDATETIME>");
	public static final StandardDataType IVL_FULL_DATE_WITH_TIME = new StandardDataType("IVL_FULL_DATE_WITH_TIME", "IVL<TS.FULLDATEWITHTIME>"); 
	public static final StandardDataType IVL_TS = new StandardDataType("IVL_TS", "IVL<TS>", "DateInterval"); 
	public static final StandardDataType IVL_HIGH_TS_FULLDATE = new StandardDataType("IVL_HIGH_TS_FULLDATE", "IVL.HIGH<TS.FULLDATE>", "DateInterval");
	public static final StandardDataType IVL_WIDTH_TS_FULLDATE = new StandardDataType("IVL_WIDTH_TS_FULLDATE", "IVL.WIDTH<TS.FULLDATE>", "DateInterval");
	public static final StandardDataType IVL_LOW_TS_DATE = new StandardDataType("IVL_LOW_TS_DATE", "IVL.LOW<TS.DATE>", "DateInterval");
	public static final StandardDataType IVL_LOW_TS_FULLDATE = new StandardDataType("IVL_LOW_TS_FULLDATE", "IVL.LOW<TS.FULLDATE>", "DateInterval");
	public static final StandardDataType IVL_PQ = new StandardDataType("IVL_PQ", "IVL<PQ>", "PhysicalQuantityInterval"); 
	public static final StandardDataType IVL_PQ_BASIC = new StandardDataType("IVL_PQ_BASIC", "IVL<PQ.BASIC>", "PhysicalQuantityInterval"); 
	public static final StandardDataType IVL_PQ_DRUG = new StandardDataType("IVL_PQ_DRUG", "IVL<PQ.DRUG>", "PhysicalQuantityInterval"); 
	public static final StandardDataType IVL_PQ_TIME = new StandardDataType("IVL_PQ_TIME", "IVL<PQ.TIME>", "PhysicalQuantityInterval"); 
	public static final StandardDataType IVL_PQ_LAB = new StandardDataType("IVL_PQ_LAB", "IVL<PQ.LAB>", "PhysicalQuantityInterval"); 
	public static final StandardDataType IVL_PQ_HEIGHTWEIGHT = new StandardDataType("IVL_PQ_HEIGHTWEIGHT", "IVL<PQ.HEIGHTWEIGHT>", "PhysicalQuantityInterval");
	public static final StandardDataType IVL_PQ_DISTANCE = new StandardDataType("IVL_PQ_DISTANCE", "IVL<PQ.DISTANCE>", "PhysicalQuantityInterval");
	
	public static final StandardDataType IVL_WIDTH = new StandardDataType("IVL_WIDTH", "IVL.WIDTH", "Interval");
	public static final StandardDataType IVL_LOW = new StandardDataType("IVL_LOW", "IVL.LOW", "Interval");
	public static final StandardDataType IVL_HIGH = new StandardDataType("IVL_HIGH", "IVL.HIGH", "Interval");
	
	public static final StandardDataType MO = new StandardDataType("MO", "MO"); 
	public static final StandardDataType MO_CAD = new StandardDataType("MO_CAD", "MO.CAD", "Money"); 
	
	public static final StandardDataType PIVL = new StandardDataType("PIVL", "PIVL");
	public static final StandardDataType PIVL_TS_DATETIME = new StandardDataType("PIVL_TS_DATETIME", "PIVL<TS.DATETIME>", "PeriodicIntervalOfTime");
	
	public static final StandardDataType INT = new StandardDataType("INT", "INT", "integer"); 
	public static final StandardDataType INT_NONNEG = new StandardDataType("INT_NONNEG", "INT.NONNEG", "integer"); 
	public static final StandardDataType INT_POS = new StandardDataType("INT_POS", "INT.POS", "integer");
	
	public static final StandardDataType PQ = new StandardDataType("PQ", "PQ", "PhysicalQuantity"); 
	public static final StandardDataType PQ_BASIC = new StandardDataType("PQ_BASIC", "PQ.BASIC", "PhysicalQuantity"); 
	public static final StandardDataType PQ_DRUG = new StandardDataType("PQ_DRUG", "PQ.DRUG", "PhysicalQuantity"); 
	public static final StandardDataType PQ_TIME = new StandardDataType("PQ_TIME", "PQ.TIME", "PhysicalQuantity"); 
	public static final StandardDataType PQ_LAB = new StandardDataType("PQ_LAB", "PQ.LAB", "PhysicalQuantity"); 
	public static final StandardDataType PQ_HEIGHTWEIGHT = new StandardDataType("PQ_HEIGHTWEIGHT", "PQ.HEIGHTWEIGHT", "PhysicalQuantity");
	public static final StandardDataType PQ_DISTANCE = new StandardDataType("PQ_DISTANCE", "PQ.DISTANCE", "PhysicalQuantity");
	
	public static final StandardDataType REAL = new StandardDataType("REAL", "REAL"); 
	public static final StandardDataType REAL_COORD = new StandardDataType("REAL_COORD", "REAL.COORD"); 
	public static final StandardDataType REAL_CONF = new StandardDataType("REAL_CONF", "REAL.CONF");
	
	public static final StandardDataType RTO = new StandardDataType("RTO", "RTO"); 
	public static final StandardDataType RTO_PQ_DRUG_PQ_TIME = new StandardDataType("RTO_PQ_DRUG_PQ_TIME", "RTO<PQ.DRUG,PQ.TIME>"); 
	public static final StandardDataType RTO_PQ_DRUG_PQ_DRUG = new StandardDataType("RTO_PQ_DRUG_PQ_DRUG", "RTO<PQ.DRUG,PQ.DRUG>"); 
	public static final StandardDataType RTO_MO_CAD_PQ_BASIC = new StandardDataType("RTO_MO_CAD_PQ_BASIC", "RTO<MO.CAD,PQ.BASIC>");
	
	public static final StandardDataType TS = new StandardDataType("TS", "TS");
	public static final StandardDataType TS_DATE = new StandardDataType("TS_DATE", "TS.DATE", "PartialDate");
	public static final StandardDataType TS_DATETIME = new StandardDataType("TS_DATETIME", "TS.DATETIME", "PartialDateTime");
	public static final StandardDataType TS_FULLDATEWITHTIME = new StandardDataType("TS_FULLDATEWITHTIME", "TS.FULLDATEWITHTIME", "FullDateWithTime");
	public static final StandardDataType TS_FULLDATE = new StandardDataType("TS_FULLDATE", "TS.FULLDATE", "FullDate");
	public static final StandardDataType TS_FULLDATETIME = new StandardDataType("TS_FULLDATETIME", "TS.FULLDATETIME", "FullDateTime");
	
	public static final StandardDataType TEL = new StandardDataType("TEL", "TEL", "BaseTelecommunicationAddress"); 
	public static final StandardDataType TEL_PHONEMAIL = new StandardDataType("TEL_PHONEMAIL", "TEL.PHONEMAIL", "PhonemailTelecommunicationAddress"); 
	public static final StandardDataType TEL_PHONE = new StandardDataType("TEL_PHONE", "TEL.PHONE", "PhoneNumber"); 
	public static final StandardDataType TEL_EMAIL = new StandardDataType("TEL_EMAIL", "TEL.EMAIL", "EmailAddress"); 
	public static final StandardDataType TEL_URI = new StandardDataType("TEL_URI", "TEL.URI", "Uri");
	
	public static final StandardDataType URG = new StandardDataType("URG", "URG");
	public static final StandardDataType URG_TS_DATE = new StandardDataType("URG_TS_DATE", "URG<TS.DATE>");
	public static final StandardDataType URG_PQ = new StandardDataType("URG_PQ", "URG<PQ>");
	public static final StandardDataType URG_PQ_BASIC = new StandardDataType("URG_PQ_BASIC", "URG<PQ.BASIC>");
	public static final StandardDataType URG_PQ_DRUG = new StandardDataType("URG_PQ_DRUG", "URG<PQ.DRUG>");
	public static final StandardDataType URG_PQ_TIME = new StandardDataType("URG_PQ_TIME", "URG<PQ.TIME>");
	public static final StandardDataType URG_PQ_LAB = new StandardDataType("URG_PQ_LAB", "URG<PQ.LAB>");
	public static final StandardDataType URG_PQ_HEIGHTWEIGHT = new StandardDataType("URG_PQ_HEIGHTWEIGHT", "URG<PQ.HEIGHTWEIGHT>");
	public static final StandardDataType URG_PQ_DISTANCE = new StandardDataType("URG_PQ_DISTANCE", "URG<PQ.DISTANCE>");
	
	public static final StandardDataType URL = new StandardDataType("URL", "URL");
	
	public static final StandardDataType SXPR = new StandardDataType("SXPR", "SXPR");
	public static final StandardDataType SXCM = new StandardDataType("SXCM", "SXCM");
	
	public static final StandardDataType SET = new StandardDataType("SET", "SET"); 
	public static final StandardDataType SET_II = new StandardDataType("SET_II", "SET<II>");
	
	public static final StandardDataType LIST = new StandardDataType("LIST", "LIST"); 
	public static final StandardDataType LIST_TEL_PHONEMAIL = new StandardDataType("LIST_TEL_PHONEMAIL", "LIST<TEL.PHONEMAIL>");
	
	public static final StandardDataType COLLECTION = new StandardDataType("COLLECTION", "COLLECTION");

	/** 
	 * <p>The BAG data type.  Note that this data type is not a standard part of the 
	 * pan-Canadian Data Types specification.
	 */
	public static final StandardDataType BAG = new StandardDataType("BAG", "BAG"); 
	
	private static final Set<StandardDataType> ignorable;
	
	static {
		Set<StandardDataType> set = new HashSet<StandardDataType>();
		set.add(ED);
		set.add(EN);
		set.add(IVL);
		set.add(ON);
		set.add(QTY);
		set.add(RTO);
		set.add(SC);
		set.add(TEL);
		set.add(TS);
		set.add(URG);
		set.add(URL);
		
		set.add(IVL_WIDTH);
		set.add(IVL_LOW);
		set.add(IVL_HIGH);
		set.add(PIVL);
		set.add(SXPR);
		set.add(SXCM);
		
		ignorable = Collections.unmodifiableSet(set);
	}
	
	private static Map<String,StandardDataType> simpleXmlMap;
	
	
	private final String type;
	private final String simpleXmlType;
	

	private StandardDataType(String enumName, String name) {
		this(enumName, name, null);
	}

	private StandardDataType(String enumName, String type, String simpleXmlType) {
		super(enumName);
		this.type = type;
		this.simpleXmlType = simpleXmlType;
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
		return this.type;
	}

	/**
	 * <p>Returns the root datatype of this data type. 
	 * 
	 * @return the root data type of this data type, as an enum.
	 */
	public StandardDataType getRootDataType() {
		return StandardDataType.getByTypeName(getRootType());
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
	 * <p>Determines if the enum represents a coded type.
	 * 
	 * @return whether or not the enum is a coded type.
	 */
	public boolean isCoded() {
		return Arrays.asList("CD", "CV", "CE", "CS").contains(getRootType());
	}
	
	/**
	 * <p>Determines if the given datatype shares the same root HL7 datatype.
	 * 
	 * @param dataType the type to compare
	 * @return whether the datatypes are eqivalent, that is, do they share the same root HL7 datatype
	 */
	public boolean isEquivalent(StandardDataType dataType) {
		return dataType!=null && getRootType().equals(dataType.getRootType());
	}

	/**
	 * <p>Determines if a given HL7 datatype name is a LIST or SET. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a collection type
	 */
	public static boolean isSetOrList(String dataTypeName) {
		// FIXME - TM - add isCollection here?
		return dataTypeName!=null && (isSet(dataTypeName) || isList(dataTypeName));
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
	 * <p>Determines if a given HL7 datatype name is a COLLECTION. 
	 * 
	 * @param dataTypeName the HL7 name of the datatype to check
	 * @return whether the supplied HL7 datatype is a COLLECTION type
	 */
	public static boolean isCollection(String dataTypeName) {
		return dataTypeName!=null && dataTypeName.startsWith(COLLECTION.getRootType());
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
	 * <p>Determines the enum datatype for the given type (Typed) object. 
	 * 
	 * @param typed the object to get the type name from
	 * @return the type enum corresponding to the input parameter type
	 */
	public static StandardDataType getByTypeName(Typed typed) {
		return typed == null ? null : getByTypeName(typed.getType());
	}
	
	/**
	 * <p>Determines the enum datatype for a given HL7 type name. 
	 * 
	 * @param name the HL7 name of a datatype 
	 * @return the type enum corresponding to the input parameter name
	 */
	public static StandardDataType getByTypeName(String name) {
		StandardDataType result = null;
		
		name = StringUtils.deleteWhitespace(name);
		
		if (isList(name)) {
			result = StandardDataType.LIST;
		} else if (isSet(name)) {
			result = StandardDataType.SET;
		} else if (isCollection(name)) {
			result = StandardDataType.COLLECTION;
		} else {
			for (StandardDataType type : EnumPattern.values(StandardDataType.class)) {
				if (StringUtils.equals(name, type.getType())) {
					result = type;
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * <p>Checks if this enum datatype is part of the Canadian datatype specs.
	 * 
	 * @return whether this enum datatype is part of the current (and possibly multiple previous) Canadian specs.
	 */
	public boolean isPartOfCanadianSpec() {
		return !ignorable.contains(this);
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
	 * @return the corresponding enum datatype
	 */
	public static StandardDataType convertSimpleXmlToDataType(String simpleXmlType) {
		if (simpleXmlMap == null) {
			initializeSimpleXmlMap();
		}
		return simpleXmlMap.get(simpleXmlType);
	}

	private synchronized static void initializeSimpleXmlMap() {
		if (simpleXmlMap == null) {
			Map<String, StandardDataType> map = new HashMap<String, StandardDataType>();
			for (StandardDataType type : EnumPattern.values(StandardDataType.class)) {
				String simpleXmlType = type.simpleXmlType;
				if (StringUtils.isNotBlank(simpleXmlType)) {
					if (map.containsKey(simpleXmlType)) {
						StandardDataType other = map.get(simpleXmlType);
						if (StringUtils.equals(other.getRootType(), type.getRootType())) {
							map.put(simpleXmlType, StandardDataType.getByTypeName(type.getRootType()));
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

}