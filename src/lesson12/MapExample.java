package lesson12;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User user = new User(2, "John");
        //System.out.println(user.hashCode());

        //Map
//        1. хранение данных в паре ключ - значение
//        2. ключи не дублирутся
//        3. хранение зависит от реализации
//        4. могут хранить любые типы данных
//        (использование null в качестве ключа зависит от реализации)

//        boolean containKey(Object key);
//        boolean containValue(Object value);
//        void putAll (Map<?extends K, ?extends V> m);
        //основные методы
//        get(T key);
//        put(T key, T val);

        //реализации Map
//        HashMap
//        TreeMap
//        EnumMap
//        LinkedHashMap
//        WeakHashMap
//        IdentityHashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Elem 1");
        hashMap.put(2, "Elem 2");
        hashMap.put(2, "Elem 3");
        hashMap.put(null, "Elem null");
        //System.out.println(hashMap);
        //System.out.println(hashMap.get(1));

        //перебрать элементы Map
        for(Map.Entry entry: hashMap.entrySet()){
            //System.out.println("Key " + entry.getKey() + " Value: " + entry.getValue());
        }

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Elem 1");
        linkedHashMap.put(2, "Elem 2");
        linkedHashMap.put(2, "Elem 3");
        linkedHashMap.put(null, "Elem null");
        //System.out.println(linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Elem 1");
        treeMap.put(2, "Elem 2");
        treeMap.put(2, "Elem 3");
        linkedHashMap.put(null, "Elem null");
        //System.out.println(treeMap);

        //бинарное дерево
//        1. корня - верхний узел
//        2. листья - узлы без потомков
//        3. Значение левого потомка долно быть меньше родителя
//        4. Значение правого потомка долно быть меньшебольше

        //красно - черное бинарное дерево
//        1. Корень всегда черные
//        2. Каждый красный узел имеет 2 черных потомка
//        3. Все пути от узла(корня) до листьев должны иметь одинаковое колличество черных узлов

        User user1 = new User(1, "Kek");
        User user2 = new User(1, "KekGreg");
        User user3 = new User(1, "KekFek");

        Map<Integer, User> userTreeMap = new TreeMap<>();
        userTreeMap.put(1, user1);
        userTreeMap.put(2, user2);
        userTreeMap.put(3, user3);
        System.out.println(userTreeMap);

        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        System.out.println(treeSet);

        Map<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(1, "Elem 1");
        hashMap2.put(3, "Elem 3");
        hashMap2.put(7, "Elem 7");
        hashMap2.put(12, "Elem 12");
        hashMap2.put(23, "Elem 23");
        System.out.println(hashMap2);

        TreeMap<Integer, String> treeMap1 = new TreeMap<>(hashMap2);
        System.out.println(treeMap1);
    }
}
