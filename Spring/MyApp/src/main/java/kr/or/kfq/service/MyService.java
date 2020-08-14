package kr.or.kfq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kfq.repository.MyRepository;

@Service
public class MyService {
	@Autowired
	MyRepository repository;
	
	public int getTotalCount() {
//		int totalcount = repository.getTotalCount();
		
		return repository.getTotalCount();
	}
}
