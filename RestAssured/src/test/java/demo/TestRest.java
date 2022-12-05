package demo;

import org.testng.annotations.Test;

import data.provider.ExcelDataProvider;

public class TestRest extends ExcelDataProvider {
	
	
//	@Test
	public void testPost_01() {
		System.out.println("hello");
	}
	
	@Test(dataProvider = "ExcelData")
	public void testPost_02(Object name, Object roll) {
		System.out.println("Name:"+name.toString());
		System.out.println("Roll:"+roll);
	}
	

}
