package org.sylrsykssoft.java.musbands.admin.function.member.domain;

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

@Table(name = "function_member_synonymic")
@Entity(name = "function_member_synonymic")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class FunctionMemberSynonymic extends Base<Integer> {

	public static final int MAX_LENGTH_NAME = 256;
	
	@Column(name = "name", nullable = false, unique = true, length = MAX_LENGTH_NAME)
	private @NonNull String name;
	
	@ManyToMany
	@JoinTable(name = "function_member_synonymic_functionmembers", 
		joinColumns = @JoinColumn(name = "function_member_synonymic_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "function_member_id", referencedColumnName = "id"))
    private @Singular Set<FunctionMember> functionMembers;

	
	@Builder(builderMethodName = "functionMemberSynonymicBuilder")
	public FunctionMemberSynonymic(Integer entityId, String name, Set<FunctionMember> functionMembers, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(entityId, createdAt, updatedAt);
		this.name = name;
		this.functionMembers = functionMembers;
	}
	
}
