import java.util.*; 

public class FracCalc {

    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        String inputLine = inputScanner.nextLine();
        System.out.println(produceAnswer(inputLine));
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        String firstoperand= input.substring(0, input.indexOf (" "));
        String operator= input.substring(input.indexOf (" "), input.indexOf (" ") + 2);
        String secondoperator = input.substring(input.indexOf (" ") + 2);
        


        
        // TODO: Implement this function to produce the solution to the input
        
        return secondoperator; 
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}


