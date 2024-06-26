import java.util.*;
import java.time.LocalTime;
import java.text.SimpleDateFormat;

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
        return Objects.equals(((VotingSystem) o).getVotingList(),that.getVotingList());
    }
    @Override
    public int hashCode(){
     return Objects.hash(getVoter());

    }
}
class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question,  boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;

    }
    Date currentDate = new Date();
    // Create a date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // Format the current time to a string
    String currentTimeString = dateFormat.format(currentDate);

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

    /**
     * putting keys of hash set of choices n an arraylist
     * @return ArrayList
     */
    public ArrayList<String> getChoices() {
        ArrayList<String> temp = new ArrayList<>();
        for (String i : choices.keySet()) {
            temp.add(i);
        }
        return temp;
    }

    /**
     * creating a choice
     * @param choice is name of new choice for adding to hash map of choices
     */
    public void createChoice(String choice) {
        HashSet<Vote> votes = new HashSet<>();
        choices.put(choice, votes);
    }

    public void vote(Person voter, ArrayList<String> voter_choices) {
        //adding voter to the list of voters
        voters.add(voter);
        //creating new vote and initializing it
        Vote vote = new Vote(voter,currentTimeString);
        /**
         * for any choices which voter has selected we add his vote to hash set of him
         * not annonumous
         */
        for (String i : voter_choices) {
            for (String j : choices.keySet()) {
                if (i.equals(j)) {
                        choices.get(j).add(vote);
                        break;
                }
            }
            break;
        }


    }

    /**
     * anounymous voting
     * we create a vote and initialize it then put key lst in array lst selecting
     * one of them by random then adding that vote to votes set of that choice
     * @param voter
     */
    public void vote(Person voter){
        int num = choices.size();
        Vote vote  = new Vote(voter,currentTimeString);
        Random random = new Random();
        int random_number = random.nextInt(num);
        ArrayList<String> keyList = new ArrayList<>(choices.keySet());
        String random_member = keyList.get(random_number);
        choices.get(random_member).add(vote);

    }

    /**
     * checking if voting is anonymous or not then printing all the voters name
     */
    public void printVoters(){
        if(isAnonymous == false){
            for(int i = 0; i < voters.size();i++){
                System.out.printf("Voter" + i+1+")"+" "+voters.get(i).getFirstname() + " "+ voters.get(i).getLastname());
            }
        }else{
            return;

        }
    }
    int number = 0;

    /**
     *showing the results of votting 
     */
    public void printResults(){
        int counter = 0;
        for (String key : choices.keySet()){
            counter++;
            System.out.println(counter + ")"+ key + " :" + choices.get(key));
        }
    }
}


class VotingSystem{
    private ArrayList<Voting> votingList;

    public VotingSystem(ArrayList<Voting> votingList) {
        this.votingList = votingList;
    }

    public ArrayList<Voting> getVotingList(){
        return votingList;
    }


    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices){
        Voting voting  = new Voting(type,question,isAnonymous);
    }
    public Voting getVotingList(int index){
     return votingList.get(index);
    }
    public void printResults(int index){
        votingList.get(index).printResults();
    }
    public void printVoters(int index){
        votingList.get(index).printVoters();
    }
    public void printVoting(int index){
        int counter = 0;
        System.out.println("Question : "+ votingList.get(index).getQuestion());
        for (int i = 0; i < votingList.get(index).getChoices().size(); i++) {
            System.out.println(counter + ")" + votingList.get(index).getChoices().get(i));
            counter++;
        }
    }
//    public void vote(int index, Person voter)
//    {
//
//    }
public void vote(Person voter, int index) {
    Date currentDate = new Date();
    // Create a date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // Format the current time to a string
    String currentTimeString = dateFormat.format(currentDate);
    //creating new vote and initializing it
    Vote vote = new Vote(voter,currentTimeString);
    /**
     * for any choices which voter has selected we add his vote to hash set of him
     * not annonumous
     */
    //votter choices
    for (String i : votingList.get(index).getChoices()) {
        for (String j : votingList.get(index).getChoices()) {
            if (i.equals(j)) {
                votingList.get(index).getChoices();
                break;
            }
        }
        break;
    }



}

}
class Main{
    public static void main(String[] args) {
        ArrayList<Voting>votingList = new ArrayList<>();
        VotingSystem votingSystem = new VotingSystem(votingList);
        Voting voting1 = new Voting(1,"Which country is best for living?",false);
        Voting voting2 = new Voting(2,"Which party willwin th war?",true);
        Person person1 = new Person("Amin","Rezaian");
        Person person2 = new Person("Ahad","Samavst");


    }
}









