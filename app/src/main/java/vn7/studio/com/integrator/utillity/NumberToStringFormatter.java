package vn7.studio.com.integrator.utillity;

public class NumberToStringFormatter {
    public static String formatNDDot(Double... dots) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (int i = 0; i < dots.length; i++) {
            String dot = formatNumber(dots[i]);
            sb.append(dot);
            if (i < dots.length - 1) {
                sb.append(" ; ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static String formatNumber(Double number) {
        return formatNumber(number, 2);
    }

    public static String formatNumber(Double number, Integer countNumbersAfterDot) {
        StringBuilder regEx = new StringBuilder("%.").append(countNumbersAfterDot).append("f");
        String result = String.format(regEx.toString(), number);

        if (result.contains(",")) {
            boolean hasZeroTail = false;
            int zeroTailStartIndex = 0;

            char[] chars = result.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0' && !hasZeroTail) {
                    hasZeroTail = true;
                    zeroTailStartIndex = i;
                }
                if (chars[i] != '0') {
                    hasZeroTail = false;
                }
            }

            if (hasZeroTail) {
                result = result.substring(0, zeroTailStartIndex);

                if (result.endsWith(",")){
                    result = result.substring(0, result.length() - 1);
                }
            }
        }

        return result;
    }
}
