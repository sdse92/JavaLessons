package pattern.factory;


abstract class Handler{
    abstract void read();
    abstract void write();
}

class TxtHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read from txt");
    }

    @Override
    void write() {
        System.out.println("Wrote in txt");
    }
}

class XmlHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read from Xml");
    }

    @Override
    void write() {
        System.out.println("Wrote in Xml");
    }
}

public class Factory {

    public  Handler getHandler(String string){
        Handler handler = null;
        if(string.endsWith("txt")){
            handler = new TxtHandler();
        }else if (string.endsWith("xml")){
            handler = new XmlHandler();
        }
        return handler;
    }

    public static void main(String[] args){
        Factory factory = new Factory();
        String file = "qwe.xml";
        Handler handler = factory.getHandler(file);
        handler.read();
        handler.write();
    }
}
