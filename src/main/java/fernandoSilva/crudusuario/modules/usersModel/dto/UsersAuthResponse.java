package fernandoSilva.crudusuario.modules.usersModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersAuthResponse {
    private String token;
    private Long duracao;
}
