package hashtable;

public class Testing {

    public static void main(String args[]) {
        //Testing HashTable class 
        HashTable<Integer, String> table = new HashTable<>();
        System.out.println(table.toString());

        table.put(1, "<<Manar Odeh>>");
        table.put(2, "A Computer Engineering Student ^-^");
        table.put(3, "Building HashTable is really intersting thing ^-^");
        table.put(4, "so I decided to improve my HashTable to have string as a key also.");
        table.put(5,"also I would Like to building iterator class,to be able to iterat my HashTable class:) ");
        table.put(8, "Value to Remove Latter");
        System.out.println(table.toString());
        System.out.println("HashTable Size is : " + table.getSize());
        
        System.out.println("Does HashTable contains 2  as Key: " + table.contains(2));
        System.out.println("Does HashTable contains 11  as Key: " + table.contains(11));
        System.out.println();
        
        
        System.out.println("Does HashTable contains <<Manar Odeh>> as value: " + table.contiansValue("<<Manar Odeh>>"));
        System.out.println("Does HashTable contains <<Manar>> as value: " + table.contiansValue("<<Manar>>"));
        System.out.println();
        
        System.out.println("The value for key 3 in HashTable is : " + table.get(3));
        System.out.println("The value for key 12 in HashTable is : " + table.get(12));
        System.out.println();
        
        System.out.println("Does The HashTable Empty: " + table.isEmpty());
        System.out.println("Removing the Value with key 8 : " + table.remove(8));
        System.out.println("Try to Remove the value with key 8: " + table.remove(8));
        System.out.println();
        
        for(int i=1;i<=5;i++){
            System.out.print(table.get(i));
            if(i<5){
                 System.out.print(" ,"); 
            }else{
                System.out.println();
            }
        }
        
        
        System.out.println();
        System.out.println("Calling clear mthods with my hashTable ");
        table.clear();
        System.out.println("Does The HashTable Empty: " + table.isEmpty());

    }
}
