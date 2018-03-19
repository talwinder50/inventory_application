package repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Server;
import vo.SearchServerResponse;
/*
 * Table name is name of the model here. 
 * Path not found exceptions are thrown if try to use joins. instead use where clause
 * 
 */
@Repository
public interface ServerRepository extends PagingAndSortingRepository<Server, String> {

	@Query("select b from Server b where " + "coalesce(b.servername, '') like concat('%', :servername, '%') "
			+ "and coalesce(b.team, '') like concat('%', :team, '%') "
			+ "and coalesce(b.container, '') like concat('%', :container, '%') "
			+ "and coalesce(b.managerName, '') like concat('%', :managerName, '%') "
			+ "and coalesce(b.enviornment, '') like concat('%', :enviornment, '%') "
			+ "and coalesce(b.tier, '') like concat('%', :tier, '%') "
			+ "and coalesce(b.type, '') like concat('%', :type, '%') ")
	public Page<Server> findByParams(@Param("servername") String servername, @Param("team") String team,
			@Param("container") String container, @Param("managerName") String managerName,
			@Param("enviornment") String enviornment, @Param("tier") String tier, @Param("type") String type,
			Pageable pageable);
	
//	@Query("Select b.servername,a.username,a.password,i.ConfigFilePath from Server b, ApplicationInstance a,InstanceConfigurationFile i "
//			+ "where b.servername = a.serverName and a.applicationID = i.applicationInstance and coalesce(b.servername, '') like concat('%', :servername, '%')")
//	public  <T> List<T> findServerUserPass(@Param("servername") String servername);
	
	@Query("Select s from Server s where s.servername like concat('%', :servername, '%')")
	public Server findServerUserPass(@Param("servername") String servername);


}