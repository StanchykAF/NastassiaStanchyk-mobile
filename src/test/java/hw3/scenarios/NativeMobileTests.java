package hw3.scenarios;

import hw3.dto.User;
import hw3.flow.NativeAppFlow;
import hw3.utils.DtoGenerator;
import hw3.setup.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "The user gets to the BudgetActivity page after logging in")
    public void budgetActivityPageAfterLoggingInTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        User user = DtoGenerator.generateUser();
        NativeAppFlow nativeStep = new NativeAppFlow();
        nativeStep.registration(user);
        nativeStep.login(user);
        Assert.assertEquals(nativeStep.getPageTitle(), "BudgetActivity");
    }
}
