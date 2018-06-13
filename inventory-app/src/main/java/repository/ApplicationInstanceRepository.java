package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ApplicationInstance;

public interface ApplicationInstanceRepository extends JpaRepository<ApplicationInstance,Integer>{

	List<ApplicationInstance> findByApplicationEnviornmentLike(String env);
	List<ApplicationInstance> findByServerServername(int applicationid);
	List<ApplicationInstance> findByAppLookupId(int appLookupID);
	List<ApplicationInstance> findAll();

}
