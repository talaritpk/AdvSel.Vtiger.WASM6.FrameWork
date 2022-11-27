package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author tpkta
 *
 */
public class PropertyFileLibrary {
	
	/**
	 * This method will read value from property file for the the key given by user
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsLibrary.propertyFilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
	}
	
}
