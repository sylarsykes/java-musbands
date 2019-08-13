package org.sylrsykssoft.java.musbands.admin.function.member.resource;

import java.util.Set;

import org.sylrsykssoft.coreapi.framework.api.resource.BaseResource;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;

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

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class FunctionMemberSynonymicResource extends BaseResource<Integer> {

	private @NonNull String name;
	private @Singular Set<FunctionMember> functionMembers;
    
}
