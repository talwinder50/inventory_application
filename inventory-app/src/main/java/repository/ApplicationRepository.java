package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Application;
import model.DependantApplicationRelation;

public interface ApplicationRepository extends JpaRepository<Application,Integer>{

	List<DependantApplicationRelation> findByDependantApplicationRelation(int id);
	List<Application> findAll();

}
