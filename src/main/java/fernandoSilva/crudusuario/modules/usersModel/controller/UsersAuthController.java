package fernandoSilva.crudusuario.modules.usersModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fernandoSilva.crudusuario.modules.usersModel.dto.UsersAuthRequest;
import fernandoSilva.crudusuario.modules.usersModel.useCase.UsersAuthUseCase;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/usuario")
public class UsersAuthController {
    
    @Autowired
    private UsersAuthUseCase usersAuthUseCase;

    @PostMapping("/auth")
    @Transactional
    public ResponseEntity<Object> autenticacao(@RequestBody UsersAuthRequest usersAuthRequest){
       try {
          var auth = this.usersAuthUseCase.execute(usersAuthRequest);
          return ResponseEntity.ok().body(auth);
       } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
       }
    }
}
