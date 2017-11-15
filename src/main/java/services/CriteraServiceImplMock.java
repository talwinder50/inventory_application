package services;

import org.springframework.stereotype.Service;

import model.SearchCriteria;


@Service
public class CriteraServiceImplMock implements CriteraService {

	@Override
	public SearchCriteria findDisplayName(String displayName) {
		// TODO Auto-generated method stub
		return new SearchCriteria(23,"This is mock result");
	}

	@Override
	public SearchCriteria saveSearchCriteria(SearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		return new SearchCriteria(1313,"This is save function");
	}

}
