package fernandoSilva.crudusuario.modules.usersModel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fernandoSilva.crudusuario.modules.usersModel.UsersModel;
import fernandoSilva.crudusuario.modules.usersModel.UsersRepository;
import fernandoSilva.crudusuario.modules.usersModel.useCase.UsersCadastroUseCase;
import fernandoSilva.crudusuario.modules.usersModel.useCase.UsersListagemUseCase;

@RestController
@RequestMapping("/usuario")
public class UsersController {

   @Autowired
   private UsersCadastroUseCase usersCadastroUseCase;

   @Autowired
   private UsersListagemUseCase usersListagemUseCase;

   @Autowired
   private UsersRepository usersRepository;

   @PostMapping
   @Transactional
   public ResponseEntity<Object> cadastro(@RequestBody UsersModel UsersModel) {
      try {
         var usuario = this.usersCadastroUseCase.execute(UsersModel);
         return ResponseEntity.ok().body(usuario);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

   @GetMapping("/{id}")
   public ResponseEntity<Object> listagemId(@PathVariable Long id) {
      try {
         var usuario = this.usersListagemUseCase.execute(id);
         return ResponseEntity.ok().body(usuario);
      } catch (Exception e) {
         return ResponseEntity.ok().body(e.getMessage());
      }

   }

   @GetMapping
   public List<UsersModel> listagem() {
      return this.usersRepository.findAll();
   }

}
