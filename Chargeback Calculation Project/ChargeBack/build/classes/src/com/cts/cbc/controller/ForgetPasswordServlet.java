
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

/**
 * Servlet implementation class ForgetPasswordServlet
 */
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(ForgetPasswordServlet.class);
       
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		final HttpSession https = request.getSession();
		
		//response.sendRedirect("Chargeback.jsp");
		
		//System.out.println("in servlet");
		
		final String userId=request.getParameter("userId");
		final String mobile=request.getParameter("mobile");
		String password=null;
		
		
		final UserBO userbo = new UserBO();
		try {
			password = userbo.validateUserForPassword(userId, mobile);
		} catch (DBException e) {
			LOG.info(new Date()+e.getMessage()+ForgetPasswordServlet.class.getName());
		} catch (BusinessException e) {
			LOG.info(new Date()+e.getMessage()+ForgetPasswordServlet.class.getName());
		} catch (ClassNotFoundException e) {
			LOG.info(new Date()+e.getMessage()+ForgetPasswordServlet.class.getName());
		} catch (SQLException e) {
			LOG.info(new Date()+e.getMessage()+ForgetPasswordServlet.class.getName());
		}
		
		//System.out.println(b);
		if(password==null){
			response.sendRedirect("error.jsp");
		}
		else if(password!=null){
			
			https.setAttribute("userId",userId);
			https.setAttribute("password",password);
			response.sendRedirect("passwordupdate.jsp");
			
			
		}
	}

}

