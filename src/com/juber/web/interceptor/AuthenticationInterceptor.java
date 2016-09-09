package com.juber.web.interceptor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 不用拦截的路径集合
	 */
	private static Set<String> excludeSet;

	static {
		excludeSet = new HashSet<>();
		excludeSet.add("/login.do");
		excludeSet.add("/defaultlogin.do");
//		excludeSet.add("/com/");
//		excludeSet.add("/static/");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = true;
		
		if (hasPassport(request.getContextPath(), request.getRequestURI())) {
			return result;
		}
		if (request.getSession() == null || request.getSession().getAttribute("token") == null) {
			result = false;
				response.sendRedirect(request.getContextPath() + "/defaultlogin.do");
		}
		return result;
	}

	/**
	 * 是否能够通行
	 * 
	 * @param uri
	 * @return
	 */
	private boolean hasPassport(String ctx, String uri) {
		Iterator<String> iter = excludeSet.iterator();
		while (iter.hasNext()) {
			Pattern p = Pattern.compile(ctx + iter.next());
			Matcher m = p.matcher(uri);
			if (m.find()) {
				return true;
			}
		}
		return false;
	}
}
