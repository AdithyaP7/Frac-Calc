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

        String firstoperand = input.substring(0, input.indexOf (" "));
        String firstoperandwhole = " ";
        String firstoperandnum = " ";
        String firstoperanddenom = " ";
        if (firstoperand.contains(" "))
        {
            firstoperandwhole = firstoperand.substring(0, firstoperand.indexOf("_"));
            firstoperandnum = firstoperand.substring(firstoperand.indexOf("_"), firstoperand.indexOf("/"));
            firstoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1);
        }
        else if (firstoperand.contains("_") == false && firstoperand.contains("/")){
            firstoperandwhole = 0;
            firstoperandnum = firstoperand.substring(indexOf("1"||"2"||"3"||"4"||"5"||"6"||"7"||"8"||"9"),firstoperand.indexOf("/"));
            firatoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1, firstoperand.indexOf(" "));
        }   
        else
        {
            firstoperandwhole = 
            /*String operator= input.substring(input.indexOf (" "), input.indexOf (" ") + 2);
            String secondoperand = input.substring(input.indexOf (" ") + 2);
            String secondoperandwhole = secondoperand.substring(0, secondoperand.indexOf("_"));
            String secondoperandnum = secondoperand.substring(secondoperand.indexOf("_"), secondoperand.indexOf("/"));
            String secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
             */
            //String secondcheckpoint = "Whole: " + secondoperandwhole + " " + "Numerator: " + secondoperandnum + " " + "Denominator: " + secondoperanddenom;

            // TODO: Implement this function to produce the solution to the input
            //return secondcheckpoint; 
        }
        return firstoperanddenom;

    }

