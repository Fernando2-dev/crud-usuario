package fernandoSilva.crudusuario.modules.usersModel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersModelDto{
     private Long id;
     private String nome;
     private String email;
     private String profissao;
}
