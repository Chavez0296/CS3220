package cs3220.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Poll {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String question;
	
	private boolean singleChoice;
	
	@ElementCollection
	private List<String> answers;
	
	public Poll() {
		
	}
	
	public Poll(String name, boolean singleChoice) {
		this.question = name;
		this.singleChoice = singleChoice;
		this.answers = new ArrayList<String>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isSingleChoice() {
		return singleChoice;
	}

	public void setSingleChoice(boolean singleChoice) {
		this.singleChoice = singleChoice;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}