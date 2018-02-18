package services.model;

/**
 * 
 * No default constructor. Reason: Object creation not allowed without
 * manadatory dependencies. TODO Notes for client?
 * 
 * @author Talwinder Kaur
 * 
 * @since 1.0
 * 
 */
public class RemoteServer {

	private String host;

	/**
	 * default port 22. Client allowed to change port after initialization using
	 * setter
	 */
	private int port = 22;

	private String user;

	private String password;
	
	private PrivateKey privateKey;
	
	private boolean passwordAuth;


	/**
	 * TODO usage details for client? validation rules for client?
	 * 
	 * @param host
	 * @param user
	 * @param password
	 */
	public RemoteServer(String host, String user, String password) {
		super();
		// call setters for validations instead of directly setting
		this.setHost(host);
		this.setUser(user);
		this.setPassword(password);
		this.passwordAuth=true;
	}

	/**
	 * TODO Document usage details for client. validation rules for client?
	 * 
	 * @param host
	 * @param user
	 * @param privateKey
	 */
	public RemoteServer(String host, String user, PrivateKey privateKey) {
		super();
		this.setHost(host);
		this.setUser(user);
		this.setPrivateKey(privateKey);
	}

	public String getHost() {
		return host;
	}

	/**
	 * TODO Document Validation rules for client
	 * 
	 * @param host
	 */
	public void setHost(String host) {
		// validate host during object property modification
		this.host = validateHost(host);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = validatePort(port);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = validateUser(user);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = validatePassword(password);
	}

	private String validateHost(String host) {

		if (host == null) {
			// Runtime Exception
			throw new IllegalArgumentException("Invalid argument" + host);
		}

		return host;
	}

	private int validatePort(int port) {
		// TODO rules
		if (port < 0) {
			// Runtime Exception
			throw new IllegalArgumentException("Invalid argument" + port);
		}
		return port;
	}

	private String validateUser(String user) {
		// TODO rules

		if (user == null || user.isEmpty()) {
			// Runtime Exception
			throw new IllegalArgumentException("Invalid argument" + user);
		}
		return user;
	}

	private String validatePassword(String password) {
		// TODO rules
		return password;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public boolean isPasswordAuth() {
		return passwordAuth;
	}


}
