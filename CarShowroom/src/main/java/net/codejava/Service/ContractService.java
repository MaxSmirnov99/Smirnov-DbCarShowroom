package net.codejava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.Contract;
import net.codejava.repository.ContractRepository;

@Service
@Transactional
public class ContractService {
	@Autowired
	private ContractRepository repo;

	public List<Contract> listAll() {
	        return repo.findAll();
	}
	     
	public void save(Contract contract) {
	        repo.save(contract);
	}
	     
	public Contract get(long id) {
	        return repo.findById(id).get();
	}
	     
	public void delete(long id) {
	        repo.deleteById(id);
	}

}
