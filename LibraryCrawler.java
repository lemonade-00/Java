import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.HttpStatusException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import java.util.Scanner;

public class LibraryCrawler{
	
	public static String ntouLibrary(String keyword) throws Exception {
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
		
		String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";
		String	url ="https://ocean.ntou.edu.tw/search*cht/X?SEARCH=" + keyword +"&SORT=A";
		Document doc = Jsoup.connect(url).userAgent(USER_AGENT).get();
		int i=0;
		String fourthColumn = "";
		try{
			Elements trElements = doc.select("tr.bibItemsEntry");
		 for (Element trElement : trElements) {	
			Element tdElement = trElement.select("td").get(3);
			fourthColumn += tdElement.text();
			fourthColumn += ", ";
			i++;
		 }
			if(i!=0)
				return "海大圖書館目前共有"+i+"本書, 處理狀態分別為: "+fourthColumn;
			return "海大圖書館目前沒有這本書";
		}
		catch (Exception e) {		
			System.out.println("Error occurred: " + e.getMessage());
            return "海大圖書館目前沒有這本書";
			
        }
}
}