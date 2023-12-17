package fernandoSilva.crudusuario.modules.usersModel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersAuthRequest {
    private String nome;
    private String senha;
}
