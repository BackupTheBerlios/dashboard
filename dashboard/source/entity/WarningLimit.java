package entity;

public class WarningLimit {
	private static int minLimit;
	private static int maxLimit;
	
	public WarningLimit ()
	{
		minLimit=25;
		maxLimit=70;
	}
	public static int getMinLimit ()
	{
		return(minLimit);
	}
	public static int getMaxLimit ()
	{
		return(maxLimit);
	}
	public static void setMaxLimit (int limit)
	{
		maxLimit=limit;
	}
	public static void setMinLimit (int limit)
	{
		minLimit=limit;
	}
	
}
