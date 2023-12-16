package fernandoSilva.crudusuario.modules.usersModel.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernandoSilva.crudusuario.Execption.UserNotFoundExecption;
import fernandoSilva.crudusuario.modules.usersModel.UsersModel;
import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;

@Service
public class UsersCadastroUseCase {

     @Autowired
     private UsersRepository usersRepository;
   

    public UsersModel execute(UsersModel usersModel) {
        this.usersRepository.findByNome(usersModel.getNome())
        .ifPresent(user -> {
            throw new UserNotFoundExecption("usuário já existe");
        });

        return this.usersRepository.save(usersModel);
    }
    
}
