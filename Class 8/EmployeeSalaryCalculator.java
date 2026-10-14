public class EmployeeSalaryCalculator {
    public static double calculateHRA(double a, double b) {
        return a + b;
    }

    public static double calculateDA(double c, double d) {
        return c + d;
    }

    public static double calculateGrossSalary(double a, double b, double c, double d, double e) {
        return calculateHRA(a, b) + calculateDA(c, d) + e;
    }

    public static double calculateDeduction(double a, double b, double c, double d, double e) {
        return calculateGrossSalary(a, b, c, d, e) * 0.05;
    }

    public static double calculateFinalSalary(double a, double b, double c, double d, double e) {
        return calculateGrossSalary(a, b, c, d, e)
             - calculateDeduction(a, b, c, d, e);
    }

    public static void main(String[] args) {
        double a = 10000, b = 2000, c = 1500, d = 1000, e = 500;

        double grossSalary = calculateGrossSalary(a, b, c, d, e);
        double deduction = calculateDeduction(a, b, c, d, e);
        double finalSalary = calculateFinalSalary(a, b, c, d, e);

        System.out.printf("Gross Salary = %.2f%n", grossSalary);
        System.out.printf("Deduction = %.2f%n", deduction);
        System.out.printf("Final Salary = %.2f%n", finalSalary);
    }
}
