import java.util.*;


public class TestSet {
    public static void main(String[] args){
//        Random rand = new Random(47);
//        Set<Integer> st = new TreeSet<Integer>();//HashSet
//        for (int i = 0;i < 10000; i++){
//            st.add(rand.nextInt(50));
//        }
//        System.out.println(st);//明明是顺序的
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1,"A B C D E F G H I J K L".split(" "));
        set1.add("M");
        System.out.println("H : " + set1.contains("H"));
        System.out.println("N : " + set1.contains("N"));
        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set2,"H I J K L".split( " "));
        System.out.println("set2 in set1 : " +set1.containsAll(set2));
        set1.removeAll(set2);
        System.out.println("set2 in set1 : " +set1.containsAll(set2));
        Collections.addAll(set1,"X Y Z".split(" "));
        System.out.println("'X Y Z' added to set1: " + set1);
    }
}
