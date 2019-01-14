package dao;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "a");
        User user2 = new User(2, "b");
        User user3 = new User(3, "c");
        UserDao uDao = new UserDao();
        uDao.createTable();
//        uDao.add(user1);
//        uDao.add(user2);
        System.out.println(uDao.getAll());
//        User u = (User) uDao.getById(1);
//        u.setLogin("www");
//        uDao.update(1, u);
        uDao.delete(1);
        uDao.delete(2);
        uDao.delete(3);
        Article a1 = new Article(1,"a1", 1);
        Article a2 = new Article(2,"a2", 2);
        Article a3 = new Article(3,"a3", 1);
        ArticleDao aDao = new ArticleDao();
        aDao.createTable();
        aDao.add(a1);
        aDao.add(a2);
        aDao.add(a3);
        System.out.println(aDao.getAll());
        Article a = (Article) aDao.getById(2);
        a.setTitle("Exo");
        aDao.update(1, a);
//        aDao.delete(1);
//        aDao.delete(2);
//        aDao.delete(3);
    }
}
