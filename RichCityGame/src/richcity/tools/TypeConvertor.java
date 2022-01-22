package richcity.tools;

public class TypeConvertor {

	public static int tryToConvTextToInt(String txt) {
		
		try{
			int nbr = Integer.parseInt(txt);
			if(nbr > 0) {
				return Integer.parseInt(txt);
			} 
        } catch (NumberFormatException ex){
            ex.printStackTrace();
            
        }return -1;
	}
}
