package repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import model.SearchCriteria;

public interface SearchCriteriaRepository extends PagingAndSortingRepository<SearchCriteria,String> {
	
	
}
