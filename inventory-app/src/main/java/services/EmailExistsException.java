package services;

public class EmailExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailExistsException(String exceptionMsg)
	{     
        System.out.println("in ScrayException: " +exceptionMsg);
    }

}
