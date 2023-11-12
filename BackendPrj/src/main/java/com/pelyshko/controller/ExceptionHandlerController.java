package com.pelyshko.controller;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pelyshko.exception.*;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	@ResponseBody
    @ExceptionHandler(AdressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String adressNotFoundHandler(AdressNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cityNotFoundHandler(CityNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(DwellingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dwellingNotFoundHandler(DwellingNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(RegionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String regionNotFoundHandler(RegionNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reservationNotFoundHandler(ReservationNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(LesseeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String lesseeNotFoundHandler(LesseeNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(PlatformUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String platformUserNotFoundHandler(PlatformUserNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(DwellingOwnerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dwellingOwnerNotFoundHandler(DwellingOwnerNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(DwellingOwnerNotFoundBySurnameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String DwellingOwnerNotFoundBySurnameHandler(DwellingOwnerNotFoundBySurnameException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(CashWithdrawalFromLesseeToServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CashWithdrawalFromLesseeToServiceNotFoundHandler(CashWithdrawalFromLesseeToServiceNotFoundException ex) {
        return ex.getMessage();
    }
	
	@ResponseBody
    @ExceptionHandler(CashWithdrawalFromServiceToOwnerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CashWithdrawalFromServiceToOwnerNotFoundHandler(CashWithdrawalFromServiceToOwnerNotFoundException ex) {
        return ex.getMessage();
    }
	
}
