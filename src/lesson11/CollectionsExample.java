package lesson11;

import lesson4.Task2.List;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        //Java Collection Framework
        // java.util.Collection
//        boolean add(E e);
//        boolean remove(Object o);
//        int size();
//        boolean isEmpty();
//        boolean contains(Object o);

//        Object[] toArray[];
//        <T> T[] toArray(T[] a);
//        String[] arr = collectionName.toArray(new String[0]);

        //iterator()

        //java.util.List
        //предоставляет методы для работы с коллекцией,
        //которая является списком
//        void add(int ind, E obj);
//        boolean addAll(int ind, Collection<? extends E> col);
//        E get(int ind);
//        int indexOf(Object o);
//        int lastIndexOf(Object o);
//        E remove(int ind);
//        E set(int ind, E obj);
//        List<E> subList(int start, int end);

        //Set

        ArrayList<String> strList = new ArrayList<>();
//        strList.ensureCapacity(20);
//        strList.trimToSize();
        strList.add("Elem 1");
        strList.add("Elem 2");
        strList.add(0, "Elem 2");
        //удаление элементов
//        strList.remove(индекс);
//        strList.remove(значение);
        System.out.println(strList.toString());

        Integer[] integers = {23, 67, 12, 90};
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(integers));
        System.out.println(intList.toString());

        for (Integer i: intList){
            System.out.println(i);
        }

        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()){
//            System.out.println("iterator" + iterator.next());
            if (iterator.next() == 12){
                iterator.remove();
            }
        }
        System.out.println(intList.toString());

//        LinkedList - двунаправленный список
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("String 1");
        stringLinkedList.add("String 2");
        stringLinkedList.add("String 3");
        stringLinkedList.add(1, "String 4");

        for (String str: stringLinkedList){
            System.out.println(str);
        }

        //удаление
//        stringLinkedList.poll(); //null
//        stringLinkedList.pollFirst(); //null
//        stringLinkedList.remove(); //NoSuchElementException
//        stringLinkedList.removeFirst(); //NoSuchElementException

        String[] arr = stringLinkedList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

        //HashSet
        //SortedSet -> TreeSet
        //LinkedHashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element2");
        hashSet.add("Element1");
        hashSet.add("Element3");
        hashSet.add("Element3");

        System.out.println(hashSet.toString());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Element2");
        treeSet.add("Element1");
        treeSet.add("Element3");
        treeSet.add("Element3");

        System.out.println(treeSet.toString());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Element 2");
        linkedHashSet.add("Element 1");
        linkedHashSet.add("Element 3");
        System.out.println(linkedHashSet.toString());

        //Ввести с клавиатуры 5 слов в список строк.
        //

    }
}
