package ca.infoway.messagebuilder.comparator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class BeanAnalysisResult {
	
	private Map<String, List<BeanAnalysisError>> map = new HashMap<String, List<BeanAnalysisError>>();
	
	public void addErrors(File file, List<BeanAnalysisError> errors) {
		String path = file.getPath();
		if (this.map.containsKey(path)) {
			this.map.get(path).addAll(errors);
		} else {
			this.map.put(path, errors);
		}
	}
	
	public String getBeanAnalysisReport() {
		StringBuilder builder = new StringBuilder();
		Set<Entry<String,List<BeanAnalysisError>>> entrySet = this.map.entrySet();
		int errorCount = 0;
		for (Entry<String, List<BeanAnalysisError>> entry : entrySet) {
			List<BeanAnalysisError> value = entry.getValue();
			if (value != null && value.size() > 0) { // only display files with errors
				builder.append("File name: " + entry.getKey());
				builder.append("\n");
				for (BeanAnalysisError beanAnalysisError : entry.getValue()) {
					builder.append("--> " + beanAnalysisError.getErrorMessage() + "\n");
					++errorCount;
				}
			}
		}
		
		builder.append("TOTAL FILES: " + this.map.size() + "\n");
		builder.append("TOTAL ERRORS: " + errorCount + "\n");

		return builder.toString();
	}
	
	public List<BeanAnalysisError> getBeanAnalysisErrors(String fileName) {
		return this.map.get(fileName);
	}

}
