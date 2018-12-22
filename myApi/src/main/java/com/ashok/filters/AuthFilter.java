package com.ashok.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter{

	String param1;
	AuthFilter auth;
	
	public AuthFilter getAuth() {
		return auth;
	}

	public void setAuth(AuthFilter auth) {
		
		System.out.println("--------------------auth initialisation: "+auth);
		this.auth = auth;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		param1= filterConfig.getInitParameter("param1");
		System.out.println("--------------------Param1: "+filterConfig.getInitParameter("param1"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("--------------------do filter: "+param1);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
