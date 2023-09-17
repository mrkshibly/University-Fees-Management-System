
import java.text.DecimalFormat;

public class NumberToWord   
{  
//string type array for one digit numbers     
private static final String[] twodigits = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};  
//string type array for two digits numbers   
private static final String[] onedigit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};  
//defining constructor of the class  
private NumberToWord()   
{  
}  
//user-defined method that converts a number to words (up to 1000)  
private static String convertUptoThousand(int number)   
{  
String soFar;  
if (number % 100 < 20)  
{  
soFar = onedigit[number % 100];  
number = number/ 100;  
}  
else   
{  
soFar = onedigit[number % 10];  
number = number/ 10;  
soFar = twodigits[number % 10] + soFar;  
number = number/ 10;  
}  
if (number == 0)   
return soFar;  
return onedigit[number] + " Hundred " + soFar;  
}  
//user-defined method that converts a long number (0 to 999999999) to string    
public static String convertNumberToWord(long number)   
{  
//checks whether the number is zero or not  
if (number == 0)   
{   
//if the given number is zero it returns zero  
return "zero";   
}  
//the toString() method returns a String object that represents the specified long  
String num = Long.toString(number);  
//for creating a mask padding with "0"   
String pattern = "000000000000";  
//creates a DecimalFormat using the specified pattern and also provides the symbols for the default locale  
DecimalFormat decimalFormat = new DecimalFormat(pattern);  
//format a number of the DecimalFormat instance  
num = decimalFormat.format(number);  
//format: XXXnnnnnnnnn  
//the subString() method returns a new string that is a substring of this string  
//the substring begins at the specified beginIndex and extends to the character at index endIndex - 1  
//the parseInt() method converts the string into integer  
int billions = Integer.parseInt(num.substring(0,3));  
//format: nnnXXXnnnnnn  
int millions  = Integer.parseInt(num.substring(3,6));  
//format: nnnnnnXXXnnn  
int hundredThousands = Integer.parseInt(num.substring(6,9));  
//format: nnnnnnnnnXXX  
int thousands = Integer.parseInt(num.substring(9,12));  
String tradBillions;  
switch (billions)   
{  
case 0:  
tradBillions = "";  
break;  
case 1 :  
tradBillions = convertUptoThousand(billions)+ " Billion ";  
break;  
default :  
tradBillions = convertUptoThousand(billions)+ " Billion ";  
}  
String result =  tradBillions;  
String tradMillions;  
switch (millions)   
{  
case 0:  
tradMillions = "";  
break;  
case 1 :  
tradMillions = convertUptoThousand(millions)+ " Million ";  
break;  
default :  
tradMillions = convertUptoThousand(millions)+ " Million ";  
}  
result =  result + tradMillions;  
String tradHundredThousands;  
switch (hundredThousands)   
{  
case 0:  
tradHundredThousands = "";  
break;  
case 1 :  
tradHundredThousands = "One Thousand ";  
break;  
default :  
tradHundredThousands = convertUptoThousand(hundredThousands)+ " Thousand ";  
}  
result =  result + tradHundredThousands;  
String tradThousand;  
tradThousand = convertUptoThousand(thousands);  
result =  result + tradThousand;  
//removing extra space if any  
return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");  
}  
//main() method  
public static void main(String args[])   
{  
//calling the user-defined method that converts the parsed number into words  
//System.out.println(convertNumberToWord(2));  

}  
}  