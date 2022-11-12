package com.taller.gatewayzuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
