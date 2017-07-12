package cn.fjlcx.office.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fjlcx.office.bean.ActionLog;

/**
 *
 * 记录信息:</br> 访问时间</br>Controller路径</br>对应方法名</br>请求参数信息</br>请求相对路径</br>请求处理时长
 *
 */

public class LogInterceptor implements HandlerInterceptor {

	ActionLog al = new ActionLog();
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		if (handler instanceof HandlerMethod) {
			StringBuilder sb = new StringBuilder(1000);
			HandlerMethod h = (HandlerMethod) handler;

			al.setAlController(h.getBean().getClass().getName());
			al.setAlMethod(h.getMethod().getName());
			al.setAlParams(getParamString(request.getParameterMap()));
			al.setAlUri(request.getRequestURI());

			sb.append("-----------------------").append(System.currentTimeMillis())
					.append("-------------------------------------\n");
			sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
			sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
			sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
			sb.append("URI       : ").append(request.getRequestURI()).append("\n");
			System.out.println(sb.toString());
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		if(handler instanceof HandlerMethod){
			StringBuilder sb = new StringBuilder(1000);
			al.setAlCostTime(executeTime);
			System.out.println(sb.toString());
		}
	}

	private String getParamString(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,String[]> e:map.entrySet()){
			sb.append(e.getKey()).append("=");
			String[] value = e.getValue();
			if(value != null && value.length == 1){
				sb.append(value[0]).append("\t");
			}else{
				sb.append(Arrays.toString(value)).append("\t");
			}
		}
		return sb.toString();
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		//存入数据库
	}
}
