
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Entry[] entries = new Entry[5];
        entries[0] = new Entry("Agathe", "Ackermann", "555-11133322");
        entries[1] = new Entry("Bernd", "Ackermann", "555-2251243");
        entries[2] = new Entry("Winfried", "Becker", "555-225123");
        entries[3] = new Entry("Alex", "Dieß", "555-343112");
        entries[4] = new Entry("Beatrix", "Dieß",  "555-2123123");
        PhoneBook phoneBook = new PhoneBook(entries);
// Here, the output should be true:
        System.out.println(entries[0].getPhoneNumber().equals(phoneBook.find("Agathe", "Ackermann")));
        System.out.println(phoneBook.find("Winfried","Becker"));
    }
}