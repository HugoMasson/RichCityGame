package richcity.tools;

public class TypeConvertor {

	public static int tryToConvTextToInt(String txt) {
		try{
			int nbr = Integer.parseInt(txt);
			if(nbr > 0) {
				return nbr;
			} 
        } catch (NumberFormatException ex){
            //ex.printStackTrace();
        	System.out.println("Invalid Input...");
        }return -1;
	}
	
	public static double tryToConvTextToDouble(String txt) {
		try{
			double nbr = Double.valueOf(txt);
			if(nbr > 0) {
				return nbr;
			} 
        } catch (NumberFormatException ex){
            //ex.printStackTrace();
        	System.out.println("Invalid Input...");
        }return -1;
	}
}
