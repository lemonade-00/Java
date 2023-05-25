import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.HttpStatusException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;
import java.util.Scanner;

public class PriceCrawler{
	public static String bookPriceCrawler(String url) throws Exception {
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
		
		Document doc = Jsoup.connect("https:"+url).userAgent(USER_AGENT).get();
		
		Element priceElement = doc.selectFirst("div.prod_cont_b ul.price li");
		
		return priceElement.text();
		
}
}