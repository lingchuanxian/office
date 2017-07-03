package cn.fjlcx.office.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fjlcx.office.bean.Admin;
import cn.fjlcx.office.bean.HttpResult;
import cn.fjlcx.office.global.MemoryData;

/**
 * Created by lcx on 2017/6/29.
 */

public class SingleUserInterceptor implements HandlerInterceptor {

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
		//如果拦截到的是登录的页面的话放行
		if(url.indexOf("login.shtml")>=0 || url.indexOf("logout.shtml")>=0){
			return true;
		}
		//如果是其他请求地址，进行拦截
		Admin admin = (Admin) request.getSession().getAttribute("admin_login_account");
		if(admin!=null){
			String sessionid = MemoryData.getSessionIDMap().get(admin.getAdId());
			//如果用户名存在放行（即登录放行）
			if(sessionid.equals(request.getSession().getId())){
				return true;
			}else{ //如果请求的sessionID和此账号Map中存放的sessionID不一致，跳转到登陆页
				//判断如果是异步请求，设置响应头 sessionstatus为timeout，自动跳转，否则重定向
				if(request.getHeader("x-requested-with")!=null
						&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
					response.setHeader("sessionstatus","timeout");
					PrintWriter out = response.getWriter();
					out.write(HttpResult.fail().toString());
					out.flush();
					out.close();
					return false;
				}else{
					String indexUrl=request.getContextPath()+"/login.shtml?msg=您的账号已在其他地方登录";
					request.getRequestDispatcher(indexUrl).forward(request, response);
					return false;
				}
			}
		}
		//如果session中没有admin，跳转到登陆页
		request.getRequestDispatcher(request.getContextPath()+"/login.shtml?msg=请先登录").forward(request, response);
		return false;
	}
}
