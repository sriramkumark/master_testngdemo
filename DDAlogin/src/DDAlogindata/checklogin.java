package DDAlogindata;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class checklogin {
	static List<String> usernameList=new ArrayList<String>();
	  static List<String> passwordList=new ArrayList<String>();


			public void readExcel() throws IOException
			{
				FileInputStream fis1=new FileInputStream("C:\\Users\\SV58TR744\\Documents\\LoginTestdata.xlsx");
				Workbook we = new XSSFWorkbook(fis1);
        		Sheet sh=we.getSheetAt(0);
				Iterator<Row> rowIterator=sh.iterator();
				while(rowIterator.hasNext())
				{
					Row rowValue=rowIterator.next();
					
					Iterator<Cell> columnIterator=rowValue.iterator();
					int i=2;
					while(columnIterator.hasNext())
					{
						if(i%2 == 0)
						{
							//create List and add username & password
							//Cell usernames=columnIterator.next();	
							// usernameList.add(columnIterator.next().toString()); column value convert into string as per datatype in excel
							// can use getstringCellValue
							usernameList.add(columnIterator.next().getStringCellValue());
							
						}
						else
						{
							//Cell passwords=columnIterator.next();
							passwordList.add(columnIterator.next().getStringCellValue());
						}
						i++;
					}
		      	}
			}
			public void login(String uname, String pwd) {
				WebDriver dri=new ChromeDriver();
				dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				dri.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				dri.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
				dri.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
				dri.findElement(By.xpath("//button[@type='submit']")).click();
				dri.quit();
				}
        public void executeTest() {
        	for(int i=1;i<usernameList.size();i++)
        	{
        		login(usernameList.get(i),passwordList.get(i));
        	}
        	
        }
        public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			checklogin poiobj=new checklogin();
			poiobj.readExcel();
		//	System.out.println("username:" + usernameList);
			//System.out.println("password:" + passwordList);
			poiobj.executeTest();
		   
		

		}  
			
}
