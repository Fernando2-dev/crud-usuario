package fernandoSilva.crudusuario.modules.usersModel.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernandoSilva.crudusuario.execption.UserNotFoundExecption;
import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;
import fernandoSilva.crudusuario.modules.usersModel.dto.UsersModelDto;

@Service
public class UsersListagemUseCase {
   
    @Autowired
    private UsersRepository UsersRepository;


    public UsersModelDto execute(Long id) {
      var usuario = this.UsersRepository.findById(id)
      .orElseThrow(() -> {
        throw new UserNotFoundExecption("id não encontrado");
      });

      var userModel = UsersModelDto.builder()
      .id(usuario.getId())
      .nome(usuario.getNome())
      .email(usuario.getEmail())
      .profissao(usuario.getProfissao())
      .build();

      return userModel;
    }
}
