import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.HttpStatusException;

import com.google.gson.Gson;

public class BookCrawler {
    
    private static final String USER_AGENT  = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36";
	private static final String SEARCH_URL1 = "https://search.books.com.tw/search/query/key/";
	private static final String SEARCH_URL2 = "/cat/all";
	
	private static class SearchResult {
        private String title;
		private String author;
        private String price;
		private String link;
        private String image;

        public SearchResult(String title,String author,String price, String link, String image) {
            this.title = title;
			this.author = author;
			this.price = price;
            this.link = link;
            this.image = image;
        }
    }
	
    public static String SearchBooks(String keyword) throws Exception {
        String url1 = SEARCH_URL1 + keyword + SEARCH_URL2;//傳入關鍵字形成目標網址
        Document doc1 = Jsoup.connect(url1).userAgent(USER_AGENT).get();//抓下目標網址的資料
		Elements books = doc1.select(".table-td");//24本書所處的欄位
		Gson gson = new Gson();
		SearchResult[] searchResults = new SearchResult[books.size()];
		int i=0;
        for (Element book : books) {
           
 		    String title = book.select("h4").text();
            //System.out.println("Title: " + title);//標題
			
			String author = book.select("p.author").text();
            // System.out.println("Author: " + author);//作者
			
			Element P = book.select("ul.price li").first();
			String price = P.select("b").last().text();
            // System.out.println("Price: " + price);//價錢
			
            Elements link = book.select("a[href]");
            //System.out.println("Link: " + link.attr("href"));//購買連結

            Elements image = book.select("img[src]");
            //System.out.println("Image: " + image.attr("data-src"));//圖片
			
			searchResults[i++] = new SearchResult(title,author,price,link.attr("href"),image.attr("data-src"));//存入
        }
		return gson.toJson(searchResults);//回傳Json檔
    }
}
