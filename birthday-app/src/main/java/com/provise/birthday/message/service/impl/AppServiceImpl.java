package com.provise.birthday.message.service.impl;

import com.provise.birthday.message.dao.AppDao;
import com.provise.birthday.message.dao.impl.AppDaoImpl;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.service.AppService;

/**
 * @author swapnil.patil
 *	The Class appServiceImpl.
 */
public class AppServiceImpl implements AppService{

	public static AppDao appDao =  new AppDaoImpl();
	
	public EmployeeModel getEmployeeList(EmployeeModel model) {
		EmployeeModel employeeModels = appDao.getEmployeeList(model);
		return employeeModels;
	}

	
}
