package com.taller.gatewayzuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class filterpost extends ZuulFilter{

	private static Logger LOGGER = LoggerFactory.getLogger(filterpost.class);
    private static String FILTERTYPE = "post";
    private static Integer FILTERORDER = 1;
	
    
    public filterpost() {}
    
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Long timeinitial = (Long)request.getAttribute("timeInit");
		Long timefinal = System.currentTimeMillis();
		
		Long transcurrido = timeinitial - timefinal;
		
		LOGGER.info(String.format("------ Tiempo transcurrido ------"+transcurrido));
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
