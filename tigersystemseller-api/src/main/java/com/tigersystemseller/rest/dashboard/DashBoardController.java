package com.tigersystemseller.rest.dashboard;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigersystemseller.model.repository.ClientRepository;
import com.tigersystemseller.model.repository.ProductRepository;
import com.tigersystemseller.model.repository.SaleRepository;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashBoardController {
       
	@Autowired
	private SaleRepository sales;
	@Autowired
	private ClientRepository clients;
	@Autowired
	private ProductRepository products;
	
	@GetMapping
	public DashboardData getDashboard() {
		long salesCount = sales.count();
		long clientsCount = clients.count();
		long productsCount = products.count();  
		int yearCurrent = LocalDate.now().getYear();
		var saleForMonth = sales.getSumSaleForMonth( (double) yearCurrent);
		
		return new DashboardData(productsCount, clientsCount, salesCount, saleForMonth);
		}
}
