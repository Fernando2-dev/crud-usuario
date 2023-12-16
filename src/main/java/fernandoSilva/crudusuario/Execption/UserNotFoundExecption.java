package fernandoSilva.crudusuario.execption;

public class UserNotFoundExecption extends RuntimeException{
    public UserNotFoundExecption(String mensagem){
        super(mensagem);
    }
}
