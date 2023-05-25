import java.util.Scanner;

public class BookCrawlerTest {
	public static void main(String[] args) {
		BookCrawler crawl = new BookCrawler();
		LibraryCrawler library = new LibraryCrawler();
		PriceCrawler price = new PriceCrawler();
		try {//注意 若是一次要好幾十本外文書 且排序結果前幾頁皆為中文書 會產生HTTP error Status=484 或是 Connection reset
            String results = crawl.searchBooks("java",true,50,1);//(關鍵字,中文=true外文=false,想抓幾本,如何排序)
			//如何排序: "1" = 精準度,"9" = 暢銷度, "8"=價格(低→高),"7"=價格(高→低),"6"=上市日期(舊→新),"5"=上市日期(新→舊)
			System.out.println(results);
			
			String libraryResults = library.ntouLibrary("漫畫結構力學入門");
			System.out.println(libraryResults);
			
			String priceResults = price.bookPriceCrawler("//search.books.com.tw/redirect/move/key/java/area/mid/item/F019333075/page/3/idx/18/cat/F01/pdf/0/spell/3");
			System.out.println(priceResults);
        } catch (Exception e) {									
            System.out.println("Error occurred: " + e.getMessage());
        }
		
		
	}
}
