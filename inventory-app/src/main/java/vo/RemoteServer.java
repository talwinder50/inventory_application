package vo;

public class RemoteServer {

	/*
	 * Target:Mandatory and flexible design Analysis: We can always follow the
	 * JavaBeans convention but its is not good choice as it will make Remote server
	 * class mutable.
	 * 
	 * Better Solution:The builder pattern.
	 * 
	 */
	private final String username; // required
	private final String hostname; // required
	private final int port; // optional otherwise use default
	private final String password; // optional out of password or private key one needs to present
	private final String privatekey; // optional

	private RemoteServer(RemoteServerBuilder builder) {
		this.username = builder.username;
		this.hostname = builder.hostname;
		this.port = builder.port;
		this.password = builder.password;
		this.privatekey = builder.privatekey;
	}

	public String getUsername() {
		return username;
	}

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public String getPassword() {
		return password;
	}

	public String getPrivatekey() {
		return privatekey;
	}

	public static class RemoteServerBuilder {
		private final String username; // required
		private final String hostname; // required
		private int port = 22; // optional otherwise use default
		private String password; // optional out of password or private key one needs to present
		private String privatekey; // optional

		public RemoteServerBuilder(String hostname, String username,String password) {
			if (hostname == null || username == null) {
				throw new IllegalArgumentException("Required  Parameter missing");
			}
			this.hostname = hostname;
			this.username = username;
			if (password == null) {
				throw new IllegalArgumentException("Password is missing, Either pass privatekeypath or password");
			}
			this.password = password;
		//	this.privatekey = privatekey;
		}

		public RemoteServerBuilder port(int port) {
			this.port = port; // != null?port:22;
			return this;
		}
		/*public RemoteServerBuilder password(String password){
			if (password == null) {
				throw new IllegalArgumentException("Password is missing, Either pass privatekeypath or password");
			}
			this.password= password; 
			return this;
		}
		public RemoteServerBuilder privatekey(String privatekey) {
			this.privatekey = privatekey; 
			return this;
		}
      */
		public RemoteServer build() {

		return new RemoteServer(this);

		}

	}

	@Override
	public String toString() {
		return "Server [hostname=" + hostname + ", user=" + username + ", password=" + password + ", privatekey="
				+ privatekey + ", port=" + port + "]";
	}

	public static void main(String[] args) {
		RemoteServer rs = new RemoteServer.RemoteServerBuilder("mrkcdsapvlut01", "admin","").build();
		//RemoteServer rs1 = new RemoteServer.RemoteServerBuilder("admin", "IBM").password("xyz").build();
		//RemoteServer rs2 = new RemoteServer.RemoteServerBuilder("admin", "IBM").password("xyz").build();
		System.out.println(rs);
		//System.out.println(rs1);
		//System.out.println(rs2);
	}
}
