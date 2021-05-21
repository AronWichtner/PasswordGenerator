import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] usersInput = getusersInput();
        List<ArrayList<String>> Passwords = generatePasswords(usersInput);
        for (int i = 0; i <= Passwords.size() - 1; i++) {
            System.out.println(Passwords.get(i));
        }
    }


    public static int[] getusersInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Passwords do you want to generate?");
        int total = sc.nextInt();
        System.out.println("How many characters should your Password(s) contain?");
        int length = sc.nextInt();
        return new int[]{total, length};
    }


    public static List<ArrayList<String>> generatePasswords(int[] usersInput) {
        List<List<Integer>> asciilsts = generateASCIIlsts();
        List<List<Integer>> passwordsInAscii = new ArrayList<>();
        for (int i = 0; i < usersInput[0]; i++) {
            List<Integer> passwordi = new ArrayList<>();
            passwordsInAscii.add(passwordi);
            for (int j = 0; j < usersInput[1]; j++) {
                int newCharacter = getrandomcharfromAsciilsts(asciilsts);
                passwordi.add(newCharacter);
            }
        }
        return transformAsciiToString(passwordsInAscii);
    }

    public static List<ArrayList<String>> transformAsciiToString(List<List<Integer>> passwordsInAscii) {
        List<ArrayList<String>> mystrings = new ArrayList<>();
        for (int i = 0; i <= passwordsInAscii.size() - 1; i++) {
            ArrayList<String> mystring = new ArrayList<>();
            mystrings.add(mystring);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= passwordsInAscii.get(i).size() - 1; j++) {
                int ascii = passwordsInAscii.get(i).get(j);
                char newChar = (char) ascii;
                sb.append(newChar);
                if (j == passwordsInAscii.get(i).size() - 1) {
                    String newString = sb.toString();
                    mystring.add(newString);
                }
            }
        }
        return mystrings;
    }


    public static int getrandomcharfromAsciilsts(List<List<Integer>> asciilsts) {
        Random ran = new Random();
        int ranCharlstindex = ran.nextInt(4);
        int randCharindex = ran.nextInt(asciilsts.get(ranCharlstindex).size());
        return asciilsts.get(ranCharlstindex).get(randCharindex);
    }
// asciilsts[ranCharlstindex].size()

    public static List<Integer> generateASCIIlist(int low, int high) {
        List<Integer> asciilst = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            asciilst.add(i);
        }
        return asciilst;
    }

    public static List<List<Integer>> generateASCIIlsts() {
        List<Integer> alphabetlower = generateASCIIlist(97,122);
        List<Integer> alphabetupper = generateASCIIlist(65,90);
        List<Integer> numbers = generateASCIIlist(48,57);
        List<Integer> signs = generateASCIIlist(33,47);
        List<Integer> signs2 = generateASCIIlist(58,64);
        List<Integer> signs3 = generateASCIIlist(91,96);
        List<Integer> signs4 = generateASCIIlist(123,126);
        signs.addAll(signs2);signs.addAll(signs3);signs.addAll(signs4);
        List<List<Integer>> asciilsts = new ArrayList<>(4);
        asciilsts.add(alphabetlower);
        asciilsts.add(alphabetupper);
        asciilsts.add(numbers);
        asciilsts.add(signs);
        return asciilsts;
    }
}

