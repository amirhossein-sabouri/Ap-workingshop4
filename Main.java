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
class Voting{
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;


}

