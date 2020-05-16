class CompanyObj{
    public final String company;
    public final int empRatePerHr;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;

    public CompanyObj(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth){
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString(){
        return "Total Emp Wage for Company: "+company+" is "+totalEmpWage;
    }
}

public class EmpWageBuilderArray {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private int numOfCompanies = 0;
    private CompanyObj[] companies;

    public EmpWageBuilderArray(){
        companies = new CompanyObj[5];
    }

    private void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth){
        companies[numOfCompanies] = new CompanyObj(company, empRatePerHr, numOfWorkingDays, maxHoursPerMonth);
        numOfCompanies++;
    }

    private void totalEmpWage(){
        for(int i = 0; i<numOfCompanies; i++){
            companies[i].setTotalEmpWage(this.totalEmpWage(companies[i]));
            System.out.println(companies[i]);
        }
    }

    public int totalEmpWage(CompanyObj companyObj) {
        //VARIABLES
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        //COMPUTATION
        while (totalEmpHrs <= companyObj.maxHoursPerMonth && totalWorkingDays < companyObj.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
                    break;
            }
            totalEmpHrs += empHrs;
            System.out.println("Days: " + totalWorkingDays + " Emp Hours: " + empHrs);
        }
        return totalEmpHrs * companyObj.empRatePerHr;
        //System.out.println("Total Emp Wage for company company is " + totalEmpWage);
    }

    public static void main(String[] args){
        EmpWageBuilderArray arrObject = new EmpWageBuilderArray();
        arrObject.addCompanyEmpWage("DMart", 20, 2, 10);
        arrObject.addCompanyEmpWage("Reliance", 50, 5, 15);
        arrObject.totalEmpWage();
    }
}
