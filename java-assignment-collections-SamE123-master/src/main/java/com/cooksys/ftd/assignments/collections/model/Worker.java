package com.cooksys.ftd.assignments.collections.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A worker is a type of employee that cannot be a superior to another employee.
 *  <br>
 *  A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker implements Employee {

    // TODO: Does this class need private fields? If so, add them here
	private String name;
	private Manager man;
	
    /**
     * TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     */
    public Worker(String name) {
        this.name = name;
    }

    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     * @param manager the direct manager of the worker to be created
     */
    public Worker(String name, Manager manager) {
        this.name = name;
        this.man = manager; 
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the name of the worker
     */
    @Override
    public String getName() {
    	return name;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return {@code true} if this worker has a manager, or {@code false} otherwise
     */
    @Override
    public boolean hasManager() {
        return man != null;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the manager of this worker, or null if it has none
     */
    @Override
    public Manager getManager() {
    	
     	if(hasManager())
    		return man;
    	else
    		return null;
    }

    /**
     * TODO: Implement this method.
     *  <br><br>
     *  Retrieves the worker's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     *  followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     *  <br><br>
     *  The returned list should never be or contain {@code null}.
     *  <br><br>
     *  If the worker does not have a {@code Manager}, an empty
     *  {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the worker's chain of command,
     */
    @Override
    public List<Manager> getChainOfCommand() {
    	
    	List<Manager> chainOfCommand = new ArrayList<Manager>();
    	
    	Manager chainMan = this.man;
    	
    	while(chainMan != null) {
    		chainOfCommand.add(chainMan);
    		chainMan = chainMan.getManager();
    	}
    	
    	return chainOfCommand; 	

    }

    
  // TODO: Does this class need custom .equals() and .hashcode() methods? If so, implement them here.
    
    @Override
    public boolean equals(Object e) {
    	if(e == null)
    		return false;
    	if(!(e instanceof Worker))
    		return false;
    	else {
    		Worker compWor = (Worker) e;
    		return this.name.equals(compWor.getName());
    	}
    }
    
    @Override
    public int hashCode() {
    	return this.name.hashCode();
    }
    

    // TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want to debug your code with System.out.println() statements
}
