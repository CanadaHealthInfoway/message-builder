/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;
import static ca.infoway.messagebuilder.generator.LogLevel.INFO;
import static ca.infoway.messagebuilder.generator.LogLevel.WARN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.StopWatch;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentable;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.UpdateMode;
import ca.infoway.messagebuilder.xml.UpdateModeType;

abstract class BaseMifProcessorImpl implements MifProcessor {

	protected final OutputUI outputUI;
	protected final MifRegistry mifRegistry;
	protected final BaseMifXPathHelper helper;
	
	protected BaseMifProcessorImpl(MifRegistry mifRegistry, OutputUI outputUI, BaseMifXPathHelper helper) {
		this.mifRegistry = mifRegistry;
		this.outputUI = outputUI;
		this.helper = helper;
	}
	
	public void addMessagePartsFromMifs(MessageSet messageSet, List<MifReference> mifs) throws IOException, GeneratorException {
		StopWatch watch = new StopWatch();
		watch.start();
		addMessagePartsFromMifs(messageSet, mifs, watch);
		watch.stop();
		this.outputUI.log(INFO, "MIF processing completed. (" + renderTime(watch) + ")");
	}

	protected void addMessagePartsFromMifs(MessageSet messageSet, List<MifReference> mifs,
			StopWatch watch) throws IOException, GeneratorException {
		
		List<MifReference> partMifs = extractPartMifs(mifs);
		
		this.outputUI.log(INFO, "MIF processing - First pass: find all packageLocations");
		for (MifReference reference : partMifs) {
			String packageLocationName = createPackageLocation(messageSet, getEntryPointElement(reference));
			PackageLocation packageLocation = messageSet.getPackageLocations().get(packageLocationName);
			packageLocation.setCategory(reference.getCategory());
			this.outputUI.log(DEBUG, "File \"" + reference.asFile().getName() + "\" contains entry point " + packageLocationName);
		}
		this.outputUI.log(INFO, "MIF processing - First pass completed (" + renderTime(watch) + ")");
		this.outputUI.log(INFO, "MIF processing - Second pass: find all message parts");
		for (Mif mif : this.mifRegistry.getAllMifs()) {
			try {
				extractMessageParts(messageSet, mif);
			} catch (MifProcessingException e) {
				this.outputUI.log(WARN, "Problem processing message parts for package location \"" + mif.getPackageLocation() + "\" : " + e.getMessage());
			}
		}
		this.outputUI.log(INFO, "MIF processing - Second pass completed (" + renderTime(watch) + ")");
		this.outputUI.log(INFO, "MIF processing - Third pass: find all relationships");
		for (Mif mif : this.mifRegistry.getAllMifs()) {
			try {
				this.outputUI.log(DEBUG, "Now processing relationships for package location \"" + mif.getPackageLocation() + "\"");
				processRelationships(messageSet, mif);
			} catch (MifProcessingException e) {
				this.outputUI.log(WARN, "Problem processing relationships for package location \"" + mif.getPackageLocation() + "\" : " + e.getMessage());
			}
		}

		List<MifReference> interactionMifs = extractInteractionMifs(mifs);
	
		this.outputUI.log(LogLevel.INFO, "Final processing starting - processing interactions - (" 
				+ CollectionUtils.size(interactionMifs) + " files)");
		processInteractions(messageSet, interactionMifs);
		this.outputUI.log(LogLevel.INFO, "Final processing - interaction processing completed ("+ renderTime(watch) + ")");
	}

	protected abstract void processInteractions(
			MessageSet messageSet, List<MifReference> interactionMifs) 
			throws IOException, GeneratorException;
	
	protected abstract List<MifReference> extractInteractionMifs(List<MifReference> mifs);

	protected List<MifReference> extractPartMifs(List<MifReference> mifs) {
		return mifs;
	}

	protected abstract Element getEntryPointElement(MifReference reference) throws IOException,
			GeneratorException;

	protected abstract void processRelationships(MessageSet messageSet, Mif mif) throws GeneratorException;

	protected String renderTime(StopWatch watch) {
		return TimeRenderer.renderInterval(watch.getTime());
	}
	
