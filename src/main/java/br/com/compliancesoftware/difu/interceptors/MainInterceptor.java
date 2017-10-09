package br.com.compliancesoftware.difu.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Intercepta solicitações (requests) antes de entregar ao controller
 * @author douglas.f.filho
 *
 */
public class MainInterceptor extends HandlerInterceptorAdapter{

	private String[] permissions = new String[]{
			"resources",
			"home",
			"getmessage",
			"sendmessage"
	};	
	
	private boolean containsPermission(String uri){
		boolean contains = false;
		for(String p : permissions){
			if(uri.contains(p))
				contains = true;
		}
		return contains;
	}
	
	@Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object controller)
	 {
		  try{
			  String uri = request.getRequestURI();
			  System.out.println("[MainInterceptor]::preHandle:: URI (url: "+uri+")");
			  if(containsPermission(uri)){
				  return true;
			  }
			  
			  else{
				  response.sendRedirect("home");
				  return false;
			  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  return false;
		  }
	 }

}