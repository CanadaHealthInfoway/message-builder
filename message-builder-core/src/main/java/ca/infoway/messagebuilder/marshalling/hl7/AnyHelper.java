package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * 
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH
 * 
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 * 
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL<PQ.x>, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG<PQ,x>
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 * 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class AnyHelper {
	
	private static List<String> ANY_LAB_LIST = Arrays.asList(new String[] {
			StandardDataType.CD_LAB.getType(), 
			StandardDataType.ST.getType(),
			StandardDataType.PQ_LAB.getType(),
			StandardDataType.IVL_PQ.getType(),
			StandardDataType.INT_NONNEG.getType(),
			StandardDataType.INT_POS.getType(),
			StandardDataType.TS_FULLDATETIME.getType(),
			StandardDataType.URG_PQ.getType()
	});
	
	private static List<String> ANY_PATH_LIST = Arrays.asList(new String[] {
			StandardDataType.ST.getType(),
			StandardDataType.PQ.getType(),
			StandardDataType.ED_DOC_OR_REF.getType(),
			StandardDataType.CD_LAB.getType() 
	});
	
	private static List<String> ANY_CA_IZ_LIST = Arrays.asList(new String[] {
			StandardDataType.ST.getType(),
			StandardDataType.PN_BASIC.getType(),
			StandardDataType.INT_POS.getType(),
			StandardDataType.BL.getType()
	});

	private static Map<String, List<String>> validTypesForAnyType = new HashMap<String, List<String>>();
	static {
		validTypesForAnyType.put("ANY.LAB", ANY_LAB_LIST); 
		validTypesForAnyType.put("ANY.CA.IZ", ANY_CA_IZ_LIST); 
		validTypesForAnyType.put("ANY.PATH", ANY_PATH_LIST); 
	}
	
	public static boolean isValidTypeForAny(String type, String specializationType) {
		if ("ANY".equals(type)) {
			return true;
		} else if (AnyHelper.validTypesForAnyType.containsKey(type)) {
			return AnyHelper.validTypesForAnyType.get(type).contains(specializationType);
		}
		return false;
	}
	
}
