package fernandoSilva.crudusuario.modules.usersModel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsersController {
     
   public String create() {
      return "funcionou";
   }

}
