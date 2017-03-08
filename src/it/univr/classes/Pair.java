package it.univr.classes;

public class Pair<A,M> {
	private String A;
	private String M;
	
	public Pair()
	{
		this.A = "";
		this.M = "";
	}
	
	public void setAuthor(String author)
	{
		this.A = author;
	}
	
	public void setMessage(String mess)
	{
		this.M = mess;
	}
	
	public String getAuthor()
	{
		return A;
	}
	
	public String getMessage()
	{
		return M;
	}
	
}
