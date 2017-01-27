package lecture3;

public class LUTTest {
  public static void main(String[] args) {
    try {
      LUT<Integer> myLUT = new LinearLUT<Integer>();

      myLUT.insert("Priscilla", new Integer(41));
      myLUT.insert("Travis", new Integer(34));
      myLUT.insert("Samuel", new Integer(28));
      myLUT.insert("Helena", new Integer(39));
      myLUT.insert("Andrew", new Integer(14));
      myLUT.insert("Kay", new Integer(24));
      myLUT.insert("John", new Integer(67));

      System.out.println(myLUT);
      System.out.println(myLUT.retrieve("John"));

      myLUT.update("Samuel", new Integer(29));
      myLUT.remove("Andrew");

      System.out.println(myLUT);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
