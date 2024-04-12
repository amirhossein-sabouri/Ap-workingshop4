import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Person{
    private String firstname;
    private String lastname;
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
class Vote{
    private final Person voter;
 private final String date;
 public Vote(Person voter, String date){
  this. voter = voter;
  this.date= date;
 }

    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof VotingSystem)){
            return false;
        }
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(getVotingList(),that.getVotingList());
    }
    @override
    public int hashCode(){
     return Objects.hash(getVotingList());

    }
}
class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, HashMap<String, HashSet<Vote>> choices, boolean isAnonymous, ArrayList<Person> voters) {
        this.type = type;
        this.question = question;
        this.choices = choices;
        this.isAnonymous = isAnonymous;
        this.voters = voters;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setChoices(HashMap<String, HashSet<Vote>> choices) {
        this.choices = choices;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public ArrayList<Person> getVoters() {
        return voters;
    }

    public void setVoters(ArrayList<Person> voters) {
        this.voters = voters;
    }

    public ArrayList<String> getChoices() {
        ArrayList<String> temp = new ArrayList<>();
        for (String i : choices.keySet()) {
            temp.add(i);
        }
        return temp;
    }

    public void createChoice(String choice) {
        HashSet<Vote> votes = new HashSet<>();
        choices.put(choice, votes);
    }

    public void vote(Person voter, ArrayList<String> voter_choices) {
        String date = "2024/4/2";
        voters.add(voter);
        Vote vote = new Vote(voter, date);
        for (String i : voter_choices) {
            for (String j : choices.keySet()) {
                if (i.equals(j)) {
                        choices.get(j).add(vote);
                }
            }


        }

    }
}

