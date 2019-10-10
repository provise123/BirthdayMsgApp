package com.provise.birthday.message.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.service.AppService;
import com.provise.birthday.message.service.impl.AppServiceImpl;

/**
 * @author swapnil.patil
 *
 */
public class EmployeeController {

	public static AppService appService = new AppServiceImpl();
	@GET
	@Path("empList")
	public EmployeeModel getEmpList(EmployeeModel model)
	{
		
		System.out.println("ABCD");
		EmployeeModel bdayEmployeeList = appService.getEmployeeList(model);
		System.out.println("AAAAAAAAAAA"+bdayEmployeeList);
		return bdayEmployeeList;
	}
}
