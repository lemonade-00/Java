import java.util.Scanner;

public class BookCrawlerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookCrawler crawl = new BookCrawler();
		String keyword = scanner.nextLine();
		try {
            String results = crawl.SearchBooks(keyword,false,30);//(關鍵字,中文true外文false,想抓幾本)
			System.out.println(results);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
	}
}
