class checkAttendance {
    double check = Math.floor(Math.random() * 10) % 2;
    void isPresent(){
        if ( check == 1)
            System.out.println("Employee is Present !");
        else
            System.out.println("Employee is Absent !");
    }
}

public class EmployeeWageComputationInJava {
    public static void main(String[] args){
        checkAttendance employee = new checkAttendance();
        System.out.println("Welcome to employee wage computation program on master branch");
        employee.isPresent();
    }
}
