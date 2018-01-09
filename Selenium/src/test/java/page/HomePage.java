package page;

import org.openqa.selenium.By;


import base.BaseClass;
import base.TopNavigation;

public class HomePage extends BaseClass{
	
	public RegistrationPage goToRegistration(){
		driver.findElement(By.xpath(".//span[@class='path5']")).click();
		
		return new RegistrationPage();
	}
	
	public DatePickerPage goToDatePciker(){
		driver.findElement(By.xpath(".//span[@class='path5']")).click();
		
		return new DatePickerPage();
	}
	
	
	public DraggablePage goToDraggablePage(){
		driver.findElement(By.xpath(".//span[@class='path5']")).click();
		
		return new DraggablePage();
	}
	
	public DroppablePage goToDroppablePage(){
		driver.findElement(By.xpath(".//span[@class='path5']")).click();
		
		return new DroppablePage();
	}
	
	public FramesPage goTOFramesPage(){
		driver.findElement(By.xpath(".//span[@class='path5']")).click();
		
		return new FramesPage();
	}
}
