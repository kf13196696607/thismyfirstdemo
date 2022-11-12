import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test2 {

    @Test(enabled = false,description = "忽略测试")
    public void test_a(){
        System.out.println("zz");
    }
    @Test(groups = "01")//分组测试 需要xml配置
    public void test_b(){
        System.out.println("zz1");
    }
    @Test(groups = "02")
    public void test_b1(){
        System.out.println("zz1");
    }
    @Test(dependsOnMethods = "test_a")//依赖测试 a失败则不会执行用例
    public void test_b11(){
        System.out.println("zz1");
    }
    //每个test执行前后都要被执行一次
    @AfterMethod
    public void test_b2(){
        System.out.println("QQQ");
    }
}
