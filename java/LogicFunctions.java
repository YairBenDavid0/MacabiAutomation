public class LogicFunctions {
    public static void main(String[] args) {
        System.out.println(PrimeNumberChecker.isPrime(7));
        System.out.println(PowerOfTwoChecker.isPowerOfTwo(8));
        System.out.println(TriangleChecker.triangleType(3, 4, 5));
    }

    static class PrimeNumberChecker {
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            if (n % 2 == 0) {
                return false;
            }
            int sqrtN = (int) Math.sqrt(n) + 1;
            for (int divisor = 3; divisor < sqrtN; divisor += 2) {
                if (n % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class PowerOfTwoChecker {
        public static boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }

    static class TriangleChecker {
        public static String triangleType(int a, int b, int c) {
            if (a + b > c && a + c > b && b + c > a) {
                if (a == b && b == c) {
                    return "משולש שווה צלעות";
                } else if (a == b || a == c || b == c) {
                    return "משולש שווה שוקיים";
                } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                    return "משולש ישר זווית";
                } else {
                    return "סתם משולש";
                }
            } else {
                return "לא ניתן להרכיב משולש";
            }
        }
    }
}
