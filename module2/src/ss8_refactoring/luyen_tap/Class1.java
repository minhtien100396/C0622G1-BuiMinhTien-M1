package ss8_refactoring.luyen_tap;

public class Class1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        System.out.println(kiemTra1(arr));
    }

    public static boolean kiemTra(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < i) {
                    sum1 += arr[j];
                }
                if (j > i) {
                    sum2 += arr[j];
                }
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }


    public static boolean kiemTra1(int[] arr) {
        int sum2 = 0;
        int sum1 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum1 += arr[j];
            }
            sum2 += arr[i + 1];
        }
        if (sum1 == sum2) {
            return true;
        }
        return false;
    }

}

