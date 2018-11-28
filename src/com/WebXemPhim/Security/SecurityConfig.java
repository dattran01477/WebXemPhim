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
			//cấu hình cho khách hầng
			List<String> urlPatternsCU=new ArrayList<String>();
			urlPatternsCU.add("/DatVe");
			
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
