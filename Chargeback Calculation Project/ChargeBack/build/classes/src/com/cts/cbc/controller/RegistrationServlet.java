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
import com.cts.cbc.dao.LoginUserDAO;
import com.cts.cbc.exceptions.BusinessException;
import com.cts.cbc.exceptions.DBException;
import com.cts.cbc.vo.UserVo;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(RegistrationServlet.class);
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(final HttpServletRequest request,final  HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("in servlet");
		String userId=null;
		final String firstName=request.getParameter("firstName");
		final String lastName=request.getParameter("lastName");
		final String password=request.getParameter("password");
		final String roleType=request.getParameter("roleType");
		final String gender=request.getParameter("gender");
		final int age=Integer.parseInt(request.getParameter("age").toString());
		final long mobile=Long.parseLong(request.getParameter("mobile").toString());
		final String email=request.getParameter("email");
		final String address=request.getParameter("address");
		final String country=request.getParameter("country");
		final String city=request.getParameter("city");
		final int zipCode=Integer.parseInt(request.getParameter("zipCode"));
		final double balanceDollar = Double.parseDouble(request.getParameter("balance"));
		

		
		final UserVo voObject = new UserVo(firstName, lastName, password, roleType, gender, age, mobile, email, address, city, zipCode, balanceDollar, country);
		//System.out.println("after vo");
		
		
		//System.out.println(request.getParameter("searchTextField"));
		
		try {
			if (new UserBO().validateUserForRegistration(voObject)) {
				//System.out.println("before dao");
				final LoginUserDAO dao = new LoginUserDAO();
				userId=dao.setUser(voObject);
				//System.out.println(userId);
				
				final HttpSession https=request.getSession();
				https.setAttribute("user",voObject);
				https.setAttribute("userId",userId);
				response.sendRedirect("registereduserpage.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		}
		catch (DBException e) {
			LOG.info(new Date()+e.getMessage()+RegistrationServlet.class.getName());
		} catch (BusinessException e) {
			LOG.info(new Date()+e.getMessage()+RegistrationServlet.class.getName());
		} catch (SQLException e) {
			LOG.info(new Date()+e.getMessage()+RegistrationServlet.class.getName());
		} catch (ClassNotFoundException e) {
			LOG.info(new Date()+e.getMessage()+RegistrationServlet.class.getName());
		}
		
	}

}
