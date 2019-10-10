package com.provise.birthday.message.activities.db;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.provise.birthday.message.model.EmployeeModel;

/**
 * @author swapnil.patil
 *	The Class AppOps.
 */
public class AppOps {
	
	public static EmployeeModel getAllEmployeeData(ODatabaseSession db,Date DOB) {
		EmployeeModel model =new EmployeeModel();
		OResultSet rs=null;
		ObjectMapper objectMapper=new ObjectMapper();
		try{			
			String queryStr="select * from `v` where DOB = '"+DOB+"'";
			System.out.println("executing query ::"+queryStr);
			rs=db.query(queryStr);
			
			if(rs!=null)
			{
				while(rs.hasNext())
				{
					String jsonStr = rs.next().toJSON();
					Map<String,Object>  mapData = objectMapper.readValue(jsonStr, Map.class);					
					System.out.println("map::"+mapData);
					model=new  EmployeeModel(mapData.get("firstName").toString(), mapData.get("lastName").toString(),mapData.get("emailAddress").toString(),mapData.get("DOB").toString());
				}//while ends
				return model;
				
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally{
			if(rs!=null)
				rs.close(); 
		}
		return model;		
	}
	
	
}
