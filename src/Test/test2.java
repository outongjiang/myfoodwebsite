package Test;
class class1{
    public static void print2(){
        System.out.println("class1的print2");
    }
}
 class class2 {
    public  static  void print(){
        System.out.println("class2的print");
        class1.print2();
    }
}
public class test2{
    public static void main(String[] args) {
        class2.print();
    }
}
