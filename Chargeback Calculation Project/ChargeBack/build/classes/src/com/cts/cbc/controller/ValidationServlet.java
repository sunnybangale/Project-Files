package com.cts.cbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.cbc.bo.UserBO;
import com.cts.cbc.exceptions.BusinessException;
import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.vo.UserVo;






/**
 * Servlet implementation class ValidationServlet
 */
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(ValidationServlet.class);
	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {

		final UserVo voObject = new UserVo();
		final HttpSession https = request.getSession();
		
		voObject.setUserId(request.getParameter("userId"));
		voObject.setPassword(request.getParameter("password"));
		voObject.setRoleType(request.getParameter("roleType"));
		
	
		
	
		try {
			if (new UserBO().validateUser(voObject)) {
			
				
				if(voObject.getRoleType().equals("BR"))
				{
					https.setAttribute("loggedIn", 1);
					LOG.info(new Date()+"  Bank representative logged in with userId  "+voObject.getUserId());
					response.sendRedirect("RoleSelection.jsp");
				
				}
				if(voObject.getRoleType().equals("INDL"))
				{	
					
					https.setAttribute("user",voObject);
					https.setAttribute("loggedIn", 1);
					LOG.info(new Date()+"  Individual user logged in with userId  "+voObject.getUserId());
					response.sendRedirect("displayforindividualuser.jsp");
										
				}
				if(voObject.getRoleType().equals("FUND"))
				{	
					
					https.setAttribute("user",voObject);
					https.setAttribute("loggedIn",1);
					LOG.info(new Date()+"  Fund user logged in with userId  "+voObject.getUserId());
					response.sendRedirect("displayforfunduser.jsp");
				}
				
	/*			if(vo.getRoleType().equals("INDL") || vo.getRoleType().equals("FUND"))
				{response.sendRedirect("success.jsp");}*/
				
				
			} else {
				response.sendRedirect("error.jsp");
			}
		
		}
		catch (DBException e) {
			LOG.info(new Date()+e.getMessage()+ValidationServlet.class.getName());
			
		} catch (BusinessException e) {
			LOG.info(new Date()+e.getMessage()+ValidationServlet.class.getName());
		} catch (SQLException e) {
			LOG.info(new Date()+e.getMessage()+ValidationServlet.class.getName());
			
		} catch (ClassNotFoundException e) {
			LOG.info(new Date()+e.getMessage()+ValidationServlet.class.getName());
		}
		

	
	

		
		
	}
}
