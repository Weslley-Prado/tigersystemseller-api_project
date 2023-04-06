package com.tigersystemseller.model.repository.projections;

import java.math.BigDecimal;

//Projeção do resultado de uma consulta
public interface SaleForMonth {
     Integer getMes();
     BigDecimal getValor();
}
