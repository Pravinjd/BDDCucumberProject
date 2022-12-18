package StepDefination;

import io.cucumber.java.en.Then;

public class CloseSteps extends BaseClass {
	
	@Then("close browser")
	public void close_browser() {
		log.info ("***********************browser closed************************");
		driver.close();
		//driver.quit();
	
	}

}
