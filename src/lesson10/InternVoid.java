package lesson10;

public class InternVoid {

//    private static final byte[] DATA = "Long String Long String " + "Long String Long String" + "Long String";

public static void main(String[] args) throws InterruptedException {
    String str = new String("String");
    String str2 = new String("String");

    System.out.println(str.intern() == str2.intern());
    System.out.println(str == str2);

    String[] strings = new String[1024*1024];
    for (int i = 0; ;i++){
        if (i <0){
            i = 0;

            strings[i % strings.length] = new String();

            Thread.sleep(10);
        }
    }
}
}
