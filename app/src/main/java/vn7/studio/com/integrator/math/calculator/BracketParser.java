package vn7.studio.com.integrator.math.calculator;

public class BracketParser {
    public static String parseSubFunction(String element, String start) {
        String result = null;
        int indexOfFirstBracket = element.indexOf('(');
        int counter = 0;
        char[] chars = element.substring(indexOfFirstBracket).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                ++counter;
            }
            if (chars[i] == ')') {
                --counter;
                if (counter == 0) {
                    StringBuilder sb = new StringBuilder(start).
                            append(element.substring(indexOfFirstBracket, indexOfFirstBracket + i + 1));
                    result = sb.toString();
                    break;
                }
            }
        }
        return result;
    }
}
