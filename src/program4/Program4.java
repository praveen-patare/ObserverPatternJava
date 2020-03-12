/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jagannath
 */
public class Program4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File f = new File("G:\\College\\OOAD\\Program4\\teams.txt");
            Scanner s = new Scanner(f);
            ArrayList teams = new ArrayList();
            ArrayList<Voter> voters = new ArrayList<Voter>();
            
            AP apSub = new AP();
            new PollObserver(apSub, "LA Times");
            new PollObserver(apSub, "Sports Illustrated");
            new PollObserver(apSub, "fuboTV");
            new PollObserver(apSub, "ESPN");
            
            USToday ustSub = new USToday();
            new PollObserver(ustSub, "LA Times");
            new PollObserver(ustSub, "Sports Illustrated");
            new PollObserver(ustSub, "fuboTV");
            new PollObserver(ustSub, "ESPN");

            
            for(int i = 0 ;i < 25 ; i++){
                teams.add(new FootBallTeam(s.nextLine(),0));
            }
            
             for(int j=0;j<40;j++){
                Voter v = new Voter(teams);
                apSub.setSubscriber(v);
                //new AP(v);
                voters.add(v);;
            }
            
            for(int j=0;j<20;j++){
                Voter v = new Voter(teams);
                //new AP(v);
                apSub.setSubscriber(v);
                ustSub.setSubscriber(v);
                
                voters.add(v);
            }
            
            for(int j=0;j<40;j++){
                Voter v = new Voter(teams);
                ustSub.setSubscriber(v);
                //new USToday(v);
                voters.add(v);
            }
            
            Iterator i = voters.iterator();
            while(i.hasNext()){
                ((Voter)i.next()).castVote();
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
       
    }
}
