import java.util.Arrays;
import java.util.List;

public class RewardsLevel {


    public static void main(String[] args) {
        RewardsLevel rewardsLevel = new RewardsLevel();
        rewardsLevel.commandLineRunner();
    }

    public int getReward(int userLevel, Config config) {

        List<Integer> levelsToRepeat = config.getLevelsToRepeat();
        int lastLevel = config.getLastLevel();

        if(userLevel > lastLevel) {
            int arrayPosition = (userLevel - lastLevel - 1) % levelsToRepeat.size();
            return levelsToRepeat.get(arrayPosition);
        }

        return userLevel;
    }


    public void commandLineRunner() {

        List<Integer> levelsToRepeat = Arrays.asList(3,4,5,6);

        Config config = new Config(10, levelsToRepeat);

        for (int i = 1; i < 20; i++) {
            int reward = getReward(i, config);
            System.out.println("User level: " + i + ". Reward level: " + reward);
        }
    }

}