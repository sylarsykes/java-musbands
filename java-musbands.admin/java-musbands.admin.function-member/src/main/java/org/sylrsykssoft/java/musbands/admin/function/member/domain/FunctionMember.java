package org.sylrsykssoft.java.musbands.admin.function.member.domain;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

/**
 * Entity function member
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = FunctionMemberConstants.REPOSITORY_TABLE_NAME)
@Entity(name = FunctionMemberConstants.REPOSITORY_ENTITY_NAME)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true, exclude = "synonyms")
@EntityListeners({BaseListener.class})
public class FunctionMember extends BaseAdmin {
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "function_member_synonymic_functionmembers", 
		joinColumns = @JoinColumn(name = "function_member_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "function_member_synonymic_id", referencedColumnName = "id"))
	private @Singular Set<FunctionMemberSynonymic> synonyms;
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param synonyms
	 * @param createdAt
	 * @param updatedAt
	 * @param removedAt
	 */
	@Builder(builderMethodName = "functionMemberBuilder")
	@ConstructorProperties({ "entityId", "name", "description", "synonyms", "createdAt", "updatedAt", "removedAt" })
	public FunctionMember(Integer entityId, String name, String description, Set<FunctionMemberSynonymic> synonyms, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
		this.synonyms = synonyms;
	}
}
