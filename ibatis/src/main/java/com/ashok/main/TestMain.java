package com.ashok.main;

import java.io.Reader;
import java.util.Date;

import com.ashok.dao.UserDao;
import com.ashok.dao.UserDaoIbatis;
import com.ashok.models.UserTEO;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestMain
{
    public static void main(String[] args) throws Exception
    {
        //Initialize dao
        UserDao manager = new UserDaoIbatis();
 
        //Create the SQLMapClient
        Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
        SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
 
        //Create a new user to persist
        UserTEO user = new UserTEO();
        user.setId(1);
        user.setName("Demo User");
        user.setPassword("password");
        user.setEmail("demo-user@howtodoinjava.com");
        user.setStatus(1);
        user.setCreatedDate(new Date());
 
        //Add the user
        manager.addUser(user,sqlmapClient);
 
        //Fetch the user detail
        UserTEO createdUser = manager.getUserById(1, sqlmapClient);
        System.out.println(createdUser.getEmail());
 
        //Lets delete the user
        //manager.deleteUserById(1, sqlmapClient);
    }
}
