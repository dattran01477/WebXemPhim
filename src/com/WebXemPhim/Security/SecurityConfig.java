package com.WebXemPhim.Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	private static final Map<String,List<String>> map=new HashMap<String,List<String>>();
		static {
			init();
		}
		private static void init()
		{
			//cấu hình cho admin
			List<String> urlPatternsAD=new ArrayList<String>();
			urlPatternsAD.add("/EmployeeTaskServlet");
			urlPatternsAD.add("/ManagerTaskServlet");
			
			//cấu hình cho khách hầng
			List<String> urlPatternsCU=new ArrayList<String>();
			urlPatternsCU.add("/EmployeeTaskServlet");
			
			map.put("ad", urlPatternsAD);
			map.put("cu",urlPatternsCU);
		
		}
		public static Set<String> getAllRoles()
		{
			return map.keySet();
		}
		public static List<String> getAllUrlPatternForRole(String role)
		{
			return map.get(role);
		}
}
