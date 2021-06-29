package com.skd.system.design.pattern;


/*
* Creational Design Pattern
* */

//Create a Parent interface,abstract class or simple class
abstract class FactoryDesignPattern {

    public abstract long getSpecification();

}
//Tablet(sub class) extends parent class
class Tablet extends FactoryDesignPattern
{

    private long price=25000L;
    private String os;//Windows || IOS
    private String ram;//8 GB || 16 GB

    public Tablet(String os, String ram) { ;
        this.os = os;
        this.ram = ram;
    }

    @Override
    public long getSpecification() {
        return this.price;
    }
}
//Laptop(sub class) extends parent class
class Laptop extends FactoryDesignPattern
{

    private long price=50000L;
    private String os;//Windows || IOS
    private String ram;//8 GB || 16 GB
    private String screenSize;// 13.3 INCH || 14 INCH
    private String storageCapacity; // 512 GB|| 1TB

    public Laptop(String os, String ram, String screenSize, String storageCapacity) {
        this.os = os;
        this.ram = ram;
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public long getSpecification() {
        return this.price;
    }
}
//Mobile(sub class) extends parent class
class Mobile extends FactoryDesignPattern
{

    private long price=1500L;
    private String os;//Andriod || IOS
    private String ram; //8 GB || 16 GB
    private String screenSize; // 5.5 INCH || 6 INCH
    private String storageCapacity; // 64 GB|| 128 GB

    public Mobile( String os, String ram, String screenSize, String storageCapacity) {
        this.os = os;
        this.ram = ram;
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public long getSpecification() {
        return this.price;
    }
}
//Create factory method as static which represent to class.
class ElectronicFactory
{

    public static FactoryDesignPattern getPrice(String type)
    {
        //By using if else
        /*if("Mobile".equalsIgnoreCase(type))
        {
            return new Mobile("Window","16 GB","6","128");
        }
        else if("Laptop".equalsIgnoreCase(type))
        {
            return new Laptop("Window","16 GB","15","512");
        }
        else if("Tablet".equalsIgnoreCase(type))
        {
            return new Tablet("Window","16 GB");
        }
        return null;*/

        //By using switch case
        switch (type)
        {
            case "Mobile":
                return new Mobile("Window","16 GB","6","128");
            case "Tablet":
                return new Tablet("Window","16 GB");
            case "Laptop":
                return new Laptop("Window","16 GB","15","512");
            default:
                return null;

        }

    }
}

class ClientCall
{
    public static void main(String[] args) {
       FactoryDesignPattern mobile= ElectronicFactory.getPrice("Mobile");
       System.out.println("Avg price of mobile is : "+mobile.getSpecification());//1500

        FactoryDesignPattern tablet= ElectronicFactory.getPrice("Tablet");
        System.out.println("Avg price of tablet is : "+tablet.getSpecification());//25000

        FactoryDesignPattern laptop= ElectronicFactory.getPrice("Laptop");
        System.out.println("Avg price of laptop is : "+laptop.getSpecification());//25000
    }
}
