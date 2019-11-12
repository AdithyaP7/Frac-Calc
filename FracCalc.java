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
        String operator= input.substring(input.indexOf (" ")+1, input.indexOf (" ") + 2);
        String secondoperand = input.substring(input.indexOf (" ") + 3);
        String secondoperandwhole = " ";
        String secondoperandnum = " ";
        String secondoperanddenom = " ";
        String unsimplifiedanswer = " ";
        String simplifiedanswer = " ";

        if (firstoperand.contains("_") && firstoperand.contains("-")==false)
        {
            firstoperandwhole = firstoperand.substring(0, firstoperand.indexOf("_"));
            firstoperandnum = firstoperand.substring(firstoperand.indexOf("_")+1, firstoperand.indexOf("/"));
            firstoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1);
        }
        else if(firstoperand.contains("_") && firstoperand.contains("-"))
        {
            firstoperandwhole = firstoperand.substring(firstoperand.indexOf("-")+1, firstoperand.indexOf("_"));
            firstoperandnum = firstoperand.substring(firstoperand.indexOf("_"), firstoperand.indexOf("/"));
            firstoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1);
        }
        else if (firstoperand.contains("_") == false && firstoperand.contains("/") && firstoperand.contains("-") == false){
            firstoperandwhole = "0" ;
            firstoperandnum = firstoperand.substring(0,firstoperand.indexOf("/"));
            firstoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1);
        }   
        else if (firstoperand.contains("_") == false && firstoperand.contains("/") && firstoperand.contains("-")){
            firstoperandwhole = "0" ;
            firstoperandnum = firstoperand.substring(firstoperand.indexOf("-")+1,firstoperand.indexOf("/"));
            firstoperanddenom = firstoperand.substring(firstoperand.indexOf("/")+1);
        }
        else if (firstoperand.contains("_") == false && firstoperand.contains("/") == false && firstoperand.contains("-")){
            firstoperandwhole = firstoperand.substring(firstoperand.indexOf("-")+1);
            firstoperandnum = "0";
            firstoperanddenom = "1";
        }
        else if (firstoperand.contains("_") == false && firstoperand.contains("/") == false && firstoperand.contains("-")== false){
            firstoperandwhole = firstoperand;
            firstoperandnum = "0";
            firstoperanddenom = "1";
        }
        if (secondoperand.contains("_") == false && secondoperand.contains("/") == false){
            secondoperandwhole = secondoperand;
            secondoperandnum = "0";
            secondoperanddenom = "1";
        }
        else if (secondoperand.contains("_") && secondoperand.contains("/")){
            secondoperandwhole = secondoperand.substring(0,secondoperand.indexOf("_"));
            secondoperandnum = secondoperand.substring(secondoperand.indexOf("_")+1, secondoperand.indexOf("/"));
            secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
        }
        else{
            secondoperandwhole = "0";
            secondoperandnum = secondoperand.substring(0, secondoperand.indexOf("/"));
            secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
        }
        String secondcheckpoint = "Whole: " + secondoperandwhole + " " + "Numerator: " + secondoperandnum + " " + "Denominator: " + secondoperanddenom;
        int firstoperandwholeint = Integer.parseInt(firstoperandwhole);
        int firstoperandnumint = Integer.parseInt(firstoperandnum);
        int firstoperanddenomint = Integer.parseInt(firstoperanddenom);
        int secondoperandwholeint = Integer.parseInt(secondoperandwhole);
        int secondoperandnumint = Integer.parseInt(secondoperandnum);
        int secondoperanddenomint = Integer.parseInt(secondoperanddenom);
        int impropernumfirstoperand = ((firstoperandwholeint * firstoperanddenomint) + firstoperandnumint) ;
        int impropernumsecondoperand = ((secondoperandwholeint * secondoperanddenomint) + secondoperandnumint);
        if (operator.contains("+")){
            unsimplifiedanswer = addition(firstoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else if (operator.contains("-")){
            unsimplifiedanswer = subtraction(firstoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else if (operator.contains("*")){
            unsimplifiedanswer = multiplication(firstoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else{
            unsimplifiedanswer = division(firstoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        System.out.println(unsimplifiedanswer);
        //simplifiedanswer = simplification(unsimplifiedanswer);

        /*String operator= input.substring(input.indexOf (" "), input.indexOf (" ") + 2);
        String secondoperand = input.substring(input.indexOf (" ") + 2);
        String secondoperandwhole = secondoperand.substring(0, secondoperand.indexOf("_"));
        String secondoperandnum = secondoperand.substring(secondoperand.indexOf("_"), secondoperand.indexOf("/"));
        String secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
         */
        //String secondcheckpoint = "Whole: " + secondoperandwhole + " " + "Numerator: " + secondoperandnum + " " + "Denominator: " + secondoperanddenom;

        // TODO: Implement this function to produce the solution to the input
        //return secondcheckpoint; 
        //return secondcheckpoint;
        return unsimplifiedanswer;
    }

    public static String addition(String container, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = firstdenom * seconddenom;
        firstnum = firstnum * seconddenom;
        secondnum = secondnum * firstdenom;
        if (container.contains("-")== false){
            num = firstnum + secondnum;
        }
        else{
            num = secondnum - firstnum;

        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String subtraction(String container, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = firstdenom * seconddenom;
        firstnum = firstnum * seconddenom;
        secondnum = secondnum * firstdenom;
        if (container.contains("-")== false){
            num = firstnum - secondnum;
        }
        else{
            num = (secondnum + firstnum);
            num *= -1;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String multiplication(String container, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = 0;
        if (container.contains("-")== false){
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
        }
        else{
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
            num *= -1;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String division(String container, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = 0;
        if (container.contains("-")== false){
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
        }
        else{
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
            num *= -1;
        }
        String result = (num + "/" + denom);
        return result;
    }

    /*public static String simplification(String fraction){
    int num = Integer.parseInt(fraction.substring(0,fraction.substring("/")));
    }*/
}

