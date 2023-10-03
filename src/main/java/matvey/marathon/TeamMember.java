package matvey.marathon;

public class TeamMember {

    private final String name;
    private final int sportSkill;

    public TeamMember(String name, int sportSkill) {
        this.name = name;
        this.sportSkill = sportSkill;
    }

    //getter'ы и setter'ы используемые в программе для получения необходимых данных
    public String getName() {
        return name;
    }

    public int getSportSkill() {
        return sportSkill;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
