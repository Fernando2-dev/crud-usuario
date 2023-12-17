package fernandoSilva.crudusuario.modules.usersModel.useCase;

import java.time.Instant;
import java.time.Duration;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;
import fernandoSilva.crudusuario.modules.usersModel.dto.UsersAuthRequest;
import fernandoSilva.crudusuario.modules.usersModel.dto.UsersAuthResponse;

@Service
public class UsersAuthUseCase {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersAuthResponse execute(UsersAuthRequest usersAuthRequest) throws AuthenticationException {
        var usuario = this.usersRepository.findByNome(usersAuthRequest.getNome())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Nome ou senha incorretos");
                });

        var password = this.passwordEncoder.matches(usersAuthRequest.getSenha(), usuario.getSenha());
       
        if (!password) {
            throw new AuthenticationException();
        }

        Algorithm algoritimo = Algorithm.HMAC256("JAVA_USUARIO_123");
        var duracao = Instant.now().plus(Duration.ofHours(2));
        var token = JWT.create().withIssuer("javausuario")
                .withExpiresAt(duracao)
                .withSubject(usuario.getId().toString())
                .sign(algoritimo);

       var result = UsersAuthResponse.builder()
       .token(token)
       .duracao(duracao.toEpochMilli())
       .build();

       return result;
    } 
}


