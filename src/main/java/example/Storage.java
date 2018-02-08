package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;


@Component
public class Storage {


    @Autowired
    private LittleSearchEngine searchEngine;

    public ArrayList<Occurrence>  getWordByValue(String word) {

        ArrayList<Occurrence> listOfFoundedOccurences = new ArrayList<>();
        if(!searchEngine.isInited()) {
            try {
                searchEngine.makeIndex("docs.txt", "noisewords.txt");
            } catch ( FileNotFoundException e ) {
                System.out.print("Error"+ e.getLocalizedMessage());
            }
            searchEngine.setInited( true );
        }
        try
        {
            for (String smbls : searchEngine.keywordsIndex.keySet())
                if(word.equals(smbls)) {
                    listOfFoundedOccurences.addAll( searchEngine.keywordsIndex.get(smbls));
                    System.out.println(smbls+" "+searchEngine.keywordsIndex.get(smbls));

                } else {
                    System.out.println("No data found");
                }
        } catch ( Exception e ) {
            System.out.println("No data found" +  e.getMessage());
        }
        return listOfFoundedOccurences;
    }

    public Boolean addWordByValue(String word) {
        return true;
    }

    public Boolean removeWordByValue(String word) {

        return true;
    }
}



