import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookCrawler {
    public static void main(String[] args) throws Exception {
		String userSearch="名偵探柯南";//使用者可以自訂搜尋關鍵字
        String url = "https://search.books.com.tw/search/query/key/"+userSearch+"/cat/all";
        Document doc = Jsoup.connect(url).get();

        // 選擇所有書籍元素
        Elements books = doc.select(".table-td");
        for (Element book : books) {
            // 取得書籍標題
            String title = book.select("h4").text();
            System.out.println("Title: " + title);

            // 取得書籍連結
            Elements link = book.select("a[href]");
            System.out.println("Link: " + link.attr("href"));

            // 取得書籍圖片
            Elements image = book.select("img[src]");
            System.out.println("Image: " + image.attr("data-src"));
        }
    }
}
