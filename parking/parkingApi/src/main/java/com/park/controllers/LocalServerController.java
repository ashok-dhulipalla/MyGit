package com.park.controllers;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

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
import com.park.dao.LocalServerDao;
import com.park.dao.impl.BusinessDaoImpl;
import com.park.dao.impl.BusinessGroupDaoImpl;
import com.park.dao.impl.LocalServerDaoImpl;
import com.park.pojo.BusinessGroupPOJO;
import com.park.pojo.BusinessPOJO;
import com.park.pojo.LocalServerPOJO;
import com.park.util.LogUtil;
import com.util.convert.ConvertUtil;

@RestController
@RequestMapping(value = "/localServer")
public class LocalServerController {

	private static LocalServerDao localServerDao= new LocalServerDaoImpl();
	private static BusinessGroupDao businessGroupDao= new BusinessGroupDaoImpl();
	private static BusinessDao businessDao= new BusinessDaoImpl();
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addLocalServer(@RequestParam(value="json") String localServer)
	{

		LogUtil.logger.info("localServer: "+localServer);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			LocalServerPOJO ls= ConvertUtil.jsonToPojo(localServer, LocalServerPOJO.class);
			ls.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
			BusinessGroupPOJO grp;
			if((grp = businessGroupDao.selectBusinessGroupById(con, ls.getGroupId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Group Id "+ls.getGroupId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			ls.setGroupName(grp.getGroupName());
			BusinessPOJO busi;
			if((busi= businessDao.getBusinessById(con, ls.getGroupId(), ls.getBusinessId())) == null)
			{
				json.put("status", "error");
				json.put("errMessage", "Business Id "+ls.getBusinessId()+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			ls.setBusinessName(busi.getBusinessName());
			if(localServerDao.getLocalServer(con, ls.getGroupId(), ls.getBusinessId(), ls.getServerMacAddress()) != null)
			{
				json.put("status", "error");
				json.put("errMessage", "Locale Server "+ls.getServerMacAddress()+" already exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			localServerDao.insertLocalServer(con, ls);
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
	public String dropLocalServer(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId)
	{
		return null;
	}
	
/*	@RequestMapping(value = "/get/{groupId}/{businessId}/{serverMacAddress}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getLocalServer(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId, @PathVariable(value= "serverMacAddress") String serverMacAddress)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			LocalServerPOJO ls = localServerDao.getLocalServer(con, Integer.valueOf(groupId), Integer.valueOf(businessId), serverMacAddress);
			if(ls == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Local Server "+serverMacAddress+" not exist");
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(ls), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}*/
	
	@RequestMapping(value = "/get/{token}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getLocalServerByToken(@PathVariable(value= "token") String token)
	{

		LogUtil.logger.info("token: "+token);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			LocalServerPOJO ls = localServerDao.getLocalServerByToken(con,token);
			if(ls == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Local Servers not exist for requested token: "+token);
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(ls), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
	
	@RequestMapping(value = "/get/{groupId}/{businessId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getLocalServersByBusiness(@PathVariable(value= "groupId") String groupId,@PathVariable(value= "businessId") String businessId)
	{

		LogUtil.logger.info("groupId: "+groupId);
		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try (Connection con= DBConnection.getConnection()){
			List<LocalServerPOJO> ls = localServerDao.getLocalServersByBusiness(con, Integer.valueOf(groupId), Integer.valueOf(businessId));
			if(ls == null)
			{
				json.put("status", "error");
				json.put("errMessage", " Local Servers not exist for business Id "+businessId);
				responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity= new ResponseEntity<String>(ConvertUtil.pojoToJsonString(ls), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	
	}
}
