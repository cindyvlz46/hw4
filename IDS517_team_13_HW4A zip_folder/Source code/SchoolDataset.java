public class SchoolDataset {
    String schoolID;
    String ranking;
    String school;
    String program;
    String lengthOfProgram;
    String totalTuition;
    String location;
    String toefl;
    String gre;
    String portfolio;
    String deadline;

    public SchoolDataset() {};
    public SchoolDataset(String schoolID, String ranking, String school, String program, String lengthOfProgram,
                         String totalTuition, String location, String toefl, String gre, String portfolio, String deadline) {
        super();
        this.schoolID = schoolID;
        this.ranking = ranking;
        this.school = school;
        this.program = program;
        this.lengthOfProgram = lengthOfProgram;
        this.totalTuition = totalTuition;
        this.location = location;
        this.toefl = toefl;
        this.gre = gre;
        this.portfolio = portfolio;
        this.deadline = deadline;
    }

    //this method overrides the parent object class to print all the records of the row
    @Override
    public String toString() {
        int numschoolspaces = 41 - school.length();
        String schoolspaces = "";
        for (int i = 0; i < numschoolspaces; i++) {
            schoolspaces+= " ";
        }

        int numprogramspaces = 87 - program.length();
        String programspaces = "";
        for (int i = 0; i < numprogramspaces; i++) {
            programspaces += " ";
        }

        int numlocationspaces = 25 - location.length();
        String locationspaces = "";
        for (int i = 0; i < numlocationspaces; i++) {
            locationspaces += " ";
        }
        return (
                schoolID + "\t\t"
                        + ranking + "\t\t"
                        + school  + schoolspaces
                        + program + programspaces
                        + lengthOfProgram + "\t\t"
                        + totalTuition + "\t\t"
                        + location  + locationspaces
                        + toefl + "\t\t"
                        + gre + "\t\t"
                        + portfolio  + "\t\t"
                        + deadline + "\t\t");

    }
}

