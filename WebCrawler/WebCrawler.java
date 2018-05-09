import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public static Queue<String> queue=new LinkedList<String>();
    public static Set<String> marked=new HashSet<>();
    public static String regex="http[s]*://(\\w+\\.)*(\\w+)";

    public static void bfsAlgorithm(String root) throws IOException {
        queue.add(root);

        BufferedReader br = null;

        while (!queue.isEmpty()) {
            String crawledUrl = queue.poll();
            System.out.println("\n=== Site crawled : " + crawledUrl + " ===");

            //Limit to 100 website
            if (marked.size() > 100)
                return;

            boolean executing = false;
            URL url = null;

            while (!executing)
            {
                try {
                    url = new URL(crawledUrl);
                    br = new BufferedReader(new InputStreamReader(url.openStream())); //url.openStream() initiates a new TCP connection to the server that the URL resolves to.
                    executing=true;
                } catch (MalformedURLException e) {
                    System.out.println("*** Malformed URL : " + crawledUrl);
                    crawledUrl = queue.poll();
                    executing = false;
                } catch (IOException e) {
                    System.out.println("*** IOException for URL : " + crawledUrl);
                    crawledUrl = queue.poll();
                    executing = false;
                }
            }
            StringBuilder sb=new StringBuilder();
            String temp;
            while ((temp=br.readLine())!=null){
                System.out.println(temp);
                sb.append(temp);
            }
            temp=sb.toString();
            /*At this point tem has the eintire html page as string*/
            Pattern pattern =Pattern.compile(regex);
            Matcher matcher= pattern.matcher(temp);
            /*pattern compiles the given format and matcher uses that to find all the links in the text*/
            while (matcher.find()){
                String w=matcher.group();
                //When you get a link look if it exists if not add it to the queue and marked
                if(!marked.contains(w)) {
                    marked.add(w);
                    System.out.println("Site added for crawling : "+w);
                    queue.add(w);
                }
            }
        }
        if (br != null)
            br.close();
    }

    public static void showResults()
    {
        System.out.println("\n\nResults :");
        System.out.println("Web sites crawled : "+marked.size()+"\n");

        for (String s: marked)
            System.out.println("* "+s);
    }
    public static void main(String[] args) {
        try{
            bfsAlgorithm("https://www.youtube.com");
            showResults();
        }catch (IOException e) {
            System.out.println(e);
        }
    }

}
