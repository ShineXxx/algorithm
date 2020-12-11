/**
 * 面试题2.单例模式
 *
 * @Author: zhj
 * @Date: 2020/12/5 14:44
 */
public class Singleton {
    /**
     * 5种方法
     *
     * @Author: zhj
     * @Date: 2020/12/5 15:07
     */
    public static void main(String[] args) {
        //1.静态内部类
        System.out.println(InnerSingleton.getInnerSingleton() == InnerSingleton.getInnerSingleton());
        //2.枚举类
        System.out.println(EnumSingleton.INSTANCE == EnumSingleton.INSTANCE);
        //3.懒汉式-双重检查锁
        System.out.println(Singleton.getLazySingletonInstance() == Singleton.getLazySingletonInstance());
        //4.懒汉式-syn锁
        System.out.println(Singleton.getLazySynSingletonInstance() == Singleton.getLazySynSingletonInstance());
        //5.饿汉式
        System.out.println(Singleton.getStarveSingletonInstance() == Singleton.getStarveSingletonInstance());
    }

    /**
     * 1.静态内部类
     */
    static class InnerSingleton {
        private static final InnerSingleton innerSingleton = new InnerSingleton();

        public static InnerSingleton getInnerSingleton() {
            return innerSingleton;
        }
    }

    /**
     * 2.枚举类
     *
     * @Author: zhj
     * @Date: 2020/12/5 15:07
     */
    enum EnumSingleton {
        INSTANCE;
    }

    /**
     * 3.懒汉式
     * 双重检查锁
     *
     * @Author: zhj
     * @Date: 2020/12/5 15:09
     */
    private static volatile Singleton lazyInstance = null;

    public static Singleton getLazySingletonInstance() {
        if (lazyInstance == null) {
            synchronized (Singleton.class) {
                if (lazyInstance == null) {
                    lazyInstance = new Singleton();
                }
            }
        }
        return lazyInstance;
    }

    /**
     * 4.懒汉式
     * syn
     *
     * @Author: zhj
     * @Date: 2020/12/5 15:09
     */
    private static volatile Singleton lazySynInstance = null;

    public static synchronized Singleton getLazySynSingletonInstance() {
        if (lazySynInstance == null) {
            lazySynInstance = new Singleton();
        }
        return lazySynInstance;
    }

    /**
     * 5.饿汉式
     *
     * @Author: zhj
     * @Date: 2020/12/5 15:14
     */
    private final static Singleton starveInstance = new Singleton();

    public static Singleton getStarveSingletonInstance() {
        return starveInstance;
    }
}
