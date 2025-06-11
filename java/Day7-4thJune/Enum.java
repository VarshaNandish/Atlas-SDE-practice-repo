enum Day {

    MONDAY, TUESDAY, WEDNESDAY;


    public static void main(String[] args) {

        System.out.println("Main method inside enum is running.");


        for (Day d : Day.values()) {

            System.out.println(d);

        }

    }

}