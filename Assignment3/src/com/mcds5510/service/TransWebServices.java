package com.mcds5510.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mcds5510.dao.TransactionMethods;
import com.mcds5510.entity.Transaction;
import com.mcds5510.logger.SimpleLogger;

@WebService
public class TransWebServices {

	@WebMethod
	public static String getTransaction(int trxn) {
	
		return TransactionMethods.getTxnMethod(trxn);
	}
	
	public boolean updateTransaction(int trxnID, String Name, String CardNumber,
			 double unitPrice, int qty, double totalPrice, String expDate){
		return TransactionMethods.updateMethod(trxnID,Name, CardNumber,unitPrice, qty,totalPrice, expDate);
	}
	
	public boolean removeTransaction(int id) {
		return TransactionMethods.deleteMethod(id);
	}
	
	public boolean  createTransaction(int trxnID, String Name, String CardNumber,
			 double unitPrice, int qty, double totalPrice, String expDate) {
		
		
	return TransactionMethods.insertMethod( trxnID,  Name,  CardNumber,
			  unitPrice,  qty,  totalPrice,  expDate);
		
	}
	
}
