package Exceptions;

public class UnallocatedConferencesException extends Exception {


	private static final long serialVersionUID = 1L;
	
	public String toString(){
		return "Nao ha conferencias alocadas!";
	}

}
