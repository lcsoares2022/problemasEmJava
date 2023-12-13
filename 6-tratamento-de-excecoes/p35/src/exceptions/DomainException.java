package exceptions;

import java.io.Serial;

public class DomainException extends RuntimeException{

    //todo(1): subclasse de Exception o compilador obriga a tratar
    //todo(2): subclasse de RuntimeException o compilador não obriga a tratar
    //todo(3): Essa é uma classe serializable - pode ser convertido para Bytes


    @Serial
    private static final long serialVersionUID = 1L; //declaração da versão da classe Serializable


    public DomainException(String message) {
        super(message); //mensagem que vai ficar armazenada dentro da minha exceção
    }


}
