package net.codejava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.model.Car;
import net.codejava.repository.CarRepository;

@Service
@Transactional
public class CarService {
	@Autowired
	private CarRepository repo;

	public List<Car> listAll() {
	        return repo.findAll();
	}
	     
	public void save(Car car) {
	        repo.save(car);
	}
	     
	public Car get(long id) {
	        return repo.findById(id).get();
	}
	     
	public void delete(long id) {
	        repo.deleteById(id);
	}

}
