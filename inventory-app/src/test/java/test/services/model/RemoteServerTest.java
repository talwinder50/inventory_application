package test.services.model;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.Test;

import services.model.RemoteServer;

public class RemoteServerTest {

	/*// hostname can't be null
	@Test(expected = IllegalArgumentException.class)
	public void RemoteServerConstructorInvalidHostTest() {
		new RemoteServer(null, "admin", Paths.get("/apps/id_rsa"));
	}

	// Username can't be blank
	@Test(expected = IllegalArgumentException.class)
	public void RemoteServerConstructorInvalidUserTest() {
		new RemoteServer("localhost", "", Paths.get("/apps/id_rsa"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void RemoteServerConstructorInvalidPortTest() {
		RemoteServer rs = new RemoteServer("localhost", "", Paths.get("/apps/id_rsa"));
		rs.setPort(-10);
	   
	}
	@Test
	public void RemoteServerConstructorDefaultPortTest() {
		RemoteServer rs = new RemoteServer("localhost", "xyz", Paths.get("/apps/id_rsa"));
		assertEquals(22, rs.getPort());
	    
	}
	*/
	
	
}
