package com.provise.birthday.message.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// TODO: Auto-generated Javadoc
/**
 * @author shreegowri.j This Class ReadPropFile :: reads the property file
 *         config ands saves the data as key value in the Hash Map
 */
public class ReadPropFile {
	Logger logger = LoggerFactory.getLogger(ReadPropFile.class);
	public static void main(String[] args) {

		ReadPropFile readProp = new ReadPropFile();

		System.out.println(readProp.getPropValues());
	}

	/** The input stream. */
	InputStream inputStream;

	//private final Logger log = LoggerFactory.getLogger(ReadPropFile.class);

	/** The result. */
	String result = "";

	/**
	 * Reads the prop values.
	 *
	 * @return the prop values
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public Map<String, String> getPropValues() {
		logger.info("Entered into the getPropValue()");
		Map propertyData = new HashMap();
		String propFileName = "db/db.config";
		try {
			Properties prop = new Properties();

			inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {

				throw new FileNotFoundException("property file '" + propFileName
						+ "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());
			String dbUserName = prop.getProperty("dbUserName");
			String dbPassword = prop.getProperty("dbPassword");
			String dbName = prop.getProperty("dbName");
			String dbUrl = prop.getProperty("dbUrl");
			String dbHost = prop.getProperty("dbHost");
			
			propertyData.put("dbUserName", dbUserName);
			propertyData.put("dbPassword", dbPassword);
			propertyData.put("dbName", dbName);
			propertyData.put("dbUrl", dbUrl);
			propertyData.put("dbHost", dbHost);
		} catch (Exception e) {
			logger.info("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("Exting the getPropFile, propertyData::"+propertyData);
		return propertyData;
	}

}
