public class Assignment5 {
    public static String reverse(String s1){
        if(s1.length() == 1) {
            return s1;
        }
        else {
            return reverse(s1.substring(1)) + s1.charAt(0);
        }
    }
    public static String convert(String s2) {
        String convert;
        convert = s2.replace('^','x');
        s2 = convert.replace('v','^');
        convert = s2.replace('x','v');
        return convert;
    }
    public static String paperFold(int i) {
        if(i == 1) {
            return "v";
        }
        else {
            String s3 = paperFold(i-1);
            return convert(reverse(s3)) + "v" + s3;
        }
    }
    public static void main(String[] args) {
        for (int i=1; i<10; i++) {
            String fold_string = paperFold(i);
            System.out.println("For " + i + " folds we get: " + fold_string + "\n");
        }
    }
}

