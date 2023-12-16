package fernandoSilva.crudusuario.modules.usersModel.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernandoSilva.crudusuario.Execption.UserNotFoundExecption;
import fernandoSilva.crudusuario.modules.usersModel.UsersModel;
import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;

@Service
public class UsersAtualizacaoUseCase {

    @Autowired
    private UsersRepository usersRepository;

    public UsersModel execute(UsersModel usersModel) {
        var usuario = this.usersRepository.findById(usersModel.getId())
                .orElseThrow(() -> {
                    throw new UserNotFoundExecption("id não encontrado, por favor, digite um id válido");
                });
        if (usersModel.getNome() != null) {
            usuario.setNome(usersModel.getNome());
        }
        if (usersModel.getEmail() != null) {
            usuario.setEmail(usersModel.getEmail());
        }
        if (usersModel.getProfissao() != null) {
            usuario.setProfissao(usersModel.getProfissao());
        }

        return usuario;
    }

}
