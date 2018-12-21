package lesson25;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class StreamApi {

    public static void main(String[] args) throws IOException {
        //создание stream
        Integer[] arr = {15, 45, 44, 45, -12, 0};
        //стрим из массива
        Stream<Integer> arrStream = Arrays.stream(arr);

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        //стрим из коллекции
        Stream<Integer> listStream = list.stream();

        //метод of
        Stream<String> stringStream = Stream.of("wq", "sa", "df");

        File file = new File("wp.txt");
//        Stream<String> fileStream = Files.lines(file.toPath());

        //примитивы
        IntStream intStream = IntStream.range(12,22);
        LongStream longStream = LongStream.builder().add(3).add(23).add(67).build();

        //удалить из списка элементы меньше 20
        //каждый элемент увеличить на 10
        //вывести в отсортированном порядке
        //Integer[] arr = {15, 45, 44, 45, -12, 0};

        list = new ArrayList<>(Arrays.asList(arr));
        list.stream()
                //удалить из списка элементы меньше 20
                .filter(s->s>20)
                //каждый элемент увеличить на 10
                .map(s->s+10)
                .sorted()
                .forEach(System.out::println);
        Optional<Integer> optional = Stream.of(1,2,3,6)
                .filter(s->s<5)
                .findFirst();
        Integer i = optional.orElse(0);

        String res = Stream.of("wq", "re", "op")
                .reduce("", (k,j)->k+j);
        System.out.println(res);

        //top 10
        Map<String, Long> wp=
            //получили стрим из файла
        Files.lines(file.toPath())
                //указываем, что стрим должен быть параллельным
                .parallel()
                //убрать знаки препинания
                .map(line->line.toLowerCase().replaceAll("pP", " "))
                //каждую строку разбиваем на слова
                .flatMap(line->Arrays.stream(line.split(" ")))
                //обрезаем пробелы
                .map(String::trim)
                //убираем пустые элементы, оставляя только слова
                .filter(word->!"".equals(word))
                //формируем мапу из объекта и колличества
                .collect(groupingBy(identity(), counting()))
                //получаем пару ключ-значение
                .entrySet().parallelStream()
                .sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(wp);

        Stream<String> stringStream1 = Files.lines(file.toPath())
                //указываем, что стрим должен быть параллельным
                .parallel()
                //убрать знаки препинания
                .map(line->line.toLowerCase().replaceAll("pP", " "))
                //каждую строку разбиваем на слова
                .flatMap(line->Arrays.stream(line.split(" ")))
                //обрезаем пробелы
                .map(String::trim)
                //убираем пустые элементы, оставляя только слова
                .filter(word->!"".equals(word));


        // the
//        Long count = stringStream1
//                .filter("the"::equals)
//                .count();
//        System.out.println(count);

        //выбрать все элементы, содержащие the

        List<String> listRes = stringStream1
                .filter((s)->s.contains("the"))
                .collect(Collectors.toList());
        System.out.println(listRes);

        arrStream = Arrays.stream(arr);
        IntSummaryStatistics statistics = arrStream
                .collect(Collectors.summarizingInt(p-> p - 1));
        System.out.println(statistics);

        //отсортировать сначала по возрасту, потом по имени
        //преобразовать в map,

        User user1 = new User("Qwe", 23);
        User user2 = new User("Asd", 12);
        User user3 = new User("Zxc", 99);
        User user4 = new User("Dfg", 39);
        User user5 = new User("Ghj", 21);
        User user6 = new User("Bnm", 7);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        //Выбрать пользователей в возрасте от 18 до 40
        userList.stream().filter((s)->s.getAge()>=18).filter((s)->s.getAge()<=40).forEach(System.out::println);
        //Найти максимальный возраст
        IntSummaryStatistics userStat = userList.stream().collect(Collectors.summarizingInt((s)->s.getAge()));
        System.out.println(userStat.getMax());
        //Найти средний возраст
//        userList.stream().mapToInt(User::getAge).average().getAsDouble();

        //получить сумму нечетных чисел
//        Integer[] arr = {15, 45, 44, 45, -12, 0};
        list = new ArrayList<>(Arrays.asList(arr));
        Integer in = list.stream().filter(n->n%2 != 0).reduce((j,k)-> j + k).get();
        System.out.println(in);

        //проверить, есть ли символ w во всех именах
        boolean bool =  userList.stream().allMatch(u->u.getName().contains("w"));
        System.out.println(bool);

    }
}


class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}