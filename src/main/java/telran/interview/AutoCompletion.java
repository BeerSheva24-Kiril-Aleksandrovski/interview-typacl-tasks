
package telran.interview;

import java.util.TreeSet;

public class AutoCompletion {
    
    TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    //adds new word into auto-completion variants
	//returns true if added, false otherwise (if a given word already exists)
    public boolean addWord(String word) {
        return words.add(word);
    }
    
    //returns all words beginning with a given prefix
	//Complexity of finding the variants is O[logN]
    public String[] getVariants(String prefix) {
        return words.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
    }
}
