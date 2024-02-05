package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddUserTest extends BaseClass{
	

	@Test
	
	public void addUserTest() {
		SoftAssert soft = new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));

		users.clickNewButton();
		soft.assertEquals(adduser.getPageHeader(), "Add New Users");

		
		Map<String,String> map = excel.readFromExcel("Add user");
		
		adduser.setEmail(map.get("Email"));
		adduser.setPassword(map.get("Password"));
		adduser.setFirstname(map.get("Firstname"));
		adduser.setLastname(map.get("Lastname"));
		adduser.setaddress(map.get("Address"));
		adduser.setContactInfo(map.get("Contact Info"));
	    adduser.uploadPhoto(map.get("Photo"));
	    adduser.clickSave();
	    soft.assertEquals(users.getSuccessMessage(), "Success");
	    soft.assertAll();
		
}
}