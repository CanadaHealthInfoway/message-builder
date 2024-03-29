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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p class="MsoNormal" 
 * style="margin-top:8.0pt;margin-right:0in;margin-bottom:0in; 
 * margin-left:.25in;margin-bottom:.0001pt;text-align:justify;text-indent:-.25in; 
 * line-height:115%;mso-list:l0 level1 lfo1"><span 
 * style="font-size: small; "><span style="font-family: Arial; 
 * "><span ><span style="line-height: normal; 
 * "></span></span><!--[endif]-->Two options exist to search 
 * for a Patient in the CR for this query:</span></span><span 
 * ></span></p> <ol> <li><span style="font-size: small; "><span 
 * style="font-family: Arial; "><span style="line-height: 115%; 
 * text-align: justify; text-indent: -0.25in; ">If available, 
 * the Healthcare Identification Number shall be used as the 
 * only search criteria provided in the query. The 
 * &ldquo;clientID&rdquo; field in the </span><span 
 * style="line-height: 115%; text-align: justify; text-indent: 
 * -0.25in; ">message path &ldquo;/queryByParameter/ 
 * parameterList&rdquo; will be used. This is comprised of the 
 * OID for the Federal, Provincial or Territorial</span><span 
 * style="line-height: 115%; text-align: justify; text-indent: 
 * -0.25in; "> Healthcare Identification Assigning Authority 
 * (i.e. NB Medicare, </span></span></span><span 
 * style="font-size: small; "><span style="font-family: Arial; 
 * ">Alberta</span></span><span style="font-size: small; 
 * "><span style="font-family: Arial; "><span 
 * style="line-height: 115%; text-align: justify; text-indent: 
 * -0.25in; ">, DND (Armed Forces Canada), etc.) that issued 
 * the Healthcare Identification Number to the patient and the 
 * corresponding identification number. If the Medicare Number 
 * is known then it shall be used rather than any other 
 * healthcare identifier. </span><span style="line-height: 
 * 115%; text-align: justify; text-indent: -0.25in; 
 * "></span></span></span></li> <li><span style="font-size: 
 * small; "><span style="font-family: Arial; "><!--[if gte mso 
 * 9]><xml> <o:OfficeDocumentSettings> 
 * <o:TargetScreenSize>800x600</o:TargetScreenSize> 
 * </o:OfficeDocumentSettings> </xml><![endif]--><!--[if gte 
 * mso 9]><xml> <w:WordDocument> <w:View>Normal</w:View> 
 * <w:Zoom>0</w:Zoom> <w:TrackMoves /> <w:TrackFormatting /> 
 * <w:PunctuationKerning /> <w:ValidateAgainstSchemas /> 
 * <w:SaveIfXMLInvalid>false</w:SaveIfXMLInvalid> 
 * <w:IgnoreMixedContent>false</w:IgnoreMixedContent> 
 * <w:AlwaysShowPlaceholderText>false</w:AlwaysShowPlaceholderText> 
 * <w:DoNotPromoteQF /> 
 * <w:LidThemeOther>EN-US</w:LidThemeOther> 
 * <w:LidThemeAsian>X-NONE</w:LidThemeAsian> 
 * <w:LidThemeComplexScript>X-NONE</w:LidThemeComplexScript> 
 * <w:Compatibility> <w:BreakWrappedTables /> 
 * <w:SnapToGridInCell /> <w:WrapTextWithPunct /> 
 * <w:UseAsianBreakRules /> <w:DontGrowAutofit /> 
 * <w:SplitPgBreakAndParaMark /> <w:EnableOpenTypeKerning /> 
 * <w:DontFlipMirrorIndents /> <w:OverrideTableStyleHps /> 
 * </w:Compatibility> 
 * <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel> 
 * <m:mathPr> <m:mathFont m:val="Cambria Math" /> <m:brkBin 
 * m:val="before" /> <m:brkBinSub m:val="&#45;-" /> 
 * <m:smallFrac m:val="off" /> <m:dispDef /> <m:lMargin 
 * m:val="0" /> <m:rMargin m:val="0" /> <m:defJc 
 * m:val="centerGroup" /> <m:wrapIndent m:val="1440" /> 
 * <m:intLim m:val="subSup" /> <m:naryLim m:val="undOvr" /> 
 * </m:mathPr></w:WordDocument> </xml><![endif]--><!--[if gte 
 * mso 9]><xml> <w:LatentStyles DefLockedState="false" 
 * DefUnhideWhenUsed="true" DefSemiHidden="true" 
 * DefQFormat="false" DefPriority="99" LatentStyleCount="267"> 
 * <w:LsdException Locked="false" Priority="0" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="Normal" /> <w:LsdException Locked="false" Priority="9" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="heading 1" /> <w:LsdException Locked="false" 
 * Priority="9" QFormat="true" Name="heading 2" /> 
 * <w:LsdException Locked="false" Priority="9" QFormat="true" 
 * Name="heading 3" /> <w:LsdException Locked="false" 
 * Priority="9" QFormat="true" Name="heading 4" /> 
 * <w:LsdException Locked="false" Priority="9" QFormat="true" 
 * Name="heading 5" /> <w:LsdException Locked="false" 
 * Priority="9" QFormat="true" Name="heading 6" /> 
 * <w:LsdException Locked="false" Priority="9" QFormat="true" 
 * Name="heading 7" /> <w:LsdException Locked="false" 
 * Priority="9" QFormat="true" Name="heading 8" /> 
 * <w:LsdException Locked="false" Priority="9" QFormat="true" 
 * Name="heading 9" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 1" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 2" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 3" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 4" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 5" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 6" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 7" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 8" /> <w:LsdException Locked="false" 
 * Priority="39" Name="toc 9" /> <w:LsdException Locked="false" 
 * Priority="0" Name="annotation text" /> <w:LsdException 
 * Locked="false" Priority="35" QFormat="true" Name="caption" 
 * /> <w:LsdException Locked="false" Priority="0" 
 * Name="annotation reference" /> <w:LsdException 
 * Locked="false" Priority="10" SemiHidden="false" 
 * UnhideWhenUsed="false" QFormat="true" Name="Title" /> 
 * <w:LsdException Locked="false" Priority="0" Name="Default 
 * Paragraph Font" /> <w:LsdException Locked="false" 
 * Priority="11" SemiHidden="false" UnhideWhenUsed="false" 
 * QFormat="true" Name="Subtitle" /> <w:LsdException 
 * Locked="false" Priority="22" SemiHidden="false" 
 * UnhideWhenUsed="false" QFormat="true" Name="Strong" /> 
 * <w:LsdException Locked="false" Priority="20" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="Emphasis" /> <w:LsdException Locked="false" 
 * Priority="59" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Table Grid" /> <w:LsdException Locked="false" 
 * UnhideWhenUsed="false" Name="Placeholder Text" /> 
 * <w:LsdException Locked="false" Priority="1" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="No Spacing" /> <w:LsdException Locked="false" 
 * Priority="60" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Shading" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1" /> <w:LsdException Locked="false" 
 * Priority="64" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 2" /> <w:LsdException Locked="false" 
 * Priority="65" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium List 1" /> <w:LsdException Locked="false" 
 * Priority="66" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium List 2" /> <w:LsdException Locked="false" 
 * Priority="67" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Grid 1" /> <w:LsdException Locked="false" 
 * Priority="68" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Grid 2" /> <w:LsdException Locked="false" 
 * Priority="69" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Grid 3" /> <w:LsdException Locked="false" 
 * Priority="70" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Dark List" /> <w:LsdException Locked="false" 
 * Priority="71" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful Shading" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List" /> <w:LsdException Locked="false" 
 * Priority="73" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful Grid" /> <w:LsdException Locked="false" 
 * Priority="60" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Shading Accent 1" /> <w:LsdException 
 * Locked="false" Priority="61" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Light List Accent 1" /> 
 * <w:LsdException Locked="false" Priority="62" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light Grid 
 * Accent 1" /> <w:LsdException Locked="false" Priority="63" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium 
 * Shading 1 Accent 1" /> <w:LsdException Locked="false" 
 * Priority="64" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 2 Accent 1" /> <w:LsdException 
 * Locked="false" Priority="65" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium List 1 Accent 1" /> 
 * <w:LsdException Locked="false" UnhideWhenUsed="false" 
 * Name="Revision" /> <w:LsdException Locked="false" 
 * Priority="34" SemiHidden="false" UnhideWhenUsed="false" 
 * QFormat="true" Name="List Paragraph" /> <w:LsdException 
 * Locked="false" Priority="29" SemiHidden="false" 
 * UnhideWhenUsed="false" QFormat="true" Name="Quote" /> 
 * <w:LsdException Locked="false" Priority="30" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="Intense Quote" /> <w:LsdException Locked="false" 
 * Priority="66" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium List 2 Accent 1" /> <w:LsdException 
 * Locked="false" Priority="67" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Grid 1 Accent 1" /> 
 * <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 1" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 1" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 1" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 1" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 1" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 1" /> 
 * <w:LsdException Locked="false" Priority="60" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light 
 * Shading Accent 2" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List Accent 2" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid Accent 2" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1 Accent 2" /> <w:LsdException 
 * Locked="false" Priority="64" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Shading 2 Accent 2" /> 
 * <w:LsdException Locked="false" Priority="65" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 1 Accent 2" /> <w:LsdException Locked="false" Priority="66" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 2 Accent 2" /> <w:LsdException Locked="false" Priority="67" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 1 Accent 2" /> <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 2" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 2" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 2" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 2" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 2" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 2" /> 
 * <w:LsdException Locked="false" Priority="60" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light 
 * Shading Accent 3" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List Accent 3" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid Accent 3" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1 Accent 3" /> <w:LsdException 
 * Locked="false" Priority="64" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Shading 2 Accent 3" /> 
 * <w:LsdException Locked="false" Priority="65" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 1 Accent 3" /> <w:LsdException Locked="false" Priority="66" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 2 Accent 3" /> <w:LsdException Locked="false" Priority="67" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 1 Accent 3" /> <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 3" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 3" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 3" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 3" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 3" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 3" /> 
 * <w:LsdException Locked="false" Priority="60" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light 
 * Shading Accent 4" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List Accent 4" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid Accent 4" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1 Accent 4" /> <w:LsdException 
 * Locked="false" Priority="64" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Shading 2 Accent 4" /> 
 * <w:LsdException Locked="false" Priority="65" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 1 Accent 4" /> <w:LsdException Locked="false" Priority="66" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 2 Accent 4" /> <w:LsdException Locked="false" Priority="67" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 1 Accent 4" /> <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 4" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 4" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 4" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 4" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 4" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 4" /> 
 * <w:LsdException Locked="false" Priority="60" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light 
 * Shading Accent 5" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List Accent 5" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid Accent 5" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1 Accent 5" /> <w:LsdException 
 * Locked="false" Priority="64" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Shading 2 Accent 5" /> 
 * <w:LsdException Locked="false" Priority="65" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 1 Accent 5" /> <w:LsdException Locked="false" Priority="66" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 2 Accent 5" /> <w:LsdException Locked="false" Priority="67" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 1 Accent 5" /> <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 5" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 5" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 5" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 5" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 5" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 5" /> 
 * <w:LsdException Locked="false" Priority="60" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Light 
 * Shading Accent 6" /> <w:LsdException Locked="false" 
 * Priority="61" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light List Accent 6" /> <w:LsdException Locked="false" 
 * Priority="62" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Light Grid Accent 6" /> <w:LsdException Locked="false" 
 * Priority="63" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Medium Shading 1 Accent 6" /> <w:LsdException 
 * Locked="false" Priority="64" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Medium Shading 2 Accent 6" /> 
 * <w:LsdException Locked="false" Priority="65" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 1 Accent 6" /> <w:LsdException Locked="false" Priority="66" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium List 
 * 2 Accent 6" /> <w:LsdException Locked="false" Priority="67" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 1 Accent 6" /> <w:LsdException Locked="false" Priority="68" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 2 Accent 6" /> <w:LsdException Locked="false" Priority="69" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Medium Grid 
 * 3 Accent 6" /> <w:LsdException Locked="false" Priority="70" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Dark List 
 * Accent 6" /> <w:LsdException Locked="false" Priority="71" 
 * SemiHidden="false" UnhideWhenUsed="false" Name="Colorful 
 * Shading Accent 6" /> <w:LsdException Locked="false" 
 * Priority="72" SemiHidden="false" UnhideWhenUsed="false" 
 * Name="Colorful List Accent 6" /> <w:LsdException 
 * Locked="false" Priority="73" SemiHidden="false" 
 * UnhideWhenUsed="false" Name="Colorful Grid Accent 6" /> 
 * <w:LsdException Locked="false" Priority="19" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="Subtle Emphasis" /> <w:LsdException Locked="false" 
 * Priority="21" SemiHidden="false" UnhideWhenUsed="false" 
 * QFormat="true" Name="Intense Emphasis" /> <w:LsdException 
 * Locked="false" Priority="31" SemiHidden="false" 
 * UnhideWhenUsed="false" QFormat="true" Name="Subtle 
 * Reference" /> <w:LsdException Locked="false" Priority="32" 
 * SemiHidden="false" UnhideWhenUsed="false" QFormat="true" 
 * Name="Intense Reference" /> <w:LsdException Locked="false" 
 * Priority="33" SemiHidden="false" UnhideWhenUsed="false" 
 * QFormat="true" Name="Book Title" /> <w:LsdException 
 * Locked="false" Priority="37" Name="Bibliography" /> 
 * <w:LsdException Locked="false" Priority="39" QFormat="true" 
 * Name="TOC Heading" /> </w:LatentStyles> 
 * </xml><![endif]--><!--[if gte mso 10]> <style> Style 
 * Definitions table.MsoNormalTable {mso-style-name:"Table 
 * Normal"; mso-tstyle-rowband-size:0; 
 * mso-tstyle-colband-size:0; mso-style-noshow:yes; 
 * mso-style-priority:99; mso-style-parent:""; 
 * mso-padding-alt:0in 5.4pt 0in 5.4pt; mso-para-margin:0in; 
 * mso-para-margin-bottom:.0001pt; mso-pagination:widow-orphan; 
 * font-size:10.0pt; font-family:"Times New Roman","serif";} 
 * </style> <![endif]-->If the Healthcare Identification Number 
 * is not available, t<span >his query message must include one 
 * or more of the following demographic elements: 
 * </span>&ldquo;personName&rdquo; (Last Name, First Name 
 * Middle Name(s) &ndash; include all names if available 
 * &ndash; no more than a single name can be supplied), 
 * &ldquo;personBirthtime&rdquo;, &ldquo;personTelecom&rdquo; 
 * (no more than a single telephone number can be supplied, use 
 * must be &ldquo;H&rdquo;), and &ldquo;personAddress&rdquo; 
 * <u>(</u>e.g. Street Address, City/Community, 
 * Province/Territory/State and/or Postal Code/Zip Code - no 
 * more than a single address can be supplied, use must be 
 * &ldquo;H&rdquo;) <span >in the message path 
 * &ldquo;/queryByParameter/ 
 * parameterList&rdquo;.</span></span></span></li> </ol> 
 * <p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101103CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CV administrativeGenderValue = new CVImpl();
    private II clientIdValue = new IIImpl();
    private DeceasedIndicatorBean deceasedIndicator;
    private DeceasedTimeBean deceasedTime;
    private LanguageCodeBean languageCode;
    private MultipleBirthIndicatorBean multipleBirthIndicator;
    private MultipleBirthOrderNumberBean multipleBirthOrderNumber;
    private AD personAddressValue = new ADImpl();
    private TS personBirthtimeValue = new TSImpl();
    private PN personNameValue = new PNImpl();
    private TEL personTelecomValue = new TELImpl();
    private PersonalRelationshipCodeBean personalRelationshipCode;


    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (U)</p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getAdministrativeGenderValue() {
        return (AdministrativeGender) this.administrativeGenderValue.getValue();
    }

    /**
     * <p>Business Name: Client Gender</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (U)</p>
     */
    public void setAdministrativeGenderValue(AdministrativeGender administrativeGenderValue) {
        this.administrativeGenderValue.setValue(administrativeGenderValue);
    }


    /**
     * <p>Business Name: (Client Healthcare Identification Number 
     * And Or NonHealthcare Identification</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.ClientId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Healthcare identiers may be assigned jurisdictionally or 
     * by care facility and/or non-healthcare identifiers for the 
     * Client (e.g. Passport, SIN, DND, DIAND, Drivers License)</p>
     */
    @Hl7XmlMapping({"clientId/value"})
    public Identifier getClientIdValue() {
        return this.clientIdValue.getValue();
    }

    /**
     * <p>Business Name: (Client Healthcare Identification Number 
     * And Or NonHealthcare Identification</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.ClientId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Healthcare identiers may be assigned jurisdictionally or 
     * by care facility and/or non-healthcare identifiers for the 
     * Client (e.g. Passport, SIN, DND, DIAND, Drivers License)</p>
     */
    public void setClientIdValue(Identifier clientIdValue) {
        this.clientIdValue.setValue(clientIdValue);
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.deceasedIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedIndicator"})
    public DeceasedIndicatorBean getDeceasedIndicator() {
        return this.deceasedIndicator;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.deceasedIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeceasedIndicator(DeceasedIndicatorBean deceasedIndicator) {
        this.deceasedIndicator = deceasedIndicator;
    }


    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public DeceasedTimeBean getDeceasedTime() {
        return this.deceasedTime;
    }

    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.deceasedTime</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setDeceasedTime(DeceasedTimeBean deceasedTime) {
        this.deceasedTime = deceasedTime;
    }


    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public LanguageCodeBean getLanguageCode() {
        return this.languageCode;
    }

    /**
     * <p>Relationship: PRPA_MT101103CA.ParameterList.languageCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLanguageCode(LanguageCodeBean languageCode) {
        this.languageCode = languageCode;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthIndicator"})
    public MultipleBirthIndicatorBean getMultipleBirthIndicator() {
        return this.multipleBirthIndicator;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthIndicator</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMultipleBirthIndicator(MultipleBirthIndicatorBean multipleBirthIndicator) {
        this.multipleBirthIndicator = multipleBirthIndicator;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public MultipleBirthOrderNumberBean getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.multipleBirthOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setMultipleBirthOrderNumber(MultipleBirthOrderNumberBean multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber = multipleBirthOrderNumber;
    }


    /**
     * <p>Business Name: Client Address</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Address(es) of the Client</p>
     */
    @Hl7XmlMapping({"personAddress/value"})
    public PostalAddress getPersonAddressValue() {
        return this.personAddressValue.getValue();
    }

    /**
     * <p>Business Name: Client Address</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Address(es) of the Client</p>
     */
    public void setPersonAddressValue(PostalAddress personAddressValue) {
        this.personAddressValue.setValue(personAddressValue);
    }


    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonBirthtime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    @Hl7XmlMapping({"personBirthtime/value"})
    public Date getPersonBirthtimeValue() {
        return this.personBirthtimeValue.getValue();
    }

    /**
     * <p>Business Name: Client Date of Birth</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonBirthtime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Date of birth of the Client</p>
     */
    public void setPersonBirthtimeValue(Date personBirthtimeValue) {
        this.personBirthtimeValue.setValue(personBirthtimeValue);
    }


    /**
     * <p>Business Name: Client Name</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Name(s) for the Client</p>
     */
    @Hl7XmlMapping({"personName/value"})
    public PersonName getPersonNameValue() {
        return this.personNameValue.getValue();
    }

    /**
     * <p>Business Name: Client Name</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Name(s) for the Client</p>
     */
    public void setPersonNameValue(PersonName personNameValue) {
        this.personNameValue.setValue(personNameValue);
    }


    /**
     * <p>Business Name: Client Telecom</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonTelecom.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Provides information about telecom</p>
     */
    @Hl7XmlMapping({"personTelecom/value"})
    public TelecommunicationAddress getPersonTelecomValue() {
        return this.personTelecomValue.getValue();
    }

    /**
     * <p>Business Name: Client Telecom</p>
     * 
     * <p>Relationship: PRPA_MT101103CA.PersonTelecom.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * client</p>
     * 
     * <p>Provides information about telecom</p>
     */
    public void setPersonTelecomValue(TelecommunicationAddress personTelecomValue) {
        this.personTelecomValue.setValue(personTelecomValue);
    }


    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.personalRelationshipCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"personalRelationshipCode"})
    public PersonalRelationshipCodeBean getPersonalRelationshipCode() {
        return this.personalRelationshipCode;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT101103CA.ParameterList.personalRelationshipCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPersonalRelationshipCode(PersonalRelationshipCodeBean personalRelationshipCode) {
        this.personalRelationshipCode = personalRelationshipCode;
    }

}
