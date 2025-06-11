class MyClass {



    static void fun() throws IllegalAccessException

    {

        System.out.println("Inside fun(). ");

        throw new IllegalAccessException("demo");

    }



    public static void main(String args[])

    {

        try {

            fun();

            // method2();   → arrayindex…

            // Method3()  —> file not found….

        }

        catch (IllegalAccessException e) {

            System.out.println("Caught in main.");

        }

    }

}
