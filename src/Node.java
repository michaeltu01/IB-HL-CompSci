public class Node
{
  private String flightName;
  private int arrivalTime;
  
  public Node(String fn, int at)
  {
    flightName = fn;
    arrivalTime = at;
  }
  
  public String getFlightName()
  {
    return flightName;
  }
  
  public int getFlightTime()
  {
    return arrivalTime;
  }
  
  public void changeArrivalTime(int time)
  {
    arrivalTime = time;
  }
}