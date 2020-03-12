/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Jagannath
 */
public class AP implements Subject, Observer{

    ArrayList<Observer> observers = new ArrayList<Observer>();
    //ArrayList<FootBallTeam> teams;
    static boolean flag = false;
    int count = 0;
    ArrayList<FootBallTeam> votedTeams = new ArrayList<FootBallTeam>();
    int total[] = new int[25]; 
    //static{
      //  votedTeams = new ArrayList<FootBallTeam>();
    //}
    Voter v;

    /*AP(Voter v) {
        this.v = v;
        v.addSubscriber(this);
    }*/

    void setSubscriber(Voter v) {
        this.v = v;
        v.addSubscriber(this);
    }

    @Override
    public String toString() {
        return "Voter added to AP poll";
    }

    @Override
    public void addSubscriber(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeSubscriber(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllSubscribers() {
        System.out.println("AP");
        for(Observer o : observers){
            o.update(votedTeams);
        }
    }

    @Override
    public void update(ArrayList<FootBallTeam> teams) {
        int t=0;
        if(!flag){
            Iterator<FootBallTeam> itr = teams.iterator();
            while(itr.hasNext()){
                FootBallTeam f = itr.next();
                votedTeams.add(f);
                total[t++] = 26 - f.getTotalVotes();    
            }            
            flag = true;
        }
        else{
            Iterator<FootBallTeam> itr = teams.iterator();

            while(itr.hasNext()){
                total[t] = total[t++] + (26 - itr.next().getTotalVotes());
            }
        }

        ++count;
        if(count == 60){
            t=0;
            Iterator<FootBallTeam> itrv = votedTeams.iterator();
            while(itrv.hasNext()){
                itrv.next().setTotalVotes(total[t++]);
            }
            Collections.sort(votedTeams);
            this.notifyAllSubscribers();
        }
    }
}
