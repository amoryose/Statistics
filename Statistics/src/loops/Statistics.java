// Avraham Moryosef
// CS 420
// 6/10/15

package loops;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Statistics
{
	public static void main(String[] args)
	{
		int observations = 1,
			num = 0,
			sum = 0,
			max = Integer.MIN_VALUE,
			min = Integer.MAX_VALUE;
		
		double mean = 0.0;
		
		String userEntry = "",
			   result,
			   list = " ",
			   seperator = "\n***********\nYou entered the following observations: ";
		
		DecimalFormat twoDigits = new DecimalFormat ("0.00");
		
		userEntry = JOptionPane.showInputDialog ("Enter observation # " + observations + 
				 " (or \"end\" to quit) ");
		
		while(!userEntry.equalsIgnoreCase("end"))
		{		
			num = Integer.parseInt(userEntry);
			observations ++;			
			userEntry = JOptionPane.showInputDialog ("Enter observation #" + observations + 
						" (or \"end\" to quit) ");
			
			sum = sum + num;		
		
			if(num > max)
			{
				max = num;
			}
			
			if(num < min)
			{
				min = num;
			}
			
			list  = list + "\n" + num;				
		}
		
		observations --;
		mean = sum / (double)observations;
		
		if(observations == 0)
		{
			result = "no observations selected"; // -1 for not capitalizing N
		}
		
		else
		{
			result = "You entered " + observations + 
					  (observations == 1 ? " observation" : " observations");
			result = result + "\nThe minimum is " + min;
			result = result + "\nThe maximum is " + max;
			result = result + "\nThe sum is " + sum;
			result = result + "\nThe mean is " + twoDigits.format(mean);
			result = result + seperator;
			result = result + list;
		}
		JOptionPane.showMessageDialog(null, result, 
				"Results", JOptionPane.INFORMATION_MESSAGE);
			
		System.exit(0);
	}
}
