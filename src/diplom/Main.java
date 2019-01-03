package diplom;

public class Main {

    public static void main(String[] args) {
        GetRequests get = new GetRequests();
//        get.createClients();
//        get.printClientList();
        get.printClients();
        get.Result();
        SetRequests set = new SetRequests();
        set.createJSON();
    }
}
