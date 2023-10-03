package matvey.marathon;


public class Main {

    public static void main(String[] args) {
        TeamMember sebastian = new TeamMember("Sebastian", 9);
        TeamMember sergey = new TeamMember("Sergey", 9);
        TeamMember garry = new TeamMember("Garry", 6);
        TeamMember daniel = new TeamMember("Daniel", 9);

        Obstacle wallOfBricks = new Obstacle("Wall of briks", 7);
        Obstacle movingFloor = new Obstacle("Moving Floor", 3);
        Obstacle river = new Obstacle("River", 4);
        Obstacle bicycleRacing = new Obstacle("Bicycle Racing", 5);

        Team alpha = new Team("Alpha", sebastian, sergey, garry, daniel);
        Course c = new Course("EndMarathon", wallOfBricks, movingFloor, river, bicycleRacing);
        alpha.showMembers();
        c.doIt(alpha);
        alpha.showResults(c);
    }
}
