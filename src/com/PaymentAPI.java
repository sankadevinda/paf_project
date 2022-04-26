package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentAPI")
public class PaymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Payment empObj = new Payment();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Payment empobj = new Payment();
		
		String output = "";
		output = empobj.readPayments();
		
		response.getWriter().append(output);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String output = empObj.insertPayments(
				request.getParameter("customer_name"),
				request.getParameter("account_number"),
				request.getParameter("date"),
				request.getParameter("payment_type"),
				request.getParameter("total_price"));
		response.getWriter().write(output);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		if (paras.get("hididSave") != null) {
		output = empObj.updatePayments(
				paras.get("hididSave").toString(),
				paras.get("customer_name").toString(),
				paras.get("account_number").toString(),
				paras.get("date").toString(), 
				paras.get("payment_type").toString(), 
				paras.get("total_price").toString());
		}
		else {
			output = empObj.updatePayments(
					request.getParameter("hididSave"),
					request.getParameter("customer_name"),
					request.getParameter("account_number"),
					request.getParameter("date"),
					request.getParameter("payment_type"), 
					request.getParameter("total_price"));
		}
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		
		if (paras.get("id") != null) {
			output = empObj.deletePayments(paras.get("id").toString());
		}
		else {
			
			output = empObj.deletePayments(request.getParameter("id"));
		}
		System.out.println("ID: " + output);
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
