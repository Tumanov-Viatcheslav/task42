import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dragons {
    public static void main(String[] args) {
        int character, numberOfHeads, result = 0;
        String numberOfHeadsString = "";
        try(FileReader input = new FileReader("input.txt")) {
            while((character = input.read()) != -1) {
                numberOfHeadsString += (char)character;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        numberOfHeads = Integer.parseInt(numberOfHeadsString);
        // Дракон с одной головой не вносит никакого вклада в силу, поэтому у каждого дракона больше одной головы, кроме случая с одной головой в стае
        // Для количества голов 2, 3, 4 всё элементарно (2, 3, 4 силы соответственно)
        if (numberOfHeads < 5) {
            result = numberOfHeads;
        }
        //
        else {
            switch (numberOfHeads % 3) {
                case 0:
                    result = (int)Math.pow(3, numberOfHeads / 3);
                    break;
                case 1:
                    result = (int)Math.pow(3, numberOfHeads / 3 - 1) * 4;
                    break;
                case 2:
                    result = (int)Math.pow(3, numberOfHeads / 3) * 2;
                    break;
                default:
                    System.out.println("Что-то пошло не так");
            }
        }
        try(FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(result));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}