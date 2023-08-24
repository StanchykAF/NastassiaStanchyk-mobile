package hw2.scenarios;

import hw2.dto.User;
import hw2.flow.flow.NativeAppFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import hw2.setup.BaseTest;
import hw2.utils.DtoGenerator;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button",
            enabled = false)
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("okBtn").click();
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");

    }

    @Test(groups = {"native"}, description = "The user gets to the BudgetActivity page after logging in")
    public void budgetActivityPageAfterLoggingInTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        User user = DtoGenerator.generateUser();
        NativeAppFlow nativeStep = new NativeAppFlow();
        getPo().getWelement("okBtn").click();
        nativeStep.registration(user);
        nativeStep.login(user);
        Assert.assertEquals(nativeStep.getPageTitle(), "BudgetActivity");
    }
}
