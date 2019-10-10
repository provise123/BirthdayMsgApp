package com.provise.birthday.message.util;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;

/**
 * @author swapnil.patil
 *	The Class AppUtil.
 */
public class EmpDBUtil {

	/**
	 * Gets the client connection.
	 *
	 * @return the client connection
	 */
	
	public static ODatabaseSession getClientConnection() {
		OrientDB orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
		ODatabaseSession databaseSession = orientDB.open("doc_DB", "root", "root");

		return databaseSession;
	}
	
	
	
	
	
	
	
	
	
}
