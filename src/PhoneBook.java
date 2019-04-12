import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private final static HashMap<String, String> phoneBook = new HashMap<String, String>();

    private static void addContact(String name, String number){
        phoneBook.put(name,number);
    }

    private static String getContact(String name){
        return phoneBook.get(name);
    }

    private static void removeContact(String name){
        phoneBook.remove(name);
    }
    private static void showList(){
        for (String str : phoneBook.keySet()) {
            System.out.println(str + " " + phoneBook.get(str));
        }
    }

    private static void Menu() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("1. Поиск по имени");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Показать все контакты");
            System.out.println("0. Выход");
            int i = in.nextInt();
            switch (i) {
                case 1: {
                    System.out.println("Введите имя:");
                    String name = in.next();
                    if (getContact(name)==null) System.out.println("Контакт не найден");
                    else System.out.println(getContact(name));
                    break;
                }
                case 2: {
                    System.out.println("Введите имя:");
                    String name = in.next();
                    System.out.println("Введите номер:");
                    String number = in.next();
                    addContact(name, number);
                    System.out.println("Контакт добавлен!");
                    break;
                }
                case 3: {
                    System.out.println("Введите имя:");
                    String name = in.next();
                    if(getContact(name)==null){
                        System.out.println("Контакт не найден");
                        break;
                    }
                    else {
                        removeContact(name);
                        System.out.println("Контакт удален");
                    }
                }
                case 4: {
                    showList();
                    break;
                }
                case 0: return;
            }
        }
    }

    public static void main(String[] args) {
        addContact("Emil", "8-913-811-76-51");
        addContact("Alex", "8-906-821-23-23");
        addContact("Ilya", "8-905-091-92-61");
        Menu();
    }
}

