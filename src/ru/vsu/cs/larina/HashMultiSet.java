package ru.vsu.cs.larina;

public class HashMultiSet extends HashSet {

    public void put(String value) {
        int index = getIndex(value);
        table[index] = new ElementsHashSet(value, table[index]);
    }

    public int counterOfValues(String value){
        int count = 0;
        int index = getIndex(value);
        for (ElementsHashSet curr = table[index]; curr != null; curr = curr.next){
            if(value.equals(curr.value)){
                count++;
            }
        }
        return count;
    }

    public void remove(String value, int numberOfElements){
        int count = 0;
        if(numberOfElements >= counterOfValues(value)){
            remove(value);
        }else{
            int index = getIndex(value);
            for (ElementsHashSet curr = table[index]; curr != null; curr = curr.next) {
                if ((value.equals(curr.value))&&(count<numberOfElements)) {
                    table[index] = curr.next;
                    count++;
                }
            }
        }
    }
}
