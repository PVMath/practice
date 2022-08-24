package booking;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass1;
import com.tms.comcast.pomrepositorylib.AdminLogin;
import com.tms.comcast.pomrepositorylib.manageBook1;
@Listeners(com.tms.comcast.genericutility.ListImpClass.class)
public class manageBooking1Test extends BaseClass1{
	@Test(groups = "smokeTest")
	public void manageBookingTest() throws Throwable {
		
	//Read all the common necessary data
	String URL     =flib.getPropertyKeyValue("url");
	String USERNAME=flib.getPropertyKeyValue("username");
	String PASSWORD=flib.getPropertyKeyValue("password");
	String BROWSER =flib.getPropertyKeyValue("browser");
	
	String ADMIN   =flib.getPropertyKeyValue("admin");
	String PASSWORD1=flib.getPropertyKeyValue("password1");
	driver.get(URL);
	
	//Login to admin module
	AdminLogin AL=new AdminLogin(driver);
	AL.logintoAdmin(ADMIN, PASSWORD1);
	
	
	manageBook1 MB=new manageBook1(driver);
	MB.managebook();
}
}

