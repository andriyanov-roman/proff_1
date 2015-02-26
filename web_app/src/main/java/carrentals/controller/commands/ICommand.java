package carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	/**
	 * Depending on request parameters and attributes values should do
	 * appropriate operations and return the results of these operations as
	 * request attribute values. Returns the result page's path
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @return the result page's path
	 * @throws javax.servlet.ServletException if a servlet-specific error occurs
	 * @throws java.io.IOException if an I/O error occurs
	 */
	public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException;
}
