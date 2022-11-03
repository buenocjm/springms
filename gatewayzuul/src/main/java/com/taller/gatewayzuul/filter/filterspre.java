package com.taller.gatewayzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class filterspre extends ZuulFilter{

	private static Logger LOGGER = LoggerFactory.getLogger(filterspre.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("Petición {} a {}", request.getMethod(), request.getRequestURL().toString());
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
