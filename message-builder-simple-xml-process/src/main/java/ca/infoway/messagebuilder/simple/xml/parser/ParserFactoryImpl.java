package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class ParserFactoryImpl implements ParserFactory {

	@SuppressWarnings("unchecked")
	Map<StandardDataType,Class<? extends SimpleXmlParser>> map = Collections.synchronizedMap(new HashMap<StandardDataType,Class<? extends SimpleXmlParser>>());
	
	public ParserFactoryImpl() {
		this.map.put(StandardDataType.II, IdentifierXmlParser.class);
		this.map.put(StandardDataType.TEL, TelecomAddressXmlParser.class);
		this.map.put(StandardDataType.PN, PersonNameXmlParser.class);
		this.map.put(StandardDataType.TS, DateXmlParser.class);
		this.map.put(StandardDataType.BL, BooleanXmlParser.class);
		this.map.put(StandardDataType.MO, MoneyXmlParser.class);
		this.map.put(StandardDataType.TN, TrivialNameXmlParser.class);
		this.map.put(StandardDataType.ST, StringXmlParser.class);
		this.map.put(StandardDataType.ST_LANG, StringXmlParser.class);
		this.map.put(StandardDataType.REAL, RealXmlParser.class);
		this.map.put(StandardDataType.AD, PostalAddressXmlParser.class);
		this.map.put(StandardDataType.INT, IntegerXmlParser.class);
		this.map.put(StandardDataType.PQ, PhysicalQuantityXmlParser.class);
		this.map.put(StandardDataType.IVL_DATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_DATETIME, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_FULL_DATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_FULL_DATE_TIME, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_FULL_DATE_WITH_TIME, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_HIGH_TS_FULLDATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_LOW_TS_DATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_LOW_TS_FULLDATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_TS, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_WIDTH_TS_FULLDATE, DateIntervalXmlParser.class);
		this.map.put(StandardDataType.IVL_PQ, PhysicalQuantityIntervalXmlParser.class);
		this.map.put(StandardDataType.URG_TS_DATE, DateUncertainRangeXmlParser.class);
		this.map.put(StandardDataType.URG_PQ, PhysicalQuantityUncertainRangeXmlParser.class);
		this.map.put(StandardDataType.URG_PQ_DRUG, PhysicalQuantityUncertainRangeXmlParser.class);
		this.map.put(StandardDataType.CD, ConceptDescriptorXmlParser.class);
		this.map.put(StandardDataType.CV, ConceptDescriptorXmlParser.class);
		this.map.put(StandardDataType.CS, SimpleCodedTypeXmlParser.class);
		this.map.put(StandardDataType.ED_SIGNATURE, EncapsulatedDataSignatureXmlParser.class);
		this.map.put(StandardDataType.ED_DOC, EncapsulatedDataDocumentXmlParser.class);
		this.map.put(StandardDataType.ED_DOC_REF, EncapsulatedDataDocumentXmlParser.class);
		this.map.put(StandardDataType.PIVL_TS_DATETIME, PeriodicIntervalOfTimeXmlParser.class);
		this.map.put(StandardDataType.GTS, BoundedPeriodicIntervalOfTimeXmlParser.class);
		this.map.put(StandardDataType.GTS_BOUNDEDPIVL, BoundedPeriodicIntervalOfTimeXmlParser.class);
		this.map.put(StandardDataType.RTO_PQ_DRUG_PQ_TIME, RatioDrugQuantityPerTimeXmlParser.class);
		this.map.put(StandardDataType.RTO_MO_CAD_PQ_BASIC, RatioMoneyPerUnitXmlParser.class);
	}
	
	@SuppressWarnings("unchecked")
	public SimpleXmlParser<?> create(StandardDataType dataType) throws ParserException {
		Class<? extends SimpleXmlParser> parserClass = this.map.get(dataType);
		
		if (parserClass != null) {
			try {
				return parserClass.newInstance();
			} catch (InstantiationException e) {
				throw new ParserException(e);
			} catch (IllegalAccessException e) {
				throw new ParserException(e);
			}
		} else if (dataType != dataType.getRootDataType()){
			return create(dataType.getRootDataType());
		} else {
			return null;
		}
	}
}
