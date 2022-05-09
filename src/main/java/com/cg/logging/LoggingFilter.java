package com.cg.logging;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class LoggingFilter extends OncePerRequestFilter {
	
    public final static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
		long startTime = System.currentTimeMillis();
		filterChain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);
		long timeTaken = System.currentTimeMillis() - startTime;
		
		
	logger.info("Filter logs : Method ={} ; RequestURL = {}; Response Code = {} ;Time Taken= {}",
		       request.getMethod() , request.getRequestURI() ,response.getStatus() ,  timeTaken);
	contentCachingResponseWrapper.copyBodyToResponse();
	}
}
