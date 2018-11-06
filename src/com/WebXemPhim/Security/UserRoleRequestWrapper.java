package com.WebXemPhim.Security;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

	  	private String user;
	   	private List<String> roles = null;
	    private HttpServletRequest realRequest;
	public UserRoleRequestWrapper(String user, List<String> roles,HttpServletRequest request) {
		super(request);
		this.user=user;
		this.roles=roles;
		this.realRequest=request;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Principal getUserPrincipal() {
		if(user==null)
			return this.realRequest.getUserPrincipal();
			return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
	}
	@Override
	public boolean isUserInRole(String role) {
		if(role==null)
		{
			return false;
		}
		return this.roles.contains(role);
	}

}
