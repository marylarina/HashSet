package ru.vsu.cs.larina;

public class HashSet {

    protected class ElementsHashSet {

        public String value;
        public ElementsHashSet next;

        public ElementsHashSet(String value, ElementsHashSet next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }
    }

    protected ElementsHashSet[] table = new ElementsHashSet[16];

    protected int getIndex(String value) {
        int index = value.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }

    private boolean uniqueValues(String value) {
        int count = 0;
        int index = getIndex(value);
        for (ElementsHashSet curr = table[index]; curr != null; curr = curr.next) {
            if (value.equals(curr.value)) {
                count += 1;
            }
        }
        return count > 0;
    }

    public void put(String value) {
        if (uniqueValues(value)) {
            System.out.println("HashSet contains '" + value + "' already");
        } else {
            int index = getIndex(value);
            table[index] = new ElementsHashSet(value, table[index]);
        }
    }

    public void remove(String value) {
        int index = getIndex(value);
        for (ElementsHashSet curr = table[index]; curr != null; curr = curr.next) {
            if (value.equals(curr.value)) {
                table[index] = curr.next;
            }
        }
    }

    public void containsValue(String value) {
        if (uniqueValues(value)) {
            System.out.print("HashSet contains '" + value + "'");
        } else {
            System.out.print("HashSet doesn't contain '" + value +"'");
        }
    }

    public void output(HashSet hashSet) {
        System.out.print("[ ");
        for (ElementsHashSet elements : table) {
            if (elements != null) {
                for (ElementsHashSet curr = elements; curr != null; curr = curr.next) {
                    System.out.print(elements.value);
                    System.out.print(" ");
                }
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
