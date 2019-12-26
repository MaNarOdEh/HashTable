
package hashtable;


public class Testing {
    public static void main(String args[]){
        HashTable<Integer,String>table=new HashTable<>();
        table.put(1, "Manar Odeh");
        table.put(2, "A Computer Engineering Student ^-^");
        table.put(3, "I am very  bored tonight,so I decided to implements a hashTable");
        System.out.println("HashTable Size is : "+table.getSize());
        System.out.println("Does key 2 found ?: "+table.contains(2));
        System.out.println(table.get(3));
    }
}
