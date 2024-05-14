package fr.dawan.myskills.exceptions;


public class InvalideAliasException extends RuntimeException {
	
	public InvalideAliasException() {
		super("Alias incorrect");
	}
    public InvalideAliasException(String error) {
        super(String.format("Alias incorrect : %s", error));
    }
	
}
