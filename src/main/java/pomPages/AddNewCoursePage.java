package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WedDriverUtility;

public class AddNewCoursePage {
  

//Declaration
	@FindBy(xpath = "//b[text()='Add New Course']")
	private WebElement pageHeader;
	
	
	@FindBy( id="name")
	private WebElement nameTF;
	
	@FindBy(xpath = "//select[@id='category' and @required]")
	private WebElement courseListLink;
	
	@FindBy( id="price")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement uploadPhotoButton;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionTextArea;
	
	
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, editor1']")
	private WebElement descriptionFrame ;
	
	@FindBy(xpath="//button[text()=' Save' and @name='add']")
	private WebElement saveButton;
	
	//Initialization
	public AddNewCoursePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//UtiliZation
	public String getPageHeader() {
		return pageHeader.getText();
		
    }
	public void setName(String courseName) {
		nameTF.sendKeys(courseName);
		
	}
	public void selectCategory (WedDriverUtility web,String text) {
		web.selectFromDropdown(text,courseListLink);
		
		
	}
	public void setPrice (String price) {
		priceTF.sendKeys(price);
		
	}
	public void uploadPhoto(String path) {
		uploadPhotoButton.sendKeys(path);
		
	}
	public void setDescription (String description,WedDriverUtility web) {
		web.switchToFrame(descriptionFrame);
		descriptionTextArea.sendKeys(description);
		web.switchBackFromFrame();
		
	}
	public void clickSave() {
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	
}
