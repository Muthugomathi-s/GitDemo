import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port ="3306";
       
		Connection con =  DriverManager .getConnection("jdbc:mysql://"  +host+ ":"  +port+  "/Test", "root", "AbI@2024");
	  
		Statement s= con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from Employeeinfo where name='guru'");
	     
		while(rs.next())
		{// pointer moves from base to first index if not given then it only points to the base index in databse
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gomat\\Downloads\\eclipseitems\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		 driver.get("https://login.salesforce.com/");
		 driver .findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(rs.getString("id"));
		 driver .findElement(By.xpath("//input[@name=\"pw\"]")).sendKeys(rs.getString("name"));	
			
			System.out.println(rs.getString("id"));
	     System.out.println(rs.getString("name"));
		}
	     
	}

}
