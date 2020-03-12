/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jagannath
 */
public class PollObserver implements Observer{
    private String name;
    Subject sub;
    
    PollObserver(Subject sub, String name) {
        this.sub = sub;
        this.name = name;
        sub.addSubscriber(this);
        //System.out.println(name + " added to subscribers list");
    }

    @Override
    public String toString() {
        return "PollObserver{" + "name=" + name + '}';
    }

    
    @Override
    public void update(ArrayList<FootBallTeam> votedTeams) {
        int count = 0;
        //System.out.println("In PollObserver's update");
        Iterator i = votedTeams.iterator();
        System.out.println(this.name);
        while(i.hasNext())
        {
            //System.out.print("in while");
            System.out.println(++count + i.next().toString());
        }

    }
    
}
