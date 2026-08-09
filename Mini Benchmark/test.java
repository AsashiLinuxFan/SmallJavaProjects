import java.util.Scanner;

public class test {
    static Scanner scan = new Scanner(System.in);
    static long a = 0;

    public static void main(String[] args) {
        System.out.println("The test will start once you press enter");
        System.out.println("This test measures how rapidly your pc can handle repetitive actions");
        System.out.println("Your PC will run a 1B times simple loop");
        System.out.println("The output will be the time that it has taken to process all that");
        String decoy = scan.nextLine();

        long start = System.nanoTime();  

        Thread worker = new Thread(() -> {
            
            for (long i = 0; i != 1000000000; i++) {
                a += i;
            }
        });

        worker.start();

        try {
            worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime(); 

        double elapsedMs = (end - start) / 1_000_000.0;
        System.out.println("Time: " + elapsedMs + " ms");
        System.out.println("Ignore: "+(a/a));
    }
}
