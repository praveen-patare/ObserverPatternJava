/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

/**
 *
 * @author Jagannath
 */
public class FootBallTeam implements Comparable {
    private String name;
    private int totalVotes;
    

    public FootBallTeam(String name, int totalVotes) {
        this.name = name;
        this.totalVotes = totalVotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }
    
    @Override
    public String toString(){
        return ". " + this.name;
    }

    @Override
    public int compareTo(Object compareTeam) {
        int compareVotes = ((FootBallTeam)compareTeam).totalVotes;
        return compareVotes - this.totalVotes;
    }
}
