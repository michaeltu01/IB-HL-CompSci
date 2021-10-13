public class ArrivalsTester
{
  public static void main(String [] args)
  {
    Arrivals flights = new Arrivals();
    //MX2460 10:15, KL4231 10:20, DU21 10:44
    flights.addFlight("MX2460", 1015);
    flights.addFlight("KL4231", 1020);
    flights.addFlight("DU21", 1044);
    System.out.println("The flight list");
    System.out.println(flights);
    
    flights.addFlight("SW2135", 1030);
    System.out.println("\nFlight SW2135 added");
    System.out.println(flights);
    
    flights.changeArrivalTime("KL4231", 1050);
    System.out.println("\nFlight KL4231 time changed");
    System.out.println(flights);
    
    flights.landed("MX2460", 1015);
    System.out.println("\nFlight MX2460 landed");
    System.out.println(flights);
    
  }
}
                         