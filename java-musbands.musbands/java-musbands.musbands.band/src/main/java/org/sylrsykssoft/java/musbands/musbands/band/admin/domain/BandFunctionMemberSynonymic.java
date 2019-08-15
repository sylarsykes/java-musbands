package org.sylrsykssoft.java.musbands.musbands.band.admin.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.Base;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.BandFunctionMemberSynonymicConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

@Table(name = BandFunctionMemberSynonymicConstants.REPOSITORY_TABLE_NAME)
@Entity(name = BandFunctionMemberSynonymicConstants.REPOSITORY_ENTITY_NAME)
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class BandFunctionMemberSynonymic extends Base<Integer> {

	public static final int MAX_LENGTH_NAME = 256;
	
	@Column(name = "name", nullable = false, unique = true, length = MAX_LENGTH_NAME)
	private @NonNull String name;
	
	@ManyToMany
	@JoinTable(name = "function_member_synonymic_functionmembers", 
		joinColumns = @JoinColumn(name = "function_member_synonymic_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "function_member_id", referencedColumnName = "id"))
    private @Singular Set<BandFunctionMember> functionMembers;

	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param functionMembers
	 * @param createdAt
	 * @param updatedAt
	 */
	@Builder(builderMethodName = "bandFunctionMemberSynonymicBuilder")
	public BandFunctionMemberSynonymic(Integer entityId, String name, Set<BandFunctionMember> functionMembers, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(entityId, createdAt, updatedAt);
		this.name = name;
		this.functionMembers = functionMembers;
	}
	
}
