import java.util.Random;

public class RandomMain {
    public static int getPerson() throws Exception{
        Random random = new Random();


        int MaxPersion = Integer.parseInt(Utils.getProperties("maxPerson"));
        String ThrowPerson = Utils.getProperties("throwPerson");

        //初始化
        int value = random.nextInt(MaxPersion);

        if(!ThrowPerson.equals("") && " " != ThrowPerson){
            String[] tparr = Utils.getProperties("throwPerson").split(",");

            for (String arr : tparr){
                while(Integer.parseInt(arr) == value){
                    value = random.nextInt(MaxPersion);
                }
            }
        }



        return (value + 1);
    }
}
