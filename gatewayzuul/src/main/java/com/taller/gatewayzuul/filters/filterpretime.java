package com.taller.gatewayzuul.filters;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class filterpretime extends ZuulFilter{

	private static Logger LOGGER = LoggerFactory.getLogger(filterpretime.class);
    private static String FILTERTYPE = "pre";
    private static Integer FILTERORDER = 1;
	
    public filterpretime() {}
    
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Long timeinit = System.currentTimeMillis();
		request.setAttribute("timeInit", timeinit);
		
		LOGGER.info(String.format("%s------ Request hacia ------%s "+request.getAttribute("timeInit"), request.getMethod(), request.getRequestURL().toString()));
	  
	     StringBuffer strLog=new StringBuffer();
	     strLog.append("\n------ validando header ------\n");	    
	     
	     try {	    	
    		 String url=UriComponentsBuilder.fromHttpUrl("http://localhost:8080/").path("/cliente").build().toUriString();
    		 String usuario=ctx.getRequest().getHeader("usuario")==null?"":ctx.getRequest().getHeader("usuario");
    	     
    		 if (!usuario.equals(""))
    	     {
    	    	if (usuario.equals("user"))
    	    	{
	    	    	String msgError="Usuario invalidos";
	    	    	strLog.append("\n"+msgError+"\n");	  
	    	    	ctx.setResponseBody(msgError);
	    	    	ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
	    	    	ctx.setSendZuulResponse(false); 
	    	    	LOGGER.info(strLog.toString());	    	    	
	    	    	return null;
    	    	}
    	    	ctx.setRouteHost(new URL(url));
    	     }	    	     	    	
		} catch ( IOException e) {

			e.printStackTrace();
		}
	    
	     LOGGER.info(strLog.toString());

		
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return FILTERORDER;
	}


}
