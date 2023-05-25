import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.HttpStatusException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import java.util.Scanner;

import com.google.gson.Gson;

public class BookCrawler {
    
    private static final String USER_AGENT  = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36";
	private static final String SEARCH_URL1 = "https://search.books.com.tw/search/query/cat/1/sort/";
	private static final String SEARCH_URL2 = "/v/1/page/";
	private static final String SEARCH_URL3 = "/spell/3/ms2/ms2_1/key/";
	private static final String SEARCH_URL4 = "#f_adv";
	private static class SearchResult {
        private String title;
		private String language;
		private String author;
        private String price;
		private String link;
        private String image;

        public SearchResult(String title,String language,String author,String price, String link, String image) {
            this.title = title;
			this.language=language;
			this.author = author;
			this.price = price;
            this.link = link;
            this.image = image;
        }
    }
	
    public static String searchBooks(String keyword,boolean bool,int howManyBooks,int howToSort) throws Exception {
		SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }          
            public void checkClientTrusted(X509Certificate[] certs, String authType) {               
            }           
            public void checkServerTrusted(X509Certificate[] certs, String authType) {                
            }
        }};
		
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom()); 
		
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
		
        HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
		int i=0,page=1;
		Gson gson = new Gson();
		SearchResult[] searchResults = new SearchResult[howManyBooks];
		while(i<howManyBooks){
			String url1 = SEARCH_URL1 + Integer.toString(howToSort) + SEARCH_URL2 + Integer.toString(page++) + SEARCH_URL3 + keyword + SEARCH_URL4;//傳入關鍵字形成目標網址
			Document doc1 = Jsoup.connect(url1).userAgent(USER_AGENT).get();//抓下目標網址的資料
			Elements books = doc1.select(".table-td");//本頁書籍所處欄位
			for (Element book : books) {
			   
				String title = book.select("h4").text();
				//System.out.println("Title: " + title);//標題
				
				String language = book.select("div.type p").first().text();
				//System.out.println("Language: " + language);//中文or外文
				
				String author = book.select("p.author").text();
				//System.out.println("Author: " + author);//作者
				
				Element P = book.select("ul.price li").first();
				String price = P.select("b").last().text();
				//System.out.println("Price: " + price);//價錢
				
				Elements link = book.select("a[href]");
				//System.out.println("Link: " + link.attr("href"));//購買連結

				Elements image = book.select("img[src]");
				//System.out.println("Image: " + image.attr("data-src"));//圖片
				if(language.equals("中文書") && bool)//true只抓中文
					searchResults[i++] = new SearchResult(title,language,author,price,link.attr("href"),image.attr("data-src"));//存入
				else if(language.equals("外文書") && !bool)//false只抓外文
					searchResults[i++] = new SearchResult(title,language,author,price,link.attr("href"),image.attr("data-src"));
				if(i==howManyBooks) break;
			}
			
		}
		return gson.toJson(searchResults);//回傳Json檔
    }
}
