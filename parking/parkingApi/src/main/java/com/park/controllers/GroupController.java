package com.park.controllers;

import java.sql.Connection;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.DBConnection;
import com.park.dao.BusinessGroupDao;
import com.park.dao.impl.BusinessGroupDaoImpl;
import com.park.pojo.BusinessGroupPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
	private static BusinessGroupDao businessGroupDao= new BusinessGroupDaoImpl();
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addGroup(@RequestParam(value="json") String group)
	{
		LogUtil.logger.info("group: "+group);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			BusinessGroupPOJO grp= ConvertUtil.jsonToPojo(group, BusinessGroupPOJO.class);
			if(businessGroupDao.selectBusinessGroup(con, grp.getGroupName()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", "Group Name "+grp.getGroupName()+" already exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			businessGroupDao.insertBusinessGroup(con, grp);
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
	
	@RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<String> getGroup(@PathVariable(value="groupId") String groupId)
	{
		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			BusinessGroupPOJO grp = businessGroupDao.selectBusinessGroupById(con, Integer.valueOf(groupId));
			if(grp == null)
			{
				json.put("status", "error");
				json.put("errMessage", "GroupId "+groupId+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(grp), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
