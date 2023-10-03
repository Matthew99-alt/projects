package matvey.marathon;

public class Course {

    //название полосы препятствий
    private final String name;

    //массив полосы препятствий (объектов класса obstacle)
    private final Obstacle[] obstacles;

    //конструктор полосы препятствий
    public Course(String name, Obstacle... obstacle) {
        this.name = name;
        this.obstacles = obstacle;
    }


    /**
     * Метод для старта забега команды по полосе препятствий
     * в данном методе перебираются показатели спортсменов
     * (sportSkills) и сложность препятствий (difficulty) при помощи getter'ов
     * у каждого объекта (спортсмена)(TeamMember) узнаются его спортивные навыки
     * перебор происходит на основе индекса присвоенного объекту в массиве teamMembers
     * таким же образом перебираются объекты Obstacle (через массив obstacles перебираются
     * объекты класса obstacle, с помощью getter'ов), в случае не соответствия навыков
     * сложности цикл прерывается, если несоответствие не было выявлено, то в конце цикла
     * делается запись
     */
    public void doIt(Team team) {
        TeamMember[] teamMembers = team.getTeamMembers();
        // перебираем участников команды
        for (TeamMember teamMember : teamMembers) {
            // перебираем препятствия
            for (int j = 0; j < obstacles.length; j++) {
                Obstacle obstacle = obstacles[j];
                if (teamMember.getSportSkill() > obstacle.getDifficulty()) {
                    //проверяем достиг ли цикл конца
                    if (j + 1 == obstacles.length)
                        team.winners.add(teamMember);
                } else {
                    //выводим имя выбывшего участника, препятствие и удаляем его из списка победителей
                    System.out.println("Спортсмен " + teamMember.getName() + " выбыл на препятствии " + obstacle);
                    team.winners.remove(teamMember);
                    break;
                }
            }
        }
    }

    //getter'ы и setter'ы используемые в программе для получения необходимых данных
    public String getCourseName() {
        return name;
    }

}
