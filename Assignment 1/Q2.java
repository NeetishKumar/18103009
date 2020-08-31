import java.util.*;

public class Q2
{
    public static void print(String msg){
    
        System.out.println(msg);
    }

    public static void main(String args[]){
    
    	Scanner sc = new Scanner(System.in);
    	print("Enter size of the word vector : ");
    	
    	int size = sc.nextInt();

    	print("Input 'ZZZ' to break cycle");
    	print("Enter the words to reduce : ");
    	
    	Set<String> s1 = new HashSet<String>();
    	
    	for(int j=0 ; j<size ; j++){
    	
    		s1.add(sc.next());
    	}

    	print("Enter word 'ZZZ' to mark the end of paragraph.");

    	print("Enter the paragraph in question : ");

    	String paragraph = sc.next();
    	StringBuffer ans = new StringBuffer();

    	while(!paragraph.equals("ZZZ")){
    	
    		if(s1.contains(paragraph)){
    		
    			ans.append(paragraph.charAt(0)+"");
    			for(int j=1 ; j<paragraph.length() ; j++)
                    ans.append("*");
    			
    			ans.append(" ");
    		}
    		
    		else
    			ans.append(paragraph + " ");
    		
    		paragraph = sc.next();
    	}
  
    	print("Answer : ");

    	print(ans.toString().trim());  	
    }   
}