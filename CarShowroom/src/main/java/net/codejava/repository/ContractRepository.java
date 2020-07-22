package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Contract;

public interface ContractRepository extends JpaRepository <Contract, Long> {

}
