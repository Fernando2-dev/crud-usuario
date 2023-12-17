package fernandoSilva.crudusuario.modules.usersModel.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernandoSilva.crudusuario.execption.UserNotFoundExecption;
import fernandoSilva.crudusuario.modules.usersModel.UsersModel;
import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;
import fernandoSilva.crudusuario.modules.usersModel.dto.UsersModelDtoListagem;

@Service
public class UsersAtualizacaoUseCase {

    @Autowired
    private UsersRepository usersRepository;

    public UsersModel execute(UsersModelDtoListagem usersModelDtoListagem) {
        var usuario = this.usersRepository.findById(usersModelDtoListagem.id())
                .orElseThrow(() -> {
                    throw new UserNotFoundExecption("id não encontrado, por favor, digite um id válido");
                });
       usuario.atualizar(usersModelDtoListagem);
       return this.usersRepository.save(usuario);

    }

}
