package com.taller.votos.enums;

public enum MessageType {
    
    NOTHING("OK", 0),
    SUCCESS_MESSAGE("Acción completada con éxito.", 1),
    ERROR_MESSAGE("Ha ocurrido un error.", 2),
    VOTE_DONE_MESSAGE("Has votado con éxito", 3);

    private String message;
    private Integer code;

    private MessageType(String message, Integer code){
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
