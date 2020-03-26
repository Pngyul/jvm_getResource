package com.pngyul;

public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getResource("").getPath());
        System.out.println(Test.class.getResource("/"));
        System.out.println("------------");
        System.out.println(Test.class.getResource("2.propertise"));
        System.out.println(Test.class.getResource("sub/3.propertise"));
        System.out.println(Test.class.getResource("/1.propertise"));
        System.out.println("------------");
        System.out.println(Test.class);
        ClassLoader classLoader = Test.class.getClassLoader();
        ClassLoader classLoader1 = classLoader.getClass().getClassLoader();
        System.out.println(classLoader1);
        //从结果中我们看出
        // TestMain.class.getResource("/")
        // ==
        // t.getClass().getClassLoader().getResource("")
        System.out.println(Test.class.getClassLoader().getResource(""));
        System.out.println(Test.class.getClassLoader().getResource("/"));

        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3= (byte) (b1+b2);

    }
}
