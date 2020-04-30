import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Stack pino = new Stack();
        Double value = 0.0;

        System.out.println("Syötä laskutoimitus: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] stringArray = new String[input.length()];
        for(int i = 0 ; i<input.length(); i++){
            stringArray[i] = String.valueOf(input.charAt(i));
        }
        System.out.println("Laskutoimituksen prosessi: ");

        for(String str: stringArray) {
            if (!str.equals("")) {
                switch (str) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        Double oikea = pino.pop().getData();
                        Double vasen = pino.pop().getData();
                        switch (str) {
                            case "+":
                                value = vasen + oikea;
                                break;
                            case "-":
                                value = vasen - oikea;
                                break;
                            case "*":
                                value = vasen * oikea;
                                break;
                            case "/":
                                value = vasen / oikea;
                                break;
                            default:
                                break;
                        }
                        pino.push(value);
                        pino.printReversedStack();
                        break;
                    default:
                        pino.push(Double.parseDouble(str));
                        pino.printReversedStack();
                        break;
                }

            }
        }

        Double tulos = pino.pop().getData();
        System.out.println("tulos: " + tulos);




    }

}

