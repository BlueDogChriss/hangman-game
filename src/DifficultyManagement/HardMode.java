package DifficultyManagement;

public class HardMode implements Difficulty{
    @Override
    public int getMaxTries() {
        return 6;
    }
}
