package br.com.arphoenix.toolschallenge.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class IdGenericoDTO implements Serializable {

    private static final long serialVersionUID = -1473293408330277591L;

    private UUID id;

}
