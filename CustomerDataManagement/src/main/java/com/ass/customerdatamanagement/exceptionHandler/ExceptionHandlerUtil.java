package com.ass.customerdatamanagement.exceptionHandler;

import java.time.LocalDateTime;
import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ass.customerdatamanagement.dto.ResponseStructure;
import com.ass.customerdatamanagement.entity.Customer;

//@ControllerAdvice//generate bean of this class and 
@RestControllerAdvice//

public class ExceptionHandlerUtil {
	@ExceptionHandler(NoDataFoundException.class)//
	public ResponseEntity<ResponseStructure<String>> noNoDataFoundException(NoDataFoundException noData) {
		ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		    rs.setMessage("No data found");
			rs.setData(noData.getMessage());
		//	rs.setData(noData.printStackTrace());set Object type in responseStructure

			rs.setTimeStamp(LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(InputMismatchException.class)//
	public ResponseEntity<ResponseStructure<String>> inputMismatchException(InputMismatchException noData) {
		ResponseStructure<String> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		    rs.setMessage("No data found");
			rs.setData(noData.getMessage());
		//	rs.setData(noData.printStackTrace());set Object type in responseStructure

			rs.setTimeStamp(LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
