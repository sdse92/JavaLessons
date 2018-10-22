package lesson3;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        // Arrays
        int [] arr; //объявление переменной массива
        int arr1[]; // второй способ объявления

        arr = new int[10];

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        int a = 90;
        // наполнения массива значениями при инициализации
        int [] arr3 = {2, 12, 45, 78, 34, a};
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3.length);

        //доступ к элементам массива
        System.out.println(arr3[2]); // 45
        System.out.println(arr3[2+2]); // 34  копирование строки ctrl+d
       // System.out.println(arr3[7]); // ArrayIndexOutOfBoundsException: 7

        arr3[1] = 123;
        System.out.println(Arrays.toString(arr3));

//        заполнить массив в цикле
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 10;
        }
        System.out.println(Arrays.toString(arr));

        // копирование массива
        int[] arr4 = {2, 6, 8, 3, 8, 3};
        int[] arr5 = arr4;

        int[] cloneArr4 = arr4.clone();
//        System.arraycopy(srcArr, int srcPos, destArr, int destPos, int length);
        int[] arr6 = new int[10];
        System.arraycopy(arr4, 1, arr6, 2, 1);
        System.out.println(Arrays.toString(arr6));

        int[] copyArr4 = Arrays.copyOf(arr4, 7);
        System.out.println(Arrays.toString(copyArr4));

        int[] copyRangeArr4 = Arrays.copyOfRange(arr4, 1,3);
        System.out.println(Arrays.toString(copyRangeArr4));


        arr4 = new int[]{2, 6, 8, 3, 8, 3};
        //перебор значений массива в цикле
//        for
        for (int i = 0; i < arr4.length; i++){
            arr4[i] += 100;
        }
        System.out.println(Arrays.toString(arr4));
        for (int num: arr4){
            System.out.println("num = " + num);
        }

        arr4 = new int[]{2, 6, 8, 3, 8, 3, 98};
        arr5 = new int[]{2, 6, 8, 3, 8, 3, 98};

        System.out.println(arr4 == arr5);
        System.out.println(arr4.equals(arr5));

        System.out.println(Arrays.equals(arr4, arr5));

        int[] arr7 = new int[14];
        Arrays.fill(arr7, 233);
        System.out.println(Arrays.toString(arr7));

        arr7 = new int[]{34, 1, -90, 45, 72};
        Arrays.sort(arr7, 1, 4); //сортировка массива с 1 элемента по 4
        System.out.println(Arrays.toString(arr7));
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));

        System.out.println(Arrays.binarySearch(arr7, 34));






    }
}
