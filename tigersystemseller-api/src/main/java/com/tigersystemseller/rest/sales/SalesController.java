package com.tigersystemseller.rest.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigersystemseller.model.Sale;
import com.tigersystemseller.model.repository.ItemSaleRepository;
import com.tigersystemseller.model.repository.SaleRepository;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin("*")
public class SalesController {
    
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private ItemSaleRepository itemSaleRepository;

	@PostMapping
	@Transactional //o spring abre uma transação só faz depois que confirma tudo, ou executa tudo ou não executa nada;
	public void executeSale(@RequestBody Sale sale) {
		//Salva primeiro a venda para ter o ID populado
		repository.save(sale);
		sale.getItems().stream().forEach(is -> is.setSale(sale));
		itemSaleRepository.saveAll(sale.getItems());
	}	
	
}
