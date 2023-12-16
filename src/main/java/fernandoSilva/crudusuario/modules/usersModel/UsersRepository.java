package fernandoSilva.crudusuario.modules.usersModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel ,Long> {
    Optional<UsersModel> findByNome(String nome);
}
