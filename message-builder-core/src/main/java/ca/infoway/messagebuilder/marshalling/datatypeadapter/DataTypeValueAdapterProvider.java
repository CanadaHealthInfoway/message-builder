package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.datatype.BareANY;


public class DataTypeValueAdapterProvider {
	
	private static final DataTypeAdapter NULL_DATA_TYPE_ADAPTER = new DataTypeAdapter() {
		public BareANY adapt(BareANY any) {
			return any;
		}
		public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
			return true;
		}
		public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
			return true;
		}
	};
	
	private final List<DataTypeAdapter> adapters = new ArrayList<DataTypeAdapter>();
	
	public DataTypeValueAdapterProvider() {
		adapters.add(new TsToIvlAdapter()); 
		adapters.add(new IvlToTsAdapter());
		
		adapters.add(new CollectionToSetOfTnAdapter()); 
		
		adapters.add(new CollectionOfAnyToAnyAdapter());
		adapters.add(new AnyToSetOfAnyAdapter());
		adapters.add(new AnyToListOfAnyAdapter());
	}

	public DataTypeAdapter getAdapter(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		DataTypeAdapter matchingAdapter = NULL_DATA_TYPE_ADAPTER;
		
		if (fromDataType!=null && toDataTypeName!=null) {
			for (DataTypeAdapter adapter : adapters) {
				if (adapter.canAdapt(fromDataType, toDataTypeName)) {
					matchingAdapter = adapter;
					break;
				}
			}
		}
		
		return matchingAdapter;
	}

	public DataTypeAdapter getAdapter(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		DataTypeAdapter matchingAdapter = NULL_DATA_TYPE_ADAPTER;
		for (DataTypeAdapter adapter : adapters) {
			if (adapter.canAdapt(fromDataTypeName, toDateType)) {
				matchingAdapter = adapter;
				break;
			}
		}
		return matchingAdapter;
	}
	
}
