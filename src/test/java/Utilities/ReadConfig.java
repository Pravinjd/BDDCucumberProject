package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="config.properties";
	
	//constructor//
	public ReadConfig() throws Exception
	{
		properties =new Properties();
		
		//open config.properties file to read & load that file
		FileInputStream fis =new FileInputStream(path);
		properties.load(fis);
	}
	
	public String getBrowser() 
	{
		String value=properties.getProperty("browser"); //browser value copy paste karun ghyaychi config.properies file madun bcz its case sesnsitive
		
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("browser not matched");
		}
	}
}
