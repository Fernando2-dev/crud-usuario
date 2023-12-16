package fernandoSilva.crudusuario.modules.usersModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel ,Long> {
    
}
