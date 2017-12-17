package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import model.Server;
import vo.SearchServerRequest;

public interface ServerRepository extends PagingAndSortingRepository<Server,String>{
	
	List<Server> findAll();
	List<Server> findByServerNameLike(String serverName);
	List<Server> findByManagerNameContaining(String managerName);
	List<Server> findByServerJbossVersion(String jbossVersion);	
	List<Server> findByTier(String tier);
	List<Server> findByType(String type);
	List<Server> findByEnviornment(String enviornment);
	List<Server> findByPatchingCycleContaining(String PatchingCycle);
	List<Server> findByTeamLike(String team);
	void save(SearchServerRequest request);
	void delete(String serverName);
	
}