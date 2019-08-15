package org.sylrsykssoft.java.musbands.musbands.band.domain;

import static org.sylrsykssoft.coreapi.framework.api.configuration.CoreApiFrameworkApiAddressConstants.MULTIPLE_ADDRESS_REPOSITORY_ENTITY_NAME;
import static org.sylrsykssoft.coreapi.framework.api.configuration.CoreApiFrameworkApiAddressConstants.MULTIPLE_ADDRESS_REPOSITORY_TABLE_NAME;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity band
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = "band_members")
@Entity(name = "bandMembers")
@Where(clause = "isPastMember = false")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BandMember {

	@Id
    @ManyToOne
    @JoinColumn
	private Band band;
	
	@Id
    @ManyToOne
    @JoinColumn
	private Member member;
	
    @Column(name = "is_past_member")
    private boolean isPastMember;
}
