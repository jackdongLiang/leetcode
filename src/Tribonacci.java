public class Tribonacci {
  public static int tribonacci(int n) {

    int[] array = new int[n + 1];
    array[0] = 0;
    if (n ==0){
        return array[0];
    }
    array[1] = 1;
    if (n == 1){
        return array[1];
    }
    array[2] = 1;
    if (n ==2){
        return array[2];
    }
    for (int i = 0; i < n - 2; i++) {
      array[i + 3] = array[i] + array[i + 1] + array[i + 2];
    }
    return array[n];
  }

  public static void main(String[] args) {
    System.out.println(tribonacci(25));
  }
}
