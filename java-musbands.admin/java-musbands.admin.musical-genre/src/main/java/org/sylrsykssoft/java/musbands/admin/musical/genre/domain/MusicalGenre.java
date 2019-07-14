package org.sylrsykssoft.java.musbands.admin.musical.genre.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity musical genre
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = "musical_genre")
@Entity()
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class MusicalGenre extends BaseAdmin {
	
}
