package com.WebXemPhim.Security;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.WebXemPhim.model.UserAccount;


public class SecurityUtils {
	public static boolean isSeacurityPage(HttpServletRequest request)
	{
		String urlPattern=UrlPatternUtils.getUrlPattern(request);
		Set<String> roles=SecurityConfig.getAllRoles();
		for(String role:roles)
		{
			List<String> urlPatterns=SecurityConfig.getAllUrlPatternForRole(role);
			if(urlPattern!=null&&urlPatterns.contains(urlPattern))
			{
				return true;
			}
			
		}
		return false;
	}
	public static boolean hasPermission(HttpServletRequest request)
	{
		
		String urlPattern=UrlPatternUtils.getUrlPattern(request);
		
		UserAccount user= (UserAccount)request.getSession().getAttribute("loginedUser");
		List<String> roles=user.getRoles();

		for (String role : roles) {
			List<String> urlPatterns=SecurityConfig.getAllUrlPatternForRole(role);
			if(urlPattern!=null&&urlPatterns.contains(urlPattern))
			{
				return true;
			}
		}
		
			
	
		return false;
		
	}
}
