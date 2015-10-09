package mobappdev.lecture12.model;

import java.util.Comparator;

/**
 * Created by USX13992 on 10/9/2015.
 */
public class ComicComparator implements Comparator<Comic> {
    @Override
    public int compare(Comic lhs, Comic rhs) {
        String lhsSeries = checkForSeriesBeginningWithThe(lhs.getSeries());
        String rhsSeries = checkForSeriesBeginningWithThe(rhs.getSeries());
        int result = lhsSeries.compareTo(rhsSeries);
        result = (result == 0 ? lhs.getVolume() - rhs.getVolume() : result);
        result = (result == 0 ? lhs.getNumber() - rhs.getNumber() : result);
        return result;
    }

    private static String checkForSeriesBeginningWithThe(String series) {
        if(series.startsWith("The ")) {
            series = series.substring(4);
        }
        return series;
    }
}
