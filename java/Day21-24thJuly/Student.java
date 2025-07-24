class Student {

    public int roll_no = 10;
    //private int roll_no = 10;

    public int getRoll() {
        System.out.println("getRoll method");
        return roll_no;
    }

    public void setRoll(int roll) {
        if (!(roll > 100)) {
            roll_no = roll;}
    }
}

class TightCoupling {

    public static void main(String[] args) {
        Student sobj = new Student();
        sobj.roll_no = 10;
        //sobj.roll_no = 110;
        System.out.println("The roll no of student is " + sobj.roll_no);
    }
}

