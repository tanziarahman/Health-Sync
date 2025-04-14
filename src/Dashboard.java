public class Dashboard{
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    public void run(){
        System.out.println(BLUE + "══════════════════════════════");
        System.out.println(BLUE + "         HEALTH SYNC");
        System.out.println(BLUE + "══════════════════════════════");

        System.out.println(GREEN + "[1] Calculate BMI");
        System.out.println("[2] Calculate Heart Rate");
        System.out.println("[3] Workout Timer");
        System.out.println("[4] Health Tip");
        System.out.println("[5] Get Heart Rate History");
        System.out.println("[6] Exit");
    }
}
