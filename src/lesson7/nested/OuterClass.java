package lesson7.nested;

public class OuterClass {
    String value;
    static int intVar = 1;

    public OuterClass(String value){
        this.value = value;
    }

    public InnerClass getInner(){
        return new InnerClass("Объект InnerClass");
    }

    static class InnerClass{
        String val;

        public InnerClass(String val){
            this.val = val;
        }

        public void someVoid(){
            intVar +=2;
            System.out.println(intVar);
            //ошибка - не имеет доступа
        }
    }
}
