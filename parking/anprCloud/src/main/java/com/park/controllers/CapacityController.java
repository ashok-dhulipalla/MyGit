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
import com.park.dao.BusinessDao;
import com.park.dao.BusinessGroupDao;
import com.park.dao.CapacityDao;
import com.park.dao.LocalServerDao;
import com.park.dao.impl.BusinessDaoImpl;
import com.park.dao.impl.BusinessGroupDaoImpl;
import com.park.dao.impl.CapacityDaoImpl;
import com.park.dao.impl.LocalServerDaoImpl;
import com.park.pojo.BusinessGroupPOJO;
import com.park.pojo.BusinessPOJO;
import com.park.pojo.CapacityPOJO;
import com.park.pojo.LocalServerPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/capacity")
public class CapacityController {

	private static LocalServerDao localServerDao= new LocalServerDaoImpl();
	private static BusinessGroupDao businessGroupDao= new BusinessGroupDaoImpl();
	private static BusinessDao businessDao= new BusinessDaoImpl();
	private static CapacityDao capacityDao= new CapacityDaoImpl();
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addCapacity(@RequestParam(value="json") String capacity)
	{

		LogUtil.logger.info("capacity: "+capacity);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			CapacityPOJO cap= ConvertUtil.jsonToPojo(capacity, CapacityPOJO.class);
			BusinessGroupPOJO grp;
			if((grp= businessGroupDao.selectBusinessGroupById(con, cap.getGroupId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Group Id "+cap.getGroupId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			cap.setGroupName(grp.getGroupName());
			BusinessPOJO busi;
			if((busi= businessDao.getBusinessById(con, cap.getGroupId(), cap.getBusinessId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Business Id "+cap.getBusinessId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			cap.setBusinessName(busi.getBusinessName());
			LocalServerPOJO ls;
			if((ls= localServerDao.getLocalServer(con, cap.getGroupId(), cap.getBusinessId(), cap.getServerMacAddress())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Locale Server "+cap.getServerMacAddress()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			cap.setServerName(ls.getServerName());
			if(capacityDao.getCapacity(con, cap.getGroupId(), cap.getBusinessId(), cap.getServerMacAddress(), cap.getCompanyName()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", "Comapny "+cap.getCompanyName()+" capacity already exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			capacityDao.insertCapacity(con, cap);
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
	public ResponseEntity<String> getCapacityByCompany(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId, @PathVariable(value= "serverMacAddress") String serverMacAddress, @PathVariable(value= "companyName") String companyName)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			CapacityPOJO cap = capacityDao.getCapacity(con, Integer.valueOf(groupId), Integer.valueOf(businessId), serverMacAddress, companyName);
			if(cap == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Company "+companyName+" capacity not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(cap), HttpStatus.OK);
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
	public ResponseEntity<String> getCapacity(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId, @PathVariable(value= "serverMacAddress") String serverMacAddress)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<CapacityPOJO> cap = capacityDao.getCapacity(con, Integer.valueOf(groupId), Integer.valueOf(businessId), serverMacAddress);
			if(cap == null)
			{
				json.put("status", "error");
				json.put("errMessage", " serverMacAddress "+serverMacAddress+" capacity not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(cap), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
}
