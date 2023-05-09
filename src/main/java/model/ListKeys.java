package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class ListKeys {

    private ArrayList<String> keyList;

    public ListKeys(){
        this.keyList = new ArrayList<>();
    }

    private String generateKey(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    private boolean checkKey(String keyL)
    {
        Iterator<String> it = keyList.iterator();

        while(it.hasNext())
        {
            String key = it.next();
            if(key.equals(keyL))
            {
                return false;
            }
        }
        return true;
    }

    public String keyadd(){
        boolean temp = false;

        while (!temp) {
            String key = generateKey();

            if (checkKey(key)) {
                keyList.add(key);
                return key;
            }
        }
        return null;
    }

    public ArrayList<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(ArrayList<String> keyList) {
        this.keyList = keyList;
    }
}
