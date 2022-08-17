package week6.day1.assignments.mandatory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DuplicateLead extends LeafTapsBaseClass{
	@Test(dependsOnMethods="week6.day1.assignments.mandatory.CreateLead.create")
	public void DuplicateLeadMethod() {
		//^^^^^^^Create Lead^^^^^^
		driver.findElement(By.linkText("Leads")).click(); //CLICK THE Leads tab link		
		driver.findElement(By.linkText("Create Lead")).click(); //click the create link id            
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SeleniumTest");//Enter company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");//Enter the first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("V");//Enter the last name
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Priya");//Enter the first name(local)
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a testcase to create a duplicate lead");
		//		driver.findElement(By.name("primaryEmail")).sendKeys("priya@gmail.com");
		WebElement dropStateOrProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));//Webelement dropdown object
		Select objProvince=new Select(dropStateOrProvince); //creating a select class to select value from dropdown
		objProvince.selectByVisibleText("New York"); //Select the state or province from dropdown
		driver.findElement(By.className("smallSubmit")).click();  //click the create lead button

		//verify if the lead is created-page verification
		String strTitle=driver.getTitle();
		//System.out.println(strTitle);
		if(strTitle.equals("View Lead | opentaps CRM")) { //Checking title of the page
			System.out.println("Successfully created lead");
		}
		else{
			System.out.println("Couldnot create lead");
		}

		//Duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();//Clear the field
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NewCompany");
		driver.findElement(By.id("createLeadForm_firstName")).clear();//clear the name field
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("priya v"); //enter new value
		driver.findElement(By.className("smallSubmit")).click(); 
		if(strTitle.equals("View Lead | opentaps CRM")) { //Checking title of the page
			System.out.println("Successfully updated lead");
		}
		else{
			System.out.println("Couldnot update lead");
		}

	}

}

