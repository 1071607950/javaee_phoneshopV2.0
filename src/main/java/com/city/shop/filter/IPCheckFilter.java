package com.city.shop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * IP拦截检查过滤器
 */
@WebFilter("/*")
public class IPCheckFilter implements Filter {
	String ips="";
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("IP检查过滤器.....");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri=req.getRequestURI();
		
		if(uri.contains("404") ){
			request.setAttribute("msg", "你的Ip不允许访问");
			chain.doFilter(request, response);
		}
		else{
			String ip=req.getRemoteAddr();
			System.out.println(ip);
			if(ips.contains(ip)){
				res.sendRedirect("/Phoneshop/404.jsp");
			}
			else{
				chain.doFilter(request, response);
			}
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
