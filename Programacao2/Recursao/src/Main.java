public class Main {

    public static void main(String[] args) {
        Elem e = new Elem("a");
        e.add("e");
        e.add("i");
        System.out.println(e.size());
        e.add("o");
        System.out.println(e.toString());
        e.remove(0);
        System.out.println(e.toString());
//        System.out.println(e.contains("e"));
//        System.out.println(e.contains("u"));
//        System.out.println(e.indexOf("o"));
//        System.out.println(e.get(3));
//        System.out.println(e.get(7));
//        System.out.println(e.size());
//        System.out.println(e.get(1));
//        System.out.println(e.toString());
//        e.remove(2);
//        System.out.println(e.get(0));
//        System.out.println(e.size());
//        System.out.println(e.toString());

    }





    public static int s(int a, int b) {
        if (a > b){ //condição de parada!
            return 0;
    }
        return a+s(a+1, b);//chamada recursiva
    }

//private String camelCase(String palavra){
     //   return camelCase(palavra, 0);
    //}

}
