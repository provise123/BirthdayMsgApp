package com.provise.birthday.message.dao;

import com.provise.birthday.message.model.EmployeeModel;

/**
 * @author swapnil.patil
 *	The Interface appDao.
 */
public interface AppDao {
	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 */
	public EmployeeModel getEmployeeList(EmployeeModel model);

	
}
