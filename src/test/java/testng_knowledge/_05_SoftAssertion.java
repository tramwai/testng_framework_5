//package testng_knowledge;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class _05_SoftAssertion {
//
//    @Test
//    public void hardAssertionExample(){
//
//        Assert.assertTrue(true);
//        Assert.assertEquals("Hello", "abc");
//        System.out.println("Hello World");
//
//    }
//
//    @Test
//    public void softAssertionExample(){
//        // need to create an object of SoftAssert class
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(2 == 2);
//        softAssert.assertEquals("Hello", "abc");
//        System.out.println("Hello World");
//
//        softAssert.assertAll();
//    }
//}
