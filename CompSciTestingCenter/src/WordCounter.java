import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordCounter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String paragraph;
		String[] datas;
		Set<String> words = new TreeSet<String>();
		System.out.print("Enter some words:\n>");
		paragraph = scan.nextLine();
		datas = paragraph.split(" ");
		for(String word : datas) {
			words.add(word);
		}
		System.out.println(paragraph + " (Number of "
			+ "original words = " + words.size() + "; "
			+ "Word count = " + datas.length);
		scan.close();
	}
}
