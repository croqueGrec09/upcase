package de.uni_koeln.spinfo.upcase.mongodb.data.document.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ref_pages")
public class Page {
	
	@Transient
	public static final String COLLECTION = "ref_pages";
	
	@Id private String id;
	
	private Date lastModified;
	private String imageUrl;
	private int pageNumber;
	private int physicalPageNumber;
	private List<Word> words = new ArrayList<>();
	private String collection;
	private String user;
	private String title;
//	@DBRef private Chapter chapter;
//	@DBRef private Volume volume;
	
	public Page() {
		// default constructor
	}
			
	// ONLY CONSTRUCTOR USED FOR NOW
	public Page(final String collection, final String imageUrl, int pageNumber, int physicalPageNumber) {
		super();
		this.lastModified = new Date();
		this.collection = collection;
		this.imageUrl = imageUrl;
		this.pageNumber = pageNumber;
		this.physicalPageNumber = physicalPageNumber;
		this.words = new ArrayList<>();
	}
	
	public Page(String imageUrl, int pageNumber, int physicalPageNumber, String collection, String user) {
		super();
		this.lastModified = new Date();
		this.imageUrl = imageUrl;
		this.pageNumber = pageNumber;
		this.physicalPageNumber = physicalPageNumber;
		this.collection = collection;
		this.user = user;
		this.words = new ArrayList<>();
	}
	
	public Page(String imageUrl, int pageNumber, int physicalPageNumber, String collection, String user, List<Word> words) {
		super();
		this.lastModified = new Date();
		this.imageUrl = imageUrl;
		this.pageNumber = pageNumber;
		this.physicalPageNumber = physicalPageNumber;
		this.collection = collection;
		this.user = user;
		this.words = words;
	}


	public Map<String, Integer> getWordIdToIndex() {
		Map<String, Integer> wordIdToIndex = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			Word word = words.get(i);
			wordIdToIndex.put(word.getId(), i);
		}
		return wordIdToIndex;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		if(title == null || title.isEmpty()) {
			List<String> parts = Arrays.asList(imageUrl.split("/"));
			return parts.get(parts.size() - 1);
		}
		return title;
	}
	
	/**
	 * 
	 * @return userId
	 */
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return collectionID
	 */
	public String getCollection() {
		return collection;
	}
	
	public void setCollection(String collection) {
		this.collection = collection;
	}


	public Date getLastModified() {
		return lastModified;
	}


	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPhysicalPageNumber() {
		return physicalPageNumber;
	}


	public void setPhysicalPageNumber(int physicalPageNumber) {
		this.physicalPageNumber = physicalPageNumber;
	}


	public List<Word> getWords() {
		return words;
	}
	
	public void setWords(List<Word> words) {
		this.words = words;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + pageNumber;
		result = prime * result + physicalPageNumber;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (physicalPageNumber != other.physicalPageNumber)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Page [id=" + id + ", imageUrl=" + imageUrl + ", pageNumber=" + pageNumber + ", words=" + words + "]";
	}


}
