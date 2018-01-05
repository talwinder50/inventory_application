package repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Server;

@Repository
public interface ServerRepository extends PagingAndSortingRepository<Server,String>{	
	
@Query("select b from Server b where " +
        "coalesce(b.serverName, '') like concat('%', :serverName, '%') " +
        "and coalesce(b.team, '') like concat('%', :team, '%') " +
        "and coalesce(b.serverJbossVersion, '') like concat('%', :serverJbossVersion, '%') " +
        "and coalesce(b.managerName, '') like concat('%', :managerName, '%') " +
        "and coalesce(b.enviornment, '') like concat('%', :enviornment, '%') " +
        "and coalesce(b.tier, '') like concat('%', :tier, '%') " +
        "and coalesce(b.type, '') like concat('%', :type, '%') " 
      )
public Page<Server> findByParams(        
		      @Param("serverName") String serverName
            , @Param("team") String team
            , @Param("serverJbossVersion") String serverJbossVersion
            , @Param("managerName") String managerName
            , @Param("enviornment") String enviornment
            , @Param("tier") String tier
            , @Param("type") String type
            , Pageable pageable
            );
/*@Query("Select DISTINCT value FROM (SELECT DISTINCT b.serverName AS value FROM Server UNION SELECT DISTINCT b.managerName AS value FROM Server) AS derived"
        "coalesce(b.serverName, '') like concat('%', :serverName, '%') " +
        "and coalesce(b.team, '') like concat('%', :team, '%') " +
        "and coalesce(b.serverJbossVersion, '') like concat('%', :serverJbossVersion, '%') " +
        "and coalesce(b.managerName, '') like concat('%', :managerName, '%') " +
        "and coalesce(b.enviornment, '') like concat('%', :enviornment, '%') " +
        "and coalesce(b.tier, '') like concat('%', :tier, '%')" +
        "and coalesce(b.type, '') like concat('%', :type, '%')"
         ) 
public P r> findDistincts( Pageable pageable);

SELECT DISTINCT value
FROM (
    SELECT DISTINCT a AS value FROM my_table
    UNION SELECT DISTINCT b AS value FROM my_table
    UNION SELECT DISTINCT c AS value FROM my_table
) AS derived

*/


}