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
            firstoperandnum = firstoperand.substring(firstoperand.indexOf("_") +1, firstoperand.indexOf("/"));
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
        if (secondoperand.contains("_") == false && secondoperand.contains("/") == false && secondoperand.contains("-") ==  false){
            secondoperandwhole = secondoperand;
            secondoperandnum = "0";
            secondoperanddenom = "1";
        }
        else if (secondoperand.contains("_") == false && secondoperand.contains("/") == false && secondoperand.contains("-")){
            secondoperandwhole = secondoperand.substring(secondoperand.indexOf("-")+1);
            secondoperandnum = "0";
            secondoperanddenom = "1";
        }
        else if (secondoperand.contains("_") && secondoperand.contains("/") && secondoperand.contains("-")== false){
            secondoperandwhole = secondoperand.substring(0,secondoperand.indexOf("_"));
            secondoperandnum = secondoperand.substring(secondoperand.indexOf("_")+1, secondoperand.indexOf("/"));
            secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
        }
        else if (secondoperand.contains("_") && secondoperand.contains("/") && secondoperand.contains("-")){
            secondoperandwhole =  secondoperand.substring(secondoperand.indexOf("-")+1, secondoperand.indexOf("_"));
            secondoperandnum = secondoperand.substring(secondoperand.indexOf("_")+1,secondoperand.indexOf("/"));
            secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
        }
        else if (secondoperand.contains("_") == false && secondoperand.contains("/") && secondoperand.contains("-") == false){
            secondoperandwhole = "0";
            secondoperandnum = secondoperand.substring(0, secondoperand.indexOf("/"));
            secondoperanddenom = secondoperand.substring(secondoperand.indexOf("/")+1);
        }
        else{
            secondoperandwhole = "0";
            secondoperandnum = secondoperand.substring(secondoperand.indexOf("-")+1, secondoperand.indexOf("/"));
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
            unsimplifiedanswer = addition(firstoperand, secondoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else if (operator.contains("-")){
            unsimplifiedanswer = subtraction(firstoperand, secondoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else if (operator.contains("*")){
            unsimplifiedanswer = multiplication(firstoperand, secondoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        else if (operator.contains("/")){
            unsimplifiedanswer = division(firstoperand, secondoperand, impropernumfirstoperand,firstoperanddenomint, impropernumsecondoperand, secondoperanddenomint);
        }
        System.out.println(unsimplifiedanswer);
        simplifiedanswer = simplification(unsimplifiedanswer);

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
        return simplifiedanswer;
    }

    public static String addition(String container, String container2, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = firstdenom * seconddenom;
        firstnum = firstnum * seconddenom;
        secondnum = secondnum * firstdenom;
        if (container.contains("-")== false && container2.contains("-") == false){
            num = firstnum + secondnum;
        }
        else if (container.contains("-") && container2.contains("-") == false){
            num = secondnum - firstnum;

        }
        else if (container.contains("-") == false && container2.contains("-")){
            num = firstnum - secondnum;
        }
        else if (container.contains("-") && container2.contains("-")){
            firstnum *= -1;
            num = firstnum - secondnum;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String subtraction(String container, String container2,int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = firstdenom * seconddenom;
        firstnum = firstnum * seconddenom;
        secondnum = secondnum * firstdenom;
        if (container.contains("-")== false && container2.contains("-") == false){
            num = firstnum - secondnum;

        }
        else if (container.contains("-") && container2.contains("-") == false){
            firstnum *= -1;
            num = firstnum - secondnum;

        }
        else if (container.contains("-") == false && container2.contains("-")){
            num = firstnum + secondnum;
        }
        else if (container.contains("-") && container2.contains("-")){
            firstnum *= -1;
            num = firstnum + secondnum;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String multiplication(String container, String container2, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = 0;
        if (container.contains("-")== false && container2.contains("-") == false){
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
        }
        else if (container.contains("-") && container2.contains("-") == false){
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
            num *= -1;

        }
        else if (container.contains("-") == false && container2.contains("-")){
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
            num *= -1;
        }
        else {
            num = firstnum * secondnum;
            denom = firstdenom * seconddenom;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String division(String container,String container2, int firstnum,int firstdenom, int secondnum, int seconddenom){
        int num = 0;
        int denom = 0;

        if (container.contains("-")== false && container2.contains("-") == false){
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
        }
        else if (container.contains("-") && container2.contains("-") == false){
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
            num *= -1;
        }
        else if (container.contains("-") == false && container2.contains("-")){
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
            num *= -1;
        }
        else if (container.contains("-") && container2.contains("-")){
            num = firstnum * seconddenom;
            denom = firstdenom * secondnum;
        }
        String result = (num + "/" + denom);
        return result;
    }

    public static String simplification(String fraction){
        int num = 0;
        int denom = 0;
        int gcf = 0; 
        String answer;
        int divide = 0;
        int mod = 0;
        if(fraction.substring(fraction.indexOf("/")+1).contains("1") && (fraction.substring(fraction.indexOf("/")+1).length() == 1)){
            answer = fraction.substring(0, fraction.indexOf("/"));
        }
        else{
            if (fraction.contains("-") == false){
                if(fraction.substring(0, 1).contains("0")){
                    answer = "0";
                }
                else{
                    num = Integer.parseInt(fraction.substring(0,fraction.indexOf("/")));
                    denom = Integer.parseInt(fraction.substring(fraction.indexOf("/")+1));
                    if (num == denom){
                        answer = "1";
                    }
                    else{
                        gcf = gcf(num, denom);
                        num = num/gcf;
                        denom = denom/gcf;
                        divide = num/denom;
                        mod = num%denom;
                        if (divide == 0){
                            answer = mod + "/" + denom;
                        }
                        else{
                            answer = divide + "_" + mod + "/" + denom;
                        }
                        
                    }
                }
            }
            else{
                if(fraction.substring(fraction.indexOf("-")+1, fraction.indexOf("-")+2).contains("0")){
                    answer = "0";
                }
                else{
                    num = Integer.parseInt(fraction.substring(fraction.indexOf("-") +1,fraction.indexOf("/")));
                    denom = Integer.parseInt(fraction.substring(fraction.indexOf("/")+1));
                    gcf = gcf(num, denom);
                    num = num/gcf;
                    denom = denom/gcf;
                    divide = num/denom;
                    mod = num%denom;
                    if (divide == 0){
                        mod *= -1;
                        answer = mod + "/" + denom;
                    }
                    else{
                        divide *= -1;
                        answer = divide + "_" + mod + "/" + denom;
                    }
                    
                }
            }
        }
        if (answer.substring(answer.indexOf("_")+1,answer.indexOf("_")+2).contains("0")){
            answer = Integer.toString(divide);
        }
        return answer;

    }

    public static int gcf(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
}

