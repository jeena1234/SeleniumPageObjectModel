package testCases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseClass;
import base.TopNavigation;


public class TopnavigationTestCases extends BaseClass {
	
	private static boolean status=false;
	TopNavigation nav =new TopNavigation();
	
	@Test(priority=1)
	@Parameters({ "AboutUsactual"})
	public void getinfo(String AboutUsactual,ITestContext context){
	
		try{
			status =nav.Aboutus(AboutUsactual);
			Assert.assertTrue(status,"Incorrect Abuot us ");
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
	}
	
	@Test(priority=0)
	@Parameters({"Name","Email","Subject","Message"})
	public void contactInfo(String Name,String Email,String Subject,String Message, ITestContext context){
		
		try{
			
			status=nav.contact(Name, Email, Subject, Message);
		
		Assert.assertTrue(status, "The contact info is not sent");
		
		
	}catch(Exception e){
		log.debug(e+"The contact info is not sent");
		
	}

}
}
