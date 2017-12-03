package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import model.Application;

public interface ApplicationRepository extends PagingAndSortingRepository<Application,String>{

	List<Application> findAll();
	List<Application> findByApplicationEnviornmentLike(String env);
	List<Application> findByApplicationNameLike(String name);
	List<Application> findByServerNameLike(String serverName);
}
