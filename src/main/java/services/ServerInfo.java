package services;


import model.Server;

public interface ServerInfo {
	 public Iterable<Server> findAll();
	 public Iterable<Server> findByServerName(String ServerName);
	 public Iterable<Server> findByManagerName(String ManagerName);
	 
}
