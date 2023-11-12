package com.pelyshko.exception;

public class CashWithdrawalFromLesseeToServiceNotFoundException extends RuntimeException {
	public CashWithdrawalFromLesseeToServiceNotFoundException(Integer id) {
        super("Could not find 'cash withdrawal from lessee to service' with id=" + id);
    }
}
