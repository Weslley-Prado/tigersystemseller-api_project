package com.tigersystemseller.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tigersystemseller.model.Sale;
import com.tigersystemseller.model.repository.projections.SaleForMonth;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	@Query(nativeQuery = true,
			value = "select "
					+ "	extract( month from v.data_venda ) as mes, "
					+ "	sum(v.total) as valor"
					+ " from sale as v"
					+ " where extract (year from v.data_venda) = :ano"
					+ " group by extract( month from v.data_venda )"
					+ " order by extract( month from v.data_venda )"
	)
	List<SaleForMonth> getSumSaleForMonth(@Param("ano")Double ano);
}
