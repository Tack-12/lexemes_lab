public class main {
    public static void main(String[] args) {

        String output= "123";
        stringcode filereader = new stringcode();

        filereader.set_filename("src/Codes/SquareGame.jack");

        output = filereader.read_line();

        System.out.println(output);
    }
}
