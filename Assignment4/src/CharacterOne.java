public class CharacterOne extends Character {

    public CharacterOne() {
        super("I'm a genius student that picked up a notebook with the power to kill with a name and a face.",
                "Light Yagami");

    }

    @Override
    public String greeting() {
        return "I know I'm a genius, but I'm not a god.";
    }

    @Override
    public String getInformation() {
        return "My enemy is L, a detective that is trying to catch me.";
    }

    @Override
    public String sayGoodbye() {
        return "Goodbye, I hope you got some entertainment during my life.";
    }
}
