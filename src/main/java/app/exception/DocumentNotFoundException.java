package app.exception;

public class DocumentNotFoundException extends RuntimeException {

    public DocumentNotFoundException(Long id) {
        super(String.format("Document %s not found", id));
    }
}
