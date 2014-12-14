package com.phd.quesans.Crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */
public class WebpageCrawer {
	public String getContent(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			String htmlContent=doc.html();
			return htmlContent; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	public Document getDocument(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String getSelectedContent(String url,String tag, String id) {
		
	}
	public String getTagContent(String url, String tag) {
		
	}
	public String getListOfLinks(String url) {
		
	}
	public String getImgURL(String url) {
		
	}
    public static void main(String[] args) throws IOException {
       // Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = "http://en.wikipedia.org/wiki/India";
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        String html=doc.html();
        //XSystem.out.println("\n\n"+html+"\n");
        //System.exit(0);
        Elements divTag=doc.select("div");
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        for (Element src : divTag) {
        	System.out.println(src.attr("id").toString());
        	if(src.attr("id").equalsIgnoreCase("content")) {
        	System.out.println(divTag.text());	
        }
        }
        
        System.exit(0);
        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}

