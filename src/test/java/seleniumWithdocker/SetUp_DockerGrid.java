package seleniumWithdocker;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetUp_DockerGrid {

	@BeforeTest
	void start_DockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(20000);
	}

	@AfterTest
	void stop_DockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(5000);
//		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); // closes the command prompt
	}
}
