package org.sylrsykssoft.java.musbands.musbands.band.admin.domain;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.MemberInstrumentConstants;
import org.sylrsykssoft.java.musbands.musbands.band.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity function member
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = MemberInstrumentConstants.REPOSITORY_TABLE_NAME)
@Entity(name = MemberInstrumentConstants.REPOSITORY_ENTITY_NAME)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true, exclude = { "member" })
@EntityListeners({BaseListener.class})
public class MemberInstrument extends BaseAdmin {
	
	// Relationships
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_member", nullable = false, updatable = false)
	private Member member;
	
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
	@Builder(builderMethodName = "memberInstrumentBuilder")
	@ConstructorProperties({ "entityId", "name", "description", "member", "createdAt", "updatedAt", "removedAt" })
	public MemberInstrument(Integer entityId, String name, String description, Member member, Set<BandFunctionMemberSynonymic> synonyms, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
		this.member = member;
	}
}
