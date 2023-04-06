package com.tigersystemseller.rest.reports;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tigersystemseller.services.ReportSaleService;
import com.tigersystemseller.util.DateUtils;



@RestController
@RequestMapping("/api/report-sales")
@CrossOrigin("*")
public class ReportSales {


	@Autowired
	private ReportSaleService reportSaleService;

	@GetMapping
	public ResponseEntity<byte[]> reportSales(
			@RequestParam(value = "id", required = false, defaultValue = "") Long id,
			@RequestParam(value = "init", required = false, defaultValue = "") String init,
			@RequestParam(value = "end", required = false, defaultValue = "") String end

			){
		Date dateInit = DateUtils.fromString(init);
		Date dateEnd = DateUtils.fromString(end, true);
        if(dateInit == null) {
        	dateInit = DateUtils.DATE_START_DEFAULT;
        }
        if(dateEnd == null) {
        	dateEnd = DateUtils.today(true);
        }

		var reportCreated =  reportSaleService.createReport(id, dateInit, dateEnd);
		var headers = new HttpHeaders();
		var fileName = "relatorio-vendas.pdf";		
		headers.setContentDispositionFormData("inline, filename=\"" +fileName+ "\"", fileName);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		var responseEntity = new ResponseEntity<>(reportCreated, headers, HttpStatus.OK);	

		return responseEntity;
	}
}
