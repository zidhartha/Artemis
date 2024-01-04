public class PhoneBook {
    private Entry[] entries;

    public PhoneBook(Entry[] entries) {
        this.entries = entries;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public String find(String firstName, String lastName) {
        int left = 0;
        int right = entries.length - 1;


        while (left <= right) {
            int mid = (right + left) / 2;
            Entry midResult = entries[mid];
            int result = compareNames(firstName, lastName, midResult.getFirstName(), midResult.getLastName());

            if (result == 0) {
                return midResult.getPhoneNumber();
            }
            if (result < 0) {
                right = mid - 1;
            } else if (result > 0) {
                left = mid + 1;
            }
        }
        return null;
    }

    private int compareNames(String firstName1, String lastName1, String firstName2, String lastName2) {
        int result = firstName1.compareTo(firstName2);
        if (result == 0) {
            return lastName1.compareTo(lastName2);
        }
        return result;
    }
}