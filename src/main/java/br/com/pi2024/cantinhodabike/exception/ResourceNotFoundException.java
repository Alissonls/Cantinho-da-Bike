package br.com.pi2024.cantinhodabike.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Informação não encontrada");
    }

    public ResourceNotFoundException(String menssagem) {
        super(menssagem);

    }
}
