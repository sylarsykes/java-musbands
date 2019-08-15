package org.sylrsykssoft.java.musbands.musbands.band.admin.domain;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.BandFunctionMemberConstants;
import org.sylrsykssoft.java.musbands.musbands.band.domain.Member;

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
@Table(name = BandFunctionMemberConstants.REPOSITORY_TABLE_NAME)
@Entity(name = BandFunctionMemberConstants.REPOSITORY_ENTITY_NAME)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true, exclude = { "member", "synonyms" })
@EntityListeners({BaseListener.class})
public class BandFunctionMember extends BaseAdmin {
	
	// Relationships
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member", nullable = false, updatable = false)
	private Member member;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "function_member_synonymic_functionmembers", 
		joinColumns = @JoinColumn(name = "function_member_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "function_member_synonymic_id", referencedColumnName = "id"))
	private @Singular Set<BandFunctionMemberSynonymic> synonyms;
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param member
	 * @param synonyms
	 * @param createdAt
	 * @param updatedAt
	 * @param removedAt
	 */
	@Builder(builderMethodName = "bandFunctionMemberBuilder")
	@ConstructorProperties({ "entityId", "name", "description", "member", "synonyms", "createdAt", "updatedAt", "removedAt" })
	public BandFunctionMember(Integer entityId, String name, String description, Member member, Set<BandFunctionMemberSynonymic> synonyms, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
		this.member = member;
		this.synonyms = synonyms;
	}
}
