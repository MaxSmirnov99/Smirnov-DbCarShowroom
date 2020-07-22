package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Client;

public interface ClientRepository extends JpaRepository <Client, Long>{

}
