package com.pelyshko.exception;

public class CashWithdrawalFromServiceToOwnerNotFoundException extends RuntimeException {
	public CashWithdrawalFromServiceToOwnerNotFoundException(Integer id) {
        super("Could not find 'cash withdrawal from service to owner' with id=" + id);
    }
}
