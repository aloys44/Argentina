package fr.MelodyApp.model;

import javax.persistence.*;

@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
    @Basic(optional = false)
	private Integer note;
	
    @Basic(optional = false)
	private String comment;
    
    private Integer user;
    


	public Notice() {
	}

	public Notice(Long id, Integer note, String comment) {
		super();
		this.id = id;
		this.note = note;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}




    
    

}
