package com.WebXemPhim.Security;

import java.io.IOException;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.AppUtils.AppUtils;
import com.WebXemPhim.model.UserAccount;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse resp = (HttpServletResponse) response;
	     
		 String servletPath = req.getServletPath();
		 
		 UserAccount loginedUser = AppUtils.getLoginedUser(req.getSession());
		 
		 if (servletPath.equals("/Login")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        HttpServletRequest wrapRequest = req;
	 
	        if (loginedUser != null) {
	            // User Name
	            String userName = loginedUser.getUser(); 
	            List<String> roles = loginedUser.getRoles();
	            // Gói request cũ bởi một Request mới với các thông tin userName và Roles.
	            wrapRequest = new UserRoleRequestWrapper(userName, roles, req);
	        }
	 
	       
	        if (SecurityUtils.isSeacurityPage(req)) {
	 
	            // Nếu người dùng chưa đăng nhập,
	            // Redirect (chuyển hướng) tới trang đăng nhập.
	            if (loginedUser == null) {
	                String requestUri = req.getRequestURI();
	                // Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
	                int redirectId = AppUtils.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
	                resp.sendRedirect(wrapRequest.getContextPath() + "/Login?redirectId=" + redirectId);
	                return;
	            }
	 
	            // Kiểm tra người dùng có vai trò hợp lệ hay không?
	            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
	            if (!hasPermission) {
	 
	                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/View/accessDenied.jsp");
	                dispatcher.forward(request, response);
	                return;
	            }
	        }
	 
	        chain.doFilter(wrapRequest, response);
	    }
	 
	     
	

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
