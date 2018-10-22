package lesson3;

import java.util.Arrays;

public class Lesson3String {
    public static void main(String[] args) {
        String str = "String";
        String str2 = new String("String");

        String str3 = String.format("String %02d", 8);
        System.out.println(str3);

        String str4 = "String String";
        String str5 = "String";
        String str6 = "strinG";

        System.out.println(str == str2); //false
        System.out.println(str == str5); //true

        System.out.println(str.equals(str2));
        System.out.println(str.equals(str5));

        System.out.println(str.equalsIgnoreCase(str6));

        System.out.println(str.startsWith("Q"));
        System.out.println(str.endsWith("g"));

        String str10 = "string";
        String str11 = new String("string");
        String str12 = "str";
        String str13 = "String string";

        //0-усли строки равны
        //положительный, если вызывающая строка больше(находится раньше)
        //отрицательный, если вызывающая строка меньше
        System.out.println(str10.compareTo(str11));
        System.out.println(str11.compareTo(str12));
        System.out.println(str11.compareTo(str13));

        String a = "Astring";
        String b = "Bstring";
        String c = "Cstring \n String";

        String[] strArr = {c, a, b};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        System.out.println(c.substring(3,8));
        System.out.println(a.contains("str")); //если символы найдены в строке, возвращает true

        String[] arr = {"qwe", "rty", "yui"};
        System.out.println();

        String string = "Up";

        // StringBuffer | StringBuilder

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        for (int i = 0; i < 10; i++){
            stringBuilder.append(" string ").append(" str ");
        }
        System.out.println(stringBuilder.toString());

    }
}
