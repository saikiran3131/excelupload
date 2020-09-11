package com.updo.excelfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.updo.excelfile.fileservice.FileServices;

@Controller
public class DownloadFileController {

	@Autowired
	FileServices fileServices;

    /*
     * Download Files
     */
	@GetMapping("/file")
	public ResponseEntity<InputStreamResource> downloadFile() {
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Employees-download.xlsx");
		
		return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(fileServices.loadFile()));	
	}
	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        return fileServices.loadPdfFile();
    }
}