public class CharacterTwo extends Character{
    public CharacterTwo() {
        super("I forgot to bring my glasses to school and I was bullied by a group of kids.",
                "Clark Kent");
    }
    @Override
    public String greeting() {
        return "I'm not a nerd, I'm just a guy that forgot his glasses.";
    }
    @Override
    public String getInformation() {
        return "I'm a reporter for the Daily Planet.";
    }
    @Override
    public String sayGoodbye() {
        return "I never got to tell Lois that I love her.";
    }
}
