public class Runner {
    public static void main(String[] args){
        final boolean[] runner = new boolean[5];
        for (int x = 0; x < 5; x++){
            System.out.println(runner[x]);
        }
        boolean running = true;
        if (running){
            System.out.println("Inside the if statement");
        }
        System.out.println("Outside the if statement");
        }
}
