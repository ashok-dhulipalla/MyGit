package com.park.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.expression.spel.InternalParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.util.webservice.serviceUtil;
import com.db.DBConnection;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.park.dao.TransactionsDao;
import com.park.dao.impl.TransactionsDaoImpl;
import com.park.exception.InternalException;
import com.park.pojo.CompanyCapacityList;
import com.park.pojo.LocalServerPOJO;
import com.park.pojo.LocalVehiclePassesList;
import com.park.util.CommonUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value="/sync")
public class SyncController {

	private TransactionsDao transactionsDao= new TransactionsDaoImpl();
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<String> syncCloudData(@RequestHeader("token") String token)
	{
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		JSONArray array= null;
		try(Connection con= DBConnection.getConnection()) {

			con.setAutoCommit(false);

			Map<String,String> headers= new HashMap<>();
			headers.put("content-type", "application/x-www-form-urlencoded");
			Map<String,Object> params= new HashMap<>();
			LocalServerPOJO server= null;
			HttpResponse<String> res = serviceUtil.callSynServiceAsString("GET", "http://localhost:8080/parkingAPI/localServer/get/"+token, headers, params);
			if(res.getStatus() == 200)
			{
				server= ConvertUtil.jsonToPojo(res.getBody(), LocalServerPOJO.class);
				CommonUtil.delete(con, "ServerDetails");
				transactionsDao.insertServerDetails(con, server);
			}
			else
				throw new InternalException(res.getBody());

			res = serviceUtil.callSynServiceAsString("GET", "http://localhost:8080/parkingAPI/vehiclePass/get/"+server.getGroupId()+"/"+server.getBusinessId()+"/"+server.getServerMacAddress(), headers, params);
			if(res.getStatus() == 200)
			{
				array= new JSONArray(res.getBody());
				json.put("list", array);
				LocalVehiclePassesList vehpassList= ConvertUtil.jsonToPojo(json.toString(), LocalVehiclePassesList.class);
				CommonUtil.delete(con, "LocalVehiclePass");
				transactionsDao.insertVehiclePass(con, vehpassList);
			}
			else
				throw new InternalException(res.getBody());

			res = serviceUtil.callSynServiceAsString("GET", "http://localhost:8080/parkingAPI/capacity/get/"+server.getGroupId()+"/"+server.getBusinessId()+"/"+server.getServerMacAddress(), headers, params);
			if(res.getStatus() == 200)
			{
				array= new JSONArray(res.getBody());
				json= new JSONObject();
				json.put("list", array);
				CompanyCapacityList capList= ConvertUtil.jsonToPojo(json.toString(), CompanyCapacityList.class);
				CommonUtil.delete(con, "CompanyCapacity");
				transactionsDao.insertCompanyCapacity(con, capList);
			}
			else
				throw new InternalException(res.getBody());

			con.commit();
			json= new JSONObject();
			json.put("status", "success");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.OK);
			return responseEntity;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", e.getMessage());
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;

	}
}
