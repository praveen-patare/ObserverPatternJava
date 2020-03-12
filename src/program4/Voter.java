/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
 
/**
 *
 * @author Jagannath
 */
public class Voter implements Subject{

    ArrayList<Observer> observers = new ArrayList<Observer>();
    static ArrayList<Integer> votes = new ArrayList<Integer>();
    ArrayList<FootBallTeam> voterTeams = new ArrayList<FootBallTeam>();
    static int voterCount;
   static{
            voterCount = 0;    
            votes.add(1);votes.add(2);votes.add(3);votes.add(4);votes.add(5);votes.add(6);votes.add(7);votes.add(8);
            votes.add(9);votes.add(10);votes.add(11);votes.add(12);votes.add(13);votes.add(14);votes.add(15);votes.add(16);
            votes.add(17);votes.add(18);votes.add(19);votes.add(20);votes.add(21);votes.add(22);votes.add(23);votes.add(24);votes.add(25);
        }

    Voter(ArrayList teams) {
        Iterator i1 = teams.iterator();
        //Iterator i2 = voterTeams.iterator();
        while(i1.hasNext()){
            voterTeams.add((FootBallTeam)i1.next());
        }
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
        for(Observer o : observers){
            //System.out.println(o.toString());
            o.update(voterTeams);
        }
    }
    
    void castVote() {
            //System.out.println("Before computation for voter " + ++voterCount);
            Collections.shuffle(votes);
            Iterator itr = voterTeams.iterator();
            Iterator i = votes.iterator();
            while(itr.hasNext() && i.hasNext()){
                ((FootBallTeam)itr.next()).setTotalVotes((Integer)i.next());
            }
            ++voterCount;
            
                notifyAllSubscribers();
    }
}
