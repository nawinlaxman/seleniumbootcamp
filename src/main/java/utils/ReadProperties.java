package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static String getElementValue(String fileName, String key ){

		Properties prop = new Properties();
		String value = null;


		FileInputStream filepath;
		try {
			filepath = new FileInputStream("./ObjectRepositories/"+fileName+".properties");
			prop.load(filepath);
			value = prop.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}

}
