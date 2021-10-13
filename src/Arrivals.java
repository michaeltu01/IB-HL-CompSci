import java.util.LinkedList;

public class Arrivals
{
  private LinkedList<Node> flights;
  
  public Arrivals()
  {
    flights = new LinkedList<Node>();
  }
  
  public void addFlight(String fn, int at)
  {
    Node n = new Node(fn, at);
    addNode(n);
  }
  
  private void addNode(Node n)
  {
    flights.add(n);
  }
  
  public String toString()
  {
    String str = "";
    for(int i = 0; i < flights.size(); i++)
    {
      str += "Flight Name: " + flights.get(i).getFlightName() + " " + "Arrival Time: " + flights.get(i).getFlightTime();
      if(i < flights.size() - 1)
      {
        str += " ";
      }
    }
    return str;
  }
  
  public void changeArrivalTime(String fn, int at)
  {
    for(Node n : flights)
    {
      if(n.getFlightName().equals(fn))
      {
        n.changeArrivalTime(at);
        break;
      }
    }
  }
  
  public void landed(String fn, int at)
  {
    for(int i = 0; i < flights.size(); i++)
    {
      if(flights.get(i).getFlightName().equals(fn))
      {
        flights.remove(i);
      }
    }
  }
}