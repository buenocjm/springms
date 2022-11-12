package com.taller.gatewayzuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class filterspre extends ZuulFilter{

	private static Logger LOGGER = LoggerFactory.getLogger(filterspre.class);
    private static String FILTERTYPE = "pre";
    private static Integer FILTERORDER = 1;
    
    public filterspre() {}
    

	@Override
	public Object run() throws ZuulException {
		 StringBuffer strLog=new StringBuffer();
	     strLog.append("\n------ LO QUE TRAE PREFILTER ------\n");	  
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("\\n------ LO QUE TRAE PREFILTER ------\\n Petición {} a {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
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
