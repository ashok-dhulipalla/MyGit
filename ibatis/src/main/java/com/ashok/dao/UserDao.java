package com.ashok.dao;

import com.ashok.models.UserTEO;
import com.ibatis.sqlmap.client.SqlMapClient;

public interface UserDao {

	public UserTEO addUser(UserTEO user, SqlMapClient sqlmapClient);

	public UserTEO getUserById(Integer id, SqlMapClient sqlmapClient);

	public void deleteUserById(Integer id, SqlMapClient sqlmapClient);

}
