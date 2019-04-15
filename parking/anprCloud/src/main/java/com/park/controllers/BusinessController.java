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
import com.park.dao.impl.BusinessDaoImpl;
import com.park.dao.impl.BusinessGroupDaoImpl;
import com.park.pojo.BusinessGroupPOJO;
import com.park.pojo.BusinessPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/business")
public class BusinessController {
	private static BusinessDao businessDao= new BusinessDaoImpl();
	private static BusinessGroupDao businessGroupDao= new BusinessGroupDaoImpl();
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addBusiness(@RequestParam(value="json") String business)
	{

		LogUtil.logger.info("business: "+business);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			BusinessPOJO busi= ConvertUtil.jsonToPojo(business, BusinessPOJO.class);
			BusinessGroupPOJO grp;
			if((grp= businessGroupDao.selectBusinessGroupById(con, busi.getGroupId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Group Id "+busi.getGroupId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			busi.setGroupName(grp.getGroupName());
			if(businessDao.getBusiness(con, busi.getGroupId(),busi.getBusinessName()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", "Business Name "+busi.getBusinessName()+" already exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			businessDao.insertBusiness(con, busi);
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
	
	@RequestMapping(value = "/drop/{groupId}/{businessId}", method = RequestMethod.POST)
	@ResponseBody
	public String dropBusiness(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId)
	{
		return null;
	}
	
	@RequestMapping(value = "/get/{groupId}/{businessId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getBusiness(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			BusinessPOJO business = businessDao.getBusinessById(con, Integer.valueOf(groupId), Integer.valueOf(businessId));
			if(business == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Business Id "+businessId+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(business), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
	
	@RequestMapping(value = "/get/{groupId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getBusinesses(@PathVariable(value= "groupId") String groupId)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<BusinessPOJO> businesses = businessDao.getBusinesses(con, Integer.valueOf(groupId));
			if(businesses == null)
			{
				json.put("status", "error");
				json.put("errMessage", "No Businesses Found");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(businesses), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAllBuisinesses()
	{
		return null;
	}
	
	@RequestMapping(value = "/{groupId}",method = RequestMethod.GET)
	@ResponseBody
	public String getBuisinessesInGroup(@PathVariable(value= "groupId") String groupId)
	{
		return null;
	}
	
}
