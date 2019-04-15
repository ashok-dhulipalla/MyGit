package com.park.filters;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.db.DBConnection;
import com.park.dao.TransactionsDao;
import com.park.dao.impl.TransactionsDaoImpl;
import com.park.exception.InvalidTokenException;
import com.park.exception.TokenNotFoundException;

public class AuthFilter implements Filter{

	TransactionsDao transactionDao= new TransactionsDaoImpl();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		JSONObject json= new JSONObject();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		try(Connection con= DBConnection.getConnection()) {
			if(!httpRequest.getPathInfo().toString().startsWith("/sync"))
			{
				if(httpRequest.getHeader("token") == null)
				{
					throw new TokenNotFoundException("Token not found");
				}
				if(transactionDao.getLocalServerByToken(con, httpRequest.getHeader("token")) == null)
				{
					throw new InvalidTokenException("Invalid Token");
				}
			}
			chain.doFilter(request, response);
		} catch (InvalidTokenException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Invalid Token");
			((HttpServletResponse) response).setStatus(401);
			((HttpServletResponse) response).getWriter().write(json.toString());
		}catch (TokenNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Token Not found");
			((HttpServletResponse) response).setStatus(401);
			((HttpServletResponse) response).getWriter().write(json.toString());
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			json.put("status", "error");
			json.put("errMessage", "Internal Error");
			((HttpServletResponse) response).setStatus(500);
			((HttpServletResponse) response).getWriter().write(json.toString());
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
