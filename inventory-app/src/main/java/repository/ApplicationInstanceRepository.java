package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import model.ApplicationInstance;
import vo.ApplicationRequest;

public interface ApplicationInstanceRepository extends PagingAndSortingRepository<ApplicationInstance,Integer>{

	List<ApplicationInstance> findByApplicationEnviornmentLike(String env);
	List<ApplicationInstance> findByServerLike(String serverName);
	List<ApplicationInstance> findByAppLookupId(int appLookupID);
	                         

}
