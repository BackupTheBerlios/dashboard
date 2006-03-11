package utils;


public class Pair<T1,T2>
{
	private T1 first;
	private T2 second;
	
	
	/**
	 * @param first
	 * @param second
	 */
	public Pair(T1 first, T2 second) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.second = second;
	}
	
	
	/**
	 * @return Returns the first.
	 */
	public T1 getFirst() {
		return first;
	}
	
	
	/**
	 * @param first The first to set.
	 */
	public void setFirst(T1 first) {
		this.first = first;
	}
	
	
	/**
	 * @return Returns the second.
	 */
	public T2 getSecond() {
		return second;
	}
	
	
	/**
	 * @param second The second to set.
	 */
	public void setSecond(T2 second) {
		this.second = second;
	}
	
	
}
