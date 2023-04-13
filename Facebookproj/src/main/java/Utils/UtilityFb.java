package Utils;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityFb {
	
	
	public static void captureScreen(WebDriver driver,String testID) throws IOException, InterruptedException
	{
		
			Date d = new Date();//Date class -> to get ss in date and time formate
			String file = d.toString().replace(':','_');//replacement of time's ':'
			//1.to capture a ss.		
			File dest = new File("test-output/FailTestScreenshots/Test"+file+".jpeg");
			Thread.sleep(1000);
			
			//2.copy from source location to target location
			File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src1, dest);
			Thread.sleep(1000);
			
		
	}
	

	public static String getExcelData(String sheet,int row,int cell)throws InterruptedException, EncryptedDocumentException, IOException{
		
		String path = "src/main/resources/Excdata/Projectdata.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Workbook book = WorkbookFactory.create(file);//to open the file
		
		String data =book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();//for String data only
		System.out.println(data);

	    return data ;
		
	}	
	
	

}

