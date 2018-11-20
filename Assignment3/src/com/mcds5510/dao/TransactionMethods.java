package com.mcds5510.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.mcds5510.connect.DBConnection;
import com.mcds5510.entity.Transaction;
import com.mcds5510.logger.SimpleLogger;
import com.mcds5510.valid.ValidationTest;

public class TransactionMethods {

	
	public TransactionMethods() {
		new SimpleLogger();
	}

////Scanner for the class..
//	public static Scanner scannerMethod() {
//		Scanner scanner = new Scanner(System.in);
//		return scanner;
//	}

	// method to check existence of user...
	private static boolean checkId(int insertId) {

		if (getTxnMethod(insertId)!= null) {
			return true;
		}
		return false;
	}

	// insert method..
	public static boolean insertMethod(int id, String Name, String CardNumber,
			 double unitPrice, int qty, double totalPrice, String expDate) {

		Collection<Transaction> insertTrans = new ArrayList<Transaction>();

		if (checkId(id)) {
			SimpleLogger.logger.info("Id exists: update the transaction");
			return false;
		} else {
			Connection connection = null;
			Transaction trans = new Transaction();

			trans.setId(id);
			insertTrans = userInput(insertTrans,Name, CardNumber,unitPrice, qty,totalPrice, expDate);

			// SQL insert......
			MySQLAccess dao = new MySQLAccess();

			try {
				connection = DBConnection.getDBConnection();

				boolean trxns = dao.createTransaction(connection, insertTrans);
				return true;
			} catch (Exception e) {
				SimpleLogger.logger.warning("Exception: " + e.toString());
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// calling exception class...
						SimpleLogger.logger.warning("SQLException: " + e.toString());

					}
				}
			}

			return false;
		}

	}

	// select method for getTransaction.....
	public static String getTxnMethod(int id) {
		MySQLAccess dao = new MySQLAccess();

		try {
			Connection connection = DBConnection.getDBConnection();
			Collection<Transaction> trxns = dao.getTheTransactions(connection, id);
			if (!trxns.isEmpty()) {
				for (Transaction trxn : trxns) {
					SimpleLogger.logger.info(trxn.toString());
					return trxn.toString();
				}
			} else {
				if (connection != null) {
					connection.close();
				}
//				return false;
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SimpleLogger.logger.warning("Exception: " + e.toString());

		}
		
		return null;

//		return true;
	}



	private static Collection<Transaction> userInput(Collection<Transaction> insertTrans,String Name, String CardNumber,
			 double unitPrice, int qty, double totalPrice, String expDate) {
		Transaction trans = new Transaction();
		long millis = System.currentTimeMillis();
		long cardNo = 0;
		String creditCardTpye = null;
//		System.out.println("Enter the Name on the Card:");
		if(ValidationTest.validateVar(Name)) {
			trans.setNameOnCard(trans.getNameOnCard());
		}
		
		if(ValidationTest.validateVisaCard(Long.parseLong(CardNumber)) ){
			trans.setCardNumber(CardNumber);
		}else if(ValidationTest.validateAmericanExpress(Long.parseLong(CardNumber))){
			trans.setCardNumber(CardNumber);
		}else if(ValidationTest.validateMasterCard(Long.parseLong(CardNumber))) {
			trans.setCardNumber(CardNumber);
		}else {
			trans.setCardNumber(CardNumber);
		}

		trans.setCreditCardType(creditCardTpye);
//		ValidationTest.expireDateValidation(trans);
		
		trans.setCreatedBy(System.getProperty("user.name"));
//		System.out.println("Enter the Quantity:");
		trans.setQuantity(qty);
		trans.setUnitPrice(unitPrice);
		trans.setTotalPrice(totalPrice);
		trans.setCreatedOn(millis);

		insertTrans.add(trans);
		return insertTrans;
	}


	//deleting fucntion....
	
	// delete method calling deleteTransaction....
	public static boolean deleteMethod(int deleteId) {
		MySQLAccess dao = new MySQLAccess();
		Connection connection = null;
		Collection<Transaction> trxns;


		if (checkId(deleteId)) {
			try {
				boolean result = dao.deleteTransaction(connection, deleteId);
				return result;

			} catch (Exception e) {
				SimpleLogger.logger.warning("Exception: " + e.toString());

			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						SimpleLogger.logger.warning("SQLException: " + e.toString());
					}
				}
			}
		} else {
			SimpleLogger.logger.info("User don't Exists!!");
		}

		return false;

	}
	
	
	
	///update Transaction....
	
	// update method for updateTransaction
	public static boolean updateMethod(int id, String Name, String CardNumber,
			 double unitPrice, int qty, double totalPrice, String expDate) {

		Collection<Transaction> insertTrans = new ArrayList<Transaction>();

		if (!checkId(id)) {
			SimpleLogger.logger.info("Id dont exists: create new id");
			return false;
			
		} else {
			Connection connection = null;
			Transaction trans = new Transaction();

			trans.setId(id);
			insertTrans = userInput(insertTrans,Name, CardNumber,unitPrice, qty,totalPrice, expDate);

			// SQL insert......
			MySQLAccess dao = new MySQLAccess();

			try {
				connection = DBConnection.getDBConnection();

				boolean trxns = dao.updateTransaction(connection, insertTrans);
			} catch (Exception e) {
				SimpleLogger.logger.warning("Exception: " + e.toString());

			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// calling exception class...
						SimpleLogger.logger.warning("SQLException: " + e.toString());
					}
				}
			}

		}

		return false;
	}



}
