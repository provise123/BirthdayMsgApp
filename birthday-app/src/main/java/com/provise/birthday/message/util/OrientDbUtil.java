package com.provise.birthday.message.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.provise.birthday.message.viewobject.EmployeeDetailsModel;

public class OrientDbUtil {
	
	public static ODatabaseSession getClientConnection() {
		OrientDB orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
		ODatabaseSession databaseSession = orientDB.open("BirthDayDetails", "root", "root");
		return databaseSession;
	}
	
	public static EmployeeDetailsModel getDetails(ODatabaseSession db,String DOB) {
		EmployeeDetailsModel model =new EmployeeDetailsModel();
		OResultSet rs=null;
		ObjectMapper objectMapper=new ObjectMapper();
		try{			
			String queryStr="select * from `Birthdays` where DOB = '"+DOB+"'";
			System.out.println("executing query ::"+queryStr);
			rs=db.query(queryStr);
			
			if(rs!=null)
			{
				while(rs.hasNext())
				{
					String jsonStr = rs.next().toJSON();
					Map<String,Object>  map = objectMapper.readValue(jsonStr, Map.class);					
					System.out.println("map::"+map);
					model=new EmployeeDetailsModel(map.get("firstName").toString(),map.get("lastName").toString());
				}//while ends
				return model;
				
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally{
			if(rs!=null)
				rs.close(); //closing resultset
		}
		return model;		
	}

	public static void main(String[] args) {
		OrientDbUtil dbUtil=new OrientDbUtil();
		ODatabaseSession db =dbUtil.getClientConnection();
	EmployeeDetailsModel out=	getDetails(db, "2019-06-11");
		System.out.println(out.toString());
	}
	
}
