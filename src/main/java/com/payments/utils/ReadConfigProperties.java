package com.payments.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties{
	static FileInputStream fis;
	static Properties prop;

	public ReadConfigProperties(){
		
		File src= new File(".\\Resource\\prop.properties");
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public String getBaseUrl() {
		String url = prop.getProperty("baseurl");		
		return url;		
	}
	
	public String setBrowser() {
		String browser = prop.getProperty("browser");	
		return browser;
	}
	
}
