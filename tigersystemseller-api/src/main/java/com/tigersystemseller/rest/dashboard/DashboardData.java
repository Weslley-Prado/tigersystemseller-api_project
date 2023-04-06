package com.tigersystemseller.rest.dashboard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.tigersystemseller.model.repository.projections.SaleForMonth;

public class DashboardData {
        private Long products;
        private Long clients;
        private Long sales;
        private List<SaleForMonth> saleForMonth;
        
        
		public DashboardData(Long products, Long clients, Long sales,  List<SaleForMonth> saleForMonth) {
			super();
			this.products = products;
			this.clients = clients;
			this.sales = sales;
			this.saleForMonth = saleForMonth;
			this.toFillMonthMissing();
		}
		public Long getProducts() {
			return products;
		}
		public void setProducts(Long products) {
			this.products = products;
		}
		public Long getClients() {
			return clients;
		}
		public void setClients(Long clients) {
			this.clients = clients;
		}
		public Long getSales() {
			return sales;
		}
		public void setSales(Long sales) {
			this.sales = sales;
		}
		public List<SaleForMonth> getSaleForMonth() {
			if(saleForMonth == null) {
				saleForMonth = new ArrayList<>();
			}
			return saleForMonth;
		}
		public void setSaleForMonth(List<SaleForMonth> saleForMonth) {
			this.saleForMonth = saleForMonth;
		}	
		
		public void toFillMonthMissing() {
			if(getSaleForMonth().isEmpty()) {
				return;
			}
			Integer maxMonth = getSaleForMonth().stream()
					.mapToInt(SaleForMonth::getMes)
					.max().getAsInt();
			List<Integer> listMonth = IntStream.rangeClosed(1, maxMonth)
					.boxed().collect(Collectors.toList()); 
			List<Integer> monthAdded = getSaleForMonth().stream()
					.map(SaleForMonth::getMes).collect(Collectors.toList());
			listMonth.stream().forEach(month -> {
				if(!monthAdded.contains(month)){
					SaleForMonth saleForMonth = new SaleForMonth() {
						@Override
						 public BigDecimal getValor() {
					    	 return BigDecimal.ZERO;
					     };
						@Override
						public Integer getMes() {
							return month;
						}
					    
					};
				    getSaleForMonth().add(saleForMonth);
				}
			});
		getSaleForMonth().sort(Comparator.comparing(SaleForMonth::getMes));
        
		}
}
