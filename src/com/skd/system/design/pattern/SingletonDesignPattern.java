package com.skd.system.design.pattern;

public class SingletonDesignPattern {

    private static SingletonDesignPattern singletonDesign;
    private SingletonDesignPattern()
    {

    }
    //LAZY INITIALIZATION
    public static SingletonDesignPattern getInstance()
    {
        if(singletonDesign==null)
        {
            singletonDesign= new SingletonDesignPattern();
        }
        return singletonDesign;
    }

    //Thread Safe
    public static synchronized SingletonDesignPattern getInstanceThreadSafe()
    {
        if(singletonDesign==null)
        {
            singletonDesign= new SingletonDesignPattern();
        }
        return singletonDesign;
    }

    //Thread Safe and Double lock
    public static  SingletonDesignPattern getInstanceThreadSafeDoubleLock()
    {

            if (singletonDesign == null) {
                synchronized (SingletonDesignPattern.class) {
                    if(singletonDesign == null) {
                        singletonDesign= new SingletonDesignPattern();
                    }
            }
        }
        return singletonDesign;
    }


    public static void main(String[] args) {
        System.out.println(SingletonDesignPattern.getInstance());//SingletonDesignPattern@6acbcfc0
        System.out.println(SingletonDesignPattern.getInstance());//SingletonDesignPattern@6acbcfc0

        System.out.println(SingletonDesignPattern.getInstanceThreadSafe());//SingletonDesignPattern@6acbcfc0
        System.out.println(SingletonDesignPattern.getInstanceThreadSafe());//SingletonDesignPattern@6acbcfc0

        System.out.println(SingletonDesignPattern.getInstanceThreadSafeDoubleLock());//SingletonDesignPattern@6acbcfc0
        System.out.println(SingletonDesignPattern.getInstanceThreadSafeDoubleLock());//SingletonDesignPattern@6acbcfc0
    }
}
