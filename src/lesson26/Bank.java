package lesson26;


//public class Bank {
//
//    public static void transfer(Accaunt src, Accaunt dst, int money){
//        Accaunt obj1;
//        Accaunt obj2;
//
//        if (src.getId() < dst.getId()){
//            obj1 = src;
//            obj2 = dst;
//        }else {
//            obj1 = dst;
//            obj2 = src;
//        }
//
//        synchronized (obj1){
//            synchronized (obj2){
//                //перевод
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        transfer(1, 2, 500);
//        transfer(2, 1, 700);
//    }
//}
