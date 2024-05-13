package fr.dawan.myskills.exceptions;


public class InvalideAliasException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalideAliasException(String alias) {
        super(String.format("Alias %s est incorrect", alias));
    }
}
