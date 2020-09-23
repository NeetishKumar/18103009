import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;


public class Assignment_3_PDF{

	public static void main(String[] args) throws IOException {
		File csvFile = new File("PDFfile.csv");
		csvFile.createNewFile();
		FileWriter csvWriter = new FileWriter("PDFfile.csv");
		CSVWriter writer= new CSVWriter(csvWriter);
		String header[]= {"URL"};
		writer.writeNext(header);
		String base = "https://pec.ac.in/";
		ArrayList<String> urlList = new ArrayList<String>();
		Set<String> urlSet = new HashSet<String>();
		int count=0;
		urlSet.add(seedUrl);
	    urlList.add(seedUrl);
	    for(int i=0;i<urlList.size();i++)
	    {
	    	if(count>=1000)
	    	{
	    		break;
	    	}
	    	Document doc = Jsoup.connect(urlList.get(i)).ignoreHttpErrors(true).ignoreContentType(true).get();
			Elements ele= doc.select("a[href]");
	    	for(Element temp: ele)
			{
				if(temp.text().length()!=0)
				{
					String[] url= new String[2];
					url[0]= temp.text();
					url[1]= temp.absUrl("href");
					if(url[1].contains("https://pec.ac.in/") && !urlSet.contains(url[1]))
					{
						count++;
						urlSet.add(url[1]);
						urlList.add(url[1]);
						if(url[1].contains(".pdf") || url[1].contains(".doc") || url[1].contains(".PDF") || url[1].contains(".DOC"))
						{
							String[] line = new String[1];
							line[0]= url[1];
							writer.writeNext(line);
						}
					}
				}
			}

	    	Elements iframe = doc.select("iframe");
		    for (Element temp : iframe)
		    {
		    	if(temp.text().length()!=0)
				{
					String[] url= new String[1];
					url[0]= temp.attr("data-src");
					if(url[0].contains("https://pec.ac.in/") && !urlSet.contains(url[0]))
					{
						count++;
						urlSet.add(url[0]);
						urlList.add(url[0]);
						if(url[0].contains(".pdf") || url[0].contains(".doc") || url[0].contains(".PDF") ||url[0].contains(".DOC"))
						{
							String[] line = new String[1];
							line[0]= url[0];
							writer.writeNext(line);
						}
					}
				}
	    }
	    writer.flush();
	}
	}
}
