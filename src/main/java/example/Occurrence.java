package example;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;

/**
 * This class encapsulates an occurrence of a keyword in a document. It stores the
 * document name, and the frequency of occurrence in that document. Occurrences are
 * associated with keywords in an index hash table.
 *
 * @author Sesh Venugopal
 *
 */
class Occurrence {
    /**
     * Document in which a keyword occurs.
     */
    @Setter
    public String document;

    /**
     * The frequency (number of times) the keyword occurs in the above document.
     */
    @Setter
    public int frequency;

    /**
     * Initializes this occurrence with the given document,frequency pair.
     *
     * @param doc Document name
     * @param freq Frequency
     */
    public Occurrence(String doc, int freq) {
        document = doc;
        frequency = freq;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "(" + document + "," + frequency + ")";
    }
}
