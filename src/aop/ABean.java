package aop;

/**
 * Created by Administrator on 2019/8/18.
 */

public class ABean {
    public ABean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
//        try {
//            for (int i = 0; i < 2; i++) {
//                Thread.sleep(1000L);
//                System.out.println(i);
//            }
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void show(int i) {
        System.out.println("~~" + getClass().getSimpleName() + ".show-i~~");
        System.out.println("i is " + i);
    }

    public void show(int i, String s) {
        System.out.println("~~" + getClass().getSimpleName() + ".show-i~~");
        System.out.println("i is " + i);
    }

    public String see(Integer i, Integer j) {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");
        System.out.println(i);
        System.out.println(j);
        return "ok";
    }
}