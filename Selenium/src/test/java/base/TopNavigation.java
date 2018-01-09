package base;



import org.openqa.selenium.By;



public class TopNavigation extends BaseClass {

	
	public boolean Aboutus(String AboutActual){
		
		boolean bvalue =false;
		
		driver.findElement(By.xpath(".//a[text()='About us']")).click();;
		
		String AboutUs = driver.findElement(By.xpath(".//*[@id='post-156']/div/p")).getText();
        log.debug(AboutUs);
        System.out.println(AboutActual);
         if(AboutUs.equals(AboutActual)){
        	 bvalue=true;
         }

         System.out.println("Bvale for Aboutus"+bvalue);
         return bvalue;
	}
	


	
	public boolean contact(String Name,String Email,String Subject,String Message) throws InterruptedException{
		 boolean bvalue=false;
		 driver.findElement(By.xpath(".//a[text()='Contact']")).click();
		 driver.findElement(By.name("your-name")).sendKeys(Name);
		 driver.findElement(By.xpath(".//input[@type='email']")).sendKeys(Email);
		 driver.findElement(By.name("your-subject")).sendKeys(Subject);
		 driver.findElement(By.name("your-message")).sendKeys(Message);
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(".//input[@type='submit']")).click();
		 
		 bvalue=BaseClass.isElementPresent(By.xpath(".//form/div[text()='Your message was sent successfully. Thanks.']")); 
		 System.out.println("Bvale for contact"+bvalue);
		return bvalue;

	}
	
	
	
}
