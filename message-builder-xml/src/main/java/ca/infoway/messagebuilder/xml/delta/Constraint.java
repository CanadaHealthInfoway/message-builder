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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.xml.delta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Responsible for providing the information regarding the change.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Inheritance(strategy=InheritanceType.JOINED)
@Entity
@Table(name="change_table") // was "change" for postgres
public abstract class Constraint implements Serializable {
	
	private static final long serialVersionUID = 8989424913346728493L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;
	@Column(nullable=false, length=20)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date updated;
	@Column(nullable=false, length=20)
	private String updatedBy;

	public Constraint() {
	}
	
	public Constraint(Constraint constraint) {
		this.id = constraint.getId();
		this.created = constraint.getCreated();
		this.createdBy = constraint.getCreatedBy();
		this.updated = constraint.getUpdated();
		this.updatedBy = constraint.getUpdatedBy();
	}

	public abstract boolean hasChange();
	public abstract boolean hasChange(Constraint constraint);
	public abstract String getAsString();
	
	public abstract ConstraintChangeType getChange(); 
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public void setTrackingFieldsIfNecessary(Date date, String user) {
		if (this.created == null) {
			this.created = new Date(date.getTime());
		}
		if (this.createdBy == null) {
			this.createdBy = user;
		}
		if (this.updated == null) {
			this.updated = new Date(date.getTime());
		}
		if (this.updatedBy == null) {
			this.updatedBy = user;
		}
	}

	void assignRealmCode(RealmCode realmCode) {
		
	}

	public abstract Constraint clone(String originalPackageName, String newPackageName);
	
}
