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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.cleanUpBusinessName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.j5goodies.Counter;
import ca.infoway.messagebuilder.j5goodies.CounterOrder;
import ca.infoway.messagebuilder.j5goodies.Tally;
import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A class that determines the best possible name for a message part, using either
 * the business name or the MIF name of the part (whichever ensures uniqueness).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class SimpleNameCoordinator implements NameCoordinator {

	/**
	 * <p>An internal interface used to determine the potential names that a 
	 * part can have.
	 */
	interface CandidateNames {
		public String getNameContext();
		public List<String> getPreferredNames();
		public String getDefaultName();
		public String getExemplarName();
	}
	
	static class ComparatorImpl implements Comparator<Name> {
		public int compare(Name o1, Name o2) {
			return o1.names.getExemplarName().compareTo(o2.names.getExemplarName());
		}
	}

	class SimpleNamesAdapter implements CandidateNames {
		
		private final Type type;
		public SimpleNamesAdapter(Type type) {
			this.type = type;
		}
		public String getNameContext() {
			if (this.type.getTypeName().isInteraction()) {
				return "interaction";
			} else {
				return this.type.getTypeName().getRootName().toString();
			}
		}
		public List<String> getPreferredNames() {
			String businessName = cleanUpBusinessName(this.type.getBusinessName());
			if (StringUtils.isNotBlank(businessName) && isBusinessNameUsed()) {
				return Arrays.asList(businessName);
			} else {
				return Collections.<String>emptyList();
			}
		}
		public String getDefaultName() {
			String result = type.getTypeName().getUnqualifiedName();
			List<String> preferredNames = getPreferredNames();
			if (!preferredNames.isEmpty()) {
				result = preferredNames.get(0);
			}
			return result;
		}
		public String getExemplarName() {
			return this.type.getTypeName().getName();
		}
	}
	
	class MergedNamesAdapter implements CandidateNames {
		
		private final Type type;
		public MergedNamesAdapter(Type type) {
			this.type = type;
		}
		public String getNameContext() {
			if (StringUtils.isBlank(this.type.getCategory())) {
				return this.type.getTypeName().getRootName().toString();
			} else {
				return this.type.getCategory() + "." + 
						this.type.getTypeName().getRootName().toString();
			}
		}
		public List<String> getPreferredNames() {
			Counter<String> counter1 = new Counter<String>();
			Counter<String> counter2 = new Counter<String>();
			for (NamedType mergedType : this.type.getMergedTypes()) {
				String businessName = cleanUpBusinessName(mergedType.getBusinessName());
				if (StringUtils.isNotBlank(businessName) && isBusinessNameUsed()) {
					counter1.increment(businessName);
				}
				counter2.increment(mergedType.getTypeName().getUnqualifiedName());
			}
			List<String> result = new ArrayList<String>();
			for (Tally<String> tally : counter1.getAll(CounterOrder.Descending)) {
				result.add(tally.getKey());
			}
			for (Tally<String> tally : counter2.getAll(CounterOrder.Descending)) {
				result.add(tally.getKey());
			}
			return result;
		}
		public String getDefaultName() {
			return getPreferredNames().get(0);
		}
		public String getExemplarName() {
			Set<String> names = new TreeSet<String>();
			for (NamedType mergedType : this.type.getMergedTypes()) {
				names.add(mergedType.getTypeName().getName());
			}
			return (String) CollectionUtils.get(names, 0);
		}
	}
	
	class Name {
		private final CandidateNames names;
		private boolean isDefault;
		private int index = 0;
		private String suffix = null;

		Name(CandidateNames names) {
			this.names = names;
			this.isDefault = this.names.getPreferredNames().isEmpty();
		}

		public boolean isDefault() {
			return this.isDefault;
		}

		public void setDefault(boolean isDefault) {
			this.isDefault = isDefault;
		}

		public int getIndex() {
			return this.index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getSuffix() {
			return this.suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		public String getName() {
			StringBuilder builder = new StringBuilder();
			if (this.isDefault) {
				builder.append(this.names.getDefaultName());
			} else {
				builder.append(this.names.getPreferredNames().get(this.index));
			}
			if (StringUtils.isNotBlank(this.suffix)) {
				builder.append(this.suffix);
			}
			return builder.toString();
		}

		public boolean tryNext() {
			if (this.isDefault) {
				return false;
			} else if (this.index == this.names.getPreferredNames().size()-1) {
				this.isDefault = true;
				return true;
			} else if (this.index < this.names.getPreferredNames().size()) {
				this.index++;
				return true;
			} else {
				return false;
			}
		}
	}

	private Map<TypeName,Name> names = Collections.synchronizedMap(new HashMap<TypeName,Name>());
	private final NamingPolicy policy;

	public SimpleNameCoordinator(TypeNameHelper typeNameHelper) {
		this(typeNameHelper, NamingPolicy.getDefaultPolicy());
	}
	public SimpleNameCoordinator(TypeNameHelper typeNameHelper, NamingPolicy policy) {
		this.policy = policy;
		setupNames(typeNameHelper.getTypes());
	}

	private void setupNames(Map<TypeName, Type> types) {
		
		Map<String,List<Name>> contexts = new HashMap<String,List<Name>>();
		
		for (Type type : types.values()) {
			
			CandidateNames candidateNames = (type.getTypeName() instanceof TemporaryTypeName)
				? new MergedNamesAdapter(type) : new SimpleNamesAdapter(type);
			
			Name name = new Name(candidateNames);
			this.names.put(type.getTypeName(), name);
			for (NamedType mergedType : type.getMergedTypes()) {
				this.names.put(mergedType.getTypeName(), name);
			}
			
			if (!contexts.containsKey(candidateNames.getNameContext())) {
				contexts.put(candidateNames.getNameContext(), new ArrayList<Name>());
			}
			contexts.get(candidateNames.getNameContext()).add(name);
		}
		
		for (String context : contexts.keySet()) {
			makeUnique(contexts.get(context));
		}
	}

	private void makeUnique(List<Name> list) {
		SuffixProvider suffixProvider = new SuffixProvider();
		
		for (List<Name> conflicts = findConflicts(list); !conflicts.isEmpty(); conflicts = findConflicts(list)) {
			boolean alternatesFound = true;
			for (Name name : conflicts) {
				alternatesFound &= name.tryNext();
			}
			if (!alternatesFound) {
				for (Name name : conflicts) {
					name.setSuffix(suffixProvider.getSuffix(name.getName()));
				}
			}
		}
	}

	private List<Name> findConflicts(List<Name> list) {
		Map<String,Name> names = new HashMap<String,Name>();
		List<Name> result = new ArrayList<Name>();
		for (Name name : list) {
			String bestName = name.getName();
			Name otherName = names.get(bestName);
			if (otherName != null) {
				result.add(name);
				if (!result.contains(otherName)) {
					result.add(otherName);
				}
			} else {
				names.put(bestName, name);
			}
		}
		Collections.sort(result, new ComparatorImpl());
		return result;
	}

	public String getName(TypeName name) {
		Name result = this.names.get(name);
		if (result != null) {
			return result.getName();
		} else {
			return name.getUnqualifiedName();
		}
	}
	boolean isBusinessNameUsed() {
		return policy != NamingPolicy.STANDARD_NAMES;
	}
}
