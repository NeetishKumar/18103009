import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Assignment_3 {

	public static void main(String[] args) throws IOException {
		String base = "https://pec.ac.in/";
		ArrayList<String> urlList = new ArrayList<String>();
		Set<String> urlSet = new HashSet<String>();
		File csv = new File("tagsfile.csv");
		csv.createNewFile();
		FileWriter csvWriter = new FileWriter("tagsfile.csv");
		CSVWriter writer= new CSVWriter(csvWriter);
		String col[]= {"Tag", "Text"};
		writer.writeNext(col);

		File url = new File("urlfile.csv");
		url.createNewFile();
		FileWriter urlWriter = new FileWriter("urlfile.csv");
		CSVWriter writer2= new CSVWriter(urlWriter);

		String col2[]= {"Text", "url"};
		writer2.writeNext(col2);
		int count=0;
	    urlSet.add(base);
	    urlList.add(base);
	    for(int i=0;i<urlList.size();i++)
	    {
	    	if(count>=1000)
	    	{
	    		break;
	    	}
	    	Document doc = Jsoup.connect(urlList.get(i)).ignoreHttpErrors(true).ignoreContentType(true).get();
			Elements ele= doc.getAllElements();
	    	for(Element temp: ele)
			{
				String[] line = new String[2];
				if(temp.text().length()!=0)
				{
					line[0]= temp.tagName();
					if(line[0]=="div")
					{
						continue;
					}
					line[1]= temp.text();
					writer.writeNext(line);
				}
				if(temp.text().length()!=0 && temp.tagName()== "a")
				{
					String[] url= new String[2];
					url[0]= temp.text();
					url[1]= temp.absUrl("href");
					if(url[1].contains("https://pec.ac.in/") && !urlSet.contains(url[1]))
					{
						count++;
						urlSet.add(url[1]);
						urlList.add(url[1]);
						System.out.println("Url[1] "+url[1]+" "+ count);
						writer2.writeNext(url);
					}
				}
			}
	    }
	    writer.flush();
	    writer2.flush();
	}
}
