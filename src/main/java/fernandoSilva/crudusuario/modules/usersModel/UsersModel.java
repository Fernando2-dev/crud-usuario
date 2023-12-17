package fernandoSilva.crudusuario.modules.usersModel;

import fernandoSilva.crudusuario.modules.usersModel.dto.UsersModelDtoListagem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UsersModel {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @NotBlank
     private String nome;
     
     @NotBlank
     @Email(message = "o email é obrigatório")
     private String email;

     @NotBlank
     private String senha;

     @NotBlank
     private String profissao;

     public void atualizar(UsersModelDtoListagem usersModelDtoListagem){
          if (usersModelDtoListagem.nome() != null) {
               this.setNome(usersModelDtoListagem.nome());
           }
           if (usersModelDtoListagem.email() != null) {
               this.setEmail(usersModelDtoListagem.email());
           }
           if (usersModelDtoListagem.profissao() != null) {
               this.setProfissao(usersModelDtoListagem.profissao());
           }
     }
} 
