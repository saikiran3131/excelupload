package com.updo.excelfile.fileservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.updo.excelfile.model.Customer;
import com.updo.excelfile.repository.CustomerRepository;
import com.updo.excelfile.util.ExcelUtils;

@Service
public class FileServices{
	
	@Autowired
	CustomerRepository customerRepository;
	
	// Store File Data to Database
	public void store(MultipartFile file){
		try {
			System.out.println("file input stream :"+file.getInputStream());
			List<Customer> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
			System.out.println("listCustomers size is : "+lstCustomers.size());
    		// Save Customers to DataBase
    		customerRepository.saveAll(lstCustomers);
        } catch (IOException e) {
        	e.printStackTrace();
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        	
        }
	}
	
	// Load Data to Excel File
    public ByteArrayInputStream loadFile() {
    	List<Customer> customers = (List<Customer>) customerRepository.findAll();
    	
    	try {
    		ByteArrayInputStream in = ExcelUtils.customersToExcel(customers);
    		return in;
		} catch (IOException e) {}
    	
        return null;
    }
    
 // Load Data to Excel File
    public ResponseEntity<InputStreamResource> loadPdfFile() {
    	List<Customer> customers = (List<Customer>) customerRepository.findAll();
    	
    	ByteArrayInputStream bis = GeneratePdfReport.citiesReport(customers);

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employeesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
