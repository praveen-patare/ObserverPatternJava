/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package program4;

/**
 *
 * @author Jagannath
 */
public interface Subject {
    public void addSubscriber(Observer o);
    public void removeSubscriber(Observer o);
    public void notifyAllSubscribers();
}
