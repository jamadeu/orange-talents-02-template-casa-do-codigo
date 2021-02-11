package br.com.zup.casadocodigo.errors;

public class ErrorsDto {

    private String field;
    private String message;

    public ErrorsDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
