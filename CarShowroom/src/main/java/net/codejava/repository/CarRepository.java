package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Car;

public interface CarRepository extends JpaRepository <Car, Long> {

}
