import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {
  public static String alphabetBoardPath(String target) {
    Map<String, Integer> map = new HashMap<>(26);
    map.put("a", 0);
    map.put("b", 1);
    map.put("c", 2);
    map.put("d", 3);
    map.put("e", 4);
    map.put("f", 10);
    map.put("g", 11);
    map.put("h", 12);
    map.put("i", 13);
    map.put("j", 14);
    map.put("k", 20);
    map.put("l", 21);
    map.put("m", 22);
    map.put("n", 23);
    map.put("o", 24);
    map.put("p", 30);
    map.put("q", 31);
    map.put("r", 32);
    map.put("s", 33);
    map.put("t", 34);
    map.put("u", 40);
    map.put("v", 41);
    map.put("w", 42);
    map.put("x", 43);
    map.put("y", 44);
    map.put("z", 50);
    char tmp;
    Integer source = 0;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < target.length(); i++) {
      tmp = target.charAt(i);
      Integer ta = map.get(String.valueOf(tmp));
      result.append(get(source, ta)).append("!");
      source = ta;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(alphabetBoardPath("z"));
  }

  private static String get(Integer source, Integer target) {
    StringBuilder stringBuilder = new StringBuilder();
    if (source == 50&&target == 50){
        return "";
    }
    if (source == 50){
        return stringBuilder.append("U").append(get(40,target)).toString();
    }
    if (target == 50){
        return stringBuilder.append(get(source,40)).append("D").toString();
    }
    Integer sf = source / 10;
    Integer ss = source % 10;
    Integer tf = target / 10;
    Integer ts = target % 10;
    int firstResult = tf - sf;
    int secondResult = ts - ss;

    if (firstResult > 0) {
      for (int i = 0; i < firstResult; i++) {
        stringBuilder.append("D");
      }
    } else if (firstResult < 0) {
      for (int i = 0; i < -firstResult; i++) {
        stringBuilder.append("U");
      }
    }
    if (secondResult > 0) {
      for (int i = 0; i < secondResult; i++) {
        stringBuilder.append("R");
      }
    } else if (secondResult < 0) {
      for (int i = 0; i < -secondResult; i++) {
        stringBuilder.append("L");
      }
    }

    return stringBuilder.toString();
  }
}
