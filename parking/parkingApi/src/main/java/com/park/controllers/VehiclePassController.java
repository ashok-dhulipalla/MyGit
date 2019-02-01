package com.park.controllers;

import java.io.StringWriter;
import java.sql.Connection;
import java.util.List;

import org.json.JSONArray;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.park.dao.BusinessDao;
import com.park.dao.BusinessGroupDao;
import com.park.dao.LocalServerDao;
import com.park.dao.VehiclePassDao;
import com.park.dao.impl.BusinessDaoImpl;
import com.park.dao.impl.BusinessGroupDaoImpl;
import com.park.dao.impl.LocalServerDaoImpl;
import com.park.dao.impl.VehiclePassDaoImpl;
import com.park.pojo.BusinessGroupPOJO;
import com.park.pojo.BusinessPOJO;
import com.park.pojo.LocalServerPOJO;
import com.park.pojo.VehiclePassPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/vehiclePass")
public class VehiclePassController {

	private static LocalServerDao localServerDao= new LocalServerDaoImpl();
	private static BusinessGroupDao businessGroupDao= new BusinessGroupDaoImpl();
	private static BusinessDao businessDao= new BusinessDaoImpl();
	private static VehiclePassDao vehiclePassDao= new VehiclePassDaoImpl();
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addPass(@RequestParam(value="json") String pass)
	{

		LogUtil.logger.info("capacity: "+pass);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			VehiclePassPOJO vehpass= ConvertUtil.jsonToPojo(pass, VehiclePassPOJO.class);
			BusinessGroupPOJO grp;
			if((grp = businessGroupDao.selectBusinessGroupById(con, vehpass.getGroupId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Group Id "+vehpass.getGroupId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			vehpass.setGroupName(grp.getGroupName());
			BusinessPOJO busi;
			if((busi= businessDao.getBusinessById(con, vehpass.getGroupId(), vehpass.getBusinessId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Business Id "+vehpass.getBusinessId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			vehpass.setBusinessName(busi.getBusinessName());
			LocalServerPOJO ls;
			if((ls= localServerDao.getLocalServer(con, vehpass.getGroupId(), vehpass.getBusinessId(), vehpass.getServerMacAddress())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Locale Server "+vehpass.getServerMacAddress()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			vehpass.setServerName(ls.getServerName());
			vehiclePassDao.insertVehiclePass(con, vehpass);
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
	
	
	@RequestMapping(value = "/get/{groupId}/{businessId}/{serverMacAddress}/{companyName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getpassesByCompany(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId, @PathVariable(value= "serverMacAddress") String serverMacAddress, @PathVariable(value= "companyName") String companyName)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<VehiclePassPOJO> passes = vehiclePassDao.getVehiclePasses(con, Integer.valueOf(groupId), Integer.valueOf(businessId), serverMacAddress, companyName);
			if(passes == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Company "+companyName+" passes don't not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(passes), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
	
	@RequestMapping(value = "/get/{groupId}/{businessId}/{serverMacAddress}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getpasses(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId, @PathVariable(value= "serverMacAddress") String serverMacAddress)
	{
		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<VehiclePassPOJO> passes = vehiclePassDao.getVehiclePasses(con, Integer.valueOf(groupId), Integer.valueOf(businessId), serverMacAddress);
			if(passes == null)
			{
				json.put("status", "error");
				json.put("errMessage", " server Mac Address "+serverMacAddress+" passes don't not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(passes), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
}
