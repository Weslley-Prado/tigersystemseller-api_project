package com.tigersystemseller.model.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tigersystemseller.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	//Pageable => serve para a páginação do sistema, lembrando que deve usar os pacotes acima;
	//like => serve para fazer uma comparação e like :name refere-se a um parâmetro;
	@Query(" select c from Client c where upper(c.name) like upper(:name) and c.cpf like :cpf")
	Page<Client> searchNameCpf(
			@Param("name")String name, 
			@Param("cpf")String cpf, Pageable pageable);
}
