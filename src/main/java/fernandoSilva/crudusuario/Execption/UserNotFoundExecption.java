package fernandoSilva.crudusuario.Execption;

public class UserNotFoundExecption extends RuntimeException{
    public UserNotFoundExecption(String mensagem){
        super(mensagem);
    }
}
