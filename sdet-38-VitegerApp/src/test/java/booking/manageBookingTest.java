package booking;

import org.testng.annotations.Test;

import com.tms.comcast.genericutility.BaseClass;
import com.tms.comcast.pomrepositorylib.manageBook1;

public class manageBookingTest extends BaseClass{
	@Test
	public void manageBookTest() {
		manageBook1 MB=new manageBook1(driver);
		MB.managebook();
	}

}
