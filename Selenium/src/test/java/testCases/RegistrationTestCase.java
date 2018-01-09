package testCases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

import page.RegistrationPage;

public class RegistrationTestCase extends BaseClass{
	
public static boolean status=false;
	
	@Test
	@Parameters({"FName","LName","Email","MaritalStaus","Hobby","month","day","year","Country","phone","Pass","Fileloc"})
	public void register(String FName,String LName,String Email,String MaritalStaus,String Hobby,int month,int day,int year,String Country,int phone,String Pass,String Fileloc){
		try{
		RegistrationPage rgis= new RegistrationPage();
		
		status=rgis.Register(FName, LName, Email, MaritalStaus, Hobby, month, day, year, Country, phone, Pass, Fileloc);
		
		Assert.assertTrue(status,"the resitration is not sucessfull");
		}catch(Exception e){
			log.debug(e);
		}
	}
	
	
	
	
}
