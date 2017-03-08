package com.oneil.ranking.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.oneil.ranking.model.Ranks;
import com.oneil.ranking.repositories.RanksRepository;
import com.oneil.ranking.util.CustomErrorType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class RestAPIController {
	private static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	@Autowired
	RanksRepository ranksRepository;
	
	//get top 5 ranks
	@RequestMapping(value= "/rank/search", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
	  public Iterable<Ranks> getSearch(HttpServletRequest servletRequest,@RequestParam(value="recDate")String  recDate){
		SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        Date date=null;
		try {
			date = formatter.parse(recDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // int visits = Integer.parseInt(webRequest.getParameter("visits"));
		logger.info("recDate----------------------"+recDate);
		return ranksRepository.retrieveTop5Ranks(date);
	}
	//get top 10 Ranks
	@RequestMapping(value= "/rank/top10", produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
	  public Iterable<Ranks> getTop10(HttpServletRequest servletRequest,@RequestParam(value="recDate") String recDate) {
	     Date date=null;
		try {
			date = formatter.parse(recDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // int visits = Integer.parseInt(webRequest.getParameter("visits"));
		logger.info("recDate----------------------"+date);
		return ranksRepository.retrieveTop10Ranks(date);
	
	}
  //get all ranks
	   @RequestMapping(value = "/rank/",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	    public ResponseEntity<List<Ranks>> listAllRanks() {
	        List<Ranks> ranks = ranksRepository.findAll();
	        if (ranks.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Ranks>>(ranks, HttpStatus.OK);
	    }
	
	 @RequestMapping(value = "/rank/{id}", method = RequestMethod.GET)
	    public ResponseEntity<?> getRank(@PathVariable("id") Long id) {
	        logger.info("Fetching Ranks with id {}", id);
	        Ranks ranks = ranksRepository.findOne(id);
	        if (ranks == null) {
	            logger.error("Rank with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("Rank with id " + id 
	                    + " not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Ranks>(ranks, HttpStatus.OK);
	    }
	 
	 //create new rank
	 @RequestMapping(value = "/rank/", method = RequestMethod.POST)
	    public ResponseEntity<?> createRank(@RequestBody Ranks rank, UriComponentsBuilder ucBuilder) {
	        logger.info("Creating Ranking : {}", rank);
	 
	        if (isWebSiteExist(rank)) {
	            logger.error("Unable to create. A Rank with id {} already exist", rank.getWebsite());
	            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
	            rank.getWebsite() + " already exist."),HttpStatus.CONFLICT);
	        }
	        ranksRepository.save(rank);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/rank/{id}").buildAndExpand(rank.getWebsite()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	//update rank
	 @RequestMapping(value = "/rank/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateRank(@PathVariable("id") Long id, @RequestBody Ranks rank) {
	        logger.info("Updating Rank with id {}", id);
	 
	        Ranks currentRanks = ranksRepository.findOne(id);
	 
	        if (currentRanks == null) {
	            logger.error("Unable to update. Ranks with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("Unable to update. Ranks with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	 
	        currentRanks.setRecDate(rank.getRecDate());
	        currentRanks.setVisits(rank.getVisits());
	        currentRanks.setWebsite(rank.getWebsite());
	 
	        ranksRepository.save(currentRanks);
	        return new ResponseEntity<Ranks>(currentRanks, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/rank/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteRank(@PathVariable("id") Long id) {
	        logger.info("Fetching & Deleting Ranks with id {}", id);
	 
	        Ranks rank = ranksRepository.findOne(id);
	        if (rank == null) {
	            logger.error("Unable to delete. User with id {} not found.", id);
	            return new ResponseEntity(new CustomErrorType("Unable to delete. Rank with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        ranksRepository.delete(rank);
	        return new ResponseEntity<Ranks>(HttpStatus.NO_CONTENT);
	    }
	 
	    // ------------------- Delete All Ranks-----------------------------
	 
	    @RequestMapping(value = "/ranks/", method = RequestMethod.DELETE)
	    public ResponseEntity<Ranks> deleteAllRanks() {
	        logger.info("Deleting All Ranks");
	 
	        ranksRepository.deleteAll();;
	        return new ResponseEntity<Ranks>(HttpStatus.NO_CONTENT);
	    }
	    
	    private boolean isWebSiteExist(Ranks rank) {
	        return ranksRepository.findByWebsite(rank.getWebsite()) != null;
	    }
}
