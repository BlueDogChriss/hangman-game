package DifficultyManagement;

public class EasyMode implements Difficulty{

    @Override
    public int getMaxTries() {
        return 10;
    }

}
