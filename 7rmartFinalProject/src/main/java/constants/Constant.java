package constants;

public class Constant 
{
 public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\TestDataProject.xlsx";
 public static final String TESTDATAIMAGE = System.getProperty("user.dir")+"\\src\\test\\resources\\images.jpg";
}
//The values are not changing that can be given at constants, from 'src' it is common(half of the system are local path). 
//not always be given as hardcoded (Not easily modified or reused)
//properties need to get from the user directory