/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dylemator;

/**
 *
 * @author nanker
 */
public class Dilemma {
    
    private String type;
    private int index;
    private String name;
    private String description;
    private String question;
    private String problem;
    private String answer;
    private long seconds;

    public Dilemma(String answer,long seconds){
        this.answer = answer;
        this.seconds = seconds;
    }
    public Dilemma(String type,String name,String description,String problem,String question){
        this.type = type;
        this.name = name;
        this.description = description;
        this.problem = problem;
        this.question = question;
    }

    Dilemma() {
        //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dilemma
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the dilemma to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    public String getAnswerType(){
        if(this.answer.equalsIgnoreCase("TAK"))
            return "1";
        if(this.answer.equalsIgnoreCase("NIE"))
            return "2";
        return "";
    }
    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the seconds
     */
    public long getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set
     */
    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }
    
    @Override
    public String toString(){
        return  "Name: " + this.name +
                " Time[ms]: " + 
                this.seconds + 
                ", Answer: " + 
                this.answer;
        
    }
}
