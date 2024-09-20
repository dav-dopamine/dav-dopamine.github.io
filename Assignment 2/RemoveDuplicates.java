
public class RemoveDuplicates 
{
	public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            
            if (inStack[c - 'a']) continue;
            
            while (result.length() > 0 && result.charAt(result.length() - 1) > c && count[result.charAt(result.length() - 1) - 'a'] > 0) {
                inStack[result.charAt(result.length() - 1) - 'a'] = false;
                result.setLength(result.length() - 1);
            }
            
            result.append(c);
            inStack[c - 'a'] = true;
        }
        
        return result.toString();
    }
}
   

