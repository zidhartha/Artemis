
import pgdp.color.RgbColor8Bit;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Alternative, advanced implementation using many different collectors
 */
public final class AdventuinPartyAdvanced {

    public static Map<HatType, List<Adventuin>> groupByHatType(List<Adventuin> adventuins) {
        return adventuins.stream().collect(groupingBy(Adventuin::getHatType));
    }

    public static void printLocalizedChristmasGreetings(List<Adventuin> adventuins) {
        adventuins.stream().sorted(Comparator.comparingInt(Adventuin::getHeight))
                .map(a -> a.getLanguage().getLocalizedChristmasGreeting(a.getName())).forEach(System.out::println);
    }

    public static Map<HatType, List<Adventuin>> getAdventuinsWithLongestNamesByHatType(List<Adventuin> adventuins) {
        return adventuins.stream().collect(groupingBy(Adventuin::getHatType, collectingAndThen(toList(), list -> {
            int max = list.stream().map(Adventuin::getName).mapToInt(String::length).max().getAsInt();
            return list.stream().filter(a -> a.getName().length() == max).collect(toList());
        })));
    }

    public static Map<Integer, Double> getAverageColorBrightnessByHeight(List<Adventuin> adventuins) {
        return adventuins.stream().collect(groupingBy(a -> ((a.getHeight() + 5) / 10) * 10,
                averagingDouble(a -> colorBrightness(a.getColor().toRgbColor8Bit()))));
    }

    public static Map<HatType, Double> getDiffOfAvgHeightDiffsToPredecessorByHatType(List<Adventuin> adventuins) {
        return adventuins.stream().collect(
                groupingBy(Adventuin::getHatType, mapping(Adventuin::getHeight, collectingAndThen(toList(), heights -> {
                    final int heightCount = heights.size();
                    Map<Integer, Double> diffAvgs = IntStream.range(0, heightCount)
                            .mapToObj(i -> heights.get(i) - heights.get((i - 1 + heightCount) % heightCount))
                            .collect(groupingBy(Integer::signum, averagingInt(i -> i)));
                    return diffAvgs.getOrDefault(1, 0.0) - diffAvgs.getOrDefault(-1, 0.0);
                }))));
    }

    private static double colorBrightness(RgbColor8Bit c) {
        return (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue()) / 255;
    }
}
