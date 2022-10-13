package platform.businesslayer.exception;

import java.util.UUID;

public class CodeNotFoundException extends RuntimeException {

    private static final String MSG_TEMPLATE = "Code not found by id=%s";

    public CodeNotFoundException(UUID id) {
        super(String.format(MSG_TEMPLATE, id));
    }
}
