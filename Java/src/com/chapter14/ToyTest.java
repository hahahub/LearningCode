package com.chapter14;

/**
 * Created by yangyunming on 2018/7/31
 */
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    Toy(){}
    Toy(int i ){}
    void print(){
        System.out.println("Inside Toy");
    }
}
class Fancy extends Toy implements HasBatteries,Waterproof,Shoots{
    Fancy(){super(1);}
}
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName() + " is interface? " + cc.isInterface());
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.chapter14.Fancy");//此处必须使用全限定的包名
        }catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face: c.getInterfaces()) {//getInterface返回Class对象，表示包含的接口
            printInfo(face);
        }
        Class up = c.getSuperclass();//获取Fancy的超类Toy
        Object obj = null;
        Toy toy = null;
        try{
            obj = up.newInstance();//虚拟构造器，使用此方法必须带有默认的构造器，得到的是一个Object的引用
            toy = (Toy)up.newInstance();//向下转型
        }catch (InstantiationException e){
            System.out.println("Cannot instantiate");
            System.exit(1);
        }catch (IllegalAccessException e){
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
        toy.print();
    }
}
