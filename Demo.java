public class Demo {

    public void greet() {
        System.out.println("good evening interns....");
    }

    // Parameters
    public void sum (int a , int b ){
        System.out.println("sum = "+a+b);
    }

    public static void main(String[] args) {
        System.out.println("hello world");

        // Variable
        String name = "Nagarjun";
        int age = 10;
        System.out.println(name);
        System.out.println(age);

        // function-methods

        Demo d = new Demo();
        d.greet();
        d.sum(3,5);
    }
}