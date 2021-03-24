package com.tekspace.learning.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekspace.learning.dto.PersonDetails;

@RestController
@RequestMapping("/")
public class LearningController {
	
	
	//h
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("test")
	public void learningFunction() {
		//an individual reqult and pass where criteri
//		 PersonDetails  personDetails = this.jdbcTemplate.queryForObject(
//		        "select LastName, FirstName from persons",
//		        new Object[]{},
//		        new RowMapper<PersonDetails>() {
//		            public  PersonDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
//		            	 PersonDetails  personDetails = new PersonDetails();
//		                personDetails.setFirstName(rs.getString("LastName"));
//		                personDetails.setLastName(rs.getString("FirstName"));
//		                return personDetails;
//		            }
//		        });
		 
		
		
		List<PersonDetails> personDetails = this.jdbcTemplate.query(
		        "select LastName, FirstName from persons",
		        new RowMapper<PersonDetails>() {
		        	  public  PersonDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			            	 PersonDetails  personDetails = new PersonDetails();
			                personDetails.setFirstName(rs.getString("LastName"));
			                personDetails.setLastName(rs.getString("FirstName"));
			                return personDetails;
			            }
		        });
		 System.out.println(personDetails);
		 
		 
		System.out.println("invoking conttroller");
	}

}
