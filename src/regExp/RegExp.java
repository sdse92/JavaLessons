package regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String string = "Строка 1 для_поиска и замены СИМВОЛОВ";
        String patern = "иск";
        System.out.println(string.replaceAll(patern,"*!*"));
        patern = "^Стр"; //строка должна начинаться с этих символов, $ - заканчиваться
        //^Стр$ - строка должна быть равна Стр
        System.out.println(string.replaceAll(patern,"*!*"));
        patern = "[иск]"; //перечень символов
        System.out.println(string.replaceAll(patern, "*"));
        patern = "[^иск]"; //поиск любых символов, кроме этих
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\d"; //цифровой символ
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\D"; //любой НЕ цифровой
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\w"; //буквенно-цифровой или _
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\W"; //не w
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\s"; //заменяет любой пробел
        System.out.println(string.replaceAll(patern, "*"));
        patern = "\\S"; //не пробельный символ
        System.out.println(string.replaceAll(patern, "*"));
        patern = "[а-я]";//все маленькие буква от а до я
        System.out.println(string.replaceAll(patern,"*"));
        patern = "[А-Я0-9]";//все заглавные от а до я и цифры
        System.out.println(string.replaceAll(patern,"*"));
        string = "Строка 1 [для_поиска] и замены СИМВОЛОВ";
        patern = ".*\\[.*\\]";//уберет все символы с начала, включая последнюю ]
        System.out.println(string.replaceAll(patern,"*"));

//        Pattern | Matcher
        string = "String B1 to search and replace CHARS";
        //string = "Str";
        Pattern pattern1 = Pattern.compile(".{6,}");// . - все символы  {} - сколько раз подряд встретит символ
        pattern1 = Pattern.compile("(?=.*\\d)(?=.*\\[a-z])(?=.*\\[A-Z]).{8,}");
        pattern1 = Pattern.compile("[a-zA-Z]");
        // ?= - соответствие | . - любой символ | * - символ может повторяться 0 и более раз | .[8,] - любой символ должен быть 8 раз
        Matcher matcher = pattern1.matcher(string);
        System.out.println(matcher.find());//true | falce
        System.out.println(matcher.matches()); //ищет полное соответствие true | falce


    }
}
