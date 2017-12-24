package repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import model.Server;
import vo.SearchServerRequest;

@Repository
public interface ServerRepository extends PagingAndSortingRepository<Server,String>{	
	
@Query("SELECT p FROM Server p WHERE coalesce(p.managerName, '')  like concat ('%', :managerName, '%')"
		+ "and coalesce(p.team, '') like concat('%', :team, '%')")
public Page<Server> findByParams( @Param("managerName") String managerName
		    , @Param("team") String team
            , Pageable pageable);
/*@Query("select b from Server b where " +
        "coalesce(b.serverName, '') like concat('%', :serverName, '%') " +
        "and coalesce(b.team, '') like concat('%', :team, '%') " +
        "and coalesce(b.serverJbossVersion, '') like concat('%', :serverJbossVersion, '%') " +
        "and coalesce(b.managerName, '') like concat('%', :managerName, '%') " +
        "and coalesce(b.enviornment, '') like concat('%', :enviornment, '%') " +
        "and coalesce(b.tier, '') like concat('%', :tier, '%') " +
        "and coalesce(b.type, '') like concat('%', :type, '%') " +
        "and coalesce(b.ramAllocated, '') like concat('%', :ramAllocated, '%') " +
        "and coalesce(b.cpuCount, '') like concat('%', :cpuCount, '%') " 
      )
public Page<Server> findByParams(        
		      @Param("serverName") String serverName
            , @Param("team") String team
            , @Param("serverJbossVersion") String serverJbossVersion
            , @Param("managerName") String managerName
            , @Param("enviornment") String enviornment
            , @Param("tier") String tier
            , @Param("type") String type
            , @Param("ramAllocated") String ramAllocated
            , @Param("cpuCount") String cpuCount
            , Pageable pageable
            );*/

	Page<Server> findAll(Pageable pageable);
	List<Server> findByServerNameLike(String serverName);
	Page<Server> findByManagerNameContaining(String managerName,Pageable pageable); 
	Page<Server> findByManagerNameContainingAndServerJbossVersion(String managerName,String jbossVersion,Pageable pageable); 
	List<Server> findByServerJbossVersion(String jbossVersion);	
	List<Server> findByTier(String tier);
	List<Server> findByType(String type);
	List<Server> findByEnviornment(String enviornment);
	List<Server> findByPatchingCycleContaining(String PatchingCycle);
	List<Server> findByTeamLike(String team);
	//TODO: entity name or vo?
	void save(SearchServerRequest request);
	void delete(String serverName);
	
	
}