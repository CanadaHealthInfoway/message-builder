/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "POIZ_MT060150CA.AnnotationIndicator", "PORX_MT030040CA.AnnotationIndicator", "PORX_MT060010CA.AnnotationIndicator", "PORX_MT060020CA.AnnotationIndicator", "PORX_MT060040CA.AnnotationIndicator", "PORX_MT060060CA.AnnotationIndicator", "PORX_MT060090CA.AnnotationIndicator", "PORX_MT060100CA.AnnotationIndicator", "PORX_MT060160CA.AnnotationIndicator", "PORX_MT060190CA.AnnotationIndicator", "PORX_MT060210CA.AnnotationIndicator", "PORX_MT060340CA.AnnotationIndicator", "REPC_MT000005CA.AnnotationIndicator", "REPC_MT000006CA.AnnotationIndicator", "REPC_MT000007CA.AnnotationIndicator", "REPC_MT100001CA.AnnotationIndicator", "REPC_MT100002CA.AnnotationIndicator", "REPC_MT000003CA.ChronicIndicator", "REPC_MT000007CA.ChronicIndicator", "REPC_MT000010CA.ChronicIndicator", "REPC_MT000014CA.ChronicIndicator", "POIZ_MT060150CA.DetectedIssueIndicator", "PORX_MT030040CA.DetectedIssueIndicator", "PORX_MT060010CA.DetectedIssueIndicator", "PORX_MT060020CA.DetectedIssueIndicator", "PORX_MT060040CA.DetectedIssueIndicator", "PORX_MT060060CA.DetectedIssueIndicator", "PORX_MT060090CA.DetectedIssueIndicator", "PORX_MT060100CA.DetectedIssueIndicator", "PORX_MT060160CA.DetectedIssueIndicator", "PORX_MT060190CA.DetectedIssueIndicator", "PORX_MT060210CA.DetectedIssueIndicator", "PORX_MT060340CA.DetectedIssueIndicator", "PORX_MT030040CA.SourceDispense", "PORX_MT060040CA.SourceDispense", "PORX_MT060060CA.SourceDispense", "PORX_MT060160CA.SourceDispense", "PORX_MT060190CA.SourceDispense", "PORX_MT060340CA.SourceDispense", "PORX_MT010110CA.VerificationEventCriterion", "PORX_MT010120CA.VerificationEventCriterion", "PORX_MT010140CA.VerificationEventCriterion", "PORX_MT030040CA.VerificationEventCriterion", "PORX_MT060040CA.VerificationEventCriterion", "PORX_MT060060CA.VerificationEventCriterion", "PORX_MT060160CA.VerificationEventCriterion", "PORX_MT060190CA.VerificationEventCriterion", "PORX_MT060340CA.VerificationEventCriterion", "POIZ_MT030050CA.AdverseReactionObservationEvent", "POIZ_MT030060CA.AdverseReactionObservationEvent" })
public class IndicatorBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 821612320206413156L;
}
