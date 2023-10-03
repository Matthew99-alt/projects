package matvey.arrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneNotebook {

    private final Map<String, HashSet<Integer>> SNNum = new HashMap<>();

    public HashSet<Integer> get(String secName) {
        return SNNum.get(secName);
    }
    public void addPhones(String secName, Integer... phone) {
        HashSet<Integer> currentPhoneNumbers = SNNum.get(secName);

        if (currentPhoneNumbers == null) {
            SNNum.put(secName, new HashSet<>(Arrays.asList(phone)));
        } else {
            currentPhoneNumbers.addAll(Arrays.asList(phone));
            SNNum.put(secName, currentPhoneNumbers);
        }
    }
}