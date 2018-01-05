package vo;

import java.util.Iterator;
import java.util.List;

import model.Server;

public class SearchMetaData {
	
	//totalPages, sort from request, 
	private long totalElements;
	private int size;
	private String direction;
	private boolean first;
	private boolean last;
	private int number;
	private int NumberOfElements;
	private boolean hasNext;
	private boolean hasPrevious;
	private Iterator<Server> serverName;

	
	public Iterator<Server> getServerName() {
		return serverName;
	}
	public void setServerName(Iterator<Server> serverName) {
		this.serverName = serverName;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public int getNumberOfElements() {
		return NumberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		NumberOfElements = numberOfElements;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	private int totalPages;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
}
