public class CharacterThree extends Character{
public CharacterThree() {
        super("I protected a young girl from parasites that were trying to kill her.",
                "Joel Miller");
    }
    @Override
    public String greeting() {
        return "I'm not interested in your opinion.";
    }
    @Override
    public String getInformation() {
        return "I was a smuggler before the outbreak.";
    }
    @Override
    public String sayGoodbye() {
        return "I'm not going to say goodbye.";
    }
}
