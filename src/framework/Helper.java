package framework;

public class Helper {

    public static String getRandomTextCat() {
//        int random = (int) (Math.random() * 250 + 1);
//        String randomText = "category" + random;
//        return randomText;
        
        return "ms" + (int) (Math.random() * 500 + 1);
    }
    
    public static String getRandomTextReg() {
        return "MSregion" + (int) (Math.random() * 200 + 1);
    }
    
    public static String getRandomTextPort() {
        return "MSportal" + (int) (Math.random() * 300 + 1);
    }
    
    public static String getRandomUrl() {
        return "http://".concat(getRandomTextCat()).concat(".rs");
    }

}
