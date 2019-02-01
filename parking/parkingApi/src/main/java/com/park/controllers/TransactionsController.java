package com.park.controllers;

import java.sql.Connection;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.DBConnection;
import com.park.dao.TransactionsDao;
import com.park.dao.impl.TransactionsDaoImpl;
import com.park.pojo.TransactionsPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionsController {

	TransactionsDao transactionDao= new TransactionsDaoImpl();
	
	@RequestMapping(value = "/entry", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addTransaction(@RequestParam(value="json") String trans)
	{
		LogUtil.logger.info("transaction: "+trans);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			TransactionsPOJO transaction= ConvertUtil.jsonToPojo(trans, TransactionsPOJO.class);
			String validation;
			if((validation= transaction.entryValidation()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", validation);
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			List<TransactionsPOJO> oldTransList= transactionDao.getTransactionOfVehicle(con, transaction.getFullLicencePlate());
			if(oldTransList != null && oldTransList.get(0).getExitTime() == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Vehicle "+transaction.getFullLicencePlate()+" already entered");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			if(!transactionDao.isCapacityAvailable(con, transaction.getCompanyName(), transaction.getVehicleType()))
			{
				json.put("status", "error");
				json.put("errMessage", "Capacity is full");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			transactionDao.insertTrnsactions(con, transaction);
			transactionDao.decreaseAvailableCapacity(con,  transaction.getCompanyName(), transaction.getVehicleType());
			json.put("status", "success");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> closeTransaction(@RequestParam(value="json") String trans)
	{
		LogUtil.logger.info("transaction: "+trans);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			TransactionsPOJO transaction= ConvertUtil.jsonToPojo(trans, TransactionsPOJO.class);
			String validation;
			if((validation= transaction.exitValidation()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", validation);
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			TransactionsPOJO oldTransaction= transactionDao.getTransactionOfVehicle(con, transaction.getFullLicencePlate(),transaction.getTransactionId());
			if(oldTransaction != null && oldTransaction.getExitTime() != null)
			{
				json.put("status", "error");
				json.put("errMessage", "Vehicle "+transaction.getFullLicencePlate()+" not entered");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			TransactionsPOJO response= transactionDao.updateExitTime(con, transaction.getFullLicencePlate(),transaction.getTransactionId(),transaction.getExitImagePath());
			transactionDao.increaseAvailableCapacity(con,  transaction.getCompanyName(), transaction.getVehicleType());
			json= new JSONObject(ConvertUtil.pojoToJsonString(response));
			json.put("status", "success");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/get/{fullLicencePlate}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getLatestTransaction(@PathVariable(value="fullLicencePlate") String fullLicencePlate)	{
		LogUtil.logger.info("fullLicencePlate: "+fullLicencePlate);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<TransactionsPOJO> oldTransaction= transactionDao.getTransactionOfVehicle(con, fullLicencePlate);
			if(oldTransaction != null && oldTransaction.isEmpty())
			{
				json.put("status", "error");
				json.put("errMessage", "No trnsactions found");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			json= new JSONObject(ConvertUtil.pojoToJsonString(oldTransaction.get(0)));
			json.put("status", "success");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
