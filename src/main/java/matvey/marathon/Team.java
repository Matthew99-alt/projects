package matvey.marathon;


import java.util.ArrayList;

public class Team {

    //список победителей
    ArrayList<TeamMember> winners = new ArrayList<>();


    //переменные используемые для создания объекта классов
    private final String name;//название команды

    //массив объектов TeamMember(членов команды)
    private final TeamMember[] teamMembers;

    //конструктор команды
    public Team(String name, TeamMember... teamMembers) {
        this.name = name;
        this.teamMembers = teamMembers;
    }

    //getter'ы и setter'ы используемые в программе для получения необходимых данных
    public TeamMember[] getTeamMembers() {
        return teamMembers;
    }

    public String getName() {
        return name;
    }

    public String getMemberName(int i) {
        return teamMembers[i].getName();
    }

    public int getMemberSportSkill(int i) {
        return teamMembers[i].getSportSkill();
    }

    public int getTeamMembersLength() {
        return teamMembers.length;
    }

    //метод для вывода результатов полосы препятствий
    public void showResults(Course course) {
        System.out.println("Команда " + getName() + " прошла полосу препятствий");
        System.out.println("Победители полосы препятствий " + course.getCourseName() + ": ");

        ArrayList<TeamMember> winners = getWinners();
        for (TeamMember winner : winners) {
            System.out.print(winner.toString() + " ");
        }
    }

    //метод для вывода информации об участниках полосы препятствий
    public void showMembers() {
        System.out.println("Команда " + getName() + " имеет следующих участников: ");
        for (int i = 0; i < getTeamMembersLength(); i++) {
            System.out.println("Спортсмен " + getMemberName(i) + " с физической подготовленностью " + getMemberSportSkill(i));
        }
    }

    public ArrayList<TeamMember> getWinners() {
        return winners;
    }
}
