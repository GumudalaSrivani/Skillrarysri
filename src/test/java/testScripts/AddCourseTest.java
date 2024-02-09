package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IconstantPath;

public class AddCourseTest extends BaseClass {
//This method is used to add course 
	//This is used
	@Test
	
	public void addCourseTest() {
		SoftAssert soft =new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(courseList.getPageHeader().contains("Course List"));
		courseList.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(), "Add New Course");
		Map<String,String> map = excel.readFromExcel("Add Course");
		
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web, map.get("Category"));
		addCourse.setPrice(map.get("Price"));
		addCourse.uploadPhoto(map.get("Photo"));
		addCourse.setDescription(map.get("Description"), web);
		addCourse.clickSave();
		soft.assertEquals(courseList.getSuccessMessage(),"Success!");
		courseList.deleteCourse(web, map.get("Name"));
		soft.assertEquals(courseList.getSuccessMessage(),"Success!");	
		 if (courseList.getSuccessMessage().equals("Success")) {
			 excel.updateTestStatus("Add Category", "Pass", IconstantPath.EXCEL_PATH);
			
		} else {
			 excel.updateTestStatus("Add Category", "Fail", IconstantPath.EXCEL_PATH); 
		}
		 soft.assertAll();
		
	}
	
}
