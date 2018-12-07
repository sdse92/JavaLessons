package lesson19.reflection;

//reflection api

public class Child extends Parent{

    private String name;
    private int version = 1;

    private Parent parent;

    public Child(String name, int version/*, Parent parent*/){
//        this.parent = new Parent(str, i, str2);
        this.parent = parent;
        this.name = name;
        this.version = version;
    }

    private String getName(){
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private String getInfo(){
        return "private getInfo()";
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}

class Parent{
//    для дз
//    public static String toString(Object o){
//        return "str";
//    }
}
