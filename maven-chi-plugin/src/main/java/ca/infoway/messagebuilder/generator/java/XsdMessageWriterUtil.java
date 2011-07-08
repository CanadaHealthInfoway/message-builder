package ca.infoway.messagebuilder.generator.java;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XsdMessageWriterUtil {
	private HashMap<String, ArrayList<Element>> ambig_type_check_map = new HashMap<String, ArrayList<Element>>();
	private HashMap<String, Element[]> swap_element_map = new HashMap<String, Element[]>();
	private static File xsdSDFolder;
	
	public XsdMessageWriterUtil() {	}
	
	public void reorderSchema(Element schema) {
		if (schema != null) {
			construct_ambig_type_map(schema);
			Set<String> recursionSet = new HashSet<String>();
			for (String key : ambig_type_check_map.keySet()) {
				ArrayList<Object> sequenceTypeList = sequence_mapper(key, recursionSet);
				detect_upa_cases(schema, sequenceTypeList, key);
			}
			updateSchema(schema);
			recursionSet.clear();
			swap_element_map.clear();
			ambig_type_check_map.clear();
		}
	}
	
	private void updateSchema(Element schema) {
		NodeList schemaChildren = schema.getChildNodes();
		for (int i=0; i<schemaChildren.getLength(); i++) {
			Element complexType = (Element)schemaChildren.item(i);
			if (complexType.getAttribute("name").length() > 0 
					&& ambig_type_check_map.get(complexType.getAttribute("name")) != null 
					&& swap_element_map.get(complexType.getAttribute("name")) !=null) {
				Element[] newSeqElements = swap_element_map.get(complexType.getAttribute("name"));
				NodeList sequences = complexType.getChildNodes(); 
				for (int j=0; j<sequences.getLength(); j++) {
					Element sequence = (Element)sequences.item(j);
					if (sequence != null) {
						Document document = schema.getOwnerDocument();
						Element [] placeholders = new Element[2];
						placeholders[0] = document.createElement("xs:placeholder" + 0);
						placeholders[1] = document.createElement("xs:placeholder" + 1);
						
						sequence.replaceChild(placeholders[0], newSeqElements[0]);
						sequence.replaceChild(placeholders[1], newSeqElements[1]);
						sequence.replaceChild(newSeqElements[1], placeholders[0]);
						sequence.replaceChild(newSeqElements[0], placeholders[1]);
					}
				}
			}
		}
	}
	
	private void construct_ambig_type_map(Element parent) {
		NodeList children = parent.getChildNodes();
		for (int k=0; k<children.getLength(); k++) {
			Element lvl1 = (Element)children.item(k);
			ArrayList<Element> sequence_map = new ArrayList<Element>();
			NodeList sequences = lvl1.getChildNodes(); 
			for (int j=0; j<sequences.getLength(); j++) {
				Element sequence = (Element)sequences.item(j);
				NodeList seq_elements = sequence.getChildNodes();
				for (int i=0; i<seq_elements.getLength(); i++) {
					Element childElement = (Element)seq_elements.item(i);
					sequence_map.add(childElement);
				}
				ambig_type_check_map.put(((Element)sequence.getParentNode()).getAttribute("name"), sequence_map);
			}
		}
	}

	private ArrayList<Object> sequence_mapper(String key, Set<String> recursionKeys){
		ArrayList<Element> sequenceElements = ambig_type_check_map.get(key);
		ArrayList<Object> sequenceTypes = new ArrayList<Object>();
		
		for(int i=0; i<sequenceElements.size(); i++) {
			String typeName = ""; 
			if (sequenceElements.get(i).getAttribute("name").length() > 0) {
				typeName = sequenceElements.get(i).getAttribute("type");
			} else {
				typeName = sequenceElements.get(i).getAttribute("ref");
			}
			
			if(typeName.startsWith("chi:")) {
				typeName = typeName.substring("chi:".length());
			}
		
			if ( (!(typeName.equals(key) || recursionKeys.contains(typeName))) && ambig_type_check_map.get(typeName) != null) {
				recursionKeys.add(key);
				sequenceTypes.add(sequence_mapper(typeName, recursionKeys));
			} else {
				sequenceTypes.add(typeName);
			}
		}
		return sequenceTypes;
	}
	
	private void detect_upa_cases(Element schema, ArrayList<Object>sequenceTypeList, String key) {
		ArrayList<Element> sequenceElements = ambig_type_check_map.get(key);
		ArrayList<Integer> namedElements = new ArrayList<Integer>();
		boolean swap_curr_flag = false;
		String needs_swap_key = new String("");
		
		for (int i=1; i<sequenceTypeList.size(); i++) {	
			int prevElementIndex = i-1, currElementIndex = i;
			while (currElementIndex < sequenceTypeList.size()) {
				if ((sequenceElements.get(currElementIndex).getAttribute("name").length() > 0 || sequenceElements.get(prevElementIndex).getAttribute("name").length() > 0)
						&& (!sequenceElements.get(currElementIndex).getAttribute("name").equals(sequenceElements.get(prevElementIndex).getAttribute("name")))) {
					if (swap_curr_flag) {
						Element[] swap_arr = swap_element_map.get(needs_swap_key);
						swap_arr[0] = sequenceElements.get(currElementIndex);
						swap_element_map.put(needs_swap_key, swap_arr);
						swap_curr_flag = false;
					} else {
						namedElements.add(currElementIndex);
					}
					break;
				}
				
				if (isElementsSameType(sequenceTypeList.get(prevElementIndex), sequenceTypeList.get(currElementIndex))) {
					if (sequenceElements.get(currElementIndex).getAttribute("minOccurs").length() > 0 && sequenceElements.get(prevElementIndex).getAttribute("minOccurs").length() > 0) {
						try {					
							if (Integer.parseInt(sequenceElements.get(prevElementIndex).getAttribute("minOccurs")) == 0) {
								if (Integer.parseInt(sequenceElements.get(currElementIndex).getAttribute("minOccurs")) > 0 
										&& (Integer.parseInt(sequenceElements.get(currElementIndex).getAttribute("minOccurs")) == Integer.parseInt(sequenceElements.get(currElementIndex).getAttribute("maxOccurs")))) {
									/* Previous is 0 or more and Current is set number (min=max) case */
									Element[] swap_arr = {sequenceElements.get(prevElementIndex), sequenceElements.get(currElementIndex)};
									swap_element_map.put(key, swap_arr);
								} else {
									/* CASE WHERE BOTH ELEMENTS ARE REF ELEMENTS AND HAVE 0 OR MORE */
									/* POSSIBLE SOLUTION WOULD BE TO PLACE AN ELEMENT THAT DOES NOT USE REF TYPE OCCURS 1 ORE MORE TIMES BEFORE EACH BETWEEN */
									/* NO CASE USES THIS RIGHT NOW IN MR2009 R02_04_02, not sure if it will be needed later */
									/* The swap purposed can also re-cause it */
									if (namedElements.size() > 0) {
										Element[] swap_arr = {sequenceElements.get(prevElementIndex), sequenceElements.get(namedElements.get(namedElements.size()-1))};
										swap_element_map.put(key, swap_arr);
										namedElements.remove(namedElements.size()-1);
									} else {
										Element[] swap_arr = {sequenceElements.get(prevElementIndex), sequenceElements.get(currElementIndex)};
										swap_element_map.put(key, swap_arr);
										needs_swap_key = key;
										swap_curr_flag = true;
									}
								} 
							}
						} catch(NumberFormatException ex) {	
							break;
						}
					} else if (sequenceElements.get(prevElementIndex).getAttribute("minOccurs").length() > 0){
						try {					
							if (Integer.parseInt(sequenceElements.get(prevElementIndex).getAttribute("minOccurs")) < Integer.parseInt(sequenceElements.get(prevElementIndex).getAttribute("maxOccurs"))) {
								/* Previous is 0 or more and current is Default Case */
								/* Don't have to do anything in the else case as that means both current and previous are fixed number of elements */
								Element[] swap_arr = {sequenceElements.get(prevElementIndex), sequenceElements.get(currElementIndex)};
								swap_element_map.put(key, swap_arr);
							} 
						} catch(NumberFormatException ex) {
							break;
						}
					}
					break;
				} else {
					/* The two elements do not resolve to the same type but current may have minOccurs = 0 so may need to skip to next element */
					try {
						if (Integer.parseInt(sequenceElements.get(currElementIndex).getAttribute("minOccurs")) == 0) {
							currElementIndex++;
						} else {
							break;
						}
					} catch(NumberFormatException ex) {	
						break;
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean isElementsSameType(Object obj1, Object obj2) {
		if(obj1 instanceof ArrayList && obj2 instanceof ArrayList) {
			Set<String> compareSet = new HashSet<String>((ArrayList<String>)obj1);
			compareSet.addAll((ArrayList<String>)obj2);
			return compareSet.size() != ((ArrayList<String>)obj2).size() + ((ArrayList<String>)obj1).size(); 
		} else if (obj1 instanceof ArrayList) { 
			Set<String> compareSet = new HashSet<String>((ArrayList<String>)obj1);
			return compareSet.contains((String)obj2);
		} else if (obj2 instanceof ArrayList) {
			Set<String> compareSet = new HashSet<String>((ArrayList<String>)obj2);
			return compareSet.contains((String)obj1);
		} else {
			return((String)obj1).equals((String)obj2);
		}
	}
	
	public static File getXsdSDFolder() {
		return xsdSDFolder;
	}
	
	public static void setXsdSDFolder(File srcFolder) {
		xsdSDFolder = srcFolder;
	}
}
