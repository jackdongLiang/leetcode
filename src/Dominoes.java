import java.util.*;

public class Dominoes {
  public static void main(String[] args) {
    int[][] dominoes = {{1, 2}, {2, 1}};
    System.out.println(Objects.equals(new Dominoe(1,2),new Dominoe(2,1)));
    System.out.println(numEquivDominoPairs(dominoes));
  }

  public static int numEquivDominoPairs(int[][] dominoes) {
    Map<Dominoe, Integer> map = new HashMap<>();
    for (int[] d : dominoes) {
      Dominoe dominoe = new Dominoe(d[0], d[1]);
      if (Objects.isNull(map.get(dominoe))) {
          map.put(dominoe, 1);
      } else {
        Integer result = map.get(dominoe);
        result = result + 1;
          map.put(dominoe, result);
      }
    }
    Set<Map.Entry<Dominoe, Integer>> set = map.entrySet();
    Integer result = 0;
    for (Map.Entry<Dominoe, Integer> entry : set) {
      Integer m = entry.getValue();
      result = result + m * (m - 1) / 2;
    }
    return result;
  }

  static class Dominoe  {
    private Integer first;
    private Integer second;

    Dominoe(Integer first, Integer second) {
      this.first = first;
      this.second = second;
    }

    public Integer getFirst() {
      return first;
    }

    public Integer getSecond() {
      return second;
    }

    @Override
    public int hashCode() {


      return 1;
    }

    @Override
    public boolean equals(Object obj) {
      Dominoe o = (Dominoe) obj;
      boolean firstFlag =
          Objects.equals(this.first, o.getFirst()) && Objects.equals(this.second, o.getSecond());
      boolean secondFlag =
          Objects.equals(this.second, o.getFirst()) && Objects.equals(this.first, o.getSecond());
        return firstFlag || secondFlag;
    }

  }
}
