package letscode;

public class CodeThis {

    public static String greet(String name) {
        return "Hello, " + name;
    }

    public static void greetFailure() throws Exception {
        throw new LetsCodeException();
    }

}
