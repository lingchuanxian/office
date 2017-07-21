package cn.fjlcx.office.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lcx on 2017/6/29.
 */

public class AuthTokenInterceptor implements HandlerInterceptor {
	@Autowired
	HttpSession session;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("login.shtml")>=0 || url.indexOf("logout.shtml")>=0){
			return true;
		}

		String ticket = request.getParameter("ticket");


		return true;
	}
}
