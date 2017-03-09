package com.oneil.ranking.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class UploadController {
	
	 private static final String EXT_NAME = "csv";
	    
	    @Autowired
	    private MultipartResolver multipartResolver;
	    
	  
	    @RequestMapping(value="/{uploadCsv}", method = RequestMethod.POST)
	    public void uploadRanks(@PathVariable String contactId, HttpServletRequest request) throws IOException {
	        MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart(request);
	        
	        MultipartFile file = multipartRequest.getFile("file");
	        File uploadFile = File.createTempFile("contact-", contactId);
	        file.transferTo(uploadFile);
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        br = new BufferedReader(new FileReader(uploadFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] rank = line.split(cvsSplitBy);

                System.out.println("WebSite = " + rank[0] + " , updateDate=" + rank[1] + " , hits=" + rank[2] );

            }

	    }
	    
	  
	}


