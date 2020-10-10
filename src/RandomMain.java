import java.util.Random;

public class RandomMain {
    public static int getPerson() throws Exception{
        Random random = new Random();
        int MaxPersion = Integer.parseInt(Utils.getProperties("maxPerson"));


        int value = random.nextInt(MaxPersion);

        while (Utils.getProperties("throwPerson").contains(value+"")){
            value = random.nextInt(MaxPersion);
        }


        return (value + 1);
    }
}
