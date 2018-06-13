package repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.repository.Repository;

import model.InstanceConfigurationValues;


public interface InstanceConfigurationFileRepository extends Repository<InstanceConfigurationValues, Integer> { 
	
    public HashMap<String, String> findByInstanceConfigurationFile(int applicationId);
   // public List<InstanceConfigurationFile> ;

	

}