	protected String createPackageLocation(MessageSet messageSet,
			Element ownedEntryPoint) {
		String qualifier = ownedEntryPoint.getAttribute("id");
		if (!messageSet.getPackageLocations().containsKey(qualifier)) {
			PackageLocation packageLocation = new PackageLocation(qualifier);
			packageLocation.setDescriptiveName(ownedEntryPoint.getAttribute("name"));
			messageSet.getPackageLocations().put(qualifier, packageLocation);
			
			packageLocation.setRootType(NameHelper.createName(qualifier, this.helper.getRootType(ownedEntryPoint)));
			this.outputUI.log(DEBUG, "Registering package location \"" + qualifier + "\" "
					+ (StringUtils.isNotBlank(packageLocation.getDescriptiveName()) 
							? "(" + packageLocation.getDescriptiveName() + ") " : "")
					+ "with root type \"" + packageLocation.getRootType() + "\"");
		}
		return qualifier;
	}
	
	protected void addDocumentation(Element element, Documentable part) {
		List<Annotation> annotations = this.helper.getDocumentation(element);
		part.setDocumentation(annotations==null || annotations.isEmpty() ? null : new Documentation(annotations));
		
		String businessName = this.helper.getBusinessName(element);
		if (StringUtils.isNotBlank(businessName)) {
			if (part.getDocumentation() == null) {
				part.setDocumentation(new Documentation());
			}
			part.getDocumentation().setBusinessName(businessName);
		}
	}
	
	protected abstract List<MessagePart> extractMessageParts(MessageSet messageSet, Mif mif) throws IOException, GeneratorException;

	protected ConformanceLevel createConformance(Element attribute) {
		String isMandatoryString = attribute.getAttribute("isMandatory");
		String minimumMultiplicityString = attribute.getAttribute("minimumMultiplicity");
		String conformanceString = attribute.getAttribute("conformance");
		if (Boolean.valueOf(isMandatoryString)) {
			return ConformanceLevel.MANDATORY;
		} else if (Integer.valueOf(minimumMultiplicityString) > 0) {
			return ConformanceLevel.POPULATED;
		} else if ("R".equals(conformanceString)) {
			return ConformanceLevel.REQUIRED;
		} else if (Integer.valueOf(minimumMultiplicityString) == 0) {
			return ConformanceLevel.OPTIONAL;
		} else {
			throw new MifProcessingException("Invalid conformance level.  It makes no sense.");
		}
	}
	
	private UpdateModeType createUpdateModeDefault(Element relationship) {
		String updateMode = relationship.getAttribute("updateModeDefault");
		if (StringUtils.isNotBlank(updateMode)) {
			return EnumPattern.valueOf(UpdateModeType.class, updateMode);
		}
		return null;
	}

	private List<UpdateModeType> createUpdateModesAllowed(Element relationship) {
		return helper.getAllowedUpdateModes(relationship); 
	}
	
	protected UpdateMode createUpdateMode(Element relationship) {
		UpdateModeType updateModeDefault = createUpdateModeDefault(relationship);
		List<UpdateModeType> updateModesAllowed = createUpdateModesAllowed(relationship);
		if (updateModeDefault != null || CollectionUtils.isNotEmpty(updateModesAllowed)) {
			UpdateMode updateMode = new UpdateMode();
			updateMode.setUpdateModeDefault(updateModeDefault);
			updateMode.setUpdateModesAllowed(updateModesAllowed);
			return updateMode;
		}
		return null;
	}	

	protected Cardinality createCardinality(Element attribute) {
		String min = attribute.getAttribute("minimumMultiplicity");
		String max = attribute.getAttribute("maximumMultiplicity");
		String range = min + "-" + max;
		if (NumberUtils.isNumber(min) && (NumberUtils.isNumber(max) || "*".equals(max))) {
			return Cardinality.create(range);
		} else {
			throw new MifProcessingException("Can't create a valid cardinality from: " + range);
		}
	}

	protected List<MifReference> filterFiles(List<MifReference> mifs, final String extension) {
		List<MifReference> result = new ArrayList<MifReference>();
		for (MifReference mifReference : mifs) {
			if (StringUtils.equalsIgnoreCase(extension,
						FilenameUtils.getExtension(mifReference.asFile().getName()))) {
				result.add(mifReference);
			}
		}
		return result;
	}
}
