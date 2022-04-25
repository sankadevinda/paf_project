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


@WebServlet("/SupplierAPI")
public class SupplierAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Supplier empObj = new Supplier();

	public SupplierAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Supplier empobj = new Supplier();
		
		String output = "";
		output = empobj.readSuppliers();
		
		response.getWriter().append(output);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String output = empObj.insertSuppliers(
				request.getParameter("name"),
				request.getParameter("account_number"),
				request.getParameter("units"),
				request.getParameter("unit_price"),
				request.getParameter("date"));
		response.getWriter().write(output);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		if (paras.get("hididSave") != null) {
		output = empObj.updateSuppliers(
				paras.get("hididSave").toString(),
				paras.get("name").toString(),
				paras.get("account_number").toString(),
				paras.get("units").toString(), 
				paras.get("unit_price").toString(), 
				paras.get("date").toString());
		}
		else {
			output = empObj.updateSuppliers(
					request.getParameter("hididSave"),
					request.getParameter("name"),
					request.getParameter("account_number"),
					request.getParameter("units"),
					request.getParameter("unit_price"), 
					request.getParameter("date"));
		}
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		
		if (paras.get("id") != null) {
			output = empObj.deleteSuppliers(paras.get("id").toString());
		}
		else {
			
			output = empObj.deleteSuppliers(request.getParameter("id"));
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
