package com.backend.contentservice.model;

import javax.persistence.*;

@Entity
@Table(name = "content_details")
public class Content {
    
    public Content() {
    }
 
             
    	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
                  
        @Column(name = "title")
	private String title;

	@Column(name = "protagonist")
	private String protagonist;

	@Column(name = "detail")
	private String detail;

	public Content(String title, String protagonist, String detail) {
		this.title = title;
		this.protagonist = protagonist;
		this.detail = detail;
	}
        
                
        public long getId() {
		return id;
	}
        
        public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
        
        public String getProtagonist() {
		return protagonist;
	}

	public void setProtagonist(String protagonist) {
		this.protagonist = protagonist;
	}
        
        public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
        
        
        @Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", protagonist=" + protagonist + ", detail=" + detail + "]";
	}

}















